package com.example.weatherapp;

import java.util.HashMap;

public final class User {

    private String nom,email,motDePasse,prenom;
    private HashMap<String,Integer> preferences;

    public User(){

    }

    public User(String email, String motDePasse){
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public User(String email, String motDePasse, String nom, String prenom){
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        preferences = new HashMap<String,Integer>();
    }

    public HashMap<String, Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(HashMap<String, Integer> preferences) {
        this.preferences = preferences;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }



}
