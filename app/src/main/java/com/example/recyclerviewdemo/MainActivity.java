package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewdemo.Adapter.RecyclerViewAdapter;
import com.example.recyclerviewdemo.Api.ApiServices;
import com.example.recyclerviewdemo.Api.RetrofitClient;
import com.example.recyclerviewdemo.Model.ResponseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recView = findViewById(R.id.recView);
         recView.setLayoutManager(new LinearLayoutManager(this));
        processData();
    }

    public void processData()
    {
        ApiServices api = new RetrofitClient().getRetrofit().create(ApiServices.class);
        Call<ResponseModel> call =api.getData();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful())
                {   ResponseModel responseModel = response.body();
                    ArrayList<ResponseModel.Data> responseData = responseModel.data;
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(responseData);
                    recView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}