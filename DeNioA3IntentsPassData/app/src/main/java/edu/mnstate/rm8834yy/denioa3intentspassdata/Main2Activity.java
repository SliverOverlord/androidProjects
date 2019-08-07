package edu.mnstate.rm8834yy.denioa3intentspassdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText payReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        payReport = findViewById(R.id.payReport);
        Intent msgIntent = getIntent();
        String msg = msgIntent.getStringExtra("EmpReport");
        payReport.setText("");
        payReport.setText(msg);
    }
}
