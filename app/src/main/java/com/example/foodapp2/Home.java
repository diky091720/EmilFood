package com.example.foodapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodapp2.CategoryAdapter;
import com.example.foodapp2.PopularAdapter;
import com.example.foodapp2.CategoryDomain;
import com.example.foodapp2.FoodDomain;
import com.example.foodapp2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, CartList.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Ayam Goreng", "ayamgoreng", "Ayam goreng tepung 1 pcs ", 8500));
        foodlist.add(new FoodDomain("Ayam Panggang", "ayampanggang", "Ayam panggang ditambah dengan potongan kentang rebus ", 46000));
        foodlist.add(new FoodDomain("Kentang Goreng", "frenchfries", " Kentang goreng hangat dengan tambahan bumbu asin", 13000));
        foodlist.add(new FoodDomain("Big Burger King", "burger2", " Burger dengan isian Mayonaise,Keju,Selada,Tomat,Australian Beef,Bawang Goreng.", 25000));
        foodlist.add(new FoodDomain("Paket Combo 1", "paket1", " Double Chesee burger dengan kentang goreng dan pepsi", 55000));
        foodlist.add(new FoodDomain("Paket Jumbo Dumbo", "paket2", " 2 Double Burger dengan 1 HotDog dan kentang goreng", 150000));
        foodlist.add(new FoodDomain("Milo", "milo", " Es Milo ", 15000));
        foodlist.add(new FoodDomain("Sprite", "sprite", " Sprite", 15000));
        foodlist.add(new FoodDomain("Coca Cola", "cocacola", " CocaCola", 15000));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}