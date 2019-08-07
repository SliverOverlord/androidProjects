package edu.mnstate.rm8834yy.denioa3intentspassdata;
/*
Author: Joshua DeNio
CSIS 365
Date: 9/20/18
Description:
This app makes employee objects and adds them to an array. It then calculates
gross pay, net pay and fica amount and sends data to another activity as well
as to a listView.

 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class                                          MainActivity extends AppCompatActivity {
    ArrayList <Employee> empList = new ArrayList<>();
    ArrayList <String> empStrL = new ArrayList<>();
    String [ ] empInfo = {};

    private TextView nameLbl;
    private TextView hoursLbl;
    private TextView payrateLbl;

    private EditText nameF;
    private EditText hoursF;
    private EditText payrateF;

    private Button addBtn;
    private Button payReportBtn;
    private Button showAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLbl = findViewById(R.id.nameLbl);
        hoursLbl = findViewById(R.id.hoursLbl);
        payrateLbl = findViewById(R.id.payrateLbl);

        nameF = findViewById(R.id.nameF);
        hoursF = findViewById(R.id.hoursF);
        payrateF = findViewById(R.id.payrateF);

        addBtn = findViewById(R.id.addBtn);
        payReportBtn = findViewById(R.id.payReportBtn);
        showAllBtn = findViewById(R.id.showAllBtn);

        nameF.requestFocus();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String tmpName = nameF.getText().toString();
                    double tmpHours = Double.parseDouble(hoursF.getText().toString());
                    double tmpPayrate = Double.parseDouble(payrateF.getText().toString());

                    Employee newEmp = new Employee(tmpName, tmpHours, tmpPayrate);
                    empList.add(newEmp);
                    Collections.sort(empList, Employee.empNameComp);

                    nameF.setText("");
                    hoursF.setText("");
                    payrateF.setText("");
                    nameF.requestFocus();

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Correct input needed",Toast.LENGTH_SHORT);
                }
            }
        });

        payReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    Intent report = new Intent(getApplicationContext(), Main2Activity.class);
                    String empInfo = "";
                    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();


                    for (int i =0;i<empList.size(); i++){
                        double gross = grossPay(empList.get(i).getHours(),empList.get(i).getPayrate());
                        double fica = ficaAmount(empList.get(i).getHours(),empList.get(i).getPayrate());
                        double net = netPay(gross,fica);

                        //String strGross = String.format("%.2f", gross);
                        //String strFica = String.format("%.2f", fica);
                        ///String strNet = String.format("%.2f", net);

                        empInfo = empInfo + empList.get(i).toString();
                        empInfo = empInfo + "Gross Pay: ";
                        empInfo = empInfo + currencyFormat.format(gross);
                        empInfo = empInfo + "\n";
                        empInfo = empInfo + "FICA Amount: ";
                        empInfo = empInfo + currencyFormat.format(fica);
                        empInfo = empInfo + "\n";
                        empInfo = empInfo + "Net Pay: ";
                        empInfo = empInfo + currencyFormat.format(net);
                        empInfo = empInfo + "\n";
                        empInfo = empInfo + "\n";
                    }

                    report.putExtra( "EmpReport",empInfo);
                    startActivity(report);

                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Pay Report Failed",Toast.LENGTH_SHORT);
                }

            }
        });

        showAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                try {
                    String tmpStr = "";
                    for (int i =0;i<empList.size(); i++){
                        //tmpStr = tmpStr +
                        empStrL.add(empList.get(i).toString());
                    }

                    ListView listVDisplay = (ListView) findViewById(R.id.listVDisplay);
                    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.emp_lable,empStrL);
                    listVDisplay.setAdapter(adapter);


                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Show all failed",Toast.LENGTH_SHORT);
                }

            }
        });


    }

    public double grossPay(double hours, double payrate){
        double pay = 0;
        double overTimePay = 0;
        double regHours = 0;
        double overHours = 0;

        if (hours > 40){
            overHours = hours - 40;
            regHours  = 40;
            overTimePay = (payrate*1.5)*overHours;
            pay = regHours*payrate;
            pay = pay + overTimePay;
        }
        else {
            pay = hours * payrate;
        }


        return pay;
    }

    public double netPay(double gross, double fica){
        double net = 0;
        net = gross-fica;
        return net;
    }

    public double ficaAmount(double hours, double payrate){
        double gross = 0;
        double fica = 0;

        gross = grossPay(hours,payrate);
        fica = gross*.0765;

        return fica;
    }
}
