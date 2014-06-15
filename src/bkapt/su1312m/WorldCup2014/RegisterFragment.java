package bkapt.su1312m.WorldCup2014;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import bkapt.su1312m.WorldCup2014.Utils.NetworkUtils;

public class RegisterFragment extends Fragment {
	private Button bt1, bt2, bt3;
	private FrameLayout container;
	private Login login;
	private Dudoan spinner;
	private EventEnd eventEnd;
	private FragmentManager myFragmentManager;
	final static String TAG_1 = "FRAGMENT_1";
	final static String TAG_2 = "FRAGMENT_2";
	final static String TAG_3 = "FRAGMENT_3";
	final static String KEY_MSG_1 = "FRAGMENT1_MSG";
	final static String KEY_MSG_2 = "FRAGMENT2_MSG";
	final static String KEY_MSG_3 = "FRAGMENT3_MSG";
	private NetworkUtils jsonConfig;
	private JSONObject jsonObject;
	private int checkfragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.register, container, false);

		container = (FrameLayout) view.findViewById(R.id.maincontainer);
		login = new Login();
		spinner = new Dudoan();
		eventEnd = new EventEnd();
		myFragmentManager = getActivity().getSupportFragmentManager();

		String check_endevent = new String();

		String menuItems = new String();
		JSONparser_check jsonParser = new JSONparser_check();
		JSONObject jObj = jsonParser.getJsonFromUrl(GlobalVariable.URL_FINISH);

		try {
			check_endevent = jObj.getString("result");
			// menuItems = data.getString("result");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		Log.e("CHECK", "checkaaa " + check_endevent.toString());

		if (savedInstanceState == null) {
			// if's the first time created

			((PagerFrafmentActivity) getActivity()).replaceFragment(login,
					TAG_1);
		}
		if (check_endevent.toString().trim().equals("true")) {

			Log.e("", "falseaaaa " + 1);

			Fragment fragment = new EventEnd();
			((PagerFrafmentActivity) getActivity()).replaceFragment(fragment,
					TAG_3);

		} else {
			Log.e("", "falseaaaa" + 0);
			SharedPreferences sp = PreferenceManager
					.getDefaultSharedPreferences(getActivity());
			checkfragment = sp.getInt("CHECK", 0);
			if (checkfragment == 0) {

				Fragment fragment = new Login();
				((PagerFrafmentActivity) getActivity()).replaceFragment(
						fragment, TAG_1);

			}
			if (checkfragment == 1) {

				Fragment fragment = new Dudoan();
				((PagerFrafmentActivity) getActivity()).replaceFragment(
						fragment, TAG_2);

			}
		}
		return view;
	}

	private void savePreferences(String key, int value) {
		// TODO Auto-generated method stub
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();
	}
}
