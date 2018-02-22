package com.example.heu1.sosmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final Button boutonUrgence = findViewById(R.id.bouton_urgence);
        boutonUrgence.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                appelUrgenceActivity(v);
            }
        });

        final Button boutonConnexion = findViewById(R.id.bouton_connexion);
        boutonConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                connexion(v);
            }
        });

        final Button boutonInscription = findViewById(R.id.bouton_inscription);
        boutonInscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inscription(v);
            }
        });

    }

    private void inscription(View v) {

    }

    public void appelUrgenceActivity(View view) {
        //Intent PageUrgence = new Intent(Accueil.this, PageUrgence.class);
        //startActivity(PageUrgence);
    }

    public void connexion(View view){

    }

}
