package com.example.cc2tdi201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
