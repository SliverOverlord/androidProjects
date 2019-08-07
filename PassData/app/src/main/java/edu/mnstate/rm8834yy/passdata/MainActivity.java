package edu.mnstate.rm8834yy.passdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText)findViewById(R.id.txtName);

    }

    public void submitbtn(View view) {
        Intent intentGreet = new Intent(this,GreetActivity.class);
         String tmpName = txtName.getText().toString();
         intentGreet.putExtra("FullName",tmpName);
         startActivity(intentGreet);

    }
}
