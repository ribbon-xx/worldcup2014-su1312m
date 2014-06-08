package bkapt.su1312m.WorldCup2014.DTO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RibboN on 8/6/2014.
 */
public class GroupDTO implements Parcelable
{
    private long groupId;
    private String groupName;

    public GroupDTO()
    {
    }

    public long getGroupId()
    {
        return groupId;
    }

    public void setGroupId(long groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {

    }
}