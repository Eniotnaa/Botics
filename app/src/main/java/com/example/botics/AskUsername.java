package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AskUsername extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_username);

        // ---------- Listener sur le bouton continuer ----------
        Button continuer = (Button) findViewById(R.id.continuer);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskUsername.this, Social.class);
                startActivity(intent);
            }
        });
    }
}