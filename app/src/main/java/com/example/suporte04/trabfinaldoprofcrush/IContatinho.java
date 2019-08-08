package com.example.suporte04.trabfinaldoprofcrush;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IContatinho {

    @GET("contatinhos/")
    Call<List<Contatinho>> buscar();

    @GET("contatinhos/{id}")
    Call<List<Contatinho>> buscarId(@Path("id") int id);

    @POST("contatinhos/")
    Call<Contatinho> inserir(@Body Contatinho c);

    @PUT("contatinhos/")
    Call<Contatinho> atualizar(@Body Contatinho c);

    @DELETE("contatinhos/{id}")
    Call<Contatinho> deletar(@Path("id") int id);
}
