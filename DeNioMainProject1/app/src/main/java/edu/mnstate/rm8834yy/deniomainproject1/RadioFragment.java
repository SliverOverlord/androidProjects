package edu.mnstate.rm8834yy.deniomainproject1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {
    private int score = 0;
    private TextView rCorrectLbl;
    private RadioButton rBtn1;
    private RadioButton rBtn2;
    private  RadioGroup rGroup;
    private Button rSubmitBtn;


    public RadioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radio, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        rCorrectLbl = getView().findViewById(R.id.correctLbl);
        rGroup = (RadioGroup) getView().findViewById(R.id.rGroup);
        rBtn1 = (RadioButton) getView().findViewById(R.id.rBtn1);
        rBtn2 = (RadioButton) getView().findViewById(R.id.rBtn2);
        rSubmitBtn = (Button) getView().findViewById(R.id.rSubmitBtn);


        getActivity().findViewById(R.id.rQuestionLbl);
        EditText questionLbl = (EditText) getView().findViewById(R.id.rQuestionLbl);
        //String q = bundle.getString("question");
        //questionLbl.setText("q");




        rGroup = (RadioGroup) getView().findViewById(R.id.rGroup);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rBtn1.isChecked()){
                    score = 1;

                }
                else if(rBtn2.isChecked()){
                    score =0;

                }

                }
                });




        rSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Main2Activity.score =

                try{
                    if(score == 1){
                        rCorrectLbl.setText("Correct");
                    }
                    else if(score == 0){
                        rCorrectLbl.setText("Incorrect");
                    }
                }
                catch (Exception e){

                }



                }
        });

    }


}
