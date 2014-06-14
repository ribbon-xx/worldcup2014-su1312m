package bkapt.su1312m.WorldCup2014.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bkapt.su1312m.WorldCup2014.R;
import bkapt.su1312m.WorldCup2014.Utils.Matches;

import java.util.ArrayList;

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

            if (obj.getNameteam1().equals("brazil")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_brazil);

            } else if (obj.getNameteam1().equals("Croatia")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_croatia);

            } else if (obj.getNameteam1().equals("mexico")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_mexico);

            } else if (obj.getNameteam1().equals("cameroon")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_cameroon);

            } else if (obj.getNameteam1().equals("spain")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_spain);

            } else if (obj.getNameteam1().equals("Netherlands")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_netherland);

            } else if (obj.getNameteam1().equals("Chile")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_chile);

            } else if (obj.getNameteam1().equals("Australia")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_australia);

            } else if (obj.getNameteam1().equals("Colombia")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_colombia);

            } else if (obj.getNameteam1().equals("Greece")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_greece);

            } else if (obj.getNameteam1().equals("Ivory Coast")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_ivory_coast);

            } else if (obj.getNameteam1().equals("Japan")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_japan);

            } else if (obj.getNameteam1().equals("Uruguay")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_uruguay);

            } else if (obj.getNameteam1().equals("Costa Rica")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_costa_rica);

            } else if (obj.getNameteam1().equals("England")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_england);

            } else if (obj.getNameteam1().equals("Italy")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_italy);

            } else if (obj.getNameteam1().equals("Switzerland")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_switzerland);

            } else if (obj.getNameteam1().equals("Ecuador")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_ecuador);

            } else if (obj.getNameteam1().equals("France")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_france);

            } else if (obj.getNameteam1().equals("Honduras")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_honduras);

            } else if (obj.getNameteam1().equals("Argentina")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_argentina);

            } else if (obj.getNameteam1().equals("Bosnia and Herzegovina")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_bosnia);

            } else if (obj.getNameteam1().equals("Iran")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_iran);

            } else if (obj.getNameteam1().equals("Nigeria")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_nigeria);

            } else if (obj.getNameteam1().equals("Germany")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_germany);

            } else if (obj.getNameteam1().equals("Portugal")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_portugal);

            } else if (obj.getNameteam1().equals("Ghana")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_ghana);

            } else if (obj.getNameteam1().equals("USA")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_usa);

            } else if (obj.getNameteam1().equals("Belgium")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_belgium);

            } else if (obj.getNameteam1().equals("Algeria")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_algeria);

            } else if (obj.getNameteam1().equals("Russia")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_russia);

            } else if (obj.getNameteam1().equals("Korea")) {
                viewholder.team1.setBackgroundResource(R.drawable.icon_korea);

            } else {
            }
            if (obj.getNameteam2().equals("brazil")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_brazil);

            } else if (obj.getNameteam2().equals("Croatia")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_croatia);

            } else if (obj.getNameteam2().equals("mexico")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_mexico);

            } else if (obj.getNameteam2().equals("cameroon")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_cameroon);

            } else if (obj.getNameteam2().equals("spain")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_spain);

            } else if (obj.getNameteam2().equals("Netherlands")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_netherland);

            } else if (obj.getNameteam2().equals("Chile")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_chile);

            } else if (obj.getNameteam2().equals("Australia")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_australia);

            } else if (obj.getNameteam2().equals("Colombia")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_colombia);

            } else if (obj.getNameteam2().equals("Greece")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_greece);

            } else if (obj.getNameteam2().equals("Ivory Coast")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_ivory_coast);

            } else if (obj.getNameteam2().equals("Japan")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_japan);

            } else if (obj.getNameteam2().equals("Uruguay")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_uruguay);

            } else if (obj.getNameteam2().equals("Costa Rica")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_costa_rica);

            } else if (obj.getNameteam2().equals("England")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_england);

            } else if (obj.getNameteam2().equals("Italy")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_italy);

            } else if (obj.getNameteam2().equals("Switzerland")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_switzerland);

            } else if (obj.getNameteam2().equals("Ecuador")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_ecuador);

            } else if (obj.getNameteam2().equals("France")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_france);

            } else if (obj.getNameteam2().equals("Honduras")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_honduras);

            } else if (obj.getNameteam2().equals("Argentina")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_argentina);

            } else if (obj.getNameteam2().equals("Bosnia and Herzegovina")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_bosnia);

            } else if (obj.getNameteam2().equals("Iran")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_iran);

            } else if (obj.getNameteam2().equals("Nigeria")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_nigeria);

            } else if (obj.getNameteam2().equals("Germany")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_germany);

            } else if (obj.getNameteam2().equals("Portugal")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_portugal);

            } else if (obj.getNameteam2().equals("Ghana")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_ghana);

            } else if (obj.getNameteam2().equals("USA")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_usa);

            } else if (obj.getNameteam2().equals("Belgium")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_belgium);

            } else if (obj.getNameteam2().equals("Algeria")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_algeria);

            } else if (obj.getNameteam2().equals("Russia")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_russia);

            } else if (obj.getNameteam2().equals("Korea")) {
                viewholder.team2.setBackgroundResource(R.drawable.icon_korea);

            } else {
            }
		}
		return convertView;
	}

}
