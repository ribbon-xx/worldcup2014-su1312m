package bkapt.su1312m.WorldCup2014.Utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import android.text.TextUtils;

@SuppressWarnings("deprecation")
public class ServiceHelper implements ServiceConfig {
	public static String getInfo(String url, String tail, String token,
			int timeout) throws IOException {
		String target = "";
		if (tail != null && tail.length() > 0) {
			target = url + "/" + tail;
		} else {
			target = url;
		}
		HttpGet httpGet = new HttpGet(target);
		if (!TextUtils.isEmpty(token)) {
			httpGet.addHeader(TOKEN, token);
		}

		return getResultFromService(httpGet, timeout);

	}

	public static String getInfo(String url, String token, int timeout)
			throws IOException {
		String target = url;

		HttpGet httpGet = new HttpGet(target);

		if (!TextUtils.isEmpty(token)) {
			httpGet.addHeader(TOKEN, token);
		}
		return getResultFromService(httpGet, timeout);
	}

	public static String getInfo(String url, List<NameValuePair> params,
			String token, int timeout) throws IOException {
		String target = url;
		if (params != null) {
			target += parseParamsToUrl(params);
		}

		HttpGet httpGet = new HttpGet(target);
		if (!TextUtils.isEmpty(token)) {
			httpGet.addHeader(TOKEN, token);
		}
		return getResultFromService(httpGet, timeout);
	}

	public static String postInfo(String url, List<NameValuePair> params,
			String token, int timeout) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		if (!TextUtils.isEmpty(token)) {
			httpPost.addHeader(TOKEN, token);
		}
		if (params != null && !params.isEmpty()) {
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return getResultFromService(httpPost, timeout);
	}

	public static String putInfo(String url, List<NameValuePair> params,
			String token, int timeout) throws IOException {
		HttpPut httpPut = new HttpPut(url);
		if (!TextUtils.isEmpty(token)) {
			httpPut.addHeader(TOKEN, token);
		}
		if (params != null && !params.isEmpty()) {
			try {
				httpPut.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return getResultFromService(httpPut, timeout);
	}

	public static String postInfo(String url, List<NameValuePair> params,
			MultipartEntity mtentity, String token, int timeout)
			throws IllegalStateException, IOException {

		if (params != null) {
			url += parseParamsToUrl(params);
		}
		String result = "";
		HttpResponse response = null;
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, timeout);
		HttpConnectionParams.setSoTimeout(httpParams, timeout);
		HttpClient httpclient = new DefaultHttpClient(httpParams);

		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(mtentity);
		if (token != null) {
			httppost.addHeader(TOKEN, token);
		}

		response = httpclient.execute(httppost);
		HttpEntity htentity = response.getEntity();

		if (htentity != null) {
			InputStream instream = null;
			instream = htentity.getContent();
			result = convertStreamToString(instream);

		}
		return result;
	}

	public static String postInfo(String url, MultipartEntity mtentity,
			String token, int timeout) throws ClientProtocolException,
			IOException {
		String result = "";
		HttpResponse response = null;
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, timeout);
		HttpConnectionParams.setSoTimeout(httpParams, timeout);
		HttpClient httpclient = new DefaultHttpClient(httpParams);
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(mtentity);
		if (token != null) {
			httppost.addHeader(TOKEN, token);
		}

		response = httpclient.execute(httppost);
		HttpEntity htentity = response.getEntity();
		if (htentity != null) {
			InputStream instream = null;
			instream = htentity.getContent();
			result = convertStreamToString(instream);

		}
		return result;
	}

	public static String delete(String url, String token, int timeout)
			throws IOException {
		HttpDelete httpDelete = new HttpDelete(url);
		if (!TextUtils.isEmpty(token)) {
			httpDelete.addHeader(TOKEN, token);
		}
		return getResultFromService(httpDelete, timeout);
	}

	public static String parseParamsToUrl(List<NameValuePair> params)
			throws UnsupportedEncodingException {
		String combinedParams = "";
		if (!params.isEmpty()) {
			combinedParams += "?";
			for (NameValuePair p : params) {
				String paramString = "";
				paramString = p.getName() + "="
						+ URLEncoder.encode(p.getValue(), "UTF-8");
				if (combinedParams.length() > 1) {
					combinedParams += "&" + paramString;
				} else {
					combinedParams += paramString;
				}
			}
		}
		return combinedParams;
	}

	public static String getResultFromService(HttpRequestBase httpRequestBase,
			int timeout) throws IOException {
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, timeout);
		HttpConnectionParams.setSoTimeout(httpParams, timeout);
		HttpClient httpclient = new DefaultHttpClient(httpParams);
		HttpResponse response;
		String result = null;
		response = httpclient.execute(httpRequestBase);
		InputStream instream = response.getEntity().getContent();
		result = convertStreamToString(instream);
		instream.close();
		return result;
	}

	public static String convertStreamToString(InputStream instream) {

		String line = null;
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					instream, "UTF-8"));
			while ((line = reader.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				instream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
