package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Partie qui regarde si c'est la première fois que l'utilisateur ouvre l'application
        SharedPreferences dataSave = getSharedPreferences("firstLog", 0);
        if(dataSave.getString("firstTime", "").toString().equals("no")){ // Il l'a déjà ouverte
            Intent intent = new Intent(MainActivity.this, MakeAccount.class);
            startActivity(intent);
        }
        else{ // c'est le premier lancement
            SharedPreferences.Editor editor = dataSave.edit();
            editor.putString("firstTime", "no");
            editor.commit();

            setContentView(R.layout.activity_main);

            Button decouvrir = (Button) findViewById(R.id.decouvrir);
            decouvrir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Presentation1.class);
                    startActivity(intent);
                }
            });
        }

    }
}