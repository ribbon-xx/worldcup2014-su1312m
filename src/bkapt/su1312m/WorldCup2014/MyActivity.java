
package bkapt.su1312m.WorldCup2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    private EditText ed_masv, ed_class;
    private Button bt_login;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ed_masv = (EditText) findViewById(R.id.ed_msv);
        ed_class = (EditText) findViewById(R.id.ed_class);
        bt_login = (Button) findViewById(R.id.bt_login);
        String st_masv = ed_masv.getText().toString();
        String st_class = ed_class.getText().toString();
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
