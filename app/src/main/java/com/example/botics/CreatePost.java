package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Entity.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreatePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        //Listener du bouton annuler
        Button annuler = (Button) findViewById(R.id.annuler);
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreatePost.this, Social.class);
                startActivity(intent);
            }
        });

        //Listener du bouton publier
        Button publier = (Button) findViewById(R.id.publier);
        publier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creation de l'objet
                Post post = new Post();
                EditText publier = (EditText) findViewById(R.id.InputDescription);
                post.setDescription(publier.getText().toString());
                int ID_user = 1;//A MODIFIER QUAND LE USER POURRA SE CONNECTER
                post.setID_user(ID_user);
                //Creation de la requete POST
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://botics.fr/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Interface.CreatePost service = retrofit.create(Interface.CreatePost.class);
                Call<Post> call = service.sendPost(post);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        //Toast.makeText(getApplicationContext(), String.format("KO"), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        //Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                    }
                });
                //A la fin, redirection sur la page Social
                Intent intent = new Intent(CreatePost.this, Social.class);
                startActivity(intent);
            }
        });
    }
}