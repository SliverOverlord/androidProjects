package edu.mnstate.rm8834yy.lab7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout llRoot = new LinearLayout(this);
        llRoot.setOrientation((LinearLayout.VERTICAL));
        llRoot.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        tvLastName = new TextView(this);
        tvLastName.setText("Jones");
        tvLastName.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        llRoot.addView(tvLastName);
        setContentView(llRoot);
        //setContentView(R.layout.activity_main);
    }
}
