package edu.mnstate.rm8834yy.lab7part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLastName = (TextView)findViewById(R.id.lblLastName);
        tvLastName.setText("Jones");
    }
}
