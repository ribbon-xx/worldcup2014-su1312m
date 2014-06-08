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
        contentValues.put(KEY_USER_NAME, userDTO.getUserName());
        contentValues.put(KEY_USER_PASSWORD, userDTO.getPassword());
        contentValues.put(KEY_CLASS_CODE, userDTO.getClassCode());
        contentValues.put(KEY_TEAM_ID, userDTO.getTeamId());
        contentValues.put(KEY_SAME_RESULT, userDTO.getSameResult());
        return db.update(TABLE_USER_NAME, contentValues, null, null);
    }

    public long insertuser(UserDTO userDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_NAME, userDTO.getUserName());
        contentValues.put(KEY_USER_PASSWORD, userDTO.getPassword());
        contentValues.put(KEY_CLASS_CODE, userDTO.getClassCode());
        contentValues.put(KEY_TEAM_ID, userDTO.getTeamId());
        contentValues.put(KEY_SAME_RESULT, userDTO.getSameResult());
        return db.insert(TABLE_USER_NAME, null, contentValues);
    }

    public int deleteAlluser(){
        return db.delete(TABLE_USER_NAME, null, null);
    }

    public static final String TABLE_USER_NAME = "User";

    public static final String KEY_ID = "userId";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_PASSWORD = "password";
    public static final String KEY_CLASS_CODE = "classCode";
    public static final String KEY_TEAM_ID = "groupId";
    public static final String KEY_SAME_RESULT = "sameResult";


    private static final String DATABASE_CREATE_USER = "Create Table "
            + TABLE_USER_NAME + "(" + KEY_ID + " integer primary key autoincrement," + KEY_USER_NAME + " text" + KEY_USER_PASSWORD + " text,"
            + KEY_CLASS_CODE + " text," + KEY_TEAM_ID + " bigint, " + KEY_SAME_RESULT + " integer" +  ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_USER);
    }
}