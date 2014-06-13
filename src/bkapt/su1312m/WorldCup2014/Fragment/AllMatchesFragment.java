package bkapt.su1312m.WorldCup2014.Fragment;

import bkapt.su1312m.WorldCup2014.R;
import bkapt.su1312m.WorldCup2014.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AllMatchesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.allmatches,
				container, false);

		return rootView;
	}
}