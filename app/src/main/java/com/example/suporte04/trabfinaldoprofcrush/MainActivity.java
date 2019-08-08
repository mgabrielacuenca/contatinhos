package com.example.suporte04.trabfinaldoprofcrush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.ContatoList);

        RecyclerView.LayoutManager layout  = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rv.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(layout);
    }

    @Override
    protected void onStart() {
        super.onStart();


        final IContatinho getService = new Config().getContatoService();

        Call<List<Contatinho>> response = getService.buscar();


        response.enqueue(new Callback<List<Contatinho>>() {
            @Override
            public void onResponse(Call<List<Contatinho>> call, Response<List<Contatinho>> response) {
                ArrayList<Contatinho> pResponse = (ArrayList<Contatinho>) response.body();
                Log.d("log","OK");

                ContatinhoAdapter ca = new ContatinhoAdapter(pResponse, MainActivity.this);
                rv.setAdapter(ca);

            }

            @Override
            public void onFailure(Call<List<Contatinho>> call, Throwable throwable) {
                Log.w("log", "Não foi dessa vez..");

            }
        });
        }

        public void chamarTelaCadastro(View view){

            Intent intent = new Intent(MainActivity.this, telaCadastro.class);
            startActivity(intent);
        }
    }

