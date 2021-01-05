package com.yashuthar.foodorderingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.DetailActivity;
import com.yashuthar.foodorderingapp.Models.BevModel;
import com.yashuthar.foodorderingapp.Models.OrderModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BevAdapter extends RecyclerView.Adapter<BevAdapter.BevViewHolder> {

    ArrayList<BevModel> list;
    Context context;

    public BevAdapter(ArrayList<BevModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BevViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_beveragesfood, parent, false);
        return new BevViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BevViewHolder holder, int position) {
        BevModel model = list.get(position);
        holder.bevImg.setImageResource(model.getBevImage());
        holder.bevName.setText(model.getBevName());
        holder.bevPrice.setText(model.getBevPrice());
        holder.bevDescription.setText(model.getBevDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getBevImage());
                intent.putExtra("name", model.getBevName());
                intent.putExtra("price", model.getBevPrice());
                intent.putExtra("description", model.getBevDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BevViewHolder extends RecyclerView.ViewHolder{
        ImageView bevImg;
        TextView bevName, bevPrice, bevDescription;

        public BevViewHolder(@NonNull View itemView) {
            super(itemView);
            bevImg = (ImageView) itemView.findViewById(R.id.bevImg);
            bevName = (TextView) itemView.findViewById(R.id.bevName);
            bevPrice = (TextView) itemView.findViewById(R.id.bevPrice);
            bevDescription = (TextView) itemView.findViewById(R.id.bevDescription);
        }
    }
}
