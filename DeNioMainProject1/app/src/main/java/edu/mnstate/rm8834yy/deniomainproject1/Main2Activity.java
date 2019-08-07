package edu.mnstate.rm8834yy.deniomainproject1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements SpinnerFragment.spinnerInterface{
    public int mainScore = 0;
    private String msg = "";
    private int count = 0;
    private int qCount =0;

    private String jsonData;

    private Button nextBtn;
    private TextView scoreLbl;

    private android.support.v4.app.FragmentTransaction c;

    ArrayList<String>  questionList = new ArrayList<>();
    ArrayList<String> answerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent nameInfo = getIntent();
        msg = nameInfo.getStringExtra("InfoReport");

        nextBtn = findViewById(R.id.nextBtn);
        scoreLbl = findViewById(R.id.scoreLbl);


        try{
            getJson();

            String tmpStr = questionList.get(count);
            String tmpStr2 = answerList.get(count);

            Intent intentStr = new Intent(getApplicationContext(), Main2Activity.class);
            String empInfo = "";

            intentStr.putExtra( "QuestionStr",tmpStr);
            startActivity(intentStr);
        }
        catch (Exception e){
            scoreLbl.setText("Error getting  json");
        }



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,
                        new CheckBoxFragment(), "newFragment")
                .commit();

        /*
        FragmentManager manager = getSupportFragmentManager();
        final android.support.v4.app.FragmentTransaction c = manager.beginTransaction();
        final CheckBoxFragment check = new CheckBoxFragment();
        c.add(R.id.fragment_container,check);
        c.commit();
        */

        final RadioFragment radio = new RadioFragment();


        scoreLbl.setText(msg);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qCount==0){
                    qCount = qCount++;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("newFragment");
                    if(fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    new RadioFragment(), "newFragment")
                            .commit();

                }
                else if(qCount==1){
                    qCount = qCount++;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("newFragment");
                    if(fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    new ToggleFragment(), "newFragment")
                            .commit();

                }
                else if(qCount==2){
                    qCount = qCount++;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("newFragment");
                    if(fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    new SpinnerFragment(), "newFragment")
                            .commit();

                }
                else if(qCount==3){
                    qCount = qCount++;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("newFragment");
                    if(fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    new ListVFragment(), "newFragment")
                            .commit();

                }
                else if(qCount==4){
                    qCount = qCount++;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("newFragment");
                    if(fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    new GridFragment(), "newFragment")
                            .commit();

                }
                else if(qCount==5){
                    AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You have reached the end of the quiz");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }


                //c.remove(check);
                //c.add(R.id.fragment_container,radio);
                //c.commit();

            }
        });

        /*
        String tmpStr = "New Question";
        String tmpStr2 = "a";

        count =  count++;

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction c = manager.beginTransaction();
        CheckFragment check = new CheckFragment();
        c.add(R.id.fragment_container,check);
        c.commit();

        check.setArguments(bundle);
        c.add(R.id.fragment_container,check);
        c.commit();
        */


    }

    public void searchSelected(String state){

    }


    public void getJson(){
        String strJson = null;

        try {




            InputStream inS = getAssets().open("questions.json");
            int size = inS.available();
            byte[] buffer = new byte[size];
            inS.read(buffer);
            inS.close();

            strJson = new String(buffer,"UTF-8");


            JSONArray jsonArray = new JSONArray(strJson);

            for (int i =0;i<jsonArray.length();i++){
                //JSONObject.getString("question")
                JSONObject obj = jsonArray.getJSONObject(i);
                questionList.add(obj.getString("question"));
                answerList.add(obj.getString("answer"));

            }



        }
        catch (IOException e)
        {
            Toast.makeText(getApplicationContext(),"json io failed",Toast.LENGTH_SHORT);

            e.printStackTrace();
        }
        catch (JSONException e){
            Toast.makeText(getApplicationContext(),"json failed",Toast.LENGTH_SHORT);

            e.printStackTrace();
        }


    }
}
