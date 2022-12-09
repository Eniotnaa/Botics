package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Entity.Post;
import Interface.GetPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Social extends AppCompatActivity {
    private TextView textViewResult;

    private ListView listView;
    private CustomAdapterPost retroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        listView = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://botics.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetPost service = retrofit.create(GetPost.class);

        Call<List<Post>> call = service.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> jsonresponse = response.body();
                writeListView(jsonresponse);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

        //Listener pour le bouton pour publier un post
        FloatingActionButton createPost = (FloatingActionButton) findViewById(R.id.createPost);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Social.this, CreatePost.class);
                startActivity(intent);
            }
        });
    }

    private void writeListView(List<Post> response){
        ArrayList<Post> ListPost = new ArrayList<>();

        for(Post data : response){
            Post post = new Post();

            post.setFirst_name(data.getFirst_name());
            post.setLast_name(data.getLast_name());
            post.setPseudo("@"+data.getPseudo());
            post.setDescription(data.getDescription());
            post.setCount_like(data.getCount_like());
            post.setCount_comment(data.getCount_comment());

            ListPost.add(post);

        }

        retroAdapter = new CustomAdapterPost(this, ListPost);
        listView.setAdapter(retroAdapter);
    }
}