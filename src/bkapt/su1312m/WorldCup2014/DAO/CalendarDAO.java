package bkapt.su1312m.WorldCup2014.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import bkapt.su1312m.WorldCup2014.DTO.CalendarDTO;
import bkapt.su1312m.WorldCup2014.DatabaseUtils.CreateDatabase;

/**
 * Created by RibboN on 8/6/2014.
 */
public class CalendarDAO
{
    private final SQLiteDatabase db;

    public CalendarDAO(Context context){
        this.db = CreateDatabase.openWrite(context);
    }

    public int updateCalendar(CalendarDTO calendarDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TEAM1_ID, calendarDTO.getTeam1Id());
        contentValues.put(KEY_TEAM2_ID, calendarDTO.getTeam2Id());
        contentValues.put(KEY_TIME_FIGHT, calendarDTO.getTimeFight());
        contentValues.put(KEY_RESULT, calendarDTO.getResult());
        return db.update(TABLE_CALENDAR_NAME, contentValues, null, null);
    }

    public long insertCalendar(CalendarDTO calendarDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TEAM1_ID, calendarDTO.getTeam1Id());
        contentValues.put(KEY_TEAM2_ID, calendarDTO.getTeam2Id());
        contentValues.put(KEY_TIME_FIGHT, calendarDTO.getTimeFight());
        contentValues.put(KEY_RESULT, calendarDTO.getResult());
        return db.insert(TABLE_CALENDAR_NAME, null, contentValues);
    }

    public int deleteAllCalendar(){
        return db.delete(TABLE_CALENDAR_NAME, null, null);
    }

    public static final String TABLE_CALENDAR_NAME = "Calendar";

    public static final String KEY_ID = "calendarId";
    public static final String KEY_TEAM1_ID = "team1Id";
    public static final String KEY_TEAM2_ID = "team2Id";
    public static final String KEY_TIME_FIGHT = "timeFight";
    public static final String KEY_RESULT = "result";

    private static final String DATABASE_CREATE_CALENDAR = "Create Table "
            + TABLE_CALENDAR_NAME + "(" + KEY_ID + " integer primary key autoincrement," + KEY_TEAM1_ID + " bigint,"
            + KEY_TEAM2_ID + " bigint," + KEY_TIME_FIGHT + " bigint," + KEY_RESULT + " text" + ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CALENDAR);
    }
}
