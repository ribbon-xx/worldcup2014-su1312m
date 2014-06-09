package bkapt.su1312m.WorldCup2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.splash);
		super.onCreate(savedInstanceState);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);
				finish();
			}
		},1000);
	}
}
