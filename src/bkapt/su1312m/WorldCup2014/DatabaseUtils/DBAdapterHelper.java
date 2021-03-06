package bkapt.su1312m.WorldCup2014.DatabaseUtils;

/**
 * Created by RibboN on 8/6/2014.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bkapt.su1312m.WorldCup2014.DAO.CalendarDAO;
import bkapt.su1312m.WorldCup2014.DAO.GroupDAO;
import bkapt.su1312m.WorldCup2014.DAO.TeamDAO;
import bkapt.su1312m.WorldCup2014.DAO.UserDAO;

public class DBAdapterHelper extends SQLiteOpenHelper
{

    private static DBAdapterHelper helper;

    private static final String DATABASE_NAME = "WCSU1312M";
    private static final int DATABASE_VERSION = 1;

    public static DBAdapterHelper getInstance(Context context) {
        if (helper == null) {
            helper = new DBAdapterHelper(context);
        }
        return helper;
    }

    public DBAdapterHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CalendarDAO.onCreate(db);
        GroupDAO.onCreate(db);
        TeamDAO.onCreate(db);
        UserDAO.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
