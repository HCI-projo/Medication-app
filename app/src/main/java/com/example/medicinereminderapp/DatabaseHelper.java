package com.example.medicinereminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Project.db";
    public static final String TABLE_NAME    ="medication_table";
    public static final String COL_1         ="ID";
    public static final String COL_2         ="MEDICATION_NAME";
    public static final String COL_3         ="NUMBER_OF_TABLETS";
    public static final String COL_4         ="PRESCRIPTION1";
    public static final String COL_5         ="PRESCRIPTION2";

    List<MedicationModel> medicationModels = new ArrayList<>();
    SQLiteDatabase db;

    public DatabaseHelper(Context context){
          super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){
        db.execSQL(" create table " + TABLE_NAME +" ( ID INTEGER PRIMARY KEY AUTOINCREMENT , MEDICATION_NAME TEXT , NUMBER_OF_TABLETS INTEGER, PRESCRIPTION1 INTEGER, PRESCRIPTION2 INTEGER)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String medicationName,String numberOfTablets,String prescription1,String prescription2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COL_2,medicationName);
        contentValues.put(COL_3,numberOfTablets);
        contentValues.put(COL_4,prescription1);
        contentValues.put(COL_5,prescription2);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else
            return true;
    }


//    public /*Cursor*/ List<MedicationModel> fetchAllData(){
    public Cursor fetchAllData(){

        SQLiteDatabase db = this.getReadableDatabase();
       // Cursor response = db.rawQuery("select * from " +TABLE_NAME,null);
       // return response;

         String  columns [] = {DatabaseHelper.COL_1,DatabaseHelper.COL_2,DatabaseHelper.COL_3,DatabaseHelper.COL_4,DatabaseHelper.COL_5};
      //  Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,columns,"select * " ,null,null,null,null);
        Cursor cursor = db.rawQuery("Select * from medication_table",null);

////                "Select "+DatabaseHelper.COL_2+,DatabaseHelper.COL_4,DatabaseHelper.COL_5+" from "+TABLE_NAME+"
////            while(cursor.moveToNext()){
////                String name = cursor.getColumnIndex(DatabaseHelper.COL_2);
////                //String finalName= toString( cursor.getInt(name));
////                int prescription1 = cursor.getColumnIndex(DatabaseHelper.COL_4);
////                int prescription1Row =cursor.getInt(prescription1);
////                int prescription2 = cursor.getColumnIndex(DatabaseHelper.COL_5);
////                int prescription2Row = cursor.getInt(prescription2);
////
////
////                MedicationModel medication = new MedicationModel(finalName,prescription1Row,prescription2Row);
////                medicationModels.add(medication);
//
//
//            }
        //return medicationModels;
        return cursor;
    }



    public boolean updateData(String id, String name,String tablets,String prescription1, String prescription2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,tablets);
        contentValues.put(COL_4,prescription1);
        contentValues.put(COL_1,prescription2);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }
    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " ID = ? ",new String[] { id });
    }

}
