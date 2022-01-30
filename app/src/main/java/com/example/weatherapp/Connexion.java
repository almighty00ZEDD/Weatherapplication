package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Connexion extends AppCompatActivity {

    private EditText ET_email,ET_mdp;
    private Button Btn_Login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //cacher la barre du nom de l'application à chaque actiivitée
        getSupportActionBar().hide();
        //assignation du layout relatif à cette activitée
        setContentView(R.layout.activity_connexion);

        //assignation des variables
        initialisation();

        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    /**
     * Transition vers la page d'inscription avec une animation de balayage
     *
     * @param view le view prédéfinis dans notre xml
     */
    public void transitionVersInscription(View view) {
        startActivity(new Intent(this,Inscription.class));
    }

    public void signIn(){
        User user = new User(ET_email.getText().toString(),ET_mdp.getText().toString());
        mAuth.signInWithEmailAndPassword(user.getEmail(),user.getMotDePasse()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Connexion.this, "Inscription enregistrée avec succès!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Connexion.this, MainActivity.class));
                }
                else{
                    Toast.makeText(Connexion.this, "Erreur : Inscription non réalisée", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void initialisation(){
        mAuth = FirebaseAuth.getInstance();
        ET_email = findViewById(R.id.Email);
        ET_mdp = findViewById(R.id.Password);
        Btn_Login = findViewById(R.id.loginButton);
    }
}