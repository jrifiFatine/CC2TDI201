package com.example.cc2tdi201;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditerSociete extends AppCompatActivity {
    Spinner sp;
    EditText e1, e2, e3;
    MyDatabase db;
    ArrayList<Societe> prds;
    ArrayAdapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editer_societe);
        db = new MyDatabase(this);
        sp= findViewById(R.id.sp);
        e1 = findViewById(R.id.t1);
        e2 = findViewById(R.id.t2);
        e3 = findViewById(R.id.t3);

        prds = MyDatabase.getAllSociete(db.getReadableDatabase());

        ArrayList<String> idSoc = new ArrayList<>();
        for(Societe pp: prds)
            idSoc.add(pp.getId()+"-");
        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,idSoc);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe e = prds.get(i);
                e1.setText(e.getNom());
                e2.setText(e.getSecteur_Activite());
                e3.setText(Integer.valueOf(e.getNombre_employe()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Modifier(View view) {
        AlertDialog.Builder alert=new AlertDialog.Builder(EditerSociete.this);
        alert.setTitle("Modifier societe");
        alert.setMessage("voulez vous vraiment moidifier cette societe");

        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe p=prds.get(sp.getSelectedItemPosition());
                e1.setText("nom:"+p.getNom());
                e2.setText("Secteur d'activite:"+p.getSecteur_Activite());
                e3.setText("nombre d'employe:"+p.getNombre_employe());


                if(MyDatabase.UpdateSociete(db.getWritableDatabase(),p)==-1)
                    Toast.makeText(EditerSociete.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditerSociete.this, "Modification reussie", Toast.LENGTH_SHORT).show();

            }
        });
        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerSociete.this, "operation annuler", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();

    }



    public void Supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditerSociete.this);
        alert.setTitle("Suppression d'une societe");
        alert.setMessage("Voulez-vous supprimer cette societe ?");

        alert.setPositiveButton("Supprimer?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe p = prds.get(sp.getSelectedItemPosition());

                if(MyDatabase.deleteSociete(db.getWritableDatabase(),p.getId())==-1)
                    Toast.makeText(EditerSociete.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(EditerSociete.this, "Suppression est reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(p.getId() + " - " + p.getNom());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerSociete.this, "Operation est annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
