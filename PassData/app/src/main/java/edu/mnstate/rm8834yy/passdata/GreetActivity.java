package edu.mnstate.rm8834yy.passdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GreetActivity extends AppCompatActivity {
    private TextView lblGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
        TextView lblGreet;
        lblGreet = (TextView) findViewById(R.id.lblGreet);
        Intent msgTntent = getIntent();
        String msg = msgTntent.getStringExtra("FullName");
        lblGreet.setText(msg);

    }
}
