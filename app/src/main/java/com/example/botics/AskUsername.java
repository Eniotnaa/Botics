package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Entity.Post;
import Entity.User;
import Interface.CreateUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                //Creation de l'objet
                User user = new User();
                EditText inputPseudo = (EditText) findViewById(R.id.inputPseudo);
                EditText inputMail = (EditText) findViewById(R.id.inputMail);
                EditText inputMdp = (EditText) findViewById(R.id.inputMdp);
                user.setPseudo(inputPseudo.getText().toString());
                user.setEmail(inputMail.getText().toString());
                user.setPassword(inputMdp.getText().toString());
                //Creation de la requete POST
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://botics.fr/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                CreateUser service = retrofit.create(CreateUser.class);
                Call<User> call = service.sendUser(user);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Toast.makeText(getApplicationContext(), String.format(String.valueOf(response.body())), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getApplicationContext(), String.format(String.valueOf(t)), Toast.LENGTH_SHORT).show();
                    }
                });
                //Redirection vers la page MakeAccout
                /*Intent intent = new Intent(AskUsername.this, MakeAccount.class);
                startActivity(intent);*/
            }
        });
    }
}