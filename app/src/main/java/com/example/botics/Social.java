package com.example.botics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://botics.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetPost service = retrofit.create(GetPost.class);

        Call<List<Post>> call = service.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()) {
                    textViewResult.setText("Code : " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String content = "";
                    content += "ID : "+ post.getID_publication() + "\n";
                    content += "Description : "+ post.getDescription() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}