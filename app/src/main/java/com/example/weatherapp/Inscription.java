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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Inscription extends AppCompatActivity {

    private EditText ET_email,ET_mdp,ET_nom,ET_prenom;
    private Button Btn_inscription;
    private FirebaseAuth mAuth;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inscription);

        //assignation des variables
        initialisation();

        Btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
    }


    //enregistrement de l'utilisateur , partie authentification
    private void addNewUser(){
        User user = new User(ET_email.getText().toString(),ET_mdp.getText().toString(),ET_nom.getText().toString(),ET_prenom.getText().toString());
        mAuth.createUserWithEmailAndPassword(user.getEmail(),user.getMotDePasse()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    registerUserInfo(mAuth.getCurrentUser().getUid().toString(), user);
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

    //enregistrement des informations de l'utilisateur dans la base de données
    private void registerUserInfo(String UID, User usr){
        myRef.child(UID).setValue(usr);
    }
    //transition vers la page d'inscription
    public void transitionVersConnexion(View view) {
        startActivity(new Intent(this,Connexion.class));
    }

    private void initialisation(){
        mAuth = FirebaseAuth.getInstance();
        ET_email = findViewById(R.id.Email);
        ET_mdp = findViewById(R.id.Password);
        ET_nom = findViewById(R.id.nom);
        ET_prenom = findViewById(R.id.prenom);
        Btn_inscription = findViewById(R.id.registerButton);
    }
}