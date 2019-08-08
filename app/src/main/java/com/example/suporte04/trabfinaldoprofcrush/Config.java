package com.example.suporte04.trabfinaldoprofcrush;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {

    public static final String BASE_URL = "https://contatinho.herokuapp.com/";
    private final Retrofit retrofit;

    public Config() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public IContatinho getContatoService(){
        return this.retrofit.create(IContatinho.class);
    }

}