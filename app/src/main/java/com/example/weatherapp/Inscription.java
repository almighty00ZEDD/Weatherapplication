package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Inscription extends AppCompatActivity {

    private EditText ET_email,ET_mdp,ET_nom;
    private Button Btn_inscription;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inscription);

        //assignation des variables
        mAuth = FirebaseAuth.getInstance();
        ET_email = findViewById(R.id.Email);
        ET_mdp = findViewById(R.id.Password);
        ET_nom = findViewById(R.id.nom);
        Btn_inscription = findViewById(R.id.registerButton);

        Btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
    }


    //ne pas oublier de rajouter firestore et préparer les préférences utilisateur
    //sur tout continuer la décomposition en fonctions pour la lisibilité du code
    private void addNewUser(){
        User user = new User(ET_email.getText().toString(),ET_mdp.getText().toString(),ET_nom.getText().toString());
        mAuth.createUserWithEmailAndPassword(user.getEmail(),user.getMotDePasse()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Inscription.this, "Inscription enregistrée avec succès!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Inscription.this, Connexion.class));
                }
                else{
                    Toast.makeText(Inscription.this, "Erreur : Inscription non réalisée", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    //vérifier la saisie de l'utilisateur
    public boolean verifyUserInput(){
        boolean result = true;
        if(ET_nom.getText().toString().isEmpty()){
            result = false;
        }
        if(ET_email.getText().toString().isEmpty()){
            result = false;
        }
        if(ET_mdp.getText().toString().isEmpty()){
            result = false;
        }

        return result;
    }

    //transition vers la page d'inscription
    public void transitionVersConnexion(View view) {
        startActivity(new Intent(this,Connexion.class));
    }


}