package com.example.cc2tdi201;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeTousSociete extends AppCompatActivity {

    ListView lst;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_societe);
        lst=findViewById(R.id.lst);
        db=new MyDatabase(this);
        ArrayList<Societe> e =MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> o = new ArrayList<>();
        for(Societe soc : e){
            HashMap<String,Object> b =new HashMap<>();
            b.put("Nom",soc.getNom());
            b.put("nombre employe",soc.getNombre_employe());
            o.add(b);
        }
        String[] from = {"Nom","nombre employe"};
        int [] to ={R.id.t1,R.id.t3};
        SimpleAdapter s = new SimpleAdapter(this,o,R.layout.liste_societe,from,to);
        lst.setAdapter(s);
    }
}
