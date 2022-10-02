package com.example.recyclerviewdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.Model.ResponseModel;
import com.example.recyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>
{
    ArrayList<ResponseModel.Data> data;

    public RecyclerViewAdapter(ArrayList<ResponseModel.Data> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position)
    {
       holder.firstName.setText(data.get(position).getFirst_name());
       holder.lastName.setText(data.get(position).getLast_name());
        Picasso.get()
                .load(data.get(position).getAvatar())
                .fit()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
      TextView firstName,lastName;
      ImageView img;
      public myViewHolder(@NonNull View itemView)
      {
          super(itemView);
          firstName = itemView.findViewById(R.id.first_name);
          lastName = itemView.findViewById(R.id.last_name);
          img = itemView.findViewById(R.id.img);
      }
  }
}
