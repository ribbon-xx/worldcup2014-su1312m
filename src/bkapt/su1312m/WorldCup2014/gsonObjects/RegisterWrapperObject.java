package bkapt.su1312m.WorldCup2014.gsonObjects;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class RegisterWrapperObject {

	@SerializedName("data")
	public List<RegisterObject> registerObjects;
}
