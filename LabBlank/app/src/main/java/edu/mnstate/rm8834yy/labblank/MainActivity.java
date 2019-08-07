package edu.mnstate.rm8834yy.labblank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText et_name;
    private EditText et_email;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        button = findViewById(R.id.btn);
        setup();


    }
    private void setup(){
        String tmp = "";
        SharedPreferences prefs = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        tmp += prefs.getString( "Name", "Hello, ");
        tmp += prefs.getString("Email","world");
        tv.setText(tmp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitClick();
            }
        });
    }
    private void submitClick(){
        SharedPreferences prefs = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        if (!et_name.getText().toString().isEmpty())
            prefs.edit().putString("Name", et_name.getText().toString()).apply();
        if (!et_email.getText().toString().isEmpty())
            prefs.edit().putString("Email", et_email.getText().toString()).apply();

        restartActivity();
    }
    private void restartActivity(){
        startActivity(new Intent(this,MainActivity.class));

        finish();

    }

}
