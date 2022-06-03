package com.example.cc2tdi201;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterSociete extends AppCompatActivity {
    EditText E1, E2, E3;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_societe);
        db = new MyDatabase(this);

        E1 = findViewById(R.id.E1);
        E2 = findViewById(R.id.E2);
        E3 = findViewById(R.id.E3);
    }

    public void enregistrer(View view) {
        Societe e = new Societe();

        e.setNom(E1.getText().toString());
        e.setSecteur_Activite(E2.getText().toString());
        e.setNombre_employe(Integer.parseInt(E3.getText().toString()));

        if(MyDatabase.ADDSociete(db.getWritableDatabase(),e)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion est  reussie", Toast.LENGTH_SHORT).show();
    }

    public void Annuler(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
