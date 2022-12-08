package com.example.loginpage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList productName, productPrice;

    CustomAdapter(Context context, ArrayList productName, ArrayList productPrice){
        this.context = context;
        this.productPrice = productPrice;
        this.productName = productName;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemName_txt.setText(String.valueOf(productName.get(position)));
        holder.itemPrice_txt.setText(String.valueOf(productPrice.get(position)));

    }

    @Override
    public int getItemCount() {
        return productName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName_txt, itemPrice_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName_txt = itemView.findViewById(R.id.itemName);
            itemPrice_txt = itemView.findViewById(R.id.itemPrice);
        }
    }
}
