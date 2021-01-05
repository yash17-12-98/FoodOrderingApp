package com.yashuthar.foodorderingapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.DBHelpers;
import com.yashuthar.foodorderingapp.DetailActivity;
import com.yashuthar.foodorderingapp.Models.OrderModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    Context context;
    ArrayList<OrderModel> list;

    public OrderAdapter(Context context, ArrayList<OrderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_orderfood,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderModel model = list.get(position);
        holder.orderId.setText(model.getOrderId());
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.orderName.setText(model.getOrderName());
        holder.orderPrice.setText(model.getOrderPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", Integer.parseInt(model.getOrderId()));
                intent.putExtra("type",2);
                context.startActivity(intent);

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Item")
                    .setMessage("Are you sure want to delete?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DBHelpers helpers = new DBHelpers(context);
                            if(helpers.deletedOrder(model.getOrderId()) > 0){
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                holder.itemView.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView orderName, orderId, orderPrice;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = (ImageView) itemView.findViewById(R.id.orderImage);
            orderName = (TextView) itemView.findViewById(R.id.orderName);
            orderId = (TextView) itemView.findViewById(R.id.orderId);
            orderPrice = (TextView) itemView.findViewById(R.id.orderPrice);
        }
    }
}
