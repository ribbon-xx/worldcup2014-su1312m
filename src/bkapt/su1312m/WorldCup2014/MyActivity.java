
package bkapt.su1312m.WorldCup2014;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Fragment implements View.OnClickListener
{
    /** Called when the activity is first created. */
    private EditText ed_masv, ed_class;
    private Button bt_login;
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        ed_masv = (EditText) findViewById(R.id.ed_msv);
//        ed_class = (EditText) findViewById(R.id.ed_class);
//        bt_login = (Button) findViewById(R.id.bt_login);
//        String st_masv = ed_masv.getText().toString();
//        String st_class = ed_class.getText().toString();
//        bt_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.main,null);
        ed_masv = (EditText) v.findViewById(R.id.ed_msv);
        ed_class = (EditText) v.findViewById(R.id.ed_class);
        bt_login = (Button) v.findViewById(R.id.bt_login);
        String st_masv = ed_masv.getText().toString();
        String st_class = ed_class.getText().toString();

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:

        }
    }
}
