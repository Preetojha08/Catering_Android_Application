package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewAllThaliActivity extends AppCompatActivity {

    List<String> viewallthali_title;
    List<Integer> viewallthali_img;

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView_viewallthali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_thali);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_viewallthali);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thali");

        recyclerView_viewallthali=(RecyclerView)findViewById(R.id.recyclerview_view_all_Thali);

        viewallthali_title = new ArrayList<>();
        viewallthali_img  = new ArrayList<>();

        viewallthali_title.add("Basic Thali");
        viewallthali_title.add("Indian Thali");
        viewallthali_title.add("Nawab Thali");
        viewallthali_title.add("Maharaja Thali");
        viewallthali_title.add("Party Thali");
        viewallthali_title.add("South Indian Thali");
        viewallthali_title.add("Punjabi Thali ");

        viewallthali_img.add(R.drawable.basic_thali);
        viewallthali_img.add(R.drawable.india_thali);
        viewallthali_img.add(R.drawable.delux_thali);
        viewallthali_img.add(R.drawable.maha_raja);
        viewallthali_img.add(R.drawable.party_thali);
        viewallthali_img.add(R.drawable.south_thali);
        viewallthali_img.add(R.drawable.punjabi_thali);

        recyclerViewAdapter=new RecyclerViewAdapter(viewallthali_title,viewallthali_img,this,40);
        recyclerView_viewallthali.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_viewallthali.setAdapter(recyclerViewAdapter);


    }
}