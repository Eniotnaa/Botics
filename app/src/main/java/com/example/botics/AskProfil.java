package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AskProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_profil);

        Button continuer = (Button) findViewById(R.id.continuer);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskProfil.this, AskGender.class);
                //On récupère les précédente valeur
                Bundle extras = getIntent().getExtras();
                String Phone = extras.getString("Phone");
                //On continue a ajouter des valeurs pour la page suivante
                intent.putExtra("Phone", Phone);
                EditText inputPrenom = (EditText) findViewById(R.id.inputPrenom);
                intent.putExtra("first_name", inputPrenom.getText().toString());
                EditText inputNom = (EditText) findViewById(R.id.inputNom);
                intent.putExtra("last_name", inputNom.getText().toString());
                startActivity(intent);
            }
        });
    }
}