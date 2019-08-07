package com.example.turtle.deniomainp2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ImageView banditImage;
    private TextView attackTxt,armorTxt,BAttackTxt,BArmorTxt,header2;

    private GameHelper gameHelper;
    private SQLiteDatabase db;

    private ArrayList<String> banditInfo = new ArrayList<>();

    private int attackP=5;
    private int armorV=5;
    private int bAttackP;
    private int bArmorV;

    private int counter = 0;
    private int num= 10;
    private int stats;

    private Button runBtn;
    private Button fightBtn;

    Integer[] imageIDs = {
            R.drawable.squirrle,
            R.drawable.mouse2,
            R.drawable.fairy1,
            R.drawable.hobgoblin,
            R.drawable.gopher,
            R.drawable.kitten,
            R.drawable.mage,
            R.drawable.goblins,
            R.drawable.spider1,
            R.drawable.spider2
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gameHelper = new GameHelper(this);

        banditImage = findViewById(R.id.banditImage);
        attackTxt = findViewById(R.id.attackTxt2);
        armorTxt = findViewById(R.id.armorTxt2);
        BAttackTxt = findViewById(R.id.banAttackTxt);
        BArmorTxt = findViewById(R.id.banArmTxt2);
        header2 = findViewById(R.id.heading2);
        runBtn = findViewById(R.id.runBtn);
        fightBtn = findViewById(R.id.fightBtn);

        attackTxt.setText(Integer.toString(attackP));
        armorTxt.setText(Integer.toString(armorV));

        if (counter == 0){

            banditInfo = getData(1);
            try {
                banditImage.setImageResource(imageIDs[0]);
                header2.setText("You have encountered "+banditInfo.get(0)+"you should probably run away");
                BAttackTxt.setText(banditInfo.get(1));
                BArmorTxt.setText(banditInfo.get(2));

                bAttackP =Integer.valueOf(banditInfo.get(1));
                bArmorV = Integer.valueOf(banditInfo.get(2));

                counter = counter +1;
            }
            catch (Exception e){

            }


        }

        fightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (attackP > bArmorV){
                        attackP = attackP+2;
                        nextBandit();
                    }


                }
                catch (Exception e){
                    Message.message(getApplicationContext(),"Error in fight button.");
                }


            }
        });
        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    nextBandit();
                }
                catch (Exception e){
                    Message.message(getApplicationContext(),"Error in fight button.");
                }

            }
        });




    }
    private ArrayList<String> getData(int i) {
        String tmpStr = "";

        ArrayList<String > tmpList = new ArrayList<>();
        db = gameHelper.getReadableDatabase();
        //Cursor c = db.rawQuery("SELECT * FROM GameTable WHERE _id = "+Integer.toString(i), null);
        Cursor c = db.rawQuery("SELECT * FROM gameTable WHERE _id = "+Integer.toString(i), null);
        try {

            if( c != null && c.moveToFirst() ){
                tmpStr = c.getString(c.getColumnIndex("banditName"));
                tmpList.add(c.getString(c.getColumnIndex("banditName")));
                tmpList.add(c.getString(c.getColumnIndex("banditAttack")));
                tmpList.add(c.getString(c.getColumnIndex("banditArmor")));


                c.close();
            }

            Message.message(this,tmpStr);

            //tmpList.add(c.getString(c.getColumnIndex("banditName")));
            //tmpList.add(c.getString(c.getColumnIndex("banditAttack")));
            //tmpList.add(c.getString(c.getColumnIndex("banditArmor")));

            /*
            String[] colNames = c.getColumnNames();
            Message.message(this, "Column Names: "
                    + getString(c.getColumnIndex(colNames[0])) + " " + colNames[1]+" "+colNames[2]);
            */

        } catch(Exception e){
            Message.message(this,"Error getting data");
        }
        return tmpList;


    }
    private void nextBandit(){
        int num1= counter+1;
        int num2= counter;

        if (counter == 11){
            Intent startGame = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startGame);
        }

        if (counter == 10){
            attackTxt.setText(Integer.toString(attackP));

            banditInfo = getData(1);
            try {
                banditImage.setImageResource(imageIDs[0]);
                header2.setText("You have encountered "+banditInfo.get(0));
                BAttackTxt.setText(banditInfo.get(1));
                BArmorTxt.setText(banditInfo.get(2));
                bArmorV = Integer.valueOf(banditInfo.get(2));
                counter = counter +1;
            }
            catch (Exception e){
                Message.message(getApplicationContext(),"Error in nextBandit.");
            }
        }
        else {
            attackTxt.setText(Integer.toString(attackP));

            banditInfo = getData(num1);
            try {
                banditImage.setImageResource(imageIDs[num2]);
                header2.setText("You have encountered "+banditInfo.get(0));
                BAttackTxt.setText(banditInfo.get(1));
                BArmorTxt.setText(banditInfo.get(2));
                bArmorV = Integer.valueOf(banditInfo.get(2));
                counter = counter + 1;
            } catch (Exception e) {
                Message.message(getApplicationContext(), "Error in nextBandit.");
            }
        }
    }

}
