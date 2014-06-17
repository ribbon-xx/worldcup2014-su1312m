package bkapt.su1312m.WorldCup2014;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
		if (activeNetwork != null && activeNetwork.isConnected()) {
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					Intent i = new Intent(getApplicationContext(),
							PagerFrafmentActivity.class);
					startActivity(i);
					finish();
				}
			},1000);
		} else {
			Intent i = new Intent(getApplicationContext(),
					PagerFrafmentActivity.class);
			startActivity(i);
			finish();
		} 
}}
