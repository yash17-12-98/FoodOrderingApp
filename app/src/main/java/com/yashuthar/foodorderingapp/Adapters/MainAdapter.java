package com.yashuthar.foodorderingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.DetailActivity;
import com.yashuthar.foodorderingapp.Models.MainModel;
import com.yashuthar.foodorderingapp.Models.OrderModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_mainfood,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainModel model = list.get(position);
        holder.productImg.setImageResource(model.getImage());
        holder.productName.setText(model.getName());
        holder.productPrice.setText(model.getPrice());
        holder.productDescription.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("name", model.getName());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView productImg;
        TextView productName, productPrice, productDescription;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = (ImageView) itemView.findViewById(R.id.productImg);
            productName = (TextView) itemView.findViewById(R.id.productName);
            productPrice = (TextView) itemView.findViewById(R.id.productPrice);
            productDescription = (TextView) itemView.findViewById(R.id.productDescription);
        }
    }


}
