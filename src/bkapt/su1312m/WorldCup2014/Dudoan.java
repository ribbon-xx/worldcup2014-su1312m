package bkapt.su1312m.WorldCup2014;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by My pc on 9/6/2014.
 */
public class Dudoan extends Fragment {
    private TextView select;
    private Spinner spinner;
    String[] nameteam = { "VietNam", "Brazil", "Lao ", "Abc" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spinner, container, false);
        select = (TextView) view.findViewById(R.id.select);
        spinner = (Spinner) view.findViewById(R.id.spinner1);

        return view;
    }
}
