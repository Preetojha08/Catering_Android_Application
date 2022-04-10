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

    List<String> sub_menu_subtitle_1;
    List<String> sub_menu_subtitle_2;
    List<String> sub_menu_subtitle_3;
    List<String> sub_menu_subtitle_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu_items);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Food Menu");

        menu_item_recyclerView=(RecyclerView) findViewById(R.id.menu_item_recycler_view);

        menu_title = new ArrayList<>();
        sub_menu_subtitle_1 = new ArrayList<>();
        sub_menu_subtitle_2 = new ArrayList<>();
        sub_menu_subtitle_3 = new ArrayList<>();
        sub_menu_subtitle_4 = new ArrayList<>();

        menu_title.add("Indian Menu");
        menu_title.add("Punjabi Menu");
        menu_title.add("Chinese Menu");

        sub_menu_subtitle_1.add("Indian Welcome Drinks");
        sub_menu_subtitle_2.add("Indian Starters");
        sub_menu_subtitle_3.add("Indian Breads");
        sub_menu_subtitle_4.add("Indian Sabzi");

        sub_menu_subtitle_1.add("Punjabi Welcome Drinks");
        sub_menu_subtitle_2.add("Punjabi Starters");
        sub_menu_subtitle_3.add("Punjabi Sabzi");
        sub_menu_subtitle_4.add("Dals And Rices");

        sub_menu_subtitle_1.add("Chinese Soups");
        sub_menu_subtitle_2.add("Chinese Starters");
        sub_menu_subtitle_3.add("Chinese items");
        sub_menu_subtitle_4.add("Chinese(Paneer) Sabzi");

        recyclerViewAdapter=new RecyclerViewAdapter(menu_title,sub_menu_subtitle_1,sub_menu_subtitle_2,sub_menu_subtitle_3,sub_menu_subtitle_4,this,70);
        menu_item_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        menu_item_recyclerView.setAdapter(recyclerViewAdapter);

    }
}