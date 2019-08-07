package com.example.turtle.deniomainp2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout content_frame;
    private DrawerLayout drawerLayout;

    private GameHelper gameHelper;
    private SQLiteDatabase db;
    public int encounterNum = 10;
    public int stats = 5;
    private ArrayList<String> banditList;

    String[] nameList = {
            "the bandit leader",
            "the bandit assassin",
            "an angry forest fairy",
            "a hobgoblin",
            "a gopher bandit",
            "a bandit archer",
            "a bandit wizard",
            "a nasty forest goblin",
            "a giant spider",
            "a medium sized spider"

    };

    String[] attackList = {
            "10",
            "8",
            "5",
            "9",
            "6",
            "3",
            "8",
            "4",
            "5",
            "3"

    };

    String[] armorList = {
            "10",
            "2",
            "1",
            "5",
            "8",
            "5",
            "6",
            "4",
            "8",
            "7"

    };

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
        setContentView(R.layout.activity_main);

        try{
            Intent msgIntent = getIntent();
            String msg = msgIntent.getStringExtra("STATS");
            stats = Integer.valueOf(msg);
        }
        catch(Exception e){

        }

        gameHelper = new GameHelper(this);

        addBandits(this);
        viewColNames();

        drawerLayout = findViewById(R.id.drawer_layout);

        drawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {

                    @Override
                    public void onDrawerSlide(@NonNull View view, float v) {

                    }

                    @Override
                    public void onDrawerOpened(@NonNull View view) {

                    }

                    @Override
                    public void onDrawerClosed(@NonNull View view) {

                    }

                    @Override
                    public void onDrawerStateChanged(int i) {

                    }
                }
        );




        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_web_black_24dp);



        content_frame = (FrameLayout) findViewById(R.id.content_frame);
        NavigationView nav = findViewById(R.id.nav_view);

        nav.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, (new HomeFragment()), "fragment_home")
                .commit();


    }

    private void addBandits(MainActivity mainActivity) {
        db = gameHelper.getWritableDatabase();

        ContentValues cVals = new ContentValues();

        String numEncounters = "10";

        cVals.put(gameHelper.BANDITNAME, numEncounters);

        for(int i = 0; i < 10; i++){

            String bName = nameList[i];
            String bAtt = attackList[i];
            String bArm = armorList[i];
            //String imageId = imageIDs[i].toString();

            cVals.put(gameHelper.BANDITNAME,bName);
            cVals.put(gameHelper.BANDITATTACK,bAtt);
            cVals.put(gameHelper.BANDITARMOR,bArm);
            long id = db.insert(gameHelper.TABLE_NAME,null,cVals);

            if (id>0){
                //Message.message(this,"success- added to db");
            }
            else{
                Message.message(this,"unsuccessful--no add");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private NavigationView
            .OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    if(stats==6){
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame,
                                        (new Home2Fragment()), "fragment_home2")
                                .commit();
                    }
                    else {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame,
                                        (new HomeFragment()), "fragment_home")
                                .commit();
                    }
                    return true;
                case R.id.about:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new AboutFragment()), "fragment_about")
                            .commit();
                    return true;
                case R.id.preferences:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame,
                                    (new PreferencFragment()), "fragment_preference")
                            .commit();
                    return true;


            }

            return false;
        }
    };

    public void viewColNames() {
        db = gameHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM GAMETABLE WHERE 0", null);

        try{
            String[] colNames = c.getColumnNames();
            Message.message(this, "Column Names: "
                   + colNames[0] + " " + colNames[1]+" "+colNames[2]);
        }finally {
            c.close();
        }

    }



}
