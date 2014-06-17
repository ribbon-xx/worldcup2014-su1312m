package bkapt.su1312m.WorldCup2014.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import bkapt.su1312m.WorldCup2014.R;
import bkapt.su1312m.WorldCup2014.Adapters.CalendarListAdapter;
import bkapt.su1312m.WorldCup2014.DAO.CalendarDAO;
import bkapt.su1312m.WorldCup2014.DTO.CalendarDTO;
import bkapt.su1312m.WorldCup2014.Utils.ShowDialogUtil;

public class AllMatchesFragment extends Fragment {

	CalendarListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	CalendarDTO calendarDTO;
	CalendarDAO calendarDAO;
	HashMap<String, List<String>> listDataChild;
	HashMap<String, List<String>> listDataChildTeam1;
	HashMap<String, List<String>> listDataChildTeam2;
	HashMap<String, List<String>> listFlagChildTeam1;
	HashMap<String, List<String>> listFlagChildTeam2;
	HashMap<String, List<String>> listDataResuft;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.calendar, container, false);
		final ConnectivityManager conMgr = (ConnectivityManager) getActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
		expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
		if (activeNetwork != null && activeNetwork.isConnected()) {
			prepareListData();
		} else {
			ShowDialogUtil.showAlertNetwork(getActivity());
			// prepareListDataFromClient();
		}
		// Listview Group click listener
		expListView
				.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

					@Override
					public boolean onGroupClick(ExpandableListView parent,
							View v, int groupPosition, long id) {
						// Toast.makeText(getApplicationContext(),
						// "Group Clicked " + listDataHeader.get(groupPosition),
						// Toast.LENGTH_SHORT).show();
						return false;
					}
				});

		// Listview Group expanded listener
		expListView
				.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

					@Override
					public void onGroupExpand(int groupPosition) {

					}
				});

		// Listview Group collasped listener
		expListView
				.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

					@Override
					public void onGroupCollapse(int groupPosition) {

					}
				});

		// Listview on child click listener
		expListView
				.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

					@Override
					public boolean onChildClick(ExpandableListView parent,
							View v, int groupPosition, int childPosition,
							long id) {
						// TODO Auto-generated method stub

						return false;
					}
				});
		return rootView;
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListDataFromClient() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				CalendarDTO calendarDTO = new CalendarDTO(getActivity());
				calendarDTO.loadCalenderFromClient();
				getActivity().runOnUiThread(new Runnable() {

					@Override
					public void run() {
						listDataHeader = new ArrayList<String>();
						listDataChild = new HashMap<String, List<String>>();
						listDataChildTeam1 = new HashMap<String, List<String>>();
						listDataChildTeam2 = new HashMap<String, List<String>>();
						listFlagChildTeam1 = new HashMap<String, List<String>>();
						listFlagChildTeam2 = new HashMap<String, List<String>>();
						listDataResuft = new HashMap<String, List<String>>();
						String times[] = new String[CalendarDTO.time_fight.length];
						String day[] = new String[CalendarDTO.time_fight.length];
						String resuft[] = new String[CalendarDTO.time_fight.length];
						String team1[] = new String[CalendarDTO.time_fight.length];
						String team2[] = new String[CalendarDTO.time_fight.length];
						String flag1[] = new String[CalendarDTO.time_fight.length];
						String flag2[] = new String[CalendarDTO.time_fight.length];

						int i = 0, j = 0, m = 0;
						Date date = null;
						for (i = 0; i < CalendarDTO.team1.length; i++) {
							try {
								date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss")
										.parse(CalendarDTO.time_fight[i]
												.toString());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String newString = new SimpleDateFormat(
									"dd-MM-yyyy HH:mm").format(date);
							times[i] = newString;
							team1[i] = CalendarDTO.team1[i];
							team2[i] = CalendarDTO.team2[i];
							resuft[i] = CalendarDTO.resufts[i];
							flag1[i] = CalendarDTO.flag_team_1[i];
							flag2[i] = CalendarDTO.flag_team_2[i];
						}

						i = 0;
						try {
							while (i < times.length - 1) {
								day[m] = times[i].split(" ")[0];
								listDataHeader.add(day[m]);
								j = i + 1;
								while (j < times.length) {
									String time1 = times[j].split(" ")[0];

									if (day[m].toUpperCase().trim()
											.equals(time1.toUpperCase().trim())) {
										j++;
									} else {
										List<String> time = new ArrayList<String>();
										List<String> teams1 = new ArrayList<String>();
										List<String> teams2 = new ArrayList<String>();
										List<String> resufts = new ArrayList<String>();
										List<String> flags1 = new ArrayList<String>();
										List<String> flags2 = new ArrayList<String>();
										for (int k = i; k < resuft.length; k++) {
											if (day[m]
													.toUpperCase()
													.trim()
													.equals(times[k].split(" ")[0]
															.toUpperCase()
															.trim())) {
												time.add(times[k].split(" ")[1]);
												teams1.add(team1[k]);
												teams2.add(team2[k]);
												resufts.add(resuft[k]);
												flags1.add(flag1[k]);
												flags2.add(flag2[k]);
												// Log.v("hours",
												// times[k].split(" ")[1] +
												// " ");
												// Log.v("team1", teams1 + " ");
												// Log.v("team2", teams2 + " ");
												// Log.v("resuft", resufts +
												// " ");
											}
										}
										listDataChild.put(
												listDataHeader.get(m), time);
										listDataChildTeam1.put(
												listDataHeader.get(m), teams1);
										listDataChildTeam2.put(
												listDataHeader.get(m), teams2);
										listFlagChildTeam1.put(
												listDataHeader.get(m), flags1);
										listFlagChildTeam2.put(
												listDataHeader.get(m), flags2);
										listDataResuft.put(
												listDataHeader.get(m), resufts);
										i = j;
										// break;
										j = times.length;
										m++;
									}
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						// listDataHeader.add(day[26]);

						List<String> time = new ArrayList<String>();
						List<String> teams1 = new ArrayList<String>();
						List<String> teams2 = new ArrayList<String>();
						List<String> resufts = new ArrayList<String>();
						List<String> flags1 = new ArrayList<String>();
						List<String> flags2 = new ArrayList<String>();

						time.add(times[63].split(" ")[1]);
						teams1.add(team1[63]);
						teams2.add(team2[63]);
						resufts.add(resuft[63]);
						flags1.add(flag1[63]);
						flags2.add(flag2[63]);

						listDataChild.put(listDataHeader.get(26), time);
						listDataChildTeam1.put(listDataHeader.get(26), teams1);
						listDataChildTeam2.put(listDataHeader.get(26), teams2);
						listFlagChildTeam1.put(listDataHeader.get(26), flags1);
						listFlagChildTeam2.put(listDataHeader.get(26), flags2);
						listDataResuft.put(listDataHeader.get(26), resufts);
						setDataToUI();
					}
				});
			}
		}).start();
		;

	}

	private void prepareListData() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				CalendarDTO.loadData();
				getActivity().runOnUiThread(new Runnable() {
					@Override
					public void run() {
						listDataHeader = new ArrayList<String>();
						listDataChild = new HashMap<String, List<String>>();
						listDataChildTeam1 = new HashMap<String, List<String>>();
						listDataChildTeam2 = new HashMap<String, List<String>>();
						listFlagChildTeam1 = new HashMap<String, List<String>>();
						listFlagChildTeam2 = new HashMap<String, List<String>>();
						listDataResuft = new HashMap<String, List<String>>();
						String times[] = new String[CalendarDTO.time_fight.length];
						String day[] = new String[CalendarDTO.time_fight.length];
						String resuft[] = new String[CalendarDTO.time_fight.length];
						String team1[] = new String[CalendarDTO.time_fight.length];
						String team2[] = new String[CalendarDTO.time_fight.length];
						String flag1[] = new String[CalendarDTO.time_fight.length];
						String flag2[] = new String[CalendarDTO.time_fight.length];

						int i = 0, j = 0, m = 0;
						Date date = null;
						for (i = 0; i < CalendarDTO.id.length; i++) {
							try {
								date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss")
										.parse(CalendarDTO.time_fight[i]
												.toString());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String newString = new SimpleDateFormat(
									"dd-MM-yyyy HH:mm").format(date);
							times[i] = newString;
							team1[i] = CalendarDTO.team1[i];
							team2[i] = CalendarDTO.team2[i];
							resuft[i] = CalendarDTO.resufts[i];
							flag1[i] = CalendarDTO.flag_team_1[i];
							flag2[i] = CalendarDTO.flag_team_2[i];
						}

						i = 0;
						try {
							while (i < times.length - 1) {
								day[m] = times[i].split(" ")[0];
								listDataHeader.add(day[m]);
								j = i + 1;
								while (j < times.length) {
									String time1 = times[j].split(" ")[0];

									if (day[m].toUpperCase().trim()
											.equals(time1.toUpperCase().trim())) {
										j++;
									} else {
										List<String> time = new ArrayList<String>();
										List<String> teams1 = new ArrayList<String>();
										List<String> teams2 = new ArrayList<String>();
										List<String> resufts = new ArrayList<String>();
										List<String> flags1 = new ArrayList<String>();
										List<String> flags2 = new ArrayList<String>();
										for (int k = i; k < resuft.length; k++) {
											if (day[m]
													.toUpperCase()
													.trim()
													.equals(times[k].split(" ")[0]
															.toUpperCase()
															.trim())) {
												time.add(times[k].split(" ")[1]);
												teams1.add(team1[k]);
												teams2.add(team2[k]);
												resufts.add(resuft[k]);
												flags1.add(flag1[k]);
												flags2.add(flag2[k]);
												// Log.v("hours",
												// times[k].split(" ")[1] +
												// " ");
												// Log.v("team1", teams1 + " ");
												// Log.v("team2", teams2 + " ");
												// Log.v("resuft", resufts +
												// " ");
											}
										}
										listDataChild.put(
												listDataHeader.get(m), time);
										listDataChildTeam1.put(
												listDataHeader.get(m), teams1);
										listDataChildTeam2.put(
												listDataHeader.get(m), teams2);
										listFlagChildTeam1.put(
												listDataHeader.get(m), flags1);
										listFlagChildTeam2.put(
												listDataHeader.get(m), flags2);
										listDataResuft.put(
												listDataHeader.get(m), resufts);
										i = j;
										// break;
										j = times.length;
										m++;
									}
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}

						listDataHeader.add(day[26]);

						List<String> time = new ArrayList<String>();
						List<String> teams1 = new ArrayList<String>();
						List<String> teams2 = new ArrayList<String>();
						List<String> resufts = new ArrayList<String>();
						List<String> flags1 = new ArrayList<String>();
						List<String> flags2 = new ArrayList<String>();

						time.add(times[63].split(" ")[1]);
						teams1.add(team1[63]);
						teams2.add(team2[63]);
						resufts.add(resuft[63]);
						flags1.add(flag1[63]);
						flags2.add(flag2[63]);

						listDataChild.put(listDataHeader.get(26), time);
						listDataChildTeam1.put(listDataHeader.get(26), teams1);
						listDataChildTeam2.put(listDataHeader.get(26), teams2);
						listFlagChildTeam1.put(listDataHeader.get(26), flags1);
						listFlagChildTeam2.put(listDataHeader.get(26), flags2);
						listDataResuft.put(listDataHeader.get(26), resufts);
						setDataToUI();
					}
				});

			}
		}).start();
	}

	private void setDataToUI() {
		listAdapter = new CalendarListAdapter(getActivity(), listDataHeader,
				listDataChild, listDataChildTeam1, listDataChildTeam2,
				listDataResuft, listFlagChildTeam1, listFlagChildTeam2);

		// setting list adapter
		expListView.setAdapter(listAdapter);
		expandAllGroup(expListView);
	}

	private void expandAllGroup(ExpandableListView expandableListView) {
		int groupCount = expandableListView.getCount();
		for (int i = 0; i < groupCount; i++) {
			expandableListView.expandGroup(i);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		expandAllGroup(expListView);
	}
}