package bkapt.su1312m.WorldCup2014.Adapters;

/**
 * Created by Long on 6/10/14.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bkapt.su1312m.WorldCup2014.R;

import java.util.HashMap;
import java.util.List;

public class CalendarListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private HashMap<String, List<String>> _listDataChildTeam1;
    private HashMap<String, List<String>> _listDataChildTeam2;
    private HashMap<String, List<String>> _listDataChildResuft;
    private HashMap<String, List<String>> _listFlagChildTeam1;
    private HashMap<String, List<String>> _listFlagChildTeam2;

    public CalendarListAdapter(Context context, List<String> listDataHeader,
                               HashMap<String, List<String>> listChildData,
                               HashMap<String, List<String>> listChildDataTeam1,
                               HashMap<String, List<String>> listChildDataTeam2,
                               HashMap<String, List<String>> listDataChildResuft,
                               HashMap<String, List<String>> listFlagChildTeam1,
                               HashMap<String, List<String>> listFlagChildTeam2) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this._listDataChildTeam1 = listChildDataTeam1;
        this._listDataChildTeam2 = listChildDataTeam2;
        this._listDataChildResuft = listDataChildResuft;
        this._listFlagChildTeam1 = listFlagChildTeam1;
        this._listFlagChildTeam2 = listFlagChildTeam2;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        // final String childText = (String) getChild(groupPosition,
        // childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        TextView txtListChildTeam1 = (TextView) convertView
                .findViewById(R.id.txtTeam1);
        TextView txtListChildTeam2 = (TextView) convertView
                .findViewById(R.id.txtTeam2);
        TextView txtListChildResuft = (TextView) convertView
                .findViewById(R.id.txtResuft);

        ImageView ivFlag1 = (ImageView) convertView.findViewById(R.id.ivFlag1);
        ImageView ivFlag2 = (ImageView) convertView.findViewById(R.id.ivFlag2);

        txtListChild.setText(this._listDataChild.get(
                this._listDataHeader.get(groupPosition)).get(childPosition));

        txtListChildTeam1.setText(this._listDataChildTeam1.get(
                this._listDataHeader.get(groupPosition)).get(childPosition));

        txtListChildTeam2.setText(this._listDataChildTeam2.get(
                this._listDataHeader.get(groupPosition)).get(childPosition));

        txtListChildResuft.setText(this._listDataChildResuft.get(
                this._listDataHeader.get(groupPosition)).get(childPosition));

        String flag1 = this._listFlagChildTeam1.get(
                this._listDataHeader.get(groupPosition)).get(childPosition);
        getFlag(ivFlag1, flag1);

        String flag2 = this._listFlagChildTeam2.get(
                this._listDataHeader.get(groupPosition)).get(childPosition);
        getFlag(ivFlag2, flag2);
        // ivFlag2.setImageResource(resId)

        // txtListChildTeam2.setText(this._listDataChildTeam2.get(this._listDataHeader.get(groupPosition))
        // .get(childPosition));
        //
        // txtListChildResuft.setText(this._listDataChildResuft.get(this._listDataHeader.get(groupPosition))
        // .get(childPosition));
        return convertView;
    }

    private void getFlag(ImageView iv, String flag) {
        if (flag.equals("brazil")) {
            iv.setImageResource(R.drawable.icon_brazil);

        } else if (flag.equals("Croatia")) {
            iv.setImageResource(R.drawable.icon_croatia);

        } else if (flag.equals("mexico")) {
            iv.setImageResource(R.drawable.icon_mexico);

        } else if (flag.equals("cameroon")) {
            iv.setImageResource(R.drawable.icon_cameroon);

        } else if (flag.equals("spain")) {
            iv.setImageResource(R.drawable.icon_spain);

        } else if (flag.equals("Netherlands")) {
            iv.setImageResource(R.drawable.icon_netherland);

        } else if (flag.equals("Chile")) {
            iv.setImageResource(R.drawable.icon_chile);

        } else if (flag.equals("Australia")) {
            iv.setImageResource(R.drawable.icon_australia);

        } else if (flag.equals("Colombia")) {
            iv.setImageResource(R.drawable.icon_colombia);

        } else if (flag.equals("Greece")) {
            iv.setImageResource(R.drawable.icon_greece);

        } else if (flag.equals("Ivory Coast")) {
            iv.setImageResource(R.drawable.icon_ivory_coast);

        } else if (flag.equals("Japan")) {
            iv.setImageResource(R.drawable.icon_japan);

        } else if (flag.equals("Uruguay")) {
            iv.setImageResource(R.drawable.icon_uruguay);

        } else if (flag.equals("Costa Rica")) {
            iv.setImageResource(R.drawable.icon_costa_rica);

        } else if (flag.equals("England")) {
            iv.setImageResource(R.drawable.icon_england);

        } else if (flag.equals("Italy")) {
            iv.setImageResource(R.drawable.icon_italy);

        } else if (flag.equals("Switzerland")) {
            iv.setImageResource(R.drawable.icon_switzerland);

        } else if (flag.equals("Ecuador")) {
            iv.setImageResource(R.drawable.icon_ecuador);

        } else if (flag.equals("France")) {
            iv.setImageResource(R.drawable.icon_france);

        } else if (flag.equals("Honduras")) {
            iv.setImageResource(R.drawable.icon_honduras);

        } else if (flag.equals("Argentina")) {
            iv.setImageResource(R.drawable.icon_argentina);

        } else if (flag.equals("Bosnia and Herzegovina")) {
            iv.setImageResource(R.drawable.icon_bosnia);

        } else if (flag.equals("Iran")) {
            iv.setImageResource(R.drawable.icon_iran);

        } else if (flag.equals("Nigeria")) {
            iv.setImageResource(R.drawable.icon_nigeria);

        } else if (flag.equals("Germany")) {
            iv.setImageResource(R.drawable.icon_germany);

        } else if (flag.equals("Portugal")) {
            iv.setImageResource(R.drawable.icon_portugal);

        } else if (flag.equals("Ghana")) {
            iv.setImageResource(R.drawable.icon_ghana);

        } else if (flag.equals("USA")) {
            iv.setImageResource(R.drawable.icon_usa);

        } else if (flag.equals("Belgium")) {
            iv.setImageResource(R.drawable.icon_belgium);

        } else if (flag.equals("Algeria")) {
            iv.setImageResource(R.drawable.icon_algeria);

        } else if (flag.equals("Russia")) {
            iv.setImageResource(R.drawable.icon_russia);

        } else if (flag.equals("Korea")) {
            iv.setImageResource(R.drawable.icon_korea);

        } else {
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
