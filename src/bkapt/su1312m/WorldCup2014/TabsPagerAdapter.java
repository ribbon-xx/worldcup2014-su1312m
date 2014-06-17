package bkapt.su1312m.WorldCup2014;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import bkapt.su1312m.WorldCup2014.Fragment.AllMatchesFragment;
import bkapt.su1312m.WorldCup2014.Fragment.ToDayTVFragment;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {


	public TabsPagerAdapter(android.support.v4.app.FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			ToDayTVFragment toDayTVFragment = new ToDayTVFragment();
			return toDayTVFragment;
		case 1:
			new AllMatchesFragment();
		case 2:
			new Predicted();

		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
