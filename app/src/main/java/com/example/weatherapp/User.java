package com.example.weatherapp;

public final class User {

    private String nom,email,motDePasse;


    public User(String email, String motDePasse){
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public User(String email, String motDePasse, String nom){
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
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
