package edu.mnstate.rm8834yy.lab11fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnGreen;
        Button btnOrange;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGreen = findViewById(R.id.btnGreen);
        btnOrange = findViewById(R.id.btnOrange);
    }

    public void btnGreenClicked(View view) {
        Toast.makeText(this, "Green button clicked",Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,
                        new GreenFragment())
                .commit();

    }

    public void btnOrangeClicked(View view) {
        Toast.makeText(this, "Orange button clicked",Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,
                        new OrangeFragment())
                .commit();

    }
}
