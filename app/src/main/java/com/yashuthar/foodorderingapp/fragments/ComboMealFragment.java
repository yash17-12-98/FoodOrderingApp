package com.yashuthar.foodorderingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.Adapters.MainAdapter;
import com.yashuthar.foodorderingapp.Models.MainModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class ComboMealFragment extends Fragment {
    RecyclerView productRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combomeal, container, false);
        productRecyclerView = (RecyclerView) view.findViewById(R.id.productRecyclerView);
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.bigmeal, "Big Mac® Combo Meal", "5", "The one and only McDonald’s Big Mac® Combo Meal. Big Mac Ingredients include a classic sesame hamburger bun, Big Mac Sauce, American cheese and sliced pickles. "));
        list.add(new MainModel(R.drawable.cheesemeal, "Double Quarter Pounder®* with Cheese Meal", "4", "Get double the fresh beef** flavor with a Double Quarter Pounder® with Cheese made with fresh beef that’s cooked when you order."));
        list.add(new MainModel(R.drawable.chickenextrameals, "Buttermilk Crispy Chicken Sandwich Meal", "4", "Our Buttermilk Crispy Chicken Sandwich Meal is a classic combination of a crispy chicken fillet on an artisan sandwich bun."));
        list.add(new MainModel(R.drawable.fishmeal, "Filet-O-Fish® Meal", "1", "A classic fish sandwich value meal made with wild-caught Alaskan Pollock on a regular McDonald’s bun, served with our World Famous Fries®."));
        list.add(new MainModel(R.drawable.baconeggcheesmeal, "Bacon, Egg & Cheese Biscuit Meal", "4", "The delicious Bacon Egg & Cheese Biscuit meal, the golden-brown way to start your day, served with McDonald’s hash browns "));
        list.add(new MainModel(R.drawable.burritomeal, "Sausage Burrito Meal", "4", "Add some spice to your morning with two sausage burritos on warm flour tortillas, plus crispy golden Hash Browns and a small McCafé® Coffee."));
        productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productRecyclerView.setAdapter(new MainAdapter(list, getContext()));
        return view;
    }

}
