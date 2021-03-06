package bkapt.su1312m.WorldCup2014;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;
import bkapt.su1312m.WorldCup2014.DAO.UserDAO;
import bkapt.su1312m.WorldCup2014.DTO.UserDTO;
import bkapt.su1312m.WorldCup2014.Utils.NetworkUtils;
import bkapt.su1312m.WorldCup2014.gsonObjects.RegisterObject;

import com.google.gson.Gson;

/**
 * Created by My pc on 9/6/2014.
 */
public class Login extends Fragment {

	private final String TAG = "Login";

	private Button bt_login;
	private FrameLayout frame;
	private FragmentManager myFragmentManager;
	final static String TAG_2 = "FRAGMENT_2";
	final static String TAG_1 = "FRAGMENT_1";
	private UserDAO userDAO;
	private UserDTO userDTO;
	private EditText ed_name, ed_phone, ed_mail, ed_id_number, ed_add, ed_work;
	private Toast toast, toast1, toast3;

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
		userDAO = new UserDAO(getActivity());

		bt_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				GlobalVariable.Name = ed_name.getText().toString().trim();
				GlobalVariable.Phone = ed_phone.getText().toString().trim();

				GlobalVariable.Mail = ed_mail.getText().toString().trim();
				GlobalVariable.Id_Number = ed_id_number.getText().toString()
						.trim();
				GlobalVariable.Add = ed_add.getText().toString().trim();
				GlobalVariable.Work = ed_work.getText().toString().trim();
				Log.d("AAAAAAAAAAAAAAAAAAAAAAA", GlobalVariable.Name
						+ GlobalVariable.Phone + GlobalVariable.Mail
						+ GlobalVariable.Id_Number + GlobalVariable.Add
						+ GlobalVariable.Work);
				if (GlobalVariable.Name.equals("")
						|| GlobalVariable.Phone.equals("")
						|| GlobalVariable.Mail.equals("")
						|| GlobalVariable.Id_Number.equals("")
						|| GlobalVariable.Add.equals("")
						|| GlobalVariable.Work.equals("")) {
					if (null != toast) {
						toast.cancel();
					}
					toast = Toast.makeText(getActivity(), getResources()
							.getString(R.string.chua_du_ttin),
							Toast.LENGTH_SHORT);
					toast.show();
				} else {
					if (GlobalVariable.Id_Number.length() < 9) {
						if (null != toast1) {
							toast1.cancel();
						}
						toast1 = Toast.makeText(getActivity(), getResources()
								.getString(R.string.cmt_error),
								Toast.LENGTH_SHORT);
						toast1.show();
					} else {
						final ConnectivityManager conMgr = (ConnectivityManager) getActivity()
								.getSystemService(Context.CONNECTIVITY_SERVICE);
						final NetworkInfo activeNetwork = conMgr
								.getActiveNetworkInfo();
						if (activeNetwork != null
								&& activeNetwork.isConnected()) {
							// notify user you are online
							savePreferences("ID", GlobalVariable.Id_Number);
							final Dialog dialog_confirm = new Dialog(
									getActivity());
							dialog_confirm.setTitle("REGISTER");
							dialog_confirm
									.setContentView(R.layout.dialog_login);
							dialog_confirm.setCancelable(true);
							dialog_confirm.show();
							Button bt_yes, bt_cancel;
							bt_yes = (Button) dialog_confirm
									.findViewById(R.id.bt_yes);
							bt_cancel = (Button) dialog_confirm
									.findViewById(R.id.bt_no);
							bt_cancel.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									dialog_confirm.dismiss();
								}
							});
							bt_yes.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									dialog_confirm.dismiss();
									// userDTO = new UserDTO(
									// GlobalVariable.Name,
									// Integer.parseInt(GlobalVariable.Phone),
									// GlobalVariable.Mail,
									// Integer.parseInt(GlobalVariable.Id_Number),
									// GlobalVariable.Add,
									// GlobalVariable.Work, 0, "", 0, "",
									// 0);
									// long result =
									// userDAO.insertuser(userDTO);
									// Log.d(TAG, "result: " + result);

									Check_Register check_Register = new Check_Register(
											getActivity());
									check_Register.execute();
								}
							});
						} else {
							// notify user you are not online
							if (toast3 != null) {
								toast3.cancel();
							}
							toast3 = Toast.makeText(
									getActivity(),
									getResources().getString(
											R.string.check_network),
									Toast.LENGTH_LONG);
							toast3.show();
						}

					}
					// String[] asyncTaskParams = new String[] {};

				}

			}
		});

		return view;
	}

	public class Check_Register extends AsyncTask<String, String, Integer[]> {

		private Context context;
		private NetworkUtils jsonConfig;
		private JSONObject jsonObject;
		private ProgressDialog dialog;

		public Check_Register(Context context) {
			this.context = context;
			dialog = new ProgressDialog(context);
		}

		@Override
		protected Integer[] doInBackground(String... params) {
			try {
				jsonObject.put("phone", GlobalVariable.Phone);
				jsonObject.put("name", GlobalVariable.Name);

				jsonObject.put("email", GlobalVariable.Mail);
				jsonObject.put("number", GlobalVariable.Id_Number);
				jsonObject.put("add", GlobalVariable.Add);
				jsonObject.put("work", GlobalVariable.Work);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String response = jsonConfig.httpPost(jsonObject.toString(),
					GlobalVariable.URL);
			Gson gson = new Gson();
			RegisterObject registerObject = gson.fromJson(response,
					RegisterObject.class);

			int exists = registerObject.exists;
			int success = registerObject.success;
			Integer[] results = new Integer[2];
			results[0] = exists;
			results[1] = success;
			return results;
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			jsonConfig = new NetworkUtils(context);
			jsonObject = new JSONObject();
			dialog.setMessage("wating...");
			dialog.show();
		}

		@Override
		protected void onPostExecute(Integer[] result) {

			super.onPostExecute(result);
			dialog.dismiss();
			if (result[0] == 1) {
				final Dialog dialog_id = new Dialog(getActivity());
				dialog_id.setTitle("REGISTER");
				dialog_id.setContentView(R.layout.dialog_login);
				dialog_id.setCancelable(true);
				dialog_id.show();
				Button bt_yes1, bt_cancel1;
				bt_yes1 = (Button) dialog_id.findViewById(R.id.bt_yes);
				bt_cancel1 = (Button) dialog_id.findViewById(R.id.bt_no);
				TextView tv_caption1 = (TextView) dialog_id
						.findViewById(R.id.tv_noti);
				tv_caption1.setText("Số CMT của bạn đã được đăng ký");

				bt_cancel1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog_id.dismiss();
					}
				});
				bt_yes1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Fragment fragment = new Dudoan();
						((PagerFrafmentActivity) getActivity())
								.replaceFragment(fragment, null);
						dialog_id.dismiss();
					}
				});
			}
			if (result[0] == 0) {
				if (result[1] == 0) {
					// Fragment fragment = new Dudoan();
					// ((PagerFrafmentActivity) getActivity()).replaceFragment(
					// fragment, TAG_2);
					Toast.makeText(getActivity(),
							getResources().getString(R.string.regis_fail),
							Toast.LENGTH_SHORT).show();
				} else {
					Fragment fragment = new Dudoan();
					((PagerFrafmentActivity) getActivity()).replaceFragment(
							fragment, TAG_2);
					Toast.makeText(getActivity(),
							getResources().getString(R.string.regis_success),
							Toast.LENGTH_SHORT).show();
				}

			}
		}

	}

	private void savePreferences(String key, int value) {
		// TODO Auto-generated method stub
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	private void savePreferences(String key, String value) {
		// TODO Auto-generated method stub
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
	}

}
