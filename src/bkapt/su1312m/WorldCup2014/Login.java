package bkapt.su1312m.WorldCup2014;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by My pc on 9/6/2014.
 */
public class Login extends Fragment {
    private Button bt_login;
    private FrameLayout frame;
    private FragmentManager myFragmentManager;
    final static String TAG_2 = "FRAGMENT_2";
    final static String TAG_1 = "FRAGMENT_1";
    final  static  String URL="http://cup.tin9x.vn/user/register.php";
    private EditText ed_name, ed_phone,ed_mail,ed_id_number,ed_add,ed_work;
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
//                Fragment sp = new Dudoan();
//                Main3 main3 = (Main3) getActivity().getSupportFragmentManager().findFragmentByTag(TAG);
//                main3.replaceFragment(sp, TAG_2);
                Name = ed_name.getText().toString().trim();
                Phone = ed_phone.getText().toString().trim();
                Mail = ed_mail.getText().toString().trim();
                Id_Number = ed_id_number.getText().toString().trim();
                Add = ed_add.getText().toString().trim();
                Work = ed_work.getText().toString().trim();
                Log.d("AAAAAAAAAAAAAAAAAAAAAAA",Name+Phone+Mail+Id_Number+Add+Work);
                Thread thread=new Thread(new Runnable() {
                    public void run() {
                        NetworkUtils jsonConfig = new NetworkUtils(getActivity());
                        final JSONObject jobj = new JSONObject();
                        try {
                            jobj.put("name", Name);
                            jobj.put("phone", Phone);
                            jobj.put("email", Mail);
                            jobj.put("indetify_number", Id_Number);
                            jobj.put("address", Add);
                            jobj.put("work", Work);

                            jsonConfig.httpPost(jobj.toString(), URL);
                            Log.d("JSONNNNNN","aaaa "+jobj.toString());
                           } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                Toast.makeText(getActivity(),"Da dang ky",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
