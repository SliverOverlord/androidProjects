package com.example.turtle.deniomainp2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


/**
 *Preferances fragment.
 */
public class PreferencFragment extends Fragment {
    private Button btn10;
    private Button btn5;
    private FrameLayout content_frame;



    public PreferencFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preferenc, container, false);

        btn10 = (Button) view.findViewById(R.id.btn10);
        btn5 = (Button) view.findViewById(R.id.btn5);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = "6";
                Intent setGame = new Intent(getContext(), MainActivity.class);
                setGame.putExtra("STATS",num);
                startActivity(setGame);


            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setGame = new Intent(getContext(), MainActivity.class);
                startActivity(setGame);


            }
        });



        return view;
    }


}
