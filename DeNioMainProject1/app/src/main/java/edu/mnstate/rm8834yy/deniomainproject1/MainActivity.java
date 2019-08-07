package edu.mnstate.rm8834yy.deniomainproject1;
/*
Author: Joshua DeNio
Class: CSIS 365
Description:
Project one is a quiz using seekbar, fragments,checkbox
,radioButtons, and more to showcase usage.

 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SeekBar ageBar;
    private static TextView ageOut;
    private EditText nameF;
    private Button startBtn;

    private int ageVal= 0;
    private String nameStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameF = findViewById(R.id.nameF);
        startBtn = findViewById(R.id.startBtn);

        nameF.requestFocus();
        getAge();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    nameStr = "Name: ";
                    nameStr = nameStr + nameF.getText().toString();
                    nameStr = nameStr + "\n";
                    nameStr = nameStr + "Age: ";
                    nameStr = nameStr + Integer.toString(ageVal);

                    Intent infoReport = new Intent(getApplicationContext(),Main2Activity.class);

                    infoReport.putExtra("InfoReport",nameStr);
                    startActivity(infoReport);
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"More input needed"
                    ,Toast.LENGTH_SHORT);
                }
            }
        });

    }



    public void getAge(){
        ageBar = (SeekBar)findViewById(R.id.ageBar);
        ageOut = (TextView)findViewById(R.id.ageOut);
        ageOut.setText("Age: " + ageBar.getProgress());

        ageBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        ageVal = progress;
                        ageOut.setText("Age: " + ageVal);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        ageOut.setText("Age: " + ageVal);
                    }
                }
        );

    }

}
