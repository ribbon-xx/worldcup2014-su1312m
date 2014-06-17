package bkapt.su1312m.WorldCup2014;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import bkapt.su1312m.WorldCup2014.Utils.NetworkUtils;
import bkapt.su1312m.WorldCup2014.gsonObjects.RegisterObject;
import bkapt.su1312m.WorldCup2014.gsonObjects.RegisterWrapperObject;

import com.google.gson.Gson;

public class Dudoan extends Fragment implements OnClickListener {
	public static int DU_DOAN_VO_DICH = 0;
	public static int DU_DOAN_CAU_THU_SUAT_SAC = 1;
	public static int DU_DOAN_CAU_THU_GHI_NHIEU_BAN_THANG = 2;

	private Button ButtonDuDoanDoiVoDich;
	private Button ButtonDuDoanCauThuSuatSac;
	private Button ButtonDuDoanCauThuGhiNhieuBan;
	private Button ButtonLamLai;
	private Button ButtonBinhChon;

	private ImageView ImageViewLogo_WC;
	private ImageView ImageViewLogo_DoiBongVoDich;
	private ImageView ImageViewLogo_CauThuSuatSac;
	private ImageView ImageViewLogo_DoiBongCauThuSuatSac;
	private ImageView ImageViewLogo_CauThuGhiNhieuBan;
	private ImageView ImageViewLogo_DoiBongCauThuGhiNhieuBan;

	private TextView TextViewTieuDeDoiBongVoDich;
	private TextView TextViewTieuDeDoiBongGhiNhieuBan;
	private TextView TextViewTieuDeThongTinKhac;
	private TextView TextViewTieuDeCauThuSuatSac;

	private TextView TextViewTenDoiBongVoDich;

	private TextView TextViewTenCauThuSuatSac;
	private TextView TextViewTenDoiBongCauThuSuatSac;

	private TextView TextViewTenCauThuGhiNhieuBan;
	private TextView TextViewTenDoiBongCauThuGhiNhieuBan;
	final static String TAG_1 = "FRAGMENT_1";
	private EditText EditSoBanThang;
	private EditText EditSoNguoiCoCungDuDoan;
	private String identify_number;
	private LinearLayout bt_logout;
	private ThongTinDuDoan _ThongTinDuDoan;
	private SharedPreferences sharedPreferences;
	private final long PERIOD = 5000;// 5 * 1000 * 60;
	private Toast warningTimePredict;

	private DATA _DATA;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.choose_team, container, false);
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		identify_number = sp.getString("ID", "0");
		InitControl(view);
		LoadAndSetDataFromServices();

		savePreferences("CHECK", 1);
		sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		return view;
	}

	private void InitControl(View view) {

		ButtonDuDoanDoiVoDich = (Button) view
				.findViewById(R.id.buttonBinhChonVoDich);
		ButtonDuDoanCauThuSuatSac = (Button) view
				.findViewById(R.id.buttonBinhChonCauThuSuatSac);
		ButtonDuDoanCauThuGhiNhieuBan = (Button) view
				.findViewById(R.id.buttonBinhChonCauThuGhiNhieuBanThang);
		ButtonLamLai = (Button) view.findViewById(R.id.buttonLamLai);
		ButtonBinhChon = (Button) view.findViewById(R.id.buttonBinhChon);

		ImageViewLogo_WC = (ImageView) view.findViewById(R.id.ImageViewLogoWC);
		ImageViewLogo_DoiBongVoDich = (ImageView) view
				.findViewById(R.id.ImageViewLogoDoiBongVoDich);
		ImageViewLogo_CauThuSuatSac = (ImageView) view
				.findViewById(R.id.ImageViewLogoCauThuSuatSacNhat);
		ImageViewLogo_DoiBongCauThuSuatSac = (ImageView) view
				.findViewById(R.id.ImageViewLogoDoiBongCauThuSuatSacNhat);
		ImageViewLogo_CauThuGhiNhieuBan = (ImageView) view
				.findViewById(R.id.ImageViewLogoCauThuGhiNhieuBanThang);
		ImageViewLogo_DoiBongCauThuGhiNhieuBan = (ImageView) view
				.findViewById(R.id.ImageViewLogoDoiBongCauThuGhiNhieuBanThang);

		TextViewTieuDeDoiBongVoDich = (TextView) view
				.findViewById(R.id.textViewTieuDeDoiBongVoDich);
		TextViewTenDoiBongVoDich = (TextView) view
				.findViewById(R.id.TextViewTenDoiBongVoDich);
		TextViewTieuDeCauThuSuatSac = (TextView) view
				.findViewById(R.id.textViewTieuDeCauThuSuatSacNhat);
		TextViewTenCauThuSuatSac = (TextView) view
				.findViewById(R.id.TextViewTenCauThuSuatSacNhat);
		TextViewTenDoiBongCauThuSuatSac = (TextView) view
				.findViewById(R.id.TextViewTenDoiBongCauThuSuatSacNhat);
		TextViewTenCauThuGhiNhieuBan = (TextView) view
				.findViewById(R.id.TextViewTenCauThuGhiNhieuBanThang);
		TextViewTenDoiBongCauThuGhiNhieuBan = (TextView) view
				.findViewById(R.id.TextViewTenDoiBongCauThuGhiNhieuBanThang);
		TextViewTieuDeDoiBongGhiNhieuBan = (TextView) view
				.findViewById(R.id.textViewTieuDeCauThuGhiNhieuBanThang);
		TextViewTieuDeThongTinKhac = (TextView) view
				.findViewById(R.id.textViewThongTinThem);

		EditSoBanThang = (EditText) view
				.findViewById(R.id.editTextSoBanThangGhiDuoc);
		EditSoNguoiCoCungDuDoan = (EditText) view
				.findViewById(R.id.editTextSoNguoiCoCungDuDoan);
		bt_logout = (LinearLayout) view.findViewById(R.id.bt_log_out);
		EditSoNguoiCoCungDuDoan.setTextColor(Color.BLACK);
		EditSoBanThang.setTextColor(Color.BLACK);

		ButtonDuDoanDoiVoDich.setOnClickListener(this);
		ButtonDuDoanCauThuSuatSac.setOnClickListener(this);
		ButtonDuDoanCauThuGhiNhieuBan.setOnClickListener(this);
		ButtonLamLai.setOnClickListener(this);
		ButtonBinhChon.setOnClickListener(this);
		bt_logout.setOnClickListener(this);

		TextViewTieuDeDoiBongVoDich
				.setBackgroundResource(R.drawable.icon_bg_yellow);
		TextViewTieuDeCauThuSuatSac
				.setBackgroundResource(R.drawable.icon_bg_yellow);
		TextViewTieuDeDoiBongGhiNhieuBan
				.setBackgroundResource(R.drawable.icon_bg_yellow);

		TextViewTieuDeThongTinKhac
				.setBackgroundResource(R.drawable.icon_bg_yellow);

		TextViewTieuDeDoiBongVoDich.setTextColor(Color.BLACK);
		TextViewTieuDeCauThuSuatSac.setTextColor(Color.BLACK);
		TextViewTieuDeDoiBongGhiNhieuBan.setTextColor(Color.BLACK);
		TextViewTieuDeThongTinKhac.setTextColor(Color.BLACK);

	}

	private void LoadAndSetDataFromServices() {
		try {
			if (_ThongTinDuDoan == null)
				_ThongTinDuDoan = new ThongTinDuDoan();
			_ThongTinDuDoan.setCMTND(identify_number);

			JSONObject param = new JSONObject();
			NetworkUtils networkUtils = new NetworkUtils(getActivity());

			param.put("identify_number", identify_number);
			String JsonString = param.toString();
			String response = networkUtils.httpPost(JsonString,
					GlobalVariable.URL_PUT_CMTND);

			Gson gson = new Gson();
			RegisterWrapperObject registerWrapperObject = gson.fromJson(
					response, RegisterWrapperObject.class);
			RegisterObject registerObject = registerWrapperObject.registerObjects
					.get(0);

			if (registerObject != null && !registerObject.team_ID.equals("")) {
				_ThongTinDuDoan.setID_DoiBongVoDich(registerObject.team_ID);

				String[] CauThuGhiNhieuBan = registerObject.player_most_goals
						.split("-");
				_ThongTinDuDoan
						.setID_DoiBongCauThuGhiNhieuBan(CauThuGhiNhieuBan[0]);
				_ThongTinDuDoan
						.setName_DoiBongCauThuGhiNhieuBan(CauThuGhiNhieuBan[1]);

				String[] CauThuSuatSac = registerObject.best_player.split("-");
				_ThongTinDuDoan.setID_DoiBongCauThuSuatSac(CauThuSuatSac[0]);
				_ThongTinDuDoan.setName_DoiBongCauThuSuatSac(CauThuSuatSac[1]);

				_ThongTinDuDoan.setSoBanThang(registerObject.goals_number
						.trim());
				_ThongTinDuDoan
						.setSoNguoiCoCungDuDoan(registerObject.same_Result
								.trim());
				// DisplayInformation();
			}
		} catch (Exception e) {

			Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG)
					.show();
			// getActivity().finish();

		}
		DisplayInformation();
	}

	private void DisplayInformation() {
		TextViewTenDoiBongVoDich.setText("Ten doi bong: "
				+ GetNameTeamFromTeamID(_ThongTinDuDoan.getID_DoiBongVoDich()));

		TextViewTenCauThuSuatSac.setText("Ten cau thu: "
				+ _ThongTinDuDoan.getName_DoiBongCauThuSuatSac());
		TextViewTenDoiBongCauThuSuatSac.setText("Ten doi bong: "
				+ GetNameTeamFromTeamID(_ThongTinDuDoan
						.getID_DoiBongCauThuSuatSac()));

		TextViewTenCauThuGhiNhieuBan.setText("Ten cau thu "
				+ _ThongTinDuDoan.getName_DoiBongCauThuGhiNhieuBan());
		TextViewTenDoiBongCauThuGhiNhieuBan.setText("Ten doi bong: "
				+ GetNameTeamFromTeamID(_ThongTinDuDoan
						.getID_DoiBongCauThuGhiNhieuBan()));

		EditSoBanThang.setText(_ThongTinDuDoan.getSoBanThang());
		EditSoNguoiCoCungDuDoan.setText(_ThongTinDuDoan
				.getSoNguoiCoCungDuDoan());

		String[] URI = new String[] {
				"drawable/icon_cup",
				"drawable/"
						+ GetIconTeamFromTeamID(_ThongTinDuDoan
								.getID_DoiBongVoDich()),
				"drawable/"
						+ GetIconTeamFromTeamID(_ThongTinDuDoan
								.getID_DoiBongCauThuSuatSac()),
				"drawable/"
						+ GetIconPlayerFromTeamID(_ThongTinDuDoan
								.getID_DoiBongCauThuSuatSac()),
				"drawable/"
						+ GetIconTeamFromTeamID(_ThongTinDuDoan
								.getID_DoiBongCauThuGhiNhieuBan()),
				"drawable/"
						+ GetIconPlayerFromTeamID(_ThongTinDuDoan
								.getID_DoiBongCauThuGhiNhieuBan()) };

		int[] IMG = new int[] {
				this.getResources().getIdentifier(URI[0], null,
						this.getActivity().getPackageName()),
				this.getResources().getIdentifier(URI[1], null,
						this.getActivity().getPackageName()),
				this.getResources().getIdentifier(URI[2], null,
						this.getActivity().getPackageName()),
				this.getResources().getIdentifier(URI[3], null,
						this.getActivity().getPackageName()),
				this.getResources().getIdentifier(URI[4], null,
						this.getActivity().getPackageName()),
				this.getResources().getIdentifier(URI[5], null,
						this.getActivity().getPackageName()) };

		ImageViewLogo_WC.setImageDrawable(this.getResources().getDrawable(
				IMG[0]));
		ImageViewLogo_DoiBongVoDich.setImageDrawable(this.getResources()
				.getDrawable(IMG[1]));

		ImageViewLogo_DoiBongCauThuSuatSac.setImageDrawable(this.getResources()
				.getDrawable(IMG[2]));
		ImageViewLogo_CauThuSuatSac.setImageDrawable(this.getResources()
				.getDrawable(IMG[3]));

		ImageViewLogo_DoiBongCauThuGhiNhieuBan.setImageDrawable(this
				.getResources().getDrawable(IMG[4]));
		ImageViewLogo_CauThuGhiNhieuBan.setImageDrawable(this.getResources()
				.getDrawable(IMG[5]));

	}

	private String GetIconPlayerFromTeamID(String TeamID) {
		if (_DATA == null)
			_DATA = GSONParser_dong.GetAllTeam(getActivity());
		for (int i = 0; i < _DATA.GetListTeam().size(); i++) {
			String _TeamID = _DATA.GetListTeam().get(i).GetTeamID();
			String IconPlayer = _DATA.GetListTeam().get(i).GetIconPlayer();
			if (_TeamID.equals(TeamID)) {
				return IconPlayer;
			}
		}
		return "icon_cup";
	}

	private String GetIconTeamFromTeamID(String TeamID) {
		if (_DATA == null)
			_DATA = GSONParser_dong.GetAllTeam(getActivity());
		for (int i = 0; i < _DATA.GetListTeam().size(); i++) {
			String _TeamID = _DATA.GetListTeam().get(i).GetTeamID();
			String IconTeam = _DATA.GetListTeam().get(i).GetIconTeam();
			if (_TeamID.equals(TeamID)) {
				return IconTeam;
			}
		}
		return "icon_cup";
	}

	private String GetNameTeamFromTeamID(String TeamID) {
		if (_DATA == null)
			_DATA = GSONParser_dong.GetAllTeam(getActivity());
		for (int i = 0; i < _DATA.GetListTeam().size(); i++) {
			String _TeamID = _DATA.GetListTeam().get(i).GetTeamID();
			String NameTeam = _DATA.GetListTeam().get(i).GetTeamName();
			if (_TeamID.equals(TeamID)) {
				return NameTeam;
			}
		}
		return "";
	}

	private void savePreferences(String key, int value) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	@Override
	public void onClick(View arg0) {
		Intent i;
		Bundle b;
		switch (arg0.getId()) {
		case R.id.buttonBinhChonVoDich: {
			i = new Intent(getActivity(), ShowDialogVote.class);
			b = new Bundle();
			b.putInt("MODE", DU_DOAN_VO_DICH);
			i.putExtra("BUNDLE", b);
			startActivityForResult(i, DU_DOAN_VO_DICH);
			break;
		}
		case R.id.buttonBinhChonCauThuSuatSac: {
			i = new Intent(getActivity(), ShowDialogVote.class);
			b = new Bundle();
			b.putInt("MODE", DU_DOAN_CAU_THU_SUAT_SAC);
			i.putExtra("BUNDLE", b);
			startActivityForResult(i, DU_DOAN_CAU_THU_SUAT_SAC);
			break;
		}
		case R.id.buttonBinhChonCauThuGhiNhieuBanThang: {
			i = new Intent(getActivity(), ShowDialogVote.class);
			b = new Bundle();
			b.putInt("MODE", DU_DOAN_CAU_THU_GHI_NHIEU_BAN_THANG);
			i.putExtra("BUNDLE", b);
			startActivityForResult(i, DU_DOAN_CAU_THU_GHI_NHIEU_BAN_THANG);
			break;
		}
		case R.id.buttonBinhChon: {
			long timeClick = System.currentTimeMillis()
					- sharedPreferences.getLong("REGISTED", 0L);
			if (timeClick < PERIOD) {
				if (null != warningTimePredict) {
					warningTimePredict.cancel();
					warningTimePredict = null;
				}
				warningTimePredict = Toast.makeText(getActivity(),
						"Please wait: " + (timeClick / 1000) + "s",
						Toast.LENGTH_LONG);
				return;
			}
			BinhChon();
			break;
		}
		case R.id.buttonLamLai: {
			EditSoBanThang.setText("");
			EditSoNguoiCoCungDuDoan.setText("");
			TextViewTenCauThuGhiNhieuBan.setText("Ten cau thu ");
			TextViewTenCauThuSuatSac.setText("TTen cau thu: ");
			TextViewTenDoiBongCauThuGhiNhieuBan.setText("Ten doi bong: ");
			TextViewTenDoiBongCauThuSuatSac.setText("Ten doi bong: ");
			TextViewTenDoiBongVoDich.setText("Ten doi bong: ");

			String uriQuestion = "drawable/icon_question";
			int ImgQuestion = this.getResources().getIdentifier(uriQuestion,
					null, this.getActivity().getPackageName());

			ImageViewLogo_DoiBongCauThuSuatSac.setImageDrawable(this
					.getResources().getDrawable(ImgQuestion));
			ImageViewLogo_DoiBongCauThuGhiNhieuBan.setImageDrawable(this
					.getResources().getDrawable(ImgQuestion));
			ImageViewLogo_WC.setImageDrawable(this.getResources().getDrawable(
					ImgQuestion));
			ImageViewLogo_DoiBongVoDich.setImageDrawable(this.getResources()
					.getDrawable(ImgQuestion));
			ImageViewLogo_CauThuGhiNhieuBan.setImageDrawable(this
					.getResources().getDrawable(ImgQuestion));
			ImageViewLogo_CauThuSuatSac.setImageDrawable(this.getResources()
					.getDrawable(ImgQuestion));

			_ThongTinDuDoan = new ThongTinDuDoan();
			_ThongTinDuDoan.setCMTND(identify_number);
			break;
		}
		case R.id.bt_log_out:
		{
			savePreferences("CHECK", 0);
			Fragment fragment = new Login();
			((PagerFrafmentActivity) getActivity()).replaceFragment(
					fragment, TAG_1);
			
		}
		default:
			break;
		}

	}

	private void BinhChon() {
		if (_ThongTinDuDoan.getID_DoiBongVoDich().equals("")) {
			ButtonDuDoanDoiVoDich.setFocusable(true);
			Toast.makeText(getActivity(), "Vui long binh chon doi vo dich",
					Toast.LENGTH_SHORT).show();
			return;
		} else if (_ThongTinDuDoan.getID_DoiBongCauThuSuatSac().equals("")
				|| _ThongTinDuDoan.getName_DoiBongCauThuSuatSac().equals("")) {
			ButtonDuDoanCauThuSuatSac.setFocusable(true);
			Toast.makeText(getActivity(),
					"Vui long binh chon cau thu suat sac nhat",
					Toast.LENGTH_SHORT).show();
			return;
		} else if (_ThongTinDuDoan.getID_DoiBongCauThuGhiNhieuBan().equals("")
				|| _ThongTinDuDoan.getName_DoiBongCauThuGhiNhieuBan()
						.equals("")) {
			ButtonDuDoanCauThuGhiNhieuBan.setFocusable(true);
			Toast.makeText(getActivity(),
					"Vui long binh chon cau thu ghi nhieu ban thang nhat",
					Toast.LENGTH_SHORT).show();
			return;
		} else if (EditSoBanThang.getText().toString().equals("")
				|| Integer.parseInt(EditSoBanThang.getText().toString()) == 0) {
			EditSoBanThang.setText("");
			EditSoBanThang.setFocusable(true);
			Toast.makeText(getActivity(), "So ban thang khong hop le",
					Toast.LENGTH_SHORT).show();
			return;
		} else if (EditSoNguoiCoCungDuDoan.getText().toString().equals("")
				|| Integer.parseInt(EditSoNguoiCoCungDuDoan.getText()
						.toString()) == 0) {
			EditSoNguoiCoCungDuDoan.setText("");
			EditSoNguoiCoCungDuDoan.setFocusable(true);
			Toast.makeText(getActivity(),
					"So nguoi co cung du doan khong hop le", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		GuiDuLieuLenService();
	}

	private void GuiDuLieuLenService() {
		try {
			_ThongTinDuDoan.setSoBanThang(EditSoBanThang.getText().toString());
			_ThongTinDuDoan.setSoNguoiCoCungDuDoan(EditSoNguoiCoCungDuDoan
					.getText().toString());
			_ThongTinDuDoan.setCMTND(identify_number);

			JSONObject JSObj = new JSONObject();
			JSObj.put("identify_Number", _ThongTinDuDoan.getCMTND());
			JSObj.put("team_ID", _ThongTinDuDoan.getID_DoiBongVoDich());
			JSObj.put("same_Result", _ThongTinDuDoan.getSoNguoiCoCungDuDoan());
			JSObj.put(
					"player_most_goals",
					_ThongTinDuDoan.getID_DoiBongCauThuGhiNhieuBan()
							+ "-"
							+ _ThongTinDuDoan
									.getName_DoiBongCauThuGhiNhieuBan());
			JSObj.put("goals_number", _ThongTinDuDoan.getSoBanThang());
			JSObj.put("best_player",
					_ThongTinDuDoan.getID_DoiBongCauThuSuatSac() + "-"
							+ _ThongTinDuDoan.getName_DoiBongCauThuSuatSac());
			String tmp = JSObj.toString();
			Log.d("JSON", "tmp: " + tmp);
			String[] params = new String[] { tmp };
			Toast.makeText(getActivity(), _ThongTinDuDoan.getCMTND(),
					Toast.LENGTH_SHORT).show();
			new PushPredict(getActivity()).execute(params);

		} catch (JSONException e) {
			Toast.makeText(getActivity(),
					"Some errors happened, please try again later!",
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null)
			return;
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == DU_DOAN_VO_DICH) {
			Bundle b = data.getBundleExtra("BUNDLE");
			String teamName = (String) b.getSerializable("TEAM_NAME");

			String uriTeam = "drawable/" + b.getString("TEAM_ICON");
			String uriWC = "drawable/icon_cup";

			int ImageTeamIcon = this.getResources().getIdentifier(uriTeam,
					null, this.getActivity().getPackageName());
			ImageViewLogo_DoiBongVoDich.setImageDrawable(this.getResources()
					.getDrawable(ImageTeamIcon));

			int ImageWCIcon = this.getResources().getIdentifier(uriWC, null,
					this.getActivity().getPackageName());
			ImageViewLogo_WC.setImageDrawable(this.getResources().getDrawable(
					ImageWCIcon));

			TextViewTenDoiBongVoDich.setText("Ten doi bong: " + teamName);

			String teamID = (String) b.getSerializable("TEAM_ID");
			_ThongTinDuDoan.setID_DoiBongVoDich(teamID);

		} else if (requestCode == DU_DOAN_CAU_THU_SUAT_SAC) {
			Bundle b = data.getBundleExtra("BUNDLE");
			String playerName = (String) b.getSerializable("PLAYER_NAME");
			String teamName = (String) b.getSerializable("TEAM_NAME");

			String uriTeam = "drawable/" + b.getString("TEAM_ICON");
			String uriPlayer = "drawable/" + b.getString("PLAYER_ICON");

			int ImageTeamIcon = this.getResources().getIdentifier(uriTeam,
					null, this.getActivity().getPackageName());
			ImageViewLogo_DoiBongCauThuSuatSac.setImageDrawable(this
					.getResources().getDrawable(ImageTeamIcon));

			int ImagePlayerIcon = this.getResources().getIdentifier(uriPlayer,
					null, this.getActivity().getPackageName());
			ImageViewLogo_CauThuSuatSac.setImageDrawable(this.getResources()
					.getDrawable(ImagePlayerIcon));

			TextViewTenDoiBongCauThuSuatSac
					.setText("Ten doi bong: " + teamName);
			TextViewTenCauThuSuatSac.setText("Ten cau thu: " + playerName);

			String teamID = (String) b.getSerializable("TEAM_ID");
			_ThongTinDuDoan.setID_DoiBongCauThuSuatSac(teamID);
			_ThongTinDuDoan.setName_DoiBongCauThuSuatSac(playerName);

		} else if (requestCode == DU_DOAN_CAU_THU_GHI_NHIEU_BAN_THANG) {
			Bundle b = data.getBundleExtra("BUNDLE");
			String playerName = (String) b.getSerializable("PLAYER_NAME");
			String teamName = (String) b.getSerializable("TEAM_NAME");

			String uriTeam = "drawable/" + b.getString("TEAM_ICON");
			String uriPlayer = "drawable/" + b.getString("PLAYER_ICON");

			int ImageTeamIcon = this.getResources().getIdentifier(uriTeam,
					null, this.getActivity().getPackageName());
			ImageViewLogo_DoiBongCauThuGhiNhieuBan.setImageDrawable(this
					.getResources().getDrawable(ImageTeamIcon));

			int ImagePlayerIcon = this.getResources().getIdentifier(uriPlayer,
					null, this.getActivity().getPackageName());
			ImageViewLogo_CauThuGhiNhieuBan.setImageDrawable(this
					.getResources().getDrawable(ImagePlayerIcon));

			TextViewTenDoiBongCauThuGhiNhieuBan.setText("Ten doi bong: "
					+ teamName);
			TextViewTenCauThuGhiNhieuBan.setText("Ten cau thu: " + playerName);

			String teamID = (String) b.getSerializable("TEAM_ID");
			_ThongTinDuDoan.setID_DoiBongCauThuGhiNhieuBan(teamID);
			_ThongTinDuDoan.setName_DoiBongCauThuGhiNhieuBan(playerName);
		}
	}

	private class PushPredict extends AsyncTask<String, Void, String> {

		private Context context;
		private ProgressDialog dialog;

		public PushPredict(Context context) {
			this.context = context;
			dialog = new ProgressDialog(context);
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			dialog = new ProgressDialog(context);
			dialog.setMessage("wating...");
			dialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			String json = params[0];
			NetworkUtils networkUtils = new NetworkUtils(getActivity());
			String response = networkUtils.httpPost(json,
					GlobalVariable.URL_PUT_THONGTINBINHCHON);
			Log.e("JSON", "json: " + json);
			Log.e("JSON", "response: " + response);
			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			dialog.dismiss();
			if (result.contains("true")) {
				Toast.makeText(getActivity(), "Registered!", Toast.LENGTH_LONG)
						.show();
				sharedPreferences.edit()
						.putLong("REGISTED", System.currentTimeMillis())
						.commit();
			} else {
				Toast.makeText(getActivity(),
						"Regist fail, please try again later!",
						Toast.LENGTH_SHORT).show();
			}
		}

	}

}