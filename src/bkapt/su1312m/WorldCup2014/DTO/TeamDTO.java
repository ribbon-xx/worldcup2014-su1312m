
package bkapt.su1312m.WorldCup2014.DTO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RibboN on 8/6/2014.
 */
public class TeamDTO implements Parcelable
{
    private long teamId;
    private String teamName;
    private String teamFlag;
    private long groupId;

    public TeamDTO()
    {
    }

    public long getTeamId()
    {
        return teamId;
    }

    public void setTeamId(long teamId)
    {
        this.teamId = teamId;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getTeamFlag()
    {
        return teamFlag;
    }

    public void setTeamFlag(String teamFlag)
    {
        this.teamFlag = teamFlag;
    }

    public long getGroupId()
    {
        return groupId;
    }

    public void setGroupId(long groupId)
    {
        this.groupId = groupId;
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
