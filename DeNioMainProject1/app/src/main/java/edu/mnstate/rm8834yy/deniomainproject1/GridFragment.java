package edu.mnstate.rm8834yy.deniomainproject1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
    private GridView gridView;
    private int tmpInt;
    private TextView gCorrectLbl;
    private Button gSubmitBtn;
    private int score = 0;
    private TextView gQuestionLbl;



    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getView().findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gCorrectLbl = getView().findViewById(R.id.gCorrectLbl);
        gSubmitBtn = (Button) getView().findViewById(R.id.gSubmitBtn);
        gQuestionLbl = getView().findViewById(R.id.gQuestionLbl);

        gQuestionLbl.setText("What state is the farthest north?");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                tmpInt = position;

                try{
                    if(tmpInt == 0){
                        score = 1;
                    }
                    else if(tmpInt == 1){
                        score =0;
                    }
                    else if(tmpInt == 2){
                        score =0;
                    }
                    else if(tmpInt == 3){
                        score =0;
                    }
                    else if(tmpInt == 4){
                        score =0;
                    }
                    else if(tmpInt == 4){
                        score =0;
                    }
                }
                catch (Exception e){

                }

            }
        });

        gSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Main2Activity.score =

                try{

                    if(score == 1){
                        gCorrectLbl.setText("Correct");
                    }
                    else{
                        gCorrectLbl.setText("Incorrect");
                    }
                }
                catch (Exception e){

                }



            }
        });

    }

}
