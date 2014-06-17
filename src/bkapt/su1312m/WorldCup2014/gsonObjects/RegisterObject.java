package bkapt.su1312m.WorldCup2014.gsonObjects;

import com.google.gson.annotations.SerializedName;

public class RegisterObject {
	
	@SerializedName("success")
	public int success;
	@SerializedName("exists")
	public int exists;
	
	@SerializedName("identify_number")
	public String identify_number;
	
	@SerializedName("same_Result")
	public String same_Result;
	@SerializedName("player_most_goals")
	public String player_most_goals;
	@SerializedName("goals_number")
	public String goals_number;
	@SerializedName("best_player")
	public String best_player;
	@SerializedName("team_ID")
	public String team_ID;
	@SerializedName("time_Result")
	public String time_Result;
	
	@SerializedName("current_time")
	public String current_time;
	
	
	

}
