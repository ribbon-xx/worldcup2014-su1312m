package bkapt.su1312m.WorldCup2014.Utils;

public class Matches {
	private String nameteam1;
	private String nameteam2;
	private String result;
	private String datetime;
	
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
	
	public Matches(String nameteam1, String nameteam2, String result,
			String datetime) {
		this.nameteam1 = nameteam1;
		this.nameteam2 = nameteam2;
		this.result = result;
		this.datetime = datetime;
	}
	public Matches() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Matches [nameteam1=" + nameteam1 + ", nameteam2=" + nameteam2
				+ ", result=" + result + ", datetime=" + datetime + "]";
	}
	
	
	

}
