package bkapt.su1312m.WorldCup2014;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

;

/**
 * Created by My pc on 9/6/2014.
 */
public class Dudoan extends Fragment {
	private TextView select;
	private Spinner spinner;
	private String[] nameteam = { "VietNam", "Brazil", "Lao ", "Abc" };
	private LinearLayout layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.spinner, container, false);
		spinner = (Spinner) view.findViewById(R.id.spinner1);
		layout = (LinearLayout) view.findViewById(R.id.liner);
		layout.setVisibility(View.GONE);
		List<String> arrSpiner = new ArrayList<String>();
		for (int i = 0; i < nameteam.length; i++) {
			arrSpiner.add(nameteam[i]);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				R.layout.page_spiner, arrSpiner);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		savePreferences("CHECK", 1);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				layout.setVisibility(View.VISIBLE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

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
