package bkapt.su1312m.WorldCup2014;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.net.wifi.WpsInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import bkapt.su1312m.WorldCup2014.Utils.NetworkUtils;

/**
 * Created by My pc on 9/6/2014.
 */
public class Login extends Fragment {
	private Button bt_login;
	private FrameLayout frame;
	private FragmentManager myFragmentManager;
	final static String TAG_2 = "FRAGMENT_2";
	final static String TAG_1 = "FRAGMENT_1";
	final static String URL = "http://cup.tin9x.vn/user/register.php";
	private EditText ed_name, ed_phone, ed_mail, ed_id_number, ed_add, ed_work;
	private String Name, Phone, Mail, Id_Number, Add, Work;
	public static final String TAG = Dudoan.class.getClass().getSimpleName();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.login, container, false);
		bt_login = (Button) view.findViewById(R.id.bt_login);
		frame = (FrameLayout) view.findViewById(R.id.frame);
		ed_name = (EditText) view.findViewById(R.id.ed_name);
		ed_phone = (EditText) view.findViewById(R.id.ed_phone);
		ed_mail = (EditText) view.findViewById(R.id.ed_mail);
		ed_id_number = (EditText) view.findViewById(R.id.ed_id_number);
		ed_add = (EditText) view.findViewById(R.id.ed_add);
		ed_work = (EditText) view.findViewById(R.id.ed_work);
		bt_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Name = ed_name.getText().toString().trim();
				Phone = ed_phone.getText().toString().trim();
				Mail = ed_mail.getText().toString().trim();
				Id_Number = ed_id_number.getText().toString().trim();
				Add = ed_add.getText().toString().trim();
				Work = ed_work.getText().toString().trim();
				Log.d("AAAAAAAAAAAAAAAAAAAAAAA", Name + Phone + Mail
						+ Id_Number + Add + Work);
				if (Name.equals("") || Phone.equals("") || Mail.equals("")
						|| Id_Number.equals("") || Add.equals("")
						|| Work.equals("")) {
					Toast.makeText(getActivity(), "Ban chua nhap du thong tin",
							Toast.LENGTH_SHORT).show();
				}
				else {
					final Dialog dialog = new Dialog(getActivity());
					dialog.setTitle("REGISTER");
					dialog.setContentView(R.layout.dialog_login);
					dialog.setCancelable(true);
					dialog.show();
					Button bt_yes, bt_cancel;
					bt_yes = (Button) dialog.findViewById(R.id.bt_yes);
					bt_cancel = (Button) dialog.findViewById(R.id.bt_no);
					bt_cancel.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
					bt_yes.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Thread thread = new Thread(new Runnable() {
								public void run() {
									NetworkUtils jsonConfig = new NetworkUtils(
											getActivity());
									final JSONObject jobj = new JSONObject();
									try {
										jobj.put("name", Name);
										jobj.put("phone", Phone);
										jobj.put("email", Mail);
										jobj.put("number", Id_Number);
										jobj.put("add", Add);
										jobj.put("work", Work);

										String response = jsonConfig.httpPost(
												jobj.toString(), URL);
										Log.d("JSONNNNNN",
												"aaaa " + jobj.toString()
														+ "---response: "
														+ response);
										if (response.contains("success")) {
											Fragment fragment = new Dudoan();
											((MainActivity) getActivity())
													.replaceFragment(fragment,
															TAG_2);
										}
									} catch (JSONException e) {
										e.printStackTrace();
									}
								}
							});
							thread.start();
							Toast.makeText(getActivity(), "Da dang ky",
									Toast.LENGTH_SHORT).show();
							dialog.dismiss();
						}
					});
				}
				

			}
		});

		return view;
	}
}
