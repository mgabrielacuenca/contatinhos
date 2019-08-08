package com.example.suporte04.trabfinaldoprofcrush;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ContatinhoViewHolder extends RecyclerView.ViewHolder {

    TextView nome;
    TextView telefone;
    TextView info;
    Button botao;
    Button botao2;

    public ContatinhoViewHolder(View itemView) {
        super(itemView);

        nome = itemView.findViewById(R.id.txtNome);
        telefone = itemView.findViewById(R.id.txtTel);
        info = itemView.findViewById(R.id.txtInfo);
        botao = itemView.findViewById(R.id.btnDelete);
        botao2 = itemView.findViewById(R.id.btnAlterar);

    }
}