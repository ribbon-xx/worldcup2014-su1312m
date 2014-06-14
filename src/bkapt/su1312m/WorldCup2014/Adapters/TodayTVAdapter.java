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

public class TodayTVAdapter extends ArrayAdapter<Matches> {
	private ArrayList<Matches> list;
	private Context context;

	public TodayTVAdapter(Context context, int resource, ArrayList<Matches> list) {
		super(context, resource, list);
		this.list = list;
		context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		class Viewholder {
			ImageView team1;
			ImageView team2;
			TextView nameteam1;
			TextView nameteam2;
			TextView result;
			TextView datetime;
		}
		Viewholder viewholder;
		if (convertView == null) {
			convertView = View.inflate(getContext(), R.layout.itemrowtodaytv,
					null);
		}
		Matches obj = getItem(position);
		if (obj != null) {

			viewholder = new Viewholder();
			viewholder.team1 = (ImageView) convertView.findViewById(R.id.team1);
			viewholder.team2 = (ImageView) convertView.findViewById(R.id.team2);
			viewholder.nameteam1 = (TextView) convertView
					.findViewById(R.id.tvNameteam1);
			viewholder.nameteam2 = (TextView) convertView
					.findViewById(R.id.tvNameteam2);
			viewholder.result = (TextView) convertView
					.findViewById(R.id.tvResult);
			viewholder.datetime = (TextView) convertView
					.findViewById(R.id.tvDatetime);
			viewholder.nameteam1.setText(obj.getNameteam1());
			viewholder.nameteam2.setText(obj.getNameteam2());
			viewholder.result.setText(obj.getResult());
			viewholder.datetime.setText(obj.getDatetime());
			if (obj.getNameteam1().equalsIgnoreCase("brazil")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_brazil);
			} else if (obj.getNameteam1().equalsIgnoreCase("Croatia")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_croatia);
			} else if (obj.getNameteam1().equalsIgnoreCase("mexico")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_mexico);
			} else if (obj.getNameteam1().equalsIgnoreCase("cameroon")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_cameroon);
			} else if (obj.getNameteam1().equalsIgnoreCase("spain")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_spain);
			} else if (obj.getNameteam1().equalsIgnoreCase("Netherlands")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_netherland);
			} else if (obj.getNameteam1().equalsIgnoreCase("Chile")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_chile);
			} else if (obj.getNameteam1().equalsIgnoreCase("Australia")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_australia);
			} else if (obj.getNameteam1().equalsIgnoreCase("Colombia")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_colombia);
			} else if (obj.getNameteam1().equalsIgnoreCase("Greece")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_greece);
			} else if (obj.getNameteam1().equalsIgnoreCase("Ivory Coast")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_ivory_coast);
			} else if (obj.getNameteam1().equalsIgnoreCase("Japan")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_japan);
			} else if (obj.getNameteam1().equalsIgnoreCase("Uruguay")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_uruguay);
			} else if (obj.getNameteam1().equalsIgnoreCase("Costa Rica")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_costa_rica);
			} else if (obj.getNameteam1().equalsIgnoreCase("England")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_england);
			} else if (obj.getNameteam1().equalsIgnoreCase("Italy")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_italy);
			} else if (obj.getNameteam1().equalsIgnoreCase("Switzerland")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_switzerland);
			} else if (obj.getNameteam1().equalsIgnoreCase("Ecuador")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_ecuador);
			} else if (obj.getNameteam1().equalsIgnoreCase("France")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_france);
			} else if (obj.getNameteam1().equalsIgnoreCase("Honduras")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_honduras);
			} else if (obj.getNameteam1().equalsIgnoreCase("Argentina")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_argentina);
			} else if (obj.getNameteam1().equalsIgnoreCase(
					"Bosnia and Herzegovina")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_bosnia);
			} else if (obj.getNameteam1().equalsIgnoreCase("Iran")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_iran);
			} else if (obj.getNameteam1().equalsIgnoreCase("Nigeria")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_netherland);
			} else if (obj.getNameteam1().equalsIgnoreCase("Germany")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_germany);
			} else if (obj.getNameteam1().equalsIgnoreCase("Portugal")) {
				viewholder.team1
						.setBackgroundResource(R.drawable.icon_portugal);
			} else if (obj.getNameteam1().equalsIgnoreCase("Ghana")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_ghana);
			} else if (obj.getNameteam1().equalsIgnoreCase("USA")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_usa);
			} else if (obj.getNameteam1().equalsIgnoreCase("Belgium")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_belgium);
			} else if (obj.getNameteam1().equalsIgnoreCase("Algeria")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_algeria);
			} else if (obj.getNameteam1().equalsIgnoreCase("Russia")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_russia);
			} else if (obj.getNameteam1().equalsIgnoreCase("Korea")) {
				viewholder.team1.setBackgroundResource(R.drawable.icon_korea);
			}
			
			
			
			
			
			
			if (obj.getNameteam2().equalsIgnoreCase("brazil")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_brazil);
			} else if (obj.getNameteam2().equalsIgnoreCase("Croatia")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_croatia);
			} else if (obj.getNameteam2().equalsIgnoreCase("mexico")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_mexico);
			} else if (obj.getNameteam2().equalsIgnoreCase("cameroon")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_cameroon);
			} else if (obj.getNameteam2().equalsIgnoreCase("spain")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_spain);
			} else if (obj.getNameteam2().equalsIgnoreCase("Netherlands")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_netherland);
			} else if (obj.getNameteam2().equalsIgnoreCase("Chile")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_chile);
			} else if (obj.getNameteam2().equalsIgnoreCase("Australia")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_australia);
			} else if (obj.getNameteam2().equalsIgnoreCase("Colombia")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_colombia);
			} else if (obj.getNameteam2().equalsIgnoreCase("Greece")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_greece);
			} else if (obj.getNameteam2().equalsIgnoreCase("Ivory Coast")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_ivory_coast);
			} else if (obj.getNameteam2().equalsIgnoreCase("Japan")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_japan);
			} else if (obj.getNameteam2().equalsIgnoreCase("Uruguay")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_uruguay);
			} else if (obj.getNameteam2().equalsIgnoreCase("Costa Rica")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_costa_rica);
			} else if (obj.getNameteam2().equalsIgnoreCase("England")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_england);
			} else if (obj.getNameteam2().equalsIgnoreCase("Italy")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_italy);
			} else if (obj.getNameteam2().equalsIgnoreCase("Switzerland")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_switzerland);
			} else if (obj.getNameteam2().equalsIgnoreCase("Ecuador")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_ecuador);
			} else if (obj.getNameteam2().equalsIgnoreCase("France")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_france);
			} else if (obj.getNameteam2().equalsIgnoreCase("Honduras")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_honduras);
			} else if (obj.getNameteam2().equalsIgnoreCase("Argentina")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_argentina);
			} else if (obj.getNameteam2().equalsIgnoreCase(
					"Bosnia and Herzegovina")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_bosnia);
			} else if (obj.getNameteam2().equalsIgnoreCase("Iran")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_iran);
			} else if (obj.getNameteam2().equalsIgnoreCase("Nigeria")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_netherland);
			} else if (obj.getNameteam2().equalsIgnoreCase("Germany")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_germany);
			} else if (obj.getNameteam2().equalsIgnoreCase("Portugal")) {
				viewholder.team2
						.setBackgroundResource(R.drawable.icon_portugal);
			} else if (obj.getNameteam2().equalsIgnoreCase("Ghana")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_ghana);
			} else if (obj.getNameteam2().equalsIgnoreCase("USA")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_usa);
			} else if (obj.getNameteam2().equalsIgnoreCase("Belgium")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_belgium);
			} else if (obj.getNameteam2().equalsIgnoreCase("Algeria")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_algeria);
			} else if (obj.getNameteam2().equalsIgnoreCase("Russia")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_russia);
			} else if (obj.getNameteam2().equalsIgnoreCase("Korea")) {
				viewholder.team2.setBackgroundResource(R.drawable.icon_korea);
			}
		}
		return convertView;
	}

}
