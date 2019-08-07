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
public class HomeFragment extends Fragment {
    private TextView welcomeLbl;
    private ImageView homePic;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        welcomeLbl = (TextView)view.findViewById(R.id.welcomeLbl);
        homePic = (ImageView)view.findViewById(R.id.homePic);
        return view;
    }

}
