package edu.mnstate.rm8834yy.lab10lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "MainActivity Created",
                Toast.LENGTH_SHORT).show();
        Log.i("oncreate():","MainActivity Created");
    }

    @Override
    protected void onStart() {

        super.onStart();
        Toast.makeText(this, "MainActivity Started",
                Toast.LENGTH_SHORT).show();
        Log.i("onStart():","MainActivity Started");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Toast.makeText(this, "MainActivity Restarted",
                Toast.LENGTH_SHORT).show();
        Log.i("onReStart():","MainActivity reStarted");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Toast.makeText(this, "MainActivity Resumed",
                Toast.LENGTH_SHORT).show();
        Log.i("onResume():","MainActivity Resumed");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Toast.makeText(this, "MainActivity Paused",
                Toast.LENGTH_SHORT).show();
        Log.i("onPause():","MainActivity Paused");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Toast.makeText(this, "MainActivity Stopped",
                Toast.LENGTH_SHORT).show();
        Log.i("onStop():","MainActivity Stoped");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Toast.makeText(this, "MainActivity Destroyed",
                Toast.LENGTH_SHORT).show();
        Log.i("onDestroy():","MainActivity Destroyed");
    }


}
