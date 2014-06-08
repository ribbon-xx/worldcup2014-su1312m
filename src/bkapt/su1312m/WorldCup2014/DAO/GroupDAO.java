package bkapt.su1312m.WorldCup2014.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import bkapt.su1312m.WorldCup2014.DTO.GroupDTO;
import bkapt.su1312m.WorldCup2014.DatabaseUtils.CreateDatabase;

/**
 * Created by RibboN on 8/6/2014.
 */
public class GroupDAO
{
    private final SQLiteDatabase db;

    public GroupDAO(Context context){
        this.db = CreateDatabase.openWrite(context);
    }

    public int updateGroup(GroupDTO groupDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, groupDTO.getGroupId());
        contentValues.put(KEY_GROUP_NAME, groupDTO.getGroupName());
        return db.update(TABLE_GROUP_NAME, contentValues, null, null);
    }

    public long insertgroup(GroupDTO groupDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, groupDTO.getGroupId());
        contentValues.put(KEY_GROUP_NAME, groupDTO.getGroupName());
        return db.insert(TABLE_GROUP_NAME, null, contentValues);
    }

    public int deleteAllgroup(){
        return db.delete(TABLE_GROUP_NAME, null, null);
    }

    public static final String TABLE_GROUP_NAME = "Group";

    public static final String KEY_ID = "groupId";
    public static final String KEY_GROUP_NAME = "groupName";

    private static final String DATABASE_CREATE_GROUP = "Create Table "
            + TABLE_GROUP_NAME + "(" + KEY_ID + " bigint primary key," + KEY_GROUP_NAME + " text" + ")";

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_GROUP);
    }
}
