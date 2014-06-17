
package bkapt.su1312m.WorldCup2014;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TEAM {

    @SerializedName("-ID")
    private String _ID;
    @SerializedName("-ICON")
    private String _ICON;
    @SerializedName("PLAYER")
    private List<String> pLAYER = new ArrayList<String>();
    private boolean Visible;
    private String PlayerName;
    public TEAM Copy(){
    	TEAM t=new TEAM();
    	t.SetIcon(_ICON);
    	t.SetID(_ID);
    	t.SetPlayer(pLAYER);
    	return t;
    }
    public void SetID(String ID){
    	this._ID=ID;
    }
    public void SetPlayer(List<String> Player){
    	this.pLAYER=Player;
    }
    public void SetIcon(String Icon){
    	this._ICON=Icon;
    }
	public List<String> GetListPlayerOfTeam(){
		return this.pLAYER;
	}
	public String GetTeamID(){
		return this._ID;
	}
	
	public String GetIconTeam(){
		return this._ICON;
	}
	
	public String GetIconPlayer(){
		return this._ICON+"_player";
	}
	public String GetTeamName(){
		//_ICON="icon_braxin_abc" =>> Name=Brazin abc
		String name=_ICON.substring(5, _ICON.length()).replace('_', ' ');
		String first=String.valueOf(name.charAt(0)).toUpperCase()+name.substring(1, name.length());;
		return first;
	}
	public void SetVisible(boolean _Visible){
		this.Visible=_Visible;
	}
	public boolean GetVisible(){
		return this.Visible;
	}
	public String GetNumberPlayerOfTeam(){
		return "Số lượng cầu thủ: "+this.GetListPlayerOfTeam().size();
	}
	public void SetPlayerName(int index){
		this.PlayerName=pLAYER.get(index);
	}
	public String GetPlayerName(){
		int index=PlayerName.indexOf("(");
		if(index==-1) return this.PlayerName;
		else{
			return PlayerName.substring(0,index-1);
		}
	}
	
}
