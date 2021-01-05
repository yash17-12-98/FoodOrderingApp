package com.yashuthar.foodorderingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yashuthar.foodorderingapp.Adapters.BevAdapter;
import com.yashuthar.foodorderingapp.Models.BevModel;
import com.yashuthar.foodorderingapp.R;

import java.util.ArrayList;

public class BeveragesFragment extends Fragment {

    RecyclerView bev_recylerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beverages, container, false);
        bev_recylerView = view.findViewById(R.id.bev_recyclerView);
        ArrayList<BevModel> list = new ArrayList<>();
        list.add(new BevModel(R.drawable.choclate_shake,"Chocolate Shake","4","The perfect sweet treat for any time of the day. Our chocolate shake is made with delicious soft serve, chocolate syrup and finished off with a creamy whipped topping."));
        list.add(new BevModel(R.drawable.diet_coke,"Diet Coke®","5","We ensure our Coke® products are fresh and always tasting the way they should by following the guidelines set by Coca-Cola®, using a ratio of syrup that allows ice to melt, and pre chilling the Coca-Cola® syrup"));
        list.add(new BevModel(R.drawable.drpepper,"Dr Pepper®","5","The classic and refreshing fountain drink. This McDonald's soda option is perfect to pair with any of your favorite menu items. "));
        list.add(new BevModel(R.drawable.fanta_orange,"Fanta Orange","6","Fanta® Orange is a caffeine-free soft drink full of bubbly, refreshing orange flavor. "));
        list.add(new BevModel(R.drawable.hot_choclate,"Hot Choclate","2","Hot chocolate made with steamed whole or nonfat milk, rich chocolate syrup and topped with whipped topping and chocolate drizzle. There are 370 calories in a small Hot Chocolate."));
        list.add(new BevModel(R.drawable.iced_tea,"Iced Tea","3","Iced Tea is made with a brisk blend of orange pekoe black tea, freshly brewed and served ice cold."));
        list.add(new BevModel(R.drawable.minutemaid_orange,"Minute Maid® Premium Orange Juice","4","100% orange juice, packed with Vitamin C. Available in Small, Medium and Large."));
        list.add(new BevModel(R.drawable.minutemaid_pinklemonadeslushie,"Minute Maid® Pink Lemonade Slushie","3","This sweet, blended pink lemonade slushie goes great with a Cheeseburger or our World Famous Fries®."));
        list.add(new BevModel(R.drawable.reducedsugar_lowfatchocolate,"Reduced Sugar* Low Fat Chocolate Milk Jug","5","A handheld chocolate milk jug, full of low fat chocolate milk, a good source of Vitamin A&D."));
        list.add(new BevModel(R.drawable.small_sprite,"Small Sprite","6","Sprite fountain drink has a delicious lemon-lime taste and is available in sizes Extra Small, Small, Medium, and Large."));
        list.add(new BevModel(R.drawable.vanilla_shake,"Vanilla Shake","7","It’s made with our creamy vanilla soft serve and topped with whipped topping for a cool, tasty treat."));
        list.add(new BevModel(R.drawable.smallmiuntemaid_fruitpunchslushie,"Small Minute Maid® Fruit Punch Slushie","2","Turn up summer with this fruit punch slushie made with crushed ice and blended with Minute Maid® fruit punch flavor"));
        bev_recylerView.setHasFixedSize(true);
        bev_recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        bev_recylerView.setAdapter(new BevAdapter(list, getContext()));

        return view;
    }
}
