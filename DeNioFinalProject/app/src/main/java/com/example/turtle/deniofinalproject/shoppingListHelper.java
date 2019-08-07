package com.example.turtle.deniofinalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class shoppingListHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoppingListDb.db";
    public  static  final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME="itemTable";
    public static final  String ITEMID = "_id";
    public  static final String ITEMNAME = "itemName";
    public static final String QUANTITY = "itemQuantity";


    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("+ITEMID+
                    " INTEGER PRIMARY KEY AUTOINCREMENT, "+ITEMNAME+
                    " VARCHAR(255), "+
                    QUANTITY+ " VARCHAR(255)"+

                    ");";
    private static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    shoppingListHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        //Message.message(context,"Called the Constructor");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        try{
            //Message.message(context,"onCrate Called");
            db.execSQL(CREATE_TABLE);

        }
        catch (Exception e){
            //Message.message(context,""+e);
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
           // Message.message(context, ""+e);
        }

    }

}
