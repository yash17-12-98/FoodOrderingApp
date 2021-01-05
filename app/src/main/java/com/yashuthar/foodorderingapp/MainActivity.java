package com.yashuthar.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.yashuthar.foodorderingapp.Adapters.MainAdapter;
import com.yashuthar.foodorderingapp.Models.MainModel;
import com.yashuthar.foodorderingapp.fragments.BakeryFragment;
import com.yashuthar.foodorderingapp.fragments.BeveragesFragment;
import com.yashuthar.foodorderingapp.fragments.BreakfastFragment;
import com.yashuthar.foodorderingapp.fragments.BurgerFragment;
import com.yashuthar.foodorderingapp.fragments.ComboMealFragment;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    TextView menuName;
    LinearLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView nav_imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_imageButton = findViewById(R.id.nav_imageButton);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        contentView = findViewById(R.id.content);
        menuName = findViewById(R.id.menuName);
        navigationDrawer();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ComboMealFragment()).commit();
        menuName.setText("> COMBO MEAL");
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_comboMeal);
        nav_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_comboMeal:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ComboMealFragment()).commit();
                menuName.setText("> COMBO MEAL");
                break;

            case R.id.nav_beverages:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BeveragesFragment()).commit();
                menuName.setText("> BEVERAGES");
                break;

            case R.id.nav_breakfast:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BreakfastFragment()).commit();
                menuName.setText("> BREAKFAST");
                break;

            case R.id.nav_burgers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BurgerFragment()).commit();
                menuName.setText("> BURGERS");
                break;

            case R.id.nav_bakery:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BakeryFragment()).commit();
                menuName.setText("> BAKERY");
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.myorders, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}