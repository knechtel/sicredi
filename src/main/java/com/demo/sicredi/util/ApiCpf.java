package com.demo.sicredi.util;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public  interface ApiCpf {

    @POST("https://www.treinaweb.com.br/ferramentas-para-desenvolvedores/validar/cpf?")
    public Call<ResponseBody> validaCPF( @Query("numero") String cpf);


}
