package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;
import java.util.List;

public class AddInquiryActivity extends AppCompatActivity {

    List<String> add_inquiry_title;
    List<Integer> add_inquiry_img;
    RecyclerView recyclerView_add_inquiry;
    RecyclerViewAdapter recyclerViewAdapter;
    ProgressBar progress_bar_add_inquiry;

    View view_bg;

    int recycler_view_zero_item=0;

    SharedPreferences add_inquiry_shared_preferences;
    String single_user_inquiry_items_cbf_1;
    String single_user_inquiry_items_cbf_2;
    String single_user_inquiry_items_cbf_3;
    String single_user_inquiry_items_cbf_4;
    String single_user_inquiry_items_cbf_5;
    String single_user_inquiry_items_cbf_6;
    String single_user_inquiry_items_cbf_7;

    String single_user_inquiry_items_allthalis_11;
    String single_user_inquiry_items_allthalis_12;
    String single_user_inquiry_items_allthalis_13;
    String single_user_inquiry_items_allthalis_14;
    String single_user_inquiry_items_allthalis_15;
    String single_user_inquiry_items_allthalis_16;
    String single_user_inquiry_items_allthalis_17;

    String user_inquiry_items_cbf;
    String user_inquiry_items_allthalis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inquiry);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_inquiry);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Add Inquiry");

        view_bg=(View)findViewById(R.id.inquiry_view_background_for_processbar);
        view_bg.setVisibility(View.GONE);

        progress_bar_add_inquiry=(ProgressBar)findViewById(R.id.add_inquiry_progress_bar);
        progress_bar_add_inquiry.setVisibility(View.GONE);

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
            single_user_inquiry_items_cbf_1="Fast Food";
        }
        if (cbf_2 == 2)
        {
            add_inquiry_title.add("Indian Starters");
            add_inquiry_img.add(R.drawable.is_2);
            single_user_inquiry_items_cbf_2="Indian Starters";
        }
        if (cbf_3 == 3)
        {
            add_inquiry_title.add("Chinese Food");
            add_inquiry_img.add(R.drawable.chinese_1);
            single_user_inquiry_items_cbf_3="Chinese Food";
        }
        if (cbf_4 == 4)
        {
            add_inquiry_title.add("Welcome Drinks");
            add_inquiry_img.add(R.drawable.drinks_3);
            single_user_inquiry_items_cbf_4="Welcome Drinks";
        }
        if (cbf_5 == 5)
        {
            add_inquiry_title.add("Non-Veg Starters");
            add_inquiry_img.add(R.drawable.nv_3);
            single_user_inquiry_items_cbf_5="Non-Veg Starters";
        }
        if (cbf_6 == 6)
        {
            add_inquiry_title.add("Barbeque Starters");
            add_inquiry_img.add(R.drawable.bar_2);
            single_user_inquiry_items_cbf_6="Barbeque Starters";
        }
        if (cbf_7 == 7)
        {
            add_inquiry_title.add("Sweet Dishes");
            add_inquiry_img.add(R.drawable.sweet_2);
            single_user_inquiry_items_cbf_7="Sweet Dishes";

        }


        if (allthalis_1==11)
        {
            add_inquiry_title.add("Basic Thali");
            add_inquiry_img.add(R.drawable.basic_thali);
            single_user_inquiry_items_allthalis_11="Basic Thali";
        }
        if (allthalis_2==12)
        {
            add_inquiry_title.add("Indian Thali");
            add_inquiry_img.add(R.drawable.india_thali);
            single_user_inquiry_items_allthalis_12="Indian Thali";
        }
        if (allthalis_3==13)
        {
            add_inquiry_title.add("Nawab Thali");
            add_inquiry_img.add(R.drawable.delux_thali);
            single_user_inquiry_items_allthalis_13="Nawab Thali";
        }
        if (allthalis_4==14)
        {
            add_inquiry_title.add("Maharaja Thali");
            add_inquiry_img.add(R.drawable.maha_raja);
            single_user_inquiry_items_allthalis_14="Maharaja Thali";
        }
        if (allthalis_5==15)
        {
            add_inquiry_title.add("Party Thali");
            add_inquiry_img.add(R.drawable.party_thali);
            single_user_inquiry_items_allthalis_15="Party Thali";
        }
        if (allthalis_6==16)
        {
            add_inquiry_title.add("South Indian Thali");
            add_inquiry_img.add(R.drawable.south_thali);
            single_user_inquiry_items_allthalis_16="South Indian Thali";
        }
        if (allthalis_7==17)
        {
            add_inquiry_title.add("Punjabi Thali");
            add_inquiry_img.add(R.drawable.punjabi_thali);
            single_user_inquiry_items_allthalis_17="Punjabi Thali";
        }

        user_inquiry_items_cbf="The Inquiry is about different Categories of Food which are"+single_user_inquiry_items_cbf_1+", "+single_user_inquiry_items_cbf_2+", "+single_user_inquiry_items_cbf_3+", "+single_user_inquiry_items_cbf_4+", "+single_user_inquiry_items_cbf_5+", "+single_user_inquiry_items_cbf_6+", "+single_user_inquiry_items_cbf_7+". ";
        user_inquiry_items_allthalis="The Inquiry is about different thails which are "+single_user_inquiry_items_allthalis_11+", "+single_user_inquiry_items_allthalis_12+", "+single_user_inquiry_items_allthalis_13+", "+single_user_inquiry_items_allthalis_14+", "+single_user_inquiry_items_allthalis_15+", "+single_user_inquiry_items_allthalis_16+", "+single_user_inquiry_items_allthalis_17+". ";

        String name,mail,number,id;

        add_inquiry_shared_preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_MULTI_PROCESS);

        name=add_inquiry_shared_preferences.getString("nameKey",null);
        id=add_inquiry_shared_preferences.getString("userIdKey",null);
        mail=add_inquiry_shared_preferences.getString("emailKey",null);
        number=add_inquiry_shared_preferences.getString("phoneKey",null);

        //Toast.makeText(this, ""+name+" "+mail+" "+number, Toast.LENGTH_LONG).show();
        //TICCard Toast.makeText(this, ""+user_inquiry_items_cbf, Toast.LENGTH_SHORT).show();

        recyclerViewAdapter=new RecyclerViewAdapter(add_inquiry_title,add_inquiry_img,this,60);
        recyclerView_add_inquiry.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_add_inquiry.setAdapter(recyclerViewAdapter);

        ImageView next_imageView=findViewById(R.id.next_add_inquiry_image_view);
        next_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbf_1>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_2>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_3>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_4>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_5>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_6>0)
                {
                    recycler_view_zero_item++;
                }
                if (cbf_7>0)
                {
                    recycler_view_zero_item++;
                }

                //About Thalis
                if (allthalis_1>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_2>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_3>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_4>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_5>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_6>0)
                {
                    recycler_view_zero_item++;
                }
                if (allthalis_7>0)
                {
                    recycler_view_zero_item++;
                }
                if(recycler_view_zero_item==0)
                {
                    Toast.makeText(AddInquiryActivity.this, "Select item for Inquiry", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    progress_bar_add_inquiry.setVisibility(View.VISIBLE);
                    view_bg.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[6];
                            field[0] = "inquiry_user_name";
                            field[1] = "inquiry_user_mobile";
                            field[2] = "inquiry_user_mail";
                            field[3] = "inquiry_thalis";
                            field[4] = "inquiry_category_food";
                            field[5] = "inquiry_user_id";
                            //field[3] = "email";

                            //Creating array for data
                            String[] data = new String[6];
                            data[0] = name;
                            data[1] = number;
                            data[2] = mail;
                            data[3] = user_inquiry_items_allthalis;
                            data[4] = user_inquiry_items_cbf; //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            data[5] = id;
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/add_inquiry.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_add_inquiry.setVisibility(View.GONE);
                                    view_bg.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Data Added Successfully"))
                                    {
                                        Toast.makeText(AddInquiryActivity.this, "Inquiry Added Successfully", Toast.LENGTH_SHORT).show();
                                        Log.e("Adding Inquiry error","Error Msg: "+result);

                                        add_inquiry_shared_preferences = getSharedPreferences("MyPREFERENCESFOOD", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor sp_editor = add_inquiry_shared_preferences.edit();

                                        sp_editor.putInt("food_item_details_ff",0);
                                        sp_editor.putInt("food_item_details_is",0);
                                        sp_editor.putInt("food_item_details_cf",0);
                                        sp_editor.putInt("food_item_details_wd",0);
                                        sp_editor.putInt("food_item_details_nvs",0);
                                        sp_editor.putInt("food_item_details_bs",0);
                                        sp_editor.putInt("food_item_details_sd",0);

                                        sp_editor.putInt("food_item_details_thali_bt",0);
                                        sp_editor.putInt("food_item_details_thali_it",0);
                                        sp_editor.putInt("food_item_details_thali_nt",0);
                                        sp_editor.putInt("food_item_details_thali_mt",0);
                                        sp_editor.putInt("food_item_details_thali_partt",0);
                                        sp_editor.putInt("food_item_details_thali_sit",0);
                                        sp_editor.putInt("food_item_details_thali_pt",0);

                                        sp_editor.commit();
                                        sp_editor.apply();

                                        startActivity(new Intent(AddInquiryActivity.this,Home_Activity.class));

                                    }
                                    else if(result.equals("Already have an InquiryData Added Successfully"))
                                    {
                                        Toast.makeText(AddInquiryActivity.this, "Inquiry Updated", Toast.LENGTH_SHORT).show();
                                        Log.e("Adding Inquiry error","Error Msg: "+result);

                                        add_inquiry_shared_preferences = getSharedPreferences("MyPREFERENCESFOOD", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor sp_editor = add_inquiry_shared_preferences.edit();

                                        sp_editor.putInt("food_item_details_ff",0);
                                        sp_editor.putInt("food_item_details_is",0);
                                        sp_editor.putInt("food_item_details_cf",0);
                                        sp_editor.putInt("food_item_details_wd",0);
                                        sp_editor.putInt("food_item_details_nvs",0);
                                        sp_editor.putInt("food_item_details_bs",0);
                                        sp_editor.putInt("food_item_details_sd",0);

                                        sp_editor.putInt("food_item_details_thali_bt",0);
                                        sp_editor.putInt("food_item_details_thali_it",0);
                                        sp_editor.putInt("food_item_details_thali_nt",0);
                                        sp_editor.putInt("food_item_details_thali_mt",0);
                                        sp_editor.putInt("food_item_details_thali_partt",0);
                                        sp_editor.putInt("food_item_details_thali_sit",0);
                                        sp_editor.putInt("food_item_details_thali_pt",0);

                                        sp_editor.commit();
                                        sp_editor.apply();

                                        startActivity(new Intent(AddInquiryActivity.this,Home_Activity.class));

                                    }
                                    else
                                    {
                                        Toast.makeText(AddInquiryActivity.this, "  Error  ", Toast.LENGTH_LONG).show();
                                        Log.e("Adding Inquiry error","Error Msg: "+result);
                                        /*tv_error.setText(result);*/
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    //End of handler
                }

            }
        });

    }
}