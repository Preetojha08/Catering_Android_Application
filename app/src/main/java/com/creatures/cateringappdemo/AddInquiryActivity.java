package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AddInquiryActivity extends AppCompatActivity {

    List<String> add_inquiry_title;
    List<Integer> add_inquiry_img;
    RecyclerView recyclerView_add_inquiry;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inquiry);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_inquiry);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Add Inquiry");

        recyclerView_add_inquiry=(RecyclerView) findViewById(R.id.add_inquiry_recycler_view);

        add_inquiry_title = new ArrayList<>();
        add_inquiry_img = new ArrayList<>();

        add_inquiry_title.add("Fast Food");
        add_inquiry_title.add("Welcome Drinks");
        add_inquiry_title.add("Party Thali");


        add_inquiry_img.add(R.drawable.ff_1);
        add_inquiry_img.add(R.drawable.drinks_2);
        add_inquiry_img.add(R.drawable.party_thali);


        //TICCard

        recyclerViewAdapter=new RecyclerViewAdapter(add_inquiry_title,add_inquiry_img,this,60);
        recyclerView_add_inquiry.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_add_inquiry.setAdapter(recyclerViewAdapter);


    }
}