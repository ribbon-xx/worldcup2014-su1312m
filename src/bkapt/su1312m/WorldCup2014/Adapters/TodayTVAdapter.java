package bkapt.su1312m.WorldCup2014.Adapters;

import java.util.ArrayList;
import java.util.zip.Inflater;

import bkapt.su1312m.WorldCup2014.R;
import bkapt.su1312m.WorldCup2014.Utils.Matches;
import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TodayTVAdapter extends ArrayAdapter<Matches>{
	private ArrayList<Matches> list;
	private Context context;
	public TodayTVAdapter(Context context, int resource,
			ArrayList<Matches> list) {
		super(context, resource,list);
		this.list = list;
		context = context;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		class Viewholder{
			ImageView team1;
			ImageView team2;
			TextView nameteam1;
			TextView nameteam2;
			TextView result;
			TextView datetime;
		}
		Viewholder viewholder;
		if(convertView == null){
			convertView =  View.inflate(getContext(), R.layout.itemrowtodaytv, null);
		}
		Matches obj = getItem(position);
		if(obj != null){
			
			viewholder = new Viewholder();
			viewholder.team1 = (ImageView) convertView.findViewById(R.id.team1);
			viewholder.team2 = (ImageView) convertView.findViewById(R.id.team2);
			viewholder.nameteam1 = (TextView) convertView.findViewById(R.id.tvNameteam1);
			viewholder.nameteam2 = (TextView) convertView.findViewById(R.id.tvNameteam2);
			viewholder.result = (TextView) convertView.findViewById(R.id.tvResult);
			viewholder.datetime = (TextView) convertView.findViewById(R.id.tvDatetime);
			viewholder.nameteam1.setText(obj.getNameteam1());
			viewholder.nameteam2.setText(obj.getNameteam2());
			viewholder.result.setText(obj.getResult());
			viewholder.datetime.setText(obj.getDatetime());
			switch (obj.getNameteam1()) {
			case "brazil":
				viewholder.team1.setBackgroundResource(R.drawable.icon_brazil);
				break;
			case "Croatia":
				viewholder.team1.setBackgroundResource(R.drawable.icon_croatia);
				break;
			case "mexico":
				viewholder.team1.setBackgroundResource(R.drawable.icon_mexico);
				break;
			case "cameroon":
				viewholder.team1.setBackgroundResource(R.drawable.icon_cameroon);
				break;
			case "spain":
				viewholder.team1.setBackgroundResource(R.drawable.icon_spain);
				break;
			case "Netherlands":
				viewholder.team1.setBackgroundResource(R.drawable.icon_netherland);
				break;
			case "Chile":
				viewholder.team1.setBackgroundResource(R.drawable.icon_chile);
				break;
			case "Australia":
				viewholder.team1.setBackgroundResource(R.drawable.icon_australia);
				break;
			case "Colombia":
				viewholder.team1.setBackgroundResource(R.drawable.icon_colombia);
				break;
			case "Greece":
				viewholder.team1.setBackgroundResource(R.drawable.icon_greece);
				break;
			case "Ivory Coast":
				viewholder.team1.setBackgroundResource(R.drawable.icon_ivory_coast);
				break;
			case "Japan":
				viewholder.team1.setBackgroundResource(R.drawable.icon_japan);
				break;
			case "Uruguay":
				viewholder.team1.setBackgroundResource(R.drawable.icon_uruguay);
				break;
			case "Costa Rica":
				viewholder.team1.setBackgroundResource(R.drawable.icon_costa_rica);
				break;
			case "England":
				viewholder.team1.setBackgroundResource(R.drawable.icon_england);
				break;
			case "Italy":
				viewholder.team1.setBackgroundResource(R.drawable.icon_italy);
				break;
			case "Switzerland":
				viewholder.team1.setBackgroundResource(R.drawable.icon_switzerland);
				break;
			case "Ecuador":
				viewholder.team1.setBackgroundResource(R.drawable.icon_ecuador);
				break;
			case "France":
				viewholder.team1.setBackgroundResource(R.drawable.icon_france);
				break;
			case "Honduras":
				viewholder.team1.setBackgroundResource(R.drawable.icon_honduras);
				break;
			case "Argentina":
				viewholder.team1.setBackgroundResource(R.drawable.icon_argentina);
				break;
			case "Bosnia and Herzegovina":
				viewholder.team1.setBackgroundResource(R.drawable.icon_bosnia);
				break;
			case "Iran":
				viewholder.team1.setBackgroundResource(R.drawable.icon_iran);
				break;
			case "Nigeria":
				viewholder.team1.setBackgroundResource(R.drawable.icon_nigeria);
				break;
			case "Germany":
				viewholder.team1.setBackgroundResource(R.drawable.icon_germany);
				break;
			case "Portugal":
				viewholder.team1.setBackgroundResource(R.drawable.icon_portugal);
				break;
			case "Ghana":
				viewholder.team1.setBackgroundResource(R.drawable.icon_ghana);
				break;
			case "USA":
				viewholder.team1.setBackgroundResource(R.drawable.icon_usa);
				break;
			case "Belgium":
				viewholder.team1.setBackgroundResource(R.drawable.icon_belgium);
				break;
			case "Algeria":
				viewholder.team1.setBackgroundResource(R.drawable.icon_algeria);
				break;
			case "Russia":
				viewholder.team1.setBackgroundResource(R.drawable.icon_russia);
				break;
			case "Korea":
				viewholder.team1.setBackgroundResource(R.drawable.icon_korea);
				break;

			default:
				break;
			}
			switch (obj.getNameteam2()) {
			case "brazil":
				viewholder.team2.setBackgroundResource(R.drawable.icon_brazil);
				break;
			case "Croatia":
				viewholder.team2.setBackgroundResource(R.drawable.icon_croatia);
				break;
			case "mexico":
				viewholder.team2.setBackgroundResource(R.drawable.icon_mexico);
				break;
			case "cameroon":
				viewholder.team2.setBackgroundResource(R.drawable.icon_cameroon);
				break;
			case "spain":
				viewholder.team2.setBackgroundResource(R.drawable.icon_spain);
				break;
			case "Netherlands":
				viewholder.team2.setBackgroundResource(R.drawable.icon_netherland);
				break;
			case "Chile":
				viewholder.team2.setBackgroundResource(R.drawable.icon_chile);
				break;
			case "Australia":
				viewholder.team2.setBackgroundResource(R.drawable.icon_australia);
				break;
			case "Colombia":
				viewholder.team2.setBackgroundResource(R.drawable.icon_colombia);
				break;
			case "Greece":
				viewholder.team2.setBackgroundResource(R.drawable.icon_greece);
				break;
			case "Ivory Coast":
				viewholder.team2.setBackgroundResource(R.drawable.icon_ivory_coast);
				break;
			case "Japan":
				viewholder.team2.setBackgroundResource(R.drawable.icon_japan);
				break;
			case "Uruguay":
				viewholder.team2.setBackgroundResource(R.drawable.icon_uruguay);
				break;
			case "Costa Rica":
				viewholder.team2.setBackgroundResource(R.drawable.icon_costa_rica);
				break;
			case "England":
				viewholder.team2.setBackgroundResource(R.drawable.icon_england);
				break;
			case "Italy":
				viewholder.team2.setBackgroundResource(R.drawable.icon_italy);
				break;
			case "Switzerland":
				viewholder.team2.setBackgroundResource(R.drawable.icon_switzerland);
				break;
			case "Ecuador":
				viewholder.team2.setBackgroundResource(R.drawable.icon_ecuador);
				break;
			case "France":
				viewholder.team2.setBackgroundResource(R.drawable.icon_france);
				break;
			case "Honduras":
				viewholder.team2.setBackgroundResource(R.drawable.icon_honduras);
				break;
			case "Argentina":
				viewholder.team2.setBackgroundResource(R.drawable.icon_argentina);
				break;
			case "Bosnia and Herzegovina":
				viewholder.team2.setBackgroundResource(R.drawable.icon_bosnia);
				break;
			case "Iran":
				viewholder.team2.setBackgroundResource(R.drawable.icon_iran);
				break;
			case "Nigeria":
				viewholder.team2.setBackgroundResource(R.drawable.icon_nigeria);
				break;
			case "Germany":
				viewholder.team2.setBackgroundResource(R.drawable.icon_germany);
				break;
			case "Portugal":
				viewholder.team2.setBackgroundResource(R.drawable.icon_portugal);
				break;
			case "Ghana":
				viewholder.team2.setBackgroundResource(R.drawable.icon_ghana);
				break;
			case "USA":
				viewholder.team2.setBackgroundResource(R.drawable.icon_usa);
				break;
			case "Belgium":
				viewholder.team2.setBackgroundResource(R.drawable.icon_belgium);
				break;
			case "Algeria":
				viewholder.team2.setBackgroundResource(R.drawable.icon_algeria);
				break;
			case "Russia":
				viewholder.team2.setBackgroundResource(R.drawable.icon_russia);
				break;
			case "Korea":
				viewholder.team2.setBackgroundResource(R.drawable.icon_korea);
				break;

			default:
				break;
			}
		}
		return convertView;
	}

}
