package com.example.recyclerviewdemo.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
  private String baseUrl= "https://reqres.in/api/";
  private Retrofit retrofit;
  public Retrofit getRetrofit()
  {
    if (retrofit==null)
    {
       retrofit = new Retrofit.Builder()
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }

    return retrofit;
  }
}
