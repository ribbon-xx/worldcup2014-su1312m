
package bkapt.su1312m.WorldCup2014;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DATA implements Serializable{
    @SerializedName("TEAM")    
    private List<TEAM> tEAM = new ArrayList<TEAM>();
    public List<TEAM> GetListTeam(){
    	return this.tEAM;
    }
    public void SetListTeam(List<TEAM> ListTeam){
    	this.tEAM=ListTeam;
    }

}
