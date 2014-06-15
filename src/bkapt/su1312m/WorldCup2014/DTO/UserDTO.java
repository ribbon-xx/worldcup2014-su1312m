
package bkapt.su1312m.WorldCup2014.DTO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RibboN on 8/6/2014.
 */
public class UserDTO implements Parcelable
{
    private String userName;
    private int phone;
    private String email;
    private int number;
    private String address;
    private String work;
    private int teamId;
    private String player_most_goals;
    private int goals_number;
    private String player_best;
    private int sameResult;


    public UserDTO(String userName, int phone, String email, int number, String address, String work, int teamId, String player_most_goals, int goals_number, String player_best, int sameResult) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.number = number;
        this.address = address;
        this.work = work;
        this.teamId = teamId;
        this.player_most_goals = player_most_goals;
        this.goals_number = goals_number;
        this.player_best = player_best;
        this.sameResult = sameResult;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPlayer_most_goals() {
        return player_most_goals;
    }

    public void setPlayer_most_goals(String player_most_goals) {
        this.player_most_goals = player_most_goals;
    }

    public int getGoals_number() {
        return goals_number;
    }

    public void setGoals_number(int goals_number) {
        this.goals_number = goals_number;
    }

    public String getPlayer_best() {
        return player_best;
    }

    public void setPlayer_best(String player_best) {
        this.player_best = player_best;
    }

    public int getSameResult() {
        return sameResult;
    }

    public void setSameResult(int sameResult) {
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
