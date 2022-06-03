package com.example.cc2tdi201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static String DB_NAME="Societe.db";
    public static String TABLE_NAME="Societe";
    public static String COL1="ID";
    public static String COL2="NOM";
    public static String COL3="Secteur_Activite";
    public static String COL4="Nombre_employe";

    public MyDatabase( Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
    public static long ADDSociete(SQLiteDatabase sqLiteDatabase,Societe e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getNom());
        cv.put(COL3,e.getSecteur_Activite());
        cv.put(COL4,e.getNombre_employe());

        return sqLiteDatabase.insert(TABLE_NAME,null,cv);
    }
    public static long UpdateSociete(SQLiteDatabase sqLiteDatabase, Societe e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getNom());
        cv.put(COL3,e.getSecteur_Activite());
        cv.put(COL4,e.getNombre_employe());
        return sqLiteDatabase.update(TABLE_NAME,cv,"id="+e.getId(),null);
    }
    public static long deleteSociete(SQLiteDatabase sqLiteDatabase, int id){
        return sqLiteDatabase.delete(TABLE_NAME,"id="+id,null);
    }
    public static ArrayList<Societe> getAllSociete(SQLiteDatabase sqLiteDatabase){
        ArrayList<Societe> soc = new ArrayList<>();

        Cursor cr = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cr.moveToNext()){
            Societe e = new Societe();
            e.setId(cr.getInt(0));
            e.setNom(cr.getString(1));
            e.setSecteur_Activite(cr.getString(2));
            e.setNombre_employe(cr.getInt(3));

            soc.add(e);
        }

        return soc;
    }
    public static Societe getOneSociete(SQLiteDatabase sqLiteDatabase, int id){
        Societe e = null;

        Cursor cr = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id,null);

        if(cr.moveToNext()){
            e = new Societe();
            e.setId(cr.getInt(0));
            e.setNom(cr.getString(1));
            e.setSecteur_Activite(cr.getString(2));
            e.setNombre_employe(cr.getInt(3));

        }

        return e;
    }

}
