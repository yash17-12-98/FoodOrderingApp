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

import com.yashuthar.foodorderingapp.Adapters.BakeryAdapter;
import com.yashuthar.foodorderingapp.Models.BakeryModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BakeryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bakery, container, false);
        RecyclerView bakery_recylerview = view.findViewById(R.id.bakery_recyclerView);
        ArrayList<BakeryModel> list = new ArrayList<>();
        list.add(new BakeryModel(R.drawable.applefritter, "Apple Fritter", "2", "A classic fritter made with cinnamon and apples fried to a golden brown and covered with a sweet glaze icing."));
        list.add(new BakeryModel(R.drawable.cinnamonroll, "Cinnamon Roll", "3", "Served warm and loaded with cinnamon layered between buttery, flaky pastry dough that is drizzled with a delicious cream cheese icing. "));
        list.add(new BakeryModel(R.drawable.bakedapplepie, "Baked Apple Pie", "5", "Baked Apple Pie is loaded with 100% American-grown apples, with a lattice crust baked to perfection and topped with sprinkled sugar. "));
        list.add(new BakeryModel(R.drawable.chocolatechipcookie, "Chocolate Chip Cookie", "2", "chocolate chip cookie, loaded with chocolate chips. It's a soft baked cookie and warmed to perfection."));
        list.add(new BakeryModel(R.drawable.blueberrymuffin, "Blueberry Muffin", "3", "A soft and fluffy muffin baked with real blueberries and topped with a streusel crumb topping"));
        bakery_recylerview.setHasFixedSize(true);
        bakery_recylerview.setLayoutManager(new LinearLayoutManager(getContext()));
        bakery_recylerview.setAdapter(new BakeryAdapter(getContext(), list));
        return view;
    }
}
