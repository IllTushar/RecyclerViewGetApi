package com.example.recyclerviewdemo.Api;

import com.example.recyclerviewdemo.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices
{
  @GET("users?page=2")
    Call<ResponseModel>getData();
}
