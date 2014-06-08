package bkapt.su1312m.WorldCup2014.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import bkapt.su1312m.WorldCup2014.DTO.TeamDTO;
import bkapt.su1312m.WorldCup2014.DatabaseUtils.CreateDatabase;

/**
 * Created by RibboN on 8/6/2014.
 */
public class TeamDAO
{
    private final SQLiteDatabase db;

    public TeamDAO(Context context){
        this.db = CreateDatabase.openWrite(context);
    }

    public int updateTeam(TeamDTO teamDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, teamDTO.getTeamId());
        contentValues.put(KEY_TEAM_NAME, teamDTO.getTeamName());
        contentValues.put(KEY_TEAM_FLAG, teamDTO.getTeamFlag());
        contentValues.put(KEY_GROUP_ID, teamDTO.getGroupId());
        return db.update(TABLE_TEAM_NAME, contentValues, null, null);
    }

    public long insertteam(TeamDTO teamDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, teamDTO.getTeamId());
        contentValues.put(KEY_TEAM_NAME, teamDTO.getTeamName());
        contentValues.put(KEY_TEAM_FLAG, teamDTO.getTeamFlag());
        contentValues.put(KEY_GROUP_ID, teamDTO.getGroupId());
        return db.insert(TABLE_TEAM_NAME, null, contentValues);
    }

    public int deleteAllteam(){
        return db.delete(TABLE_TEAM_NAME, null, null);
    }

    public static final String TABLE_TEAM_NAME = "Team";

    public static final String KEY_ID = "teamId";
    public static final String KEY_TEAM_NAME = "teamName";
    public static final String KEY_TEAM_FLAG = "teamFlag";
    public static final String KEY_GROUP_ID = "groupId";


    private static final String DATABASE_CREATE_TEAM = "Create Table "
            + TABLE_TEAM_NAME + "(" + KEY_ID + " bigint primary key," + KEY_TEAM_NAME + " text" + KEY_TEAM_FLAG + " text,"
            + KEY_GROUP_ID + " bigint" +  ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_TEAM);
    }
}