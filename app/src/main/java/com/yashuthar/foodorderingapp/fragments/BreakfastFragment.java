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

import com.yashuthar.foodorderingapp.Adapters.BreakfastAdapter;
import com.yashuthar.foodorderingapp.Models.BreakfastModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BreakfastFragment extends Fragment {
    RecyclerView breakfast_recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breakfast, container, false);
        breakfast_recyclerview = view.findViewById(R.id.breakfast_recyclerView);
        ArrayList<BreakfastModel> list = new ArrayList<>();
        list.add(new BreakfastModel(R.drawable.bacon_egg_cheese_biscuit,"Bacon, Egg & Cheese Biscuit","2","Bacon, Egg & Cheese Biscuit breakfast sandwich features a warm, buttermilk biscuit brushed with real butter, thick cut Applewood smoked bacon, a fluffy folded egg, and a slice of melty American cheese."));
        list.add(new BreakfastModel(R.drawable.baconeggcheesmeal,"","2","Craving a breakfast sandwich at McDonald's? Our Bacon, Egg and Cheese bagel features a toasted bagel with butter, thick-cut Applewood smoked bacon"));
        list.add(new BreakfastModel(R.drawable.bigbreakfast,"Big Breakfast®","2","Our full, satisfying Big Breakfast® is perfect for any morning. Wake up to a breakfast meal with a warm biscuit, fluffy scrambled eggs"));
        list.add(new BreakfastModel(R.drawable.bigbreakfast_with_hotcakes,"Big Breakfast® with Hotcakes","2","Fill up with a warm biscuit, savory hot sausage, fluffy scrambled eggs, crispy hash browns, and golden brown hotcakes with a side of real butter "));
        list.add(new BreakfastModel(R.drawable.sausage_burrito,"Sausage Burrito","2","Breakfast Burrito and is loaded with fluffy scrambled egg, pork sausage, melty cheese, green chiles and onion! It's wrapped in a soft tortilla"));
        list.add(new BreakfastModel(R.drawable.sausage_with_egg,"Sausage, Egg & Cheese","2","warm griddle cakes—with the sweet taste of maple—that hold a fluffy folded egg, savory sausage, and melty American cheese."));
        list.add(new BreakfastModel(R.drawable.fruit_and_maple_oatmeal,"Fruit & Maple Oatmealt","2","Our Fruit and Maple Oatmeal has two full servings of whole-grain oats and a touch of cream."));
        breakfast_recyclerview.setHasFixedSize(true);
        breakfast_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        breakfast_recyclerview.setAdapter(new BreakfastAdapter(getContext(),list));
        return view;
    }
}
