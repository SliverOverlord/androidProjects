package com.example.turtle.myriadmobilechallenge.activity;
/*
Author Joshua DeNio
Project name: Fargo Events App
Date: 12/20/18

Description:
This app gathers a users login information and submits it to api for a security token.
It then uses the token to request a json from the api and uses the data to populate
a recyclerView with events.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.turtle.myriadmobilechallenge.R;
import com.example.turtle.myriadmobilechallenge.controller.LoginService;

public class MainActivity extends AppCompatActivity {
    private EditText userNameTxt;
    private EditText passwordTxt;
    private Button loginBtn;

    private LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTxt = findViewById(R.id.userNameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        loginBtn = findViewById(R.id.loginBtn);

        userNameTxt.requestFocus();

        //Check to see if there is a saved key
        checkForKey();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean validVar = validate();
                if (validVar == true){


                    loginService = new LoginService(getApplicationContext(),userNameTxt.getText().toString(),passwordTxt.getText().toString());
                    loginService.execute();


                    userNameTxt.setText("");
                    passwordTxt.setText("");
                    userNameTxt.requestFocus();


                }
                else {
                    invalidAlert();

                }
            }
        });
    }

    private void checkForKey(){
        try{
            String tmpKey = "";
            SharedPreferences sharedToken = getApplicationContext().getSharedPreferences("tokenInfo", Context.MODE_PRIVATE);
            tmpKey += sharedToken.getString("token", "");
            if(tmpKey != ""){
                //Start new activity and sen in the key
                Intent secondActivity = new Intent(getApplicationContext(), Main2Activity.class);
                secondActivity.putExtra("TokenKey", tmpKey);
                startActivity(secondActivity);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //Function to save API token
    private void saveToken(String tokenStr){
        SharedPreferences sharedToken = getSharedPreferences("tokenInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedToken.edit();
        editor.putString("token", tokenStr);
        editor.apply();
    }

    //Function to save username and password to sharedPreferences
    public void savelogin(View view){
        SharedPreferences sharedP = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedP.edit();
        editor.putString("userName", userNameTxt.getText().toString());
        editor.putString("password", passwordTxt.getText().toString());
        editor.apply();
    }

    //Function to validate input
    private Boolean validate(){

        Boolean validV = true;
        int str1 = userNameTxt.getText().toString().trim().length();
        int str2 = passwordTxt.getText().toString().trim().length();

        if (str1 == 0 || str2 == 0){
            validV = false;

        }

        return validV;
    }

    //Function alert and reset fields
    private void invalidAlert(){
        userNameTxt.setText("");
        passwordTxt.setText("");
        userNameTxt.requestFocus();

        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(this);
        alertbuilder.setMessage("Enter a valid username and password");
        alertbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = alertbuilder.create();
        alertDialog.show();

    }


}
