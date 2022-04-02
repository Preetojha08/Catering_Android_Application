package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddInquiryActivity extends AppCompatActivity {

    List<String> add_inquiry_title;
    List<Integer> add_inquiry_img;
    RecyclerView recyclerView_add_inquiry;
    RecyclerViewAdapter recyclerViewAdapter;

    SharedPreferences add_inquiry_shared_preferences;

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

        add_inquiry_shared_preferences=getSharedPreferences("MyPREFERENCESFOOD", Context.MODE_MULTI_PROCESS);

        //Food Categories Data
        int cbf_1 = add_inquiry_shared_preferences.getInt("food_item_details_ff",0);
        int cbf_2 = add_inquiry_shared_preferences.getInt("food_item_details_is",0);
        int cbf_3 = add_inquiry_shared_preferences.getInt("food_item_details_cf",0);
        int cbf_4 = add_inquiry_shared_preferences.getInt("food_item_details_wd",0);

        int cbf_5 = add_inquiry_shared_preferences.getInt("food_item_details_nvs",0);
        int cbf_6 = add_inquiry_shared_preferences.getInt("food_item_details_bs",0);
        int cbf_7 = add_inquiry_shared_preferences.getInt("food_item_details_sd",0);


        //Thali Data
        int allthalis_1 = add_inquiry_shared_preferences.getInt("food_item_details_thali_bt",0);
        int allthalis_2 = add_inquiry_shared_preferences.getInt("food_item_details_thali_it",0);
        int allthalis_3 = add_inquiry_shared_preferences.getInt("food_item_details_thali_nt",0);
        int allthalis_4 = add_inquiry_shared_preferences.getInt("food_item_details_thali_mt",0);

        int allthalis_5 = add_inquiry_shared_preferences.getInt("food_item_details_thali_partt",0);
        int allthalis_6 = add_inquiry_shared_preferences.getInt("food_item_details_thali_sit",0);
        int allthalis_7 = add_inquiry_shared_preferences.getInt("food_item_details_thali_pt",0);

        if (cbf_1 == 1)
        {
            add_inquiry_title.add("Fast Food");
            add_inquiry_img.add(R.drawable.ff_1);
        }
        if (cbf_2 == 2)
        {
            add_inquiry_title.add("Indian Starters");
            add_inquiry_img.add(R.drawable.is_2);
        }
        if (cbf_3 == 3)
        {
            add_inquiry_title.add("Chinese Food");
            add_inquiry_img.add(R.drawable.chinese_1);
        }
        if (cbf_4 == 4)
        {
            add_inquiry_title.add("Welcome Drinks");
            add_inquiry_img.add(R.drawable.drinks_3);
        }
        if (cbf_5 == 5)
        {
            add_inquiry_title.add("Non-Veg Starters");
            add_inquiry_img.add(R.drawable.nv_3);
        }
        if (cbf_6 == 6)
        {
            add_inquiry_title.add("Barbeque Starters");
            add_inquiry_img.add(R.drawable.bar_2);
        }
        if (cbf_7 == 7)
        {
            add_inquiry_title.add("Sweet Dishes");
            add_inquiry_img.add(R.drawable.sweet_2);

        }


        if (allthalis_1==11)
        {
            add_inquiry_title.add("Basic Thali");
            add_inquiry_img.add(R.drawable.basic_thali);
        }
        if (allthalis_2==12)
        {
            add_inquiry_title.add("Indian Thali");
            add_inquiry_img.add(R.drawable.india_thali);
        }
        if (allthalis_3==13)
        {
            add_inquiry_title.add("Nawab Thali");
            add_inquiry_img.add(R.drawable.delux_thali);
        }
        if (allthalis_4==14)
        {
            add_inquiry_title.add("Maharaja Thali");
            add_inquiry_img.add(R.drawable.maha_raja);
        }
        if (allthalis_5==15)
        {
            add_inquiry_title.add("Party Thali");
            add_inquiry_img.add(R.drawable.party_thali);
        }
        if (allthalis_6==16)
        {
            add_inquiry_title.add("South Indian Thali");
            add_inquiry_img.add(R.drawable.south_thali);
        }
        if (allthalis_7==17)
        {
            add_inquiry_title.add("Punjabi Thali");
            add_inquiry_img.add(R.drawable.punjabi_thali);
        }


        //TICCard

        recyclerViewAdapter=new RecyclerViewAdapter(add_inquiry_title,add_inquiry_img,this,60);
        recyclerView_add_inquiry.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_add_inquiry.setAdapter(recyclerViewAdapter);


    }
}