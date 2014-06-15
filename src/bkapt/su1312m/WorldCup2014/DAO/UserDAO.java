package bkapt.su1312m.WorldCup2014.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import bkapt.su1312m.WorldCup2014.DTO.UserDTO;
import bkapt.su1312m.WorldCup2014.DatabaseUtils.CreateDatabase;

/**
 * Created by RibboN on 8/6/2014.
 */
public class UserDAO
{
    private final SQLiteDatabase db;

    public UserDAO(Context context){
        this.db = CreateDatabase.openWrite(context);
    }

    public int updateUser(UserDTO userDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_IDE_NUMBER, userDTO.getNumber());
        contentValues.put(KEY_PLAYER_MOST_GOALS, userDTO.getPlayer_most_goals());
        contentValues.put(KEY_GOALS_NUMBER, userDTO.getGoals_number());
        contentValues.put(KEY_PLAYER_BEST, userDTO.getPlayer_best());
        contentValues.put(KEY_SAME_RESULT, userDTO.getSameResult());
        return db.update(TABLE_USER_NAME, contentValues, null, null);
    }

    public long insertuser(UserDTO userDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_NAME, userDTO.getUserName());
        contentValues.put(KEY_PHONE, userDTO.getPhone());
        contentValues.put(KEY_EMAIL, userDTO.getEmail());
        contentValues.put(KEY_IDE_NUMBER, userDTO.getNumber());
        contentValues.put(KEY_ADDRESS, userDTO.getAddress());
        contentValues.put(KEY_WORK, userDTO.getWork());
        contentValues.put(KEY_PLAYER_MOST_GOALS, userDTO.getPlayer_most_goals());
        contentValues.put(KEY_GOALS_NUMBER, userDTO.getGoals_number());
        contentValues.put(KEY_PLAYER_BEST, userDTO.getPlayer_best());
        contentValues.put(KEY_SAME_RESULT, userDTO.getSameResult());
        return db.insert(TABLE_USER_NAME, null, contentValues);
    }

    public int deleteAlluser(){
        return db.delete(TABLE_USER_NAME, null, null);
    }

    public static final String TABLE_USER_NAME = "User";

    public static final String KEY_ID = "userId";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_IDE_NUMBER = "number";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_WORK = "work";
    public static final String KEY_PLAYER_MOST_GOALS = "player_most_goals";
    public static final String KEY_GOALS_NUMBER = "goals_number";
    public static final String KEY_PLAYER_BEST = "player_best";
    public static final String KEY_SAME_RESULT = "sameResult";


    private static final String DATABASE_CREATE_USER = "Create Table "
            + TABLE_USER_NAME + "(" + KEY_ID + " integer primary key autoincrement," + KEY_USER_NAME + " text, " + KEY_PHONE + " integer,"
            + KEY_EMAIL + " text," + KEY_IDE_NUMBER + " integer, "+KEY_ADDRESS+ " text," +KEY_WORK+ " text, " +KEY_PLAYER_MOST_GOALS+ " text, "
            +KEY_GOALS_NUMBER+ " integer ," +KEY_PLAYER_BEST+ " text, " + KEY_SAME_RESULT + " integer" +  ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_USER);
    }
}