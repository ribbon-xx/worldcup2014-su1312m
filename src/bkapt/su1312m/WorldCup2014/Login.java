package bkapt.su1312m.WorldCup2014;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by My pc on 9/6/2014.
 */
public class Login extends Fragment {
    private Button bt_login;
    private FrameLayout frame;
    private FragmentManager myFragmentManager;
    final static String TAG_2 = "FRAGMENT_2";
    final static String TAG_1 = "FRAGMENT_1";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        bt_login = (Button) view.findViewById(R.id.bt_login);
        frame = (FrameLayout) view.findViewById(R.id.frame);
        bt_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment sp = new Dudoan();
                Main3 main3 = (Main3) getActivity().getSupportFragmentManager().findFragmentByTag(TAG_1);
                main3.replaceFragment(sp, TAG_2);
            }
        });

        return view;
    }
}
