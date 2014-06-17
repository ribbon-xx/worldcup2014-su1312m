package bkapt.su1312m.WorldCup2014;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class ShowDialogVote extends Activity {
	
	private ListView Lv;
	private EditText edit_search;
	
	DATA DataAllTeam;
	DATA DataNow;
	TEAM TeamNow;
	
	private int Mode;
	private int InerMode=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_team);
		Intent i=getIntent();
		Bundle b=i.getBundleExtra("BUNDLE");
		Mode=b.getInt("MODE"); 
		DataAllTeam=GSONParser_dong.GetAllTeam(getApplicationContext());
		InitControl();
	}
	
	private void InitControl() {
		edit_search = (EditText) findViewById(R.id.edit_search);
		edit_search.setTextColor(Color.BLACK);
		edit_search.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				SearchTeam();
			}
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {				
			}
		});
		
		Lv = (ListView) findViewById(R.id.lv_team);
		DisplayData(null,DataAllTeam);
		
		Lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
				if(Mode==Dudoan.DU_DOAN_VO_DICH){
					TEAM t=(TEAM) Lv.getItemAtPosition(position);
					Intent i=getIntent();
					Bundle b=new Bundle();    
					b.putSerializable("TEAM_ID",t.GetTeamID());
					b.putSerializable("TEAM_NAME",t.GetTeamName());
					b.putString("TEAM_ICON", t.GetIconTeam());
					i.putExtra("BUNDLE", b);
					setResult(0,i);
					finish();    
				}
				else{
					TEAM t=(TEAM) Lv.getItemAtPosition(position);
					if(t!=null){
						if(InerMode==0){
							InerMode=1;
							TeamNow=t.Copy();
							edit_search.setText("");
							DisplayData(t,null); 
						}
						else{
							Intent i=getIntent();
							Bundle b=new Bundle();    
							b.putSerializable("TEAM_ID",t.GetTeamID());
							b.putString("PLAYER_ICON", t.GetIconPlayer());
							b.putString("PLAYER_NAME", t.GetPlayerName());
							b.putSerializable("TEAM_NAME",t.GetTeamName());
							b.putString("TEAM_ICON", t.GetIconTeam());
							i.putExtra("BUNDLE", b);
							setResult(0,i);
							finish();    
						}
					}
				} 
			} 
		});
	}
	@Override
	public void onBackPressed() {
		if(InerMode==1) {
			InerMode=0;
			DisplayData(null,DataAllTeam);
		}
		else {
			finish();
		}
	}
	private void SearchTeam() {
		if(Mode==Dudoan.DU_DOAN_VO_DICH){
			DataNow=new DATA();
			List<TEAM> ListTeam=new ArrayList<TEAM>();
			String keyWord = edit_search.getText().toString().toLowerCase();
			for(int i=0;i<DataAllTeam.GetListTeam().size();i++){
				String teamName=DataAllTeam.GetListTeam().get(i).GetTeamName().toLowerCase();
				if(teamName.contains(keyWord)){
					TEAM tmp=DataAllTeam.GetListTeam().get(i).Copy();
					ListTeam.add(tmp);
				}
			}
			DataNow.SetListTeam(ListTeam);
			DisplayData(null, DataNow);
		}
		else{
			if(InerMode==0){
				DataNow=new DATA();
				List<TEAM> ListTeam=new ArrayList<TEAM>();
				String keyWord = edit_search.getText().toString().toLowerCase();
				for(int i=0;i<DataAllTeam.GetListTeam().size();i++){
					String teamName=DataAllTeam.GetListTeam().get(i).GetTeamName().toLowerCase();
					if(teamName.contains(keyWord)){
						TEAM tmp=DataAllTeam.GetListTeam().get(i).Copy();
						ListTeam.add(tmp);
					}
				}
				DataNow.SetListTeam(ListTeam);
				DisplayData(null, DataNow);
			}
			else{
				TEAM CopyTeam=TeamNow.Copy();
				String keyWord = edit_search.getText().toString().toLowerCase();
				List<String> ListStr=new ArrayList<String>();
				for(int i=0;i<CopyTeam.GetListPlayerOfTeam().size();i++){
					String playerName=CopyTeam.GetListPlayerOfTeam().get(i).toLowerCase();
					if(playerName.contains(keyWord)){
						ListStr.add(CopyTeam.GetListPlayerOfTeam().get(i));
					}
				}
				CopyTeam.SetPlayer(ListStr);
				DisplayData(CopyTeam, null);
			}
		}
	}
	
	private void DisplayData(TEAM _TEAM,DATA _DATA) {
		final ArrayList<TEAM> arr = new ArrayList<TEAM>();
		if(InerMode==0){
			List<TEAM> ListTeam=_DATA.GetListTeam();
			for(int i=0;i<ListTeam.size();i++){
				TEAM tmp=ListTeam.get(i).Copy();
				tmp.SetVisible(false);
				arr.add(tmp);
			}
		}
		else{
			for(int i=0;i<_TEAM.GetListPlayerOfTeam().size();i++){
				TEAM tmp=_TEAM.Copy();
				tmp.SetVisible(true);
				tmp.SetPlayerName(i);
				arr.add(tmp);
			}
		}
		Team_ArrayAdapter mayArr = new Team_ArrayAdapter(this,R.layout.listview_item, arr);
		Lv.setAdapter(mayArr);
	}
}
