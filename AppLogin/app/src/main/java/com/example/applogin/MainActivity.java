package com.example.applogin;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applogin.api.ResponseInsert;
import com.example.applogin.model.AddListMovie;
import com.example.applogin.model.RetrofitServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    String name, pass;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = username.getText().toString();
                pass = password.getText().toString();

                saveToList();
            }
        } );
    }

    private void saveToList(){
        AddListMovie api = new RetrofitServer().getClient().create(AddListMovie.class);

        Call<ResponseInsert> sendIdMovie = api.addIdMovie(name, pass);
//        Toast.makeText(MainActivity.this, pass, Toast.LENGTH_LONG).show();

        sendIdMovie.enqueue(new Callback<ResponseInsert>() {
            @Override
            public void onResponse(Call<ResponseInsert> call, Response<ResponseInsert> response) {
                Log.d("Retro", "response: berhasil" + response.body().toString());
                String code = response.body().getKode();
                String message = response.body().getPesan();
                Toast.makeText( MainActivity.this, "Berhasil", Toast.LENGTH_LONG ).show();

                if (code.equals("1") ){
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseInsert> call, Throwable t) {
                Log.d("Retro", "Failed Save hahahahah");
                Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
