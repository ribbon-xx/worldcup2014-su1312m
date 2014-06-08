
package bkapt.su1312m.WorldCup2014.DTO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RibboN on 8/6/2014.
 */
public class UserDTO implements Parcelable
{
    private String userName;
    private String password;
    private String classCode;
    private String teamId;
    private int sameResult;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getClassCode()
    {
        return classCode;
    }

    public void setClassCode(String classCode)
    {
        this.classCode = classCode;
    }

    public String getTeamId()
    {
        return teamId;
    }

    public void setTeamId(String teamId)
    {
        this.teamId = teamId;
    }

    public int getSameResult()
    {
        return sameResult;
    }

    public void setSameResult(int sameResult)
    {
        this.sameResult = sameResult;
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
