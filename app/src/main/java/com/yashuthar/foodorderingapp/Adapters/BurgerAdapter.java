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
import com.yashuthar.foodorderingapp.Models.BurgerModel;
import com.yashuthar.foodorderingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder> {

    Context context;
    ArrayList<BurgerModel> list;

    public BurgerAdapter(Context context, ArrayList<BurgerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_burgerfood, parent, false);

        return new BurgerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgerViewHolder holder, int position) {
        BurgerModel model = list.get(position);
        holder.burgerImg.setImageResource(model.getBurgerImage());
        holder.burgerName.setText(model.getBurgerName());
        holder.burgerPrice.setText(model.getBurgerPrice());
        holder.burgerDescription.setText(model.getBurgerDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getBurgerImage());
                intent.putExtra("name", model.getBurgerName());
                intent.putExtra("price", model.getBurgerPrice());
                intent.putExtra("description", model.getBurgerDescription());
                intent.putExtra("type",1);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BurgerViewHolder extends RecyclerView.ViewHolder{
        ImageView burgerImg;
        TextView burgerName, burgerPrice, burgerDescription;

        public BurgerViewHolder(@NonNull View itemView) {
            super(itemView);
            burgerImg = itemView.findViewById(R.id.burgerImg);
            burgerName = itemView.findViewById(R.id.burgerName);
            burgerPrice = itemView.findViewById(R.id.burgerPrice);
            burgerDescription = itemView.findViewById(R.id.burgerDescription);
        }
    }
}
