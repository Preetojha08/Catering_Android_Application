package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewAllCategoriesActivity extends AppCompatActivity {

    List<String> viewallfoodbycat_title;
    List<String> viewallfoodbycat_sub_title;
    List<Integer> viewallfoodbycat_img;

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView_viewallfoodbycat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_categories);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_viewallfoodbycat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Order By Categories");

        recyclerView_viewallfoodbycat=(RecyclerView)findViewById(R.id.viewallfoodbycat_recycler_view);

        viewallfoodbycat_title = new ArrayList<>();
        viewallfoodbycat_sub_title = new ArrayList<>();
        viewallfoodbycat_img = new ArrayList<>();

        viewallfoodbycat_title.add("Fast Food");
        viewallfoodbycat_title.add("Indian Starters");
        viewallfoodbycat_title.add("Chinese Food");

        viewallfoodbycat_title.add("Welcome Drinks");
        viewallfoodbycat_title.add("Non-Veg Starters");
        viewallfoodbycat_title.add("Barbeque Starters");

        viewallfoodbycat_title.add("Sweet Dishes");

        viewallfoodbycat_sub_title.add("Pizza, Burger, French Fries, Sandwiches, And Many More...");
        viewallfoodbycat_sub_title.add("Samosa, Bhel Puri, Sev Puri, Pani Puri, Aloo Tikki, And Many More...");
        viewallfoodbycat_sub_title.add("Manchurian, Hakka noodles, Momos, Fried Rice, And Many More...");


        viewallfoodbycat_sub_title.add("Masala Chai, Coffee, Masala Chaas, Lassi, And Many More...");
        viewallfoodbycat_sub_title.add("Chicken spring rolls, Chicken Manchurian, Chicken Pakora,Chicken Kebab, And Many More...");
        viewallfoodbycat_sub_title.add("Paneer Tikka, Barbequed Pineapple Slices, Grilled Sweet Potato, Mexican Kebab, And Many More...");

        viewallfoodbycat_sub_title.add("Gulab Jamun, Gajar Ka Halwa, Sandesh, Kaju ki Barfi, Malai Ghevar, And Many More...");

        viewallfoodbycat_img.add(R.drawable.fastfood);
        viewallfoodbycat_img.add(R.drawable.samosa);
        viewallfoodbycat_img.add(R.drawable.chinese);

        viewallfoodbycat_img.add(R.drawable.drinks);
        viewallfoodbycat_img.add(R.drawable.non_veg);
        viewallfoodbycat_img.add(R.drawable.barbeque);

        viewallfoodbycat_img.add(R.drawable.sweet);

        recyclerViewAdapter=new RecyclerViewAdapter(viewallfoodbycat_title,viewallfoodbycat_sub_title,viewallfoodbycat_img,this,40);
        recyclerView_viewallfoodbycat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_viewallfoodbycat.setAdapter(recyclerViewAdapter);


    }
}