package com.example.weatherapp;

import java.util.HashMap;
import java.util.Optional;

public final class User {

    private Optional<String> nom = Optional.ofNullable(null);
    private Optional<String> prenom = Optional.ofNullable(null);
    private Optional<String> email = Optional.ofNullable(null);
    private Optional<String> motDePasse = Optional.ofNullable(null);
    private HashMap<String,Integer> preferences;

    public User(){

    }

    public User(String email, String motDePasse){
        this.email = Optional.ofNullable(email);
        this.motDePasse = Optional.ofNullable(motDePasse);
    }

    public User(String email, String motDePasse, String nom, String prenom){
        this.email = Optional.ofNullable(email);
        this.motDePasse = Optional.ofNullable(motDePasse);
        this.nom = Optional.ofNullable(nom);
        this.prenom = Optional.ofNullable(prenom);
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
        this.nom = Optional.ofNullable(nom);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = Optional.ofNullable(motDePasse);
    }



}
