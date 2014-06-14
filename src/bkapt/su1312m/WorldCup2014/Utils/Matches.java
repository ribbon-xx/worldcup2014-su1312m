package bkapt.su1312m.WorldCup2014.Utils;

public class Matches {
	private String team1;
	private String team2;
	private String nameteam1;
	private String nameteam2;
	private String result;
	private String datetime;
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getNameteam1() {
		return nameteam1;
	}
	public void setNameteam1(String nameteam1) {
		this.nameteam1 = nameteam1;
	}
	public String getNameteam2() {
		return nameteam2;
	}
	public void setNameteam2(String nameteam2) {
		this.nameteam2 = nameteam2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public Matches(String team1, String team2, String nameteam1,
			String nameteam2, String result, String datetime) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.nameteam1 = nameteam1;
		this.nameteam2 = nameteam2;
		this.result = result;
		this.datetime = datetime;
	}
	public Matches(String nameteam1, String nameteam2, String result,
			String datetime) {
		super();
		this.nameteam1 = nameteam1;
		this.nameteam2 = nameteam2;
		this.result = result;
		this.datetime = datetime;
	}
	
	

}
