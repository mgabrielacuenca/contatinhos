package com.example.suporte04.trabfinaldoprofcrush;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class telaCadastro extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText info;
    Button botao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nome = findViewById(R.id.edNome);
        telefone = findViewById(R.id.edTel);
        info = findViewById(R.id.edInfo);
        botao = findViewById(R.id.btnSalvar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Contatinho c = new Contatinho( nome.getText().toString(), telefone.getText().toString(), info.getText().toString());

                IContatinho pResponse = new Config().getContatoService();

                Call<Contatinho> response = pResponse.inserir(c);

                response.enqueue(new Callback<Contatinho>() {
                    @Override
                    public void onResponse(retrofit2.Call<Contatinho> call, Response<Contatinho> response) {
                        Contatinho pResponse = response.body();
                        finish();
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

