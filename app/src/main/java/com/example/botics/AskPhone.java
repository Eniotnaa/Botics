package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AskPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_phone);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
                if (editTextPhone.getText().toString().equals("")){//Si le champ est vide
                    Toast.makeText(getApplicationContext(), String.format("Le champs est obligatoire"), Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(AskPhone.this, AskProfil.class);
                    intent.putExtra("Phone", editTextPhone.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}