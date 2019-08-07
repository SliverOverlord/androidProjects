package com.example.rm8834yy.buttonlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    private TextView lblGreeting;

    private TextView lblGreeting2;
    private Button btnGreet2;
    private EditText txtFirstName;

    private EditText txtFirstName3;
    private TextView lblGreeting3;
    private Button btnGreet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        lblGreeting = findViewById(R.id.lblGreeting);

        txtFirstName = findViewById(R.id.txtFirstName);
        lblGreeting2 = findViewById(R.id.lblGreeting2);
        btnGreet2 = (Button) findViewById(R.id.btnGreet2);
        btnGreet2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String tmp = getResources().getString(R.string.hello_there);
                lblGreeting2.setText(tmp + "Welcome " + txtFirstName.getText());

            }
        });

        lblGreeting3 = (TextView) findViewById(R.id.lblGreeting3);
        txtFirstName3 = (EditText) findViewById(R.id.txtFirstName2);
        btnGreet3 = (Button) findViewById(R.id.btnGreet3);
        btnGreet3.setOnClickListener((v) -> {
                String tmp2 = getResources().getString(R.string.hello_there2);
                lblGreeting3.setText(tmp2 + " " + txtFirstName3.getText());
        });

    }

    public void btn1Clicked(View view) {
        String strName = txtName.getText().toString();
        lblGreeting.setText("Good Morning " + strName);

    }
}


