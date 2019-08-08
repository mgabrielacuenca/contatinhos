package com.example.suporte04.trabfinaldoprofcrush;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Alterar extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText info;
    Button botao;

    Contatinho alterar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        Intent intent = getIntent();
        if (intent.hasExtra("contatinho")) {
            alterar = (Contatinho) intent.getSerializableExtra("contatinho");

            nome = findViewById(R.id.edNome);
            telefone = findViewById(R.id.edTel);
            info = findViewById(R.id.edInfo);


            nome.setText(alterar.getNome());
            telefone.setText(alterar.getTelefone());
            info.setText(alterar.getInfo());

        }


        Button botao = findViewById(R.id.btnAlterar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IContatinho pResponse = new Config().getContatoService();

                Contatinho c = new Contatinho(alterar.getId(), nome.getText().toString(), telefone.getText().toString(), info.getText().toString());

                Call<Contatinho> response = pResponse.atualizar(c);

                response.enqueue(new Callback<Contatinho>() {
                    @Override
                    public void onResponse(retrofit2.Call<Contatinho> call, Response<Contatinho> response) {
                        Contatinho pResponse = response.body();
                        Log.d("log","OK");
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Contatinho> call, Throwable t) {
                    Log.w("log", "Não foi dessa vez..");
                    }
                });


                finish();

            }
        });
    }

    }

