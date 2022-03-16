package com.creatures.cateringappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rv_food_by_cat,rv_book_by_thali;
    TextView tv_viewall_cat,tv_viewall_thali;

    ImageSlider home_imageSlider;

    List<String> foodbycat_title;
    List<Integer> foodbycat_img;

    List<String> bookbythali_title;
    List<Integer> bookbythali_img;

    RecyclerViewAdapter adapter,new_adapter;

    DrawerLayout drawer;
    LinearLayoutManager HorizontalLayout;

    TextView tool_bar_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home_portal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Catering App");


        rv_food_by_cat=(RecyclerView)findViewById(R.id.recyclerView_food_by_cat);
        rv_book_by_thali=(RecyclerView)findViewById(R.id.recyclerView_book_by_thali);
        tv_viewall_cat=(TextView)findViewById(R.id.tv_view_all_category);
        tv_viewall_thali=(TextView)findViewById(R.id.tv_view_all_thali);

        //Food by Cat
        foodbycat_img = new ArrayList<>();
        foodbycat_title = new ArrayList<>();

        foodbycat_title.add("Fast Food");
        foodbycat_title.add("Chinese Food");
        foodbycat_title.add("Welcome Drinks");
        foodbycat_title.add("Non Veg Food");
        foodbycat_title.add("Sweet Dish");

        foodbycat_img.add(R.drawable.fast_food);
        foodbycat_img.add(R.drawable.chinese);
        foodbycat_img.add(R.drawable.welcome_drink);
        foodbycat_img.add(R.drawable.non_veg);
        foodbycat_img.add(R.drawable.sweet);

        adapter = new RecyclerViewAdapter(foodbycat_title,foodbycat_img,this,10);
        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rv_food_by_cat.setLayoutManager(HorizontalLayout);
        rv_food_by_cat.setAdapter(adapter);

        //Book By thali

        bookbythali_title = new ArrayList<>();
        bookbythali_img = new ArrayList<>();

        bookbythali_title.add("Basic Thali");
        bookbythali_title.add("Nawab Thali");
        bookbythali_title.add("Hindustani Thali");
        bookbythali_title.add("Party Thali");

        bookbythali_img.add(R.drawable.basic_thali);
        bookbythali_img.add(R.drawable.delux_thali);
        bookbythali_img.add(R.drawable.india_thali);
        bookbythali_img.add(R.drawable.party_thali);


        new_adapter = new RecyclerViewAdapter(bookbythali_title,bookbythali_img,this,20);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        rv_book_by_thali.setLayoutManager(layoutManager);
        //rv_book_by_thali.setLayoutManager(HorizontalLayout);
        rv_book_by_thali.setAdapter(new_adapter);

        //Image Slider

        home_imageSlider=(ImageSlider)findViewById(R.id.home_image_slider);

        List<SlideModel> slide_image_models = new ArrayList<>();

        slide_image_models.add(new SlideModel(R.drawable.one));
        slide_image_models.add(new SlideModel(R.drawable.two));
        slide_image_models.add(new SlideModel(R.drawable.three));
        slide_image_models.add(new SlideModel(R.drawable.four));
        slide_image_models.add(new SlideModel(R.drawable.five));

        home_imageSlider.setImageList(slide_image_models);


        //Drawer Code
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.nav_cart):
                Toast.makeText(this , "Your Cart" , Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case (R.id.nav_setting):
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_logout):
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_help):
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_motivational):
                Toast.makeText(this, "Motivational", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_job):
                Toast.makeText(this, "Job", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}