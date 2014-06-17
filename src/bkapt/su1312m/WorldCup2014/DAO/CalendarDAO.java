package bkapt.su1312m.WorldCup2014.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bkapt.su1312m.WorldCup2014.DTO.CalendarDTO;
import bkapt.su1312m.WorldCup2014.DatabaseUtils.CreateDatabase;
import bkapt.su1312m.WorldCup2014.Utils.Matches;

/**
 * Created by RibboN on 8/6/2014.
 */
public class CalendarDAO {
	private final SQLiteDatabase db;

	
	public CalendarDAO(Context context) {
		this.db = CreateDatabase.openWrite(context);
	}

	public List<Matches> getAllcalendar() {
		String query = "SELECT * FROM " + TABLE_CALENDAR_NAME;
		List<Matches> matches = new ArrayList<Matches>();
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				Matches match = new Matches();
				match.setNameteam1(cursor.getString(cursor
						.getColumnIndex(KEY_NAMETEAM1)));
				match.setNameteam2(cursor.getString(cursor
						.getColumnIndex(KEY_NAMETEAM2)));
				match.setDatetime(cursor.getString(cursor
						.getColumnIndex(KEY_TIME_FIGHT)));
				match.setResult(cursor.getString(cursor
						.getColumnIndex(KEY_RESULT)));
				matches.add(match);
			} while (cursor.moveToNext());
		}
		return matches;
	}

	public List<Matches> gettoday() {
		Date cDate = new Date();
		String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
		String query = "SELECT * FROM " + TABLE_CALENDAR_NAME + " WHERE "
				+ KEY_TIME_FIGHT + " like '%" + fDate + "%'";

		List<Matches> matchestoday = new ArrayList<Matches>();
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				Matches match = new Matches();
				match.setNameteam1(cursor.getString(cursor
						.getColumnIndex(KEY_NAMETEAM1)));
				match.setNameteam2(cursor.getString(cursor
						.getColumnIndex(KEY_NAMETEAM2)));
				match.setDatetime(cursor.getString(cursor
						.getColumnIndex(KEY_TIME_FIGHT)));
				match.setResult(cursor.getString(cursor
						.getColumnIndex(KEY_RESULT)));
				matchestoday.add(match);
			} while (cursor.moveToNext());
		}
		return matchestoday;

	}

	public int updateCalendar( Matches calendarDTO) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_NAMETEAM1, calendarDTO.getNameteam1());
		contentValues.put(KEY_NAMETEAM2, calendarDTO. getNameteam2());
		contentValues.put(KEY_TIME_FIGHT, calendarDTO.getDatetime());
		contentValues.put(KEY_RESULT, calendarDTO.getResult());
		return db.update(TABLE_CALENDAR_NAME, contentValues, null, null);
	}

	public long insertCalendar(Matches calendarDTO) {
		ContentValues contentValues = new ContentValues();
		
		contentValues.put(KEY_NAMETEAM1, calendarDTO.getNameteam1());
		contentValues.put(KEY_NAMETEAM2, calendarDTO. getNameteam2());
		contentValues.put(KEY_TIME_FIGHT, calendarDTO.getDatetime());
		contentValues.put(KEY_RESULT, calendarDTO.getResult());
		
		
		return db.insert(TABLE_CALENDAR_NAME, null, contentValues);
	}

	public int deleteAllCalendar() {
		return db.delete(TABLE_CALENDAR_NAME, null, null);
	}

	public static final String TABLE_CALENDAR_NAME = "Calendar";

	public static final String KEY_ID = "calendarId";
	
	public static final String KEY_NAMETEAM1 = "nameteam1";
	public static final String KEY_NAMETEAM2 = "nameteam2";
	static final String KEY_TIME_FIGHT = "timeFight";
	public static final String KEY_RESULT = "result";
	
	private static final String DATABASE_CREATE_CALENDAR = "Create Table "
			+ TABLE_CALENDAR_NAME + "(" + KEY_ID
			+ " integer primary key autoincrement," + KEY_NAMETEAM1 + " text,"
			+ KEY_NAMETEAM2 + " text, " + KEY_TIME_FIGHT + " text," 
			+ KEY_RESULT + " text" + ")";

	public static void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_CALENDAR);
	}
}
