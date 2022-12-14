package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AskGender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_gender);

        //Action lorsqu'on click sur le bouton Homme
        Button homme = (Button) findViewById(R.id.homme);
        homme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskGender.this, AskBirthday.class);
                //On récupère les précédente valeur
                Bundle extras = getIntent().getExtras();
                intent.putExtra("Phone", extras.getString("Phone"));
                intent.putExtra("first_name", extras.getString("first_name"));
                intent.putExtra("last_name", extras.getString("last_name"));
                //On continue a ajouter des valeurs pour la page suivante
                intent.putExtra("Gender", "Homme");
                startActivity(intent);
            }
        });

        //Action lorsqu'on click sur le bouton Femme
        Button femme = (Button) findViewById(R.id.femme);
        femme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskGender.this, AskBirthday.class);
                //On récupère les précédente valeur
                Bundle extras = getIntent().getExtras();
                intent.putExtra("Phone", extras.getString("Phone"));
                intent.putExtra("first_name", extras.getString("first_name"));
                intent.putExtra("last_name", extras.getString("last_name"));
                //On continue a ajouter des valeurs pour la page suivante
                intent.putExtra("Gender", "Femme");
                startActivity(intent);
            }
        });

        //Action lorsqu'on click sur le bouton Autre
        Button autre = (Button) findViewById(R.id.autre);
        autre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskGender.this, AskBirthday.class);
                //On récupère les précédente valeur
                Bundle extras = getIntent().getExtras();
                intent.putExtra("Phone", extras.getString("Phone"));
                intent.putExtra("first_name", extras.getString("first_name"));
                intent.putExtra("last_name", extras.getString("last_name"));
                //On continue a ajouter des valeurs pour la page suivante
                intent.putExtra("Gender", "Autre");
                startActivity(intent);
            }
        });
    }
}