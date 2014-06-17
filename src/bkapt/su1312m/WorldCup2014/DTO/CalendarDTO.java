package bkapt.su1312m.WorldCup2014.DTO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import bkapt.su1312m.WorldCup2014.DAO.CalendarDAO;
import bkapt.su1312m.WorldCup2014.DAO.CalenderEntity;
import bkapt.su1312m.WorldCup2014.DefintConstant.UrlServices;
import bkapt.su1312m.WorldCup2014.Utils.JSONParser;
import bkapt.su1312m.WorldCup2014.Utils.Matches;

/**
 * Created by RibboN on 8/6/2014.
 */
public class CalendarDTO implements Parcelable {
	private long team1Id, team2Id;
	private String timeFight;
	private static Context context;
	private static CalendarDAO calendarDAO;
	private String result;

	public static String[] id = null;
	public static String[] team1 = null;
	public static String[] team2 = null;
	public static String[] time_fight = null;
	public static String[] flag_team_1 = null;
	public static String[] flag_team_2 = null;
	public static String[] resufts = null;

	public CalendarDTO(Context context) {
		this.context = context;
	}

	public static String[] getFlag_team_1() {
		return flag_team_1;
	}

	public static void setFlag_team_1(String[] flag_team_1) {
		CalendarDTO.flag_team_1 = flag_team_1;
	}

	public static String[] getFlag_team_2() {
		return flag_team_2;
	}

	public static void setFlag_team_2(String[] flag_team_2) {
		CalendarDTO.flag_team_2 = flag_team_2;
	}

	public long getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(long team1Id) {
		this.team1Id = team1Id;
	}

	public long getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(long team2Id) {
		this.team2Id = team2Id;
	}

	public String getTimeFight() {
		return timeFight;
	}

	public void setTimeFight(String timeFight) {
		this.timeFight = timeFight;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {

	}

	public static void loadCalenderFromClient() {
		calendarDAO = new CalendarDAO(context);
		List<Matches> arrayList = new ArrayList<Matches>();
		arrayList = calendarDAO.getAllcalendar();
		int count = arrayList.size();
		team1 = new String[count];
		team2 = new String[count];
		time_fight = new String[count];
		flag_team_1 = new String[count];
		flag_team_2 = new String[count];
		resufts = new String[count];
		for (int i = 0; i < count; i++) {
			team1[i] = flag_team_1[i] = arrayList.get(i).getNameteam1();
			team2[i] = flag_team_2[i] = arrayList.get(i).getNameteam2();
			time_fight[i] = arrayList.get(i).getDatetime();
			resufts[i] = arrayList.get(i).getResult();
		}
	}

	public static void loadData() {
		String url = UrlServices.BASE_URL + UrlServices.ALL_MATCH_URL;
		JSONParser jParser = new JSONParser();
		JSONObject jobject = jParser.getJSONFromUrl(url);

		try {
			JSONArray data = jobject.getJSONArray("data");
			int count = data.length();
			Log.v("count", count + "");
			id = new String[count];
			team1 = new String[count];
			team2 = new String[count];
			time_fight = new String[count];
			flag_team_1 = new String[count];
			flag_team_2 = new String[count];
			resufts = new String[count];
			calendarDAO = new CalendarDAO(context);
			calendarDAO.deleteAllCalendar();
			for (int i = 0; i < count; i++) {
				flag_team_1[i] = data.getJSONObject(i).getString("flag_team_1");
				flag_team_2[i] = data.getJSONObject(i).getString("flag_team_2");
				id[i] = data.getJSONObject(i).getString("calendar_id");
				team1[i] = data.getJSONObject(i).getString("team_code_1");
				team2[i] = data.getJSONObject(i).getString("team_code_2");
				time_fight[i] = data.getJSONObject(i).getString("time_fight");
				resufts[i] = data.getJSONObject(i).getString("result");
				// Log.v("link", flag_team_1[i].toString() + " ");
				Matches calenderEntity = new Matches();
				calenderEntity.setNameteam1(flag_team_1[i]);
				calenderEntity.setNameteam2(flag_team_2[i]);
				calenderEntity.setDatetime(time_fight[i]);
				calenderEntity.setResult(resufts[i]);
				calendarDAO.insertCalendar(calenderEntity);
			}

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
