package com.example.cc2tdi201;

import java.io.Serializable;

public class Societe implements Serializable {

    private int id;
    private String nom;
    private String Secteur_Activite;
    private int Nombre_employe;

    public Societe() {
    }

    public Societe(int id, String nom, String secteur_Activite, int nombre_employe) {
        this.id = id;
        this.nom = nom;
        Secteur_Activite = secteur_Activite;
        Nombre_employe = nombre_employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteur_Activite() {
        return Secteur_Activite;
    }

    public void setSecteur_Activite(String secteur_Activite) {
        Secteur_Activite = secteur_Activite;
    }

    public int getNombre_employe() {
        return Nombre_employe;
    }

    public void setNombre_employe(int nombre_employe) {
        Nombre_employe = nombre_employe;
    }
}
