package edu.mnstate.rm8834yy.deniomainproject1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple check fragment.
 */
public class CheckBoxFragment extends Fragment {

    private int localScore = 0;
    private  Button cSubmitBtn;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private TextView correctLbl;


    public interface selectedListener {
        void onBoxSelected(int localScore);
    }


    public CheckBoxFragment() {
        // Required empty public constructor
    }

    selectedListener nListener;
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try{
            nListener = (selectedListener) context;

        }
        catch(Exception e){
            Toast.makeText(getContext(),"failed to link",Toast.LENGTH_SHORT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_check_box, container, false);
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        getActivity().findViewById(R.id.cQuestionLbl);
        EditText questionLbl = (EditText) getView().findViewById(R.id.cQuestionLbl);

        /*
        try{
            questionLbl.setText("question");
        }
        catch (Exception e){
            questionLbl.setText("question");
        }
        */

        final CheckBox checkBox1 = (CheckBox) getView().findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) getView().findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) getView().findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) getView().findViewById(R.id.checkBox4);

        correctLbl = getView().findViewById(R.id.correctLbl);
        cSubmitBtn = getView().findViewById(R.id.cSubmitBtn);

        cSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {

                if (checkBox1.isChecked()){
                    correctLbl.setText("Correct");
                }
                if (checkBox2.isChecked()){
                    correctLbl.setText("Incorrect");
                }
                if (checkBox3.isChecked()){
                    correctLbl.setText("Incorrect");
                }
                if (checkBox4.isChecked()){
                    correctLbl.setText("incorrect");
                }
                }
        });

    }



}
