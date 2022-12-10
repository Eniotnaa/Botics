package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AskSize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_size);

        // ---------- Listener sur le bouton continuer ----------
        Button continuer = (Button) findViewById(R.id.continuer);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
                if (editTextNumber.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), String.format("Le champs est obligatoire"), Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(AskSize.this, AskWeight.class);
                    //On récupère les précédente valeur
                    Bundle extras = getIntent().getExtras();
                    intent.putExtra("Phone", extras.getString("Phone"));
                    intent.putExtra("first_name", extras.getString("first_name"));
                    intent.putExtra("last_name", extras.getString("last_name"));
                    intent.putExtra("Gender", extras.getString("Gender"));
                    intent.putExtra("birthday", extras.getString("birthday"));
                    //On continue a ajouter des valeurs pour la page suivante
                    intent.putExtra("Size", editTextNumber.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}