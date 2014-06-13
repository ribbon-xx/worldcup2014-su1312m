package bkapt.su1312m.WorldCup2014.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bkapt.su1312m.WorldCup2014.R;
import bkapt.su1312m.WorldCup2014.Adapters.TodayTVAdapter;
import bkapt.su1312m.WorldCup2014.Adapters.TransparentProgressDialog;
import bkapt.su1312m.WorldCup2014.R.id;
import bkapt.su1312m.WorldCup2014.R.layout;
import bkapt.su1312m.WorldCup2014.Utils.Matches;
import bkapt.su1312m.WorldCup2014.Utils.ServiceConfig;
import bkapt.su1312m.WorldCup2014.Utils.ServiceHelper;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class ToDayTVFragment extends Fragment {
	private TodayTVAdapter adapter;
	private ArrayList<Matches> list = new ArrayList<Matches>();
	private static String url = "http://cup.tin9x.vn/lichthidau/get_all_match_current_day.php";
	private Matches matches;
	private ListView lvtodaytv;
	private TransparentProgressDialog pDialog;
	private static String TAG_DATA = "data";
	private static String TAG_FLAGTEAM1 = "flag_team_1";
	private static String TAG_FLAGTEAM2 = "flag_team_2";
	private static String TAG_TIME = "time_fight";
	private static String TAG_RESULT = "result";
	JSONArray data = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.todaytv, container, false);
		InitView(rootView);
		return rootView;
	}

	public void InitView(View v) {
		lvtodaytv = (ListView) v.findViewById(R.id.lvtodaytv);
		new Getcontacts().execute();
	}

	class Getcontacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			pDialog = new TransparentProgressDialog(getActivity(),R.drawable.loading);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			ServiceHelper sh = new ServiceHelper();
			String Jsonstr = null;
			try {
				Jsonstr = ServiceHelper
						.getInfo(url, "", ServiceConfig.TIME_OUT);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			if (Jsonstr != null) {
				try {
					JSONObject jsonObject = new JSONObject(Jsonstr);
					data = jsonObject.getJSONArray(TAG_DATA);
					for (int i = 0; i < data.length(); i++) {
						JSONObject c = (JSONObject) data.get(i);
						String flag_team_1 = c.getString(TAG_FLAGTEAM1);
						String flag_team_2 = c.getString(TAG_FLAGTEAM2);
						String time_fight = c.getString(TAG_TIME);
						String result = c.getString(TAG_RESULT);

						matches = new Matches(flag_team_1, flag_team_2, result,
								time_fight);
						list.add(matches);
					}

				} catch (JSONException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (pDialog.isShowing())
				;
			pDialog.dismiss();
			adapter = new TodayTVAdapter(getActivity(),
					R.layout.itemrowtodaytv, list);
			lvtodaytv.setAdapter(adapter);
			if (adapter.getCount() < 1) {
				Toast.makeText(getActivity(), "KhÃ´ng CÃ³ Lá»‹ch Thi Ä�áº¥u", 1)
						.show();
				Log.e("", "adapter"+adapter.getCount());
			}
			super.onPostExecute(result);
		}

	}

}