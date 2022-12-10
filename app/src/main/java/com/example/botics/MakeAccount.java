package com.example.botics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Entity.User;
import Interface.Connexion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MakeAccount extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_account);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        Button with_phone = (Button) findViewById(R.id.with_phone);
        with_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeAccount.this, AskPhone.class);
                startActivity(intent);
            }
        });

        Button with_google = (Button) findViewById(R.id.with_google);
        with_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        Button connexion = (Button) findViewById(R.id.buttonConnexion);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creation de l'objet
                User user = new User();
                EditText inputPseudo = (EditText) findViewById(R.id.inputPseudo);
                EditText inputMdp = (EditText) findViewById(R.id.inputMdp);
                user.setPseudo(inputPseudo.getText().toString());
                user.setPassword(inputMdp.getText().toString());
                //Creation de la requete POST
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://botics.fr/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Connexion service = retrofit.create(Connexion.class);
                Call<User> call = service.sendUser(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Integer ID_user = response.body().getID_user();
                        if(ID_user == -1){
                            Toast.makeText(getApplicationContext(), String.format("Le pseudo ou mot de passe est incorrect"), Toast.LENGTH_SHORT).show();
                        }else{
                            //Message de réussite
                            Toast.makeText(getApplicationContext(), String.format("Connexion réussi !"), Toast.LENGTH_SHORT).show();
                            //Sauvegrade de l'id user dans SharedPreference
                            SharedPreferences dataSave = getSharedPreferences("ID_user", 0);
                            SharedPreferences.Editor editor = dataSave.edit();
                            editor.putString("ID_user", String.valueOf(ID_user));
                            editor.commit();
                            //Redirection vers la page Social
                            Intent intent = new Intent(MakeAccount.this, Social.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getApplicationContext(), String.format(String.valueOf(t)), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    void signIn() {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            navigateToSecondActivity();
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong !!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(MakeAccount.this,AskPhone.class);
        startActivity(intent);
    }

}