package edu.mnstate.rm8834yy.a2deniov2;
/*
Author: Joshua DeNio
CSIS 365
Date: 9/13/18
Description:
This app takes input for first and last name as well as 3 test
scores and makes an arrayList of student objects.
It will then process the students score based on what button is pressed.
mean, median and modee, as well as lowest and highest.

 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class MainActivity extends AppCompatActivity {

    ArrayList <Student> studentList = new ArrayList<Student>();
    ArrayList <Integer> t1List = new ArrayList<Integer>();
    ArrayList <Integer> t2List = new ArrayList<Integer>();
    ArrayList <Integer> t3List = new ArrayList<Integer>();

    private EditText fNameBox;
    private EditText lNameBox;
    private EditText test1Box;
    private EditText test2Box;
    private EditText test3Box;


    private TextView medianF;
    private TextView modeF;
    private TextView meanF;
    private TextView lowF;
    private TextView highF;

    private EditText textOut;

    private Button addBtn;
    private Button highestBtn;
    private Button lowestBtn;
    private Button modeBtn;
    private Button meanBtn;
    private Button medianBtn;
    private Button printAllBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fNameBox = findViewById(R.id.fNameBox);
        lNameBox = findViewById(R.id.lNameBox);
        test1Box = findViewById(R.id.test1Box);
        test2Box = findViewById(R.id.test2Box);
        test3Box = findViewById(R.id.test3Box);

        medianF = findViewById(R.id.medianF);
        modeF = findViewById(R.id.modeF);
        meanF = findViewById(R.id.meanF);
        lowF = findViewById(R.id.lowF);
        highF = findViewById(R.id.highF);

        textOut = findViewById(R.id.textOut);

        addBtn = (Button) findViewById(R.id.addBtn);
        highestBtn = (Button) findViewById(R.id.highestBtn);
        lowestBtn = (Button) findViewById(R.id.lowestBtn);
        modeBtn = (Button) findViewById(R.id.modeBtn);
        meanBtn = (Button) findViewById(R.id.meanBtn);
        medianBtn = (Button) findViewById(R.id.medianBtn);
        printAllBtn = (Button) findViewById(R.id.printAllBtn);

        fNameBox.requestFocus();

        printAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v6) {
                printAllM();

            }
        });

        medianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                try {


                    int tmpMedian = 0;
                    //fill the list

                    for (int i = 0; i < studentList.size(); i++) {

                        int tmpNum = studentList.get(i).getTest2();
                        t2List.add(tmpNum);
                    }
                    //sort
                    Collections.sort(t2List);



                    int middle = t2List.size() / 2;

                    if (t2List.size() % 2 == 1) {
                        tmpMedian = t2List.get(middle);

                    } else {
                        tmpMedian = (t2List.get(middle - 1) + t2List.get(middle)) / 2;
                    }

                    String tmpMed = Integer.toString(tmpMedian);

                    medianF.setText(tmpMed);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Median button failed no input?",Toast.LENGTH_SHORT).show();
                }

            }
        });

        meanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {

                try {

                    for (int i = 0; i < studentList.size(); i++) {

                        int tmpNum = studentList.get(i).getTest3();
                        t3List.add(tmpNum);
                    }
                    //sort
                    Collections.sort(t3List);
                    //double tmpmean = getMeanOft3(t3List);

                    double meanSum=0;
                    for (int i =0; i < t3List.size(); i++) {
                        int tmpNum = t3List.get(i);
                        meanSum = meanSum + t3List.get(i);
                    }
                    meanSum = meanSum/t3List.size();

                    DecimalFormat roundedNum = new DecimalFormat("0.0");
                    String formNum = roundedNum.format(meanSum);


                    meanF.setText(formNum);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"mean button failure",Toast.LENGTH_SHORT).show();
                }

            }
        });

        modeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                try {

                    int tmpMode2 = 0;
                    int maxVal = 0;
                    int maxCount = 0;
                    int numModes =0;
                    //fill the list

                    for (int i = 0; i < studentList.size(); i++) {

                        int tmpNum = studentList.get(i).getTest1();
                        t1List.add(tmpNum);
                    }
                    //sort
                    Collections.sort(t1List);

                    for (int i = 0; i < t1List.size(); i++) {
                        int count = 0;
                        for (int j = 0; j < t1List.size(); ++j) {
                            if (t1List.get(j) == t1List.get(i)) ++count;

                        }
                        if (count > maxCount) {
                            maxCount = count;
                            maxVal = t1List.get(i);
                        }
                        else if ( count == maxCount){
                            tmpMode2 = t1List.get(i);
                            numModes = 2;
                        }
                    }

                    if (numModes == 2){
                        String tmpVal = Integer.toString(maxVal);
                        tmpVal = tmpVal + "," + tmpMode2;
                        modeF.setText(tmpVal);
                    }
                    else {
                        String tmpVal = Integer.toString(maxVal);
                        modeF.setText(tmpVal);
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Mode button failure.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        lowestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                try {
                    int tmpLow = 0;

                    for (int i = 0; i < studentList.size(); i++) {
                        int tmpNum = studentList.get(i).getTest1();
                        int tmpNum2 = studentList.get(i).getTest2();
                        int tmpNum3 = studentList.get(i).getTest3();

                        if (i == 0) {
                            tmpLow = tmpNum;

                        }

                        tmpLow = min(tmpLow, tmpNum);
                        tmpLow = min(tmpLow, tmpNum2);
                        tmpLow = min(tmpLow, tmpNum3);

                    }
                    lowF.setText(Integer.toString(tmpLow));
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Lowest button error: no input.",Toast.LENGTH_SHORT).show();
                }


            }
        });

        highestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    int tmpHigh = 0;

                    for (int i = 0; i < studentList.size(); i++) {

                        int tmpNum = studentList.get(i).getTest1();
                        int tmpNum2 = studentList.get(i).getTest2();
                        int tmpNum3 = studentList.get(i).getTest3();

                        if (i == 0) {
                            tmpHigh = tmpNum;

                        }

                        tmpHigh = max(tmpHigh, tmpNum);
                        tmpHigh = max(tmpHigh, tmpNum2);

                        tmpHigh = max(tmpHigh, tmpNum3);
                    }
                    highF.setText(Integer.toString(tmpHigh));
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Highest button error no input.",Toast.LENGTH_SHORT).show();
                }


            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    //Makes aa student and adds to the list.
                    String strFName = fNameBox.getText().toString();
                    String strLName = lNameBox.getText().toString();

                    int i = Integer.parseInt(test1Box.getText().toString());
                    int ii = Integer.parseInt(test2Box.getText().toString());
                    int iii = Integer.parseInt(test3Box.getText().toString());

                    Student newStudent = new Student(strFName,strLName,i,ii,iii);
                    studentList.add(newStudent);

                    fNameBox.setText("");
                    lNameBox.setText("");
                    test1Box.setText("");
                    test2Box.setText("");
                    test3Box.setText("");
                    fNameBox.requestFocus();

                }
                catch (Exception e){
                    //textOut.setText("Unable to add student");
                    Toast.makeText(getApplicationContext(),"Add btn: please enter valid input",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    public double getMeanOft3(ArrayList t3List){
        double mean=0;
        double roundedNumber;
        for (int i =0; i < t3List.size(); i++) {
            //int tmpNum = t3List.get(i);
            //mean = mean + t3List.get(i);
        }
        mean = mean/t3List.size();
        roundedNumber =
                (double)Math.round(mean * Math.pow(10, 10))
                        / Math.pow(10, 10);
        return mean;
    }

    public void returnLowest(ArrayList studentList){

        //int tmpLowest = 0;
        //tmpLowest = Collections.min();
        //for (int i = 0; i<studentList.size();i++){
            //int tmp1 = studentList.get(i).getTest1()
            //if (studentList.get(i).getTest1()<tmpLowest){

           // }
        //}
        //return tmpLowest;


    }

    public void printAllM(){
        try {
            //textOut = findViewById(R.id.textOut);
            String tmpStr = "";
            for (int i =0; i < studentList.size(); i++) {
                //tmpStr= tmpStr + studentList.indexOf(i);
                tmpStr= tmpStr + studentList.get(i).toString()+"\n";
            }
            textOut.setText(tmpStr);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Print All failed",Toast.LENGTH_SHORT).show();

        }
    }
    public void btn1Clicked(View view) {
        try {
            String strFName = fNameBox.getText().toString();
            String strLName = lNameBox.getText().toString();

            int i = Integer.parseInt(test1Box.getText().toString());
            int ii = Integer.parseInt(test2Box.getText().toString());
            int iii = Integer.parseInt(test3Box.getText().toString());


            Student newStudent = new Student(strFName,strLName,i,ii,iii);
            studentList.add(newStudent);
            //lblGreeting.setText("Good Morning " + strName);
        }
        catch (Exception e){
            textOut.setText("Unable to add student");
        }

    }
}
