package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AskProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_profil);

        Button continuer = (Button) findViewById(R.id.continuer);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputPrenom = (EditText) findViewById(R.id.inputPrenom);
                EditText inputNom = (EditText) findViewById(R.id.inputNom);
                if (inputPrenom.getText().toString().equals("") || inputNom.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), String.format("Les champs sont obligatoire"), Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(AskProfil.this, AskGender.class);
                    //On récupère les précédente valeur
                    Bundle extras = getIntent().getExtras();
                    String Phone = extras.getString("Phone");
                    //On continue a ajouter des valeurs pour la page suivante
                    intent.putExtra("Phone", Phone);
                    intent.putExtra("first_name", inputPrenom.getText().toString());
                    intent.putExtra("last_name", inputNom.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}