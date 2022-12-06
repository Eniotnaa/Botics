package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AskBirthday extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_birthday);

        // ---------- Configuration du Spinner du jour ----------
        //boucle for pour remplir le Spinner des année
        Integer[] arrayDay = new Integer[31];
        int index=0;
        for (int i=1; i<32 ; i++){
            arrayDay[index] = i;
            index++;
        }
        //Remplissage du Spinner
        Spinner day = (Spinner) findViewById(R.id.spinner_day);
        ArrayAdapter<Integer> adapter_day = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arrayDay);
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter_day);
        day.setOnItemSelectedListener(this);

        // ---------- Configuration du Spinner du mois ----------
        String[] arrayMounth = new String[] {
                "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet",
                "Août", "Septembre", "Octobre", "Novembre", "Décembre"
        };
        Spinner mounth = (Spinner) findViewById(R.id.spinner_mounth);
        ArrayAdapter<String> adapter_mounth = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayMounth);
        adapter_mounth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mounth.setAdapter(adapter_mounth);
        mounth.setOnItemSelectedListener(this);

        // ---------- Configuration du Spinner des années ----------
        //MaxRangeAnnee configure le nombre d'année entre le plus jeune et le plus vieux
        int maxRangeAnnee = 50;
        //maxYear configure la date la plus récente
        int maxYear = 2010;
        //boucle for pour remplir le Spinner des année
        Integer[] arrayYear = new Integer[maxRangeAnnee];
        index=0;
        for (int i=maxYear; i>maxYear-maxRangeAnnee ; i--){
            arrayYear[index] = i;
            index++;
        }
        //Remplissage du Spinner
        Spinner year = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter<Integer> adapter_year = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arrayYear);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(adapter_year);
        year.setOnItemSelectedListener(this);

        // ---------- Listener sur le bouton continuer ----------
        Button continuer = (Button) findViewById(R.id.continuer);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskBirthday.this, AskSize.class);
                startActivity(intent);
            }
        });
    }

    // ---------- Fonctions pour les Spinner ----------
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT ).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}