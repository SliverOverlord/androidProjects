package edu.mnstate.rm8834yy.lab8listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //String [ ] empNames = {"Joe", "Sally", "Molly", "James"};
    String [ ] empNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empNames = getResources().getStringArray(R.array.empNames);
        ListView empListView =
                (ListView) findViewById(R.id.empListView);

        ArrayAdapter adapterEmp =
                new ArrayAdapter(getApplicationContext(),R.layout.emp_label,empNames);

        empListView.setAdapter(adapterEmp);
    }
}
