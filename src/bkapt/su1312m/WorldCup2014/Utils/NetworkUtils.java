
package bkapt.su1312m.WorldCup2014.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.security.KeyStore;

/**
 * Created by RibboN on 8/6/2014.
 */
public class NetworkUtils
{
    private DefaultHttpClient client;
    private Context context;

    private final int TIME_OUT = 300000;

    private DefaultHttpClient getNewHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            trustStore.load(null, null);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
            HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
            HttpConnectionParams.setSoTimeout(params, TIME_OUT);
            HttpConnectionParams.setTcpNoDelay(params, true);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(
                    params, registry);
            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public NetworkUtils(Context context) {
        super();
        client = getNewHttpClient();
        this.context = context;
    }

    public String httpPost(String json, String url) {
        HttpResponse httpResponse = null;
        String resString = "";
        try {
            HttpPost httpPost = new HttpPost(url);

            StringEntity entity = new StringEntity(json, HTTP.UTF_8);
//            entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(entity);

            httpResponse = client.execute(httpPost);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            Log.e("REpon","reaaaaa "+responseCode);
            HttpEntity response = httpResponse.getEntity();
            resString = EntityUtils.toString(response, HTTP.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resString;
    }

    public static void turnWifiOn(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
    }

    public static void turnWifiOff(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }

    public static boolean getNetworkStatus(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            return false;
        } else {
            return false;
        }
    }

    public static enum NetworkType {
        WIFI, EDGE, HSPA, WIMAX;
    }

    public static NetworkType getNetworkType(Context context) {
        NetworkType networkType = NetworkType.HSPA;
        // Check each connection type
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        /**
         * WIFI
         */

        /** Check the connection **/
        NetworkInfo network = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        // Make sure the network is available
        if (network != null && network.isAvailable() && network.isConnectedOrConnecting()) {
            networkType = NetworkType.WIFI;
        }

        /**
         * 2G/3G
         */
        /** Check the connection **/
        network = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        // Show the right icon
        if (network != null &&
                (network.getSubtype() == TelephonyManager.NETWORK_TYPE_GPRS ||
                        network.getSubtype() == TelephonyManager.NETWORK_TYPE_EDGE)) {
            if (network.isAvailable() && network.isConnectedOrConnecting()) {
                networkType = NetworkType.EDGE;
            }
        } else {
            if (network.isAvailable() && network.isConnectedOrConnecting()) {
                networkType = NetworkType.HSPA;
            }
        }

        /**
         * 4G
         */

        /** Check the connection **/
        network = cm.getNetworkInfo(ConnectivityManager.TYPE_WIMAX);

        // Make sure the network is available
        if (network != null && network.isAvailable() && network.isConnectedOrConnecting()) {
            networkType = NetworkType.HSPA;
        }

        return networkType;
    }
}
