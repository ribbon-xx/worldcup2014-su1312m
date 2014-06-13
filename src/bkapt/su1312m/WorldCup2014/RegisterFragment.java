
package bkapt.su1312m.WorldCup2014;

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

public class RegisterFragment extends Fragment
{
    private Button bt1, bt2,bt3;
    private FrameLayout container;
    private Login login;
    private Dudoan spinner;
    private EventEnd eventEnd;
    private FragmentManager myFragmentManager;
    final static String TAG_1 = "FRAGMENT_1";
    final static String TAG_2 = "FRAGMENT_2";
    final static String TAG_3 = "FRAGMENT_3";
    final static String KEY_MSG_1 = "FRAGMENT1_MSG";
    final static String KEY_MSG_2 = "FRAGMENT2_MSG";
    final static String KEY_MSG_3 = "FRAGMENT3_MSG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main3, container, false);
        bt1 = (Button) view.findViewById(R.id.button1);
        bt2 = (Button) view.findViewById(R.id.button2);
        bt3 = (Button) view.findViewById(R.id.button3);
        container = (FrameLayout) view.findViewById(R.id.maincontainer);
        login = new Login();
        spinner = new Dudoan();
        eventEnd = new EventEnd();
        myFragmentManager = getActivity().getSupportFragmentManager();
        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Login lg = (Login) myFragmentManager.findFragmentByTag(TAG_1);

                if (lg == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_1, "Replace MyFragment1");
                    login.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.maincontainer, login,
                            TAG_1);
                    fragmentTransaction.commit();

                } else {

                    // fragment.setMsg("MyFragment1 already loaded");
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Dudoan sp = (Dudoan) myFragmentManager
                        .findFragmentByTag(TAG_2);

                if (sp == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_2, "Replace MyFragment2");
                    spinner.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.maincontainer, spinner,
                            TAG_2);
                    fragmentTransaction.commit();

                } else {
                    // fragment.setMsg("MyFragment2 already loaded");
                }
            }
        });
        bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EventEnd ev = (EventEnd) myFragmentManager.findFragmentByTag(TAG_3);

                if (ev == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_3, "Replace MyFragment3");
                    eventEnd.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.maincontainer, eventEnd,
                            TAG_3);
                    fragmentTransaction.commit();

                } else {

                    // fragment.setMsg("MyFragment1 already loaded");
                }
			}
		});
        
        if (savedInstanceState == null) {
            // if's the first time created

            ((MainActivity)getActivity()).replaceFragment(login, TAG_1);
        }
        return  view;
    }



}