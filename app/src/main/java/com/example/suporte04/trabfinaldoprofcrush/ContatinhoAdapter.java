package com.example.suporte04.trabfinaldoprofcrush;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContatinhoAdapter extends RecyclerView.Adapter<ContatinhoViewHolder> {


    private List<Contatinho> contatos;
    private Context c;

    public ContatinhoAdapter(List<Contatinho> contatos, Context c) {
        this.contatos = contatos;
        this.c = c;
    }


    @NonNull
    @Override
    public ContatinhoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View l = LayoutInflater.from(c).inflate(R.layout.lista, viewGroup, false);

        ContatinhoViewHolder vh = new ContatinhoViewHolder(l);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContatinhoViewHolder contatoViewHolder, int posicao) {

        final Contatinho contato = contatos.get(posicao);
        contatoViewHolder.nome.setText(contato.getNome());
        contatoViewHolder.telefone.setText(contato.getTelefone());
        contatoViewHolder.info.setText(contato.getInfo());

        contatoViewHolder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IContatinho pResponse = new Config().getContatoService();

                Call<Contatinho> response = pResponse.deletar(contato.getId());

                response.enqueue(new Callback<Contatinho>() {
                    @Override
                    public void onResponse(Call<Contatinho> call, Response<Contatinho> response) {
                        Contatinho pResponse = response.body();
                        remover(contato);
                    }

                    @Override
                    public void onFailure(Call<Contatinho> call, Throwable throwable) {
                        Log.w("log", "Não foi dessa vez..");
                    }

                });
            }


        });

        contatoViewHolder.botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity at = enviarActivity(v);
                Intent i = new Intent(at, Alterar.class);
                i.addFlags(i.FLAG_ACTIVITY_NO_ANIMATION);
                i.putExtra("contatinho", (Serializable) contato);
                at.startActivity(i);


            }
        });

    }

        @Override
        public int getItemCount() {
            return this.contatos.size();
        }

        public void remover(Contatinho c) {
            int posicao = contatos.indexOf(c);
            contatos.remove(posicao);
            notifyItemRemoved(posicao);
        }

    private Activity enviarActivity(View v){
        Context c = v.getContext();
        while (c instanceof ContextWrapper){
            if (c instanceof Activity){
                return (Activity) c;
            }
            c = ((ContextWrapper) c).getBaseContext();
        }
        return null;
    }
    }