package com.example.suporte04.contatinhos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contatinho implements Serializable{

    public Contatinho(int id, String nome, String telefone, String info) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.info = info;
    }

    public Contatinho(String nome, String telefone, String info) {
        this.nome = nome;
        this.telefone = telefone;
        this.info = info;
    }

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("telefone")
    @Expose
    private String telefone;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("createAdt")
    @Expose
    private String createAdt;
    @SerializedName("updateAdt")
    @Expose
    private String updateAdt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
