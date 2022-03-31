package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        int cbf_1 = InquiryDataPass.food_category_ff;
        int cbf_2 = InquiryDataPass.food_category_is;
        int cbf_3 = InquiryDataPass.food_category_cf;
        int cbf_4 = InquiryDataPass.food_category_wd;
        int cbf_5 = InquiryDataPass.food_category_nvs;
        int cbf_6 = InquiryDataPass.food_category_bs;
        int cbf_7 = InquiryDataPass.food_category_sd;

        int allthalis_1 = InquiryDataPass.thali_category_BT;
        int allthalis_2 = InquiryDataPass.thali_category_IT;
        int allthalis_3 = InquiryDataPass.thali_category_NT;
        int allthalis_4 = InquiryDataPass.thali_category_MT;

        int allthalis_5 = InquiryDataPass.thali_category_PARTT;
        int allthalis_6 = InquiryDataPass.thali_category_SIT;
        int allthalis_7 = InquiryDataPass.thali_category_PT;

        Toast.makeText(this, " "+cbf_1+" "+" "+cbf_2+" "+" "+cbf_3+" "+" "+cbf_4+" "+" "+cbf_5+" "+" "+cbf_6+" "+" "+cbf_7, Toast.LENGTH_SHORT).show();

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
        /*else {
            Log.e("Error","Error 1");
        }*/

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
        /*else
        {
            Log.e("Error","Error 2");
        }*/


        //TICCard

        recyclerViewAdapter=new RecyclerViewAdapter(add_inquiry_title,add_inquiry_img,this,60);
        recyclerView_add_inquiry.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_add_inquiry.setAdapter(recyclerViewAdapter);


    }
}