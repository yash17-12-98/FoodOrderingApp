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
import com.yashuthar.foodorderingapp.Models.BreakfastModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.BreakfastViewHolder> {

    Context context;
    ArrayList<BreakfastModel> list;

    public BreakfastAdapter(Context context, ArrayList<BreakfastModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BreakfastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_breakfastfood, parent, false);
        return new BreakfastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastViewHolder holder, int position) {
        BreakfastModel model = list.get(position);
        holder.bfImg.setImageResource(model.getBfImage());
        holder.bfName.setText(model.getBfName());
        holder.bfPrice.setText(model.getBfPrice());
        holder.bfDescription.setText(model.getBfDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getBfImage());
                intent.putExtra("name", model.getBfName());
                intent.putExtra("price", model.getBfPrice());
                intent.putExtra("description", model.getBfDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BreakfastViewHolder extends RecyclerView.ViewHolder{
        ImageView bfImg;
        TextView bfName, bfPrice, bfDescription;

        public BreakfastViewHolder(@NonNull View itemView) {
            super(itemView);
            bfImg = (ImageView) itemView.findViewById(R.id.bfImg);
            bfName = (TextView) itemView.findViewById(R.id.bfName);
            bfPrice = (TextView) itemView.findViewById(R.id.bfPrice);
            bfDescription = (TextView) itemView.findViewById(R.id.bfDescription);
        }
    }
}
