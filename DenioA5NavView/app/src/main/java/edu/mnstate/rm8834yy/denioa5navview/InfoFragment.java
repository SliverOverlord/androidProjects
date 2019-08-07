package edu.mnstate.rm8834yy.denioa5navview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    private TextView infoLbl;
    private ImageView infoPic;


    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_info, container, false);
        infoLbl = (TextView) view.findViewById(R.id.infoLbl);
        infoPic = (ImageView) view.findViewById(R.id.infoPic);


        return view;
    }

}
