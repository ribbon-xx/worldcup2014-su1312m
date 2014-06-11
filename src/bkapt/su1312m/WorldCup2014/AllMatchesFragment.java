package bkapt.su1312m.WorldCup2014;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import bkapt.su1312m.WorldCup2014.Adapters.CalendarListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllMatchesFragment extends Fragment {

    CalendarListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String, List<String>> listDataChildTeam1;
    HashMap<String, List<String>> listDataChildTeam2;
    HashMap<String, List<String>> listDataResuft;


    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.calendar,
                container, false);


        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);


        // preparing list data
        prepareListData();

        listAdapter = new CalendarListAdapter(getActivity(), listDataHeader, listDataChild,
                listDataChildTeam1, listDataChildTeam2, listDataResuft);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                return false;
            }
        });

        return rootView;
    }

    /*
	 * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataChildTeam1= new HashMap<String, List<String>>();
        listDataChildTeam2= new HashMap<String, List<String>>();
        listDataResuft= new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("20/5/2014");
        listDataHeader.add("24/5/2014");
        listDataHeader.add("28/5/2014");

        // Adding child data
        //Add time
        List<String> time1 = new ArrayList<String>();
        time1.add("00:30");
        time1.add("01:45");
        time1.add("02:45");

        List<String> time2 = new ArrayList<String>();
        time2.add("00:30");
        time2.add("02:45");
        time2.add("02:30");

        List<String> time3 = new ArrayList<String>();
        time3.add("01:45");
        time3.add("02:45");
        time3.add("02:30");

        //Add team 1
        List<String> team11 = new ArrayList<String>();
        team11.add("Anh");
        team11.add("Đức");
        team11.add("Pháp");

        List<String> team12 = new ArrayList<String>();
        team12.add("Anh");
        team12.add("Ha Lan");
        team12.add("Nga");

        List<String> team13 = new ArrayList<String>();
        team13.add("Pháp");
        team13.add("Nhật");
        team13.add("Hà Lan");

        //Add team 2
        List<String> team21 = new ArrayList<String>();
        team21.add("Anh");
        team21.add("Đức");
        team21.add("Pháp");

        List<String> team22 = new ArrayList<String>();
        team22.add("Anh");
        team22.add("Ha Lan");
        team22.add("Nga");

        List<String> team23 = new ArrayList<String>();
        team23.add("Pháp");
        team23.add("Nhật");
        team23.add("Hà Lan");

        listDataChild.put(listDataHeader.get(0), time1);
        listDataChild.put(listDataHeader.get(1), time2);
        listDataChild.put(listDataHeader.get(2), time3);

        listDataChildTeam1.put(listDataHeader.get(0), team11);
        listDataChildTeam1.put(listDataHeader.get(1), team12);
        listDataChildTeam1.put(listDataHeader.get(2), team13);

        listDataChildTeam2.put(listDataHeader.get(0), team21);
        listDataChildTeam2.put(listDataHeader.get(1), team22);
        listDataChildTeam2.put(listDataHeader.get(2), team23);
    }
}