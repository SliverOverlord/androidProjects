package edu.mnstate.rm8834yy.deniomainproject1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListVFragment extends Fragment {
    private ListView stateListV;
    private int score = 0;
    private TextView lCorrectLbl;
    private Button lSubmitBtn;
    String [ ] states ;
    private int tmpInt;
    private TextView lQuestionLbl;



    public ListVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_v, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lCorrectLbl = getView().findViewById(R.id.lCorrectLbl);
        lSubmitBtn = (Button) getView().findViewById(R.id.lSubmitBtn);
        stateListV = (ListView) getView().findViewById(R.id.stateListV);
        lQuestionLbl = (ListView) getView().findViewById(R.id.lQuestionLbl);

        states = getResources().getStringArray(R.id.states);


        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.state_lable,states);
        String q = "Select the US state that is the farthest north";

        lQuestionLbl.setText(q);
        stateListV.setAdapter(adapter);

        stateListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                tmpInt = position;

                try{
                    if(tmpInt == 1){
                        score = 1;
                    }
                    else if(tmpInt == 0){
                        score =0;
                    }
                    else if(tmpInt == 2){
                        score =0;
                    }
                    else if(tmpInt == 3){
                        score =0;
                    }

                }
                catch (Exception e){

                }

            }
        });

        lSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Main2Activity.score =

                try{

                    if(score == 1){
                        lCorrectLbl.setText("Correct");
                    }
                    else{
                        lCorrectLbl.setText("Incorrect");
                    }
                }
                catch (Exception e){

                }



            }
        });
    }

}
