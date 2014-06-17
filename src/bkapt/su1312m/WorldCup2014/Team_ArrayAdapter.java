package bkapt.su1312m.WorldCup2014;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Team_ArrayAdapter extends ArrayAdapter<TEAM> {
	Activity context = null;
	int layoutId;
	ArrayList<TEAM> arr = null;

	public Team_ArrayAdapter(Activity context, int layoutId, ArrayList<TEAM> list) {
		super(context, layoutId, list);
		this.context = context;
		this.layoutId = layoutId;
		this.arr = list; 
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		try{

			//__________________________________________________________________________________________________
			if(convertView==null){
				LayoutInflater inflater = context.getLayoutInflater();
				convertView = inflater.inflate(layoutId, null);
				}
			//__________________________________________________________________________________________________		
			TEAM _Team=arr.get(position);
			ImageView ImageLeftSrc=(ImageView)convertView.findViewById(R.id.ImageViewLeft);
			ImageView ImageRightSrc=(ImageView)convertView.findViewById(R.id.ImageViewRight);
			TextView TextViewTeamName = (TextView)convertView.findViewById(R.id.TextViewTeamName);
			TextView TextViewPlayername = (TextView)convertView.findViewById(R.id.TextViewPlayername);
			RelativeLayout RL=(RelativeLayout)convertView.findViewById(R.id.RelativeLayoutMain);
			
			String uri_icon_Left;
			if(_Team.GetVisible()==false){
				uri_icon_Left= "drawable/icon_cup";
			}
			else{
				uri_icon_Left= "drawable/" + _Team.GetIconPlayer();
			}
			String uri_icon_Right = "drawable/" + _Team.GetIconTeam();
			
			int ImageLeft = convertView.getContext().getResources().getIdentifier(uri_icon_Left, null, convertView.getContext().getApplicationContext().getPackageName());
			Drawable Image_Left = convertView.getContext().getResources().getDrawable(ImageLeft);
			
			int ImageRight = convertView.getContext().getResources().getIdentifier(uri_icon_Right, null, convertView.getContext().getApplicationContext().getPackageName());
			Drawable Image_Right = convertView.getContext().getResources().getDrawable(ImageRight);
			//__________________________________________________________________________________________________
			
			if(_Team.GetVisible()==false){
				//Hiển thị thông tin của Tên đội + số lượng cầu thủ
				TextViewPlayername.setText(_Team.GetNumberPlayerOfTeam());
				TextViewTeamName.setText(_Team.GetTeamName());
			}	
			else{
				//Hiển thị thông tin tên cầu thủ, sau đó đến tên đội
				TextViewPlayername.setText(_Team.GetTeamName());
				TextViewTeamName.setText(_Team.GetPlayerName());  
			}
			RL.setBackgroundColor(Color.WHITE);
			ImageLeftSrc.setImageDrawable(Image_Left);
			ImageRightSrc.setImageDrawable(Image_Right);
			
		}
		catch(Exception ex){
			Toast.makeText(getContext(), "Error: "+ex.toString()+" : Position: "+position, Toast.LENGTH_LONG).show();
		}
		return convertView;
	}
}
