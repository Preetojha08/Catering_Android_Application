package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView menu_item_recyclerView;

    List<String> menu_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu_items);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Food Menu");

        menu_item_recyclerView=(RecyclerView) findViewById(R.id.menu_item_recycler_view);

        menu_title = new ArrayList<>();

        menu_title.add("Indian Menu");
        menu_title.add("Punjabi Menu");
        menu_title.add("Chinese Menu");


        recyclerViewAdapter=new RecyclerViewAdapter(menu_title,this,70);
        menu_item_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        menu_item_recyclerView.setAdapter(recyclerViewAdapter);

    }
}