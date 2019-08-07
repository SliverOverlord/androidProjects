package com.example.turtle.deniomainp2;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class GameHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "game.db";
    public  static  final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME="gameTable";
    public static final  String BANDITID = "_id";
    public  static final String BANDITNAME = "banditName";
    public static final String BANDITATTACK = "banditAttack";
    public static final String BANDITARMOR = "banditArmor";


    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("+BANDITID+
                    " INTEGER PRIMARY KEY AUTOINCREMENT, "+BANDITNAME+
                    " VARCHAR(255), "+
                    BANDITATTACK+ " VARCHAR(255), "+
                    BANDITARMOR+ " VARCHAR(255)"+

                    ");";
    private static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    GameHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Called the Constructor");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        try{
            //Message.message(context,"onCrate Called");
            db.execSQL(CREATE_TABLE);

        }
        catch (Exception e){
            Message.message(context,""+e);
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{

            //Message.message(context, "onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch(Exception e){
            Message.message(context, ""+e);
        }

    }


}
