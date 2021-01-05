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
import com.yashuthar.foodorderingapp.Models.BakeryModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BakeryAdapter extends RecyclerView.Adapter<BakeryAdapter.BakeryViewHolder> {

    Context context;
    ArrayList<BakeryModel> list;

    public BakeryAdapter(Context context, ArrayList<BakeryModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public BakeryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_bakeryfood, parent, false);
        return new BakeryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BakeryViewHolder holder, int position) {
        BakeryModel model = list.get(position);
        holder.bakImg.setImageResource(model.getBakImage());
        holder.bakName.setText(model.getBakName());
        holder.bakPrice.setText(model.getBakPrice());
        holder.bakDescription.setText(model.getBakDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getBakImage());
                intent.putExtra("name", model.getBakName());
                intent.putExtra("price", model.getBakPrice());
                intent.putExtra("description", model.getBakDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BakeryViewHolder extends RecyclerView.ViewHolder{
        ImageView bakImg;
        TextView bakName, bakPrice, bakDescription;

        public BakeryViewHolder(@NonNull View itemView) {
            super(itemView);
            bakImg = itemView.findViewById(R.id.bakImg);
            bakName = itemView.findViewById(R.id.bakName);
            bakPrice = itemView.findViewById(R.id.bakPrice);
            bakDescription = itemView.findViewById(R.id.bakDescription);
        }
    }
}
