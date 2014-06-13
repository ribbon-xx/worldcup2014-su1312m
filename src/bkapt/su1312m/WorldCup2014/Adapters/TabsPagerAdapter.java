package bkapt.su1312m.WorldCup2014.Adapters;

import bkapt.su1312m.WorldCup2014.Main3;
import bkapt.su1312m.WorldCup2014.Fragment.AllMatchesFragment;
import bkapt.su1312m.WorldCup2014.Fragment.ToDayTVFragment;
import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {


	public TabsPagerAdapter(android.support.v4.app.FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return new ToDayTVFragment();
		case 1:
			return new AllMatchesFragment();
		case 2:
			return new Main3();
		}

		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
