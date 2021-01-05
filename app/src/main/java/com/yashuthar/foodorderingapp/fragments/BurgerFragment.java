package com.yashuthar.foodorderingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.Adapters.BurgerAdapter;
import com.yashuthar.foodorderingapp.Models.BurgerModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BurgerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger, container, false);
        RecyclerView burger_recyclerview = view.findViewById(R.id.burger_recyclerView);
        ArrayList<BurgerModel> list = new ArrayList<>();
        list.add(new BurgerModel(R.drawable.bigmac, "Big Mac®", "2", "Mouthwatering perfection starts with two 100% pure beef patties and Big Mac sauce sandwiched between a sesame seed bun."));
        list.add(new BurgerModel(R.drawable.doubl_quarter_pounder_with_cheese, "Double Quarter Pounder®* with Cheese", "2", "Each Double Quarter Pounder with Cheese features two quarter pound* 100% fresh beef burger patties that are hot, deliciously juicy and cooked when you order."));
        list.add(new BurgerModel(R.drawable.quarterpounderwithcheese, "Quarter Pounder®* with Cheese Deluxe", "2", "Seasoned with just a pinch of salt and pepper and sizzled on our flat iron grill. Layered with two slices of melty American cheese, creamy mayo, slivered onions and tangy pickles on a soft."));
        list.add(new BurgerModel(R.drawable.hamburger, "Hamburger", "2", "The original burger starts with a 100% pure beef burger seasoned with just a pinch of salt and pepper."));
        burger_recyclerview.setHasFixedSize(true);
        burger_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        burger_recyclerview.setAdapter(new BurgerAdapter(getContext(), list));
        return view;
    }
}
