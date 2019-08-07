package edu.mnstate.rm8834yy.lab13_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        String jsonData;
        try{
            InputStream is = this.getAssets().open("studentsdata.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonData = new String(buffer, "UTF-8");
            JSONObject obj = new JSONObject(jsonData);
            JSONObject stu =obj.getJSONObject("student");
            String name = stu.getString("name");
            Toast.makeText(this, "Name: " + name, Toast.LENGTH_LONG).show();
            tvName.setText(name);

        }
        catch(JSONException e){
            Toast.makeText(this, "json exception", Toast.LENGTH_LONG).show();
            Log.d("DENIOERROR", "JSON Exception");
        }
        catch(IOException e){
            Toast.makeText(this, "io exception", Toast.LENGTH_LONG).show();
            Log.d("DENIOERROR", "IOException");
        }
    }
}
