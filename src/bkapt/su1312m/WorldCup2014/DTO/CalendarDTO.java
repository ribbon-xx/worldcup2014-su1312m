package bkapt.su1312m.WorldCup2014.DTO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RibboN on 8/6/2014.
 */
public class CalendarDTO implements Parcelable
{
    private long team1Id, team2Id;
    private long timeFight;
    private String result;

    public CalendarDTO()
    {
    }

    public long getTeam1Id()
    {
        return team1Id;
    }

    public void setTeam1Id(long team1Id)
    {
        this.team1Id = team1Id;
    }

    public long getTeam2Id()
    {
        return team2Id;
    }

    public void setTeam2Id(long team2Id)
    {
        this.team2Id = team2Id;
    }

    public long getTimeFight()
    {
        return timeFight;
    }

    public void setTimeFight(long timeFight)
    {
        this.timeFight = timeFight;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
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
