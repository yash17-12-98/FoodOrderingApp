package com.yashuthar.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.yashuthar.foodorderingapp.Adapters.OrderAdapter;
import com.yashuthar.foodorderingapp.Models.OrderModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        RecyclerView orderFoodRecyclerview= (RecyclerView) findViewById(R.id.orderfoodRecyclerview);
        DBHelpers helpers = new DBHelpers(this);
        ArrayList<OrderModel> list = helpers.gettOrders();
        orderFoodRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        orderFoodRecyclerview.setAdapter(new OrderAdapter(this, list));

    }
}