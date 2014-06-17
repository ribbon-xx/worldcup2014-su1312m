package bkapt.su1312m.WorldCup2014.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import bkapt.su1312m.WorldCup2014.RegisterFragment;
import bkapt.su1312m.WorldCup2014.Fragment.AllMatchesFragment;
import bkapt.su1312m.WorldCup2014.Fragment.ToDayTVFragment;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
	private ToDayTVFragment toDayTVFragment;
	private AllMatchesFragment allMatchesFragment;
	private RegisterFragment registerFragment;


	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		toDayTVFragment = new ToDayTVFragment();
		allMatchesFragment = new AllMatchesFragment();
		registerFragment = new RegisterFragment();
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return toDayTVFragment;
		case 1:
			return allMatchesFragment;
		case 2:
			return registerFragment;
		}

		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
