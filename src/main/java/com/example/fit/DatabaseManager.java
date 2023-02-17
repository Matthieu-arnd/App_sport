package com.example.fit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Fit.db";
    private static final int DATABASE_VERSION=1;


    public DatabaseManager (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Seancelist ("
                + "id integer primary key autoincrement,"
                + "name text not null,"
                +")";
        db.execSQL(strSql);

        String strsql2 = "create table Seance"
                + "id integer primary key autoincrement,"
                + "name text not null,"
                + "isDone bool not null,"
                + "idSeanceList int not null,"
                +")";
        db.execSQL(strsql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<SeanceList> getAllSeanceList(){
        ArrayList<SeanceList> listseance = new ArrayList<SeanceList>();

        String strSql = "select * from Seancelist";
        Cursor cursor = this.getWritableDatabase().rawQuery(strSql, null);

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String seanceListName = cursor.getString(cursor.getColumnIndex("name"));

                SeanceList seanceListObj = new SeanceList();
                seanceListObj.setId(id);
                seanceListObj.setName(seanceListName);

                listseance.add(seanceListObj);
                cursor.moveToNext();
            }
        }
        return listseance;
    }



}
