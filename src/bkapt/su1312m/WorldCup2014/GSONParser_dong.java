package bkapt.su1312m.WorldCup2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import com.google.gson.Gson;

public class GSONParser_dong {
	private static final String FileName="json.txt";
	public static DATA GetAllTeam(Context context){
		try {
			AssetManager assetManager = context.getAssets();
			BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open(FileName)));
		    Gson gson = new Gson();
			DATA data = gson.fromJson(reader, DATA.class);
			return data;
		} catch (IOException e) {
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
			return null;
		}
	}
}
