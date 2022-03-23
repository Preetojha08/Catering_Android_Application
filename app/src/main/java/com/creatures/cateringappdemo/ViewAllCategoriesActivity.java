package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.models.SlideModel;

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

        //Titles
        viewallfoodbycat_title.add("Fast Food");
        viewallfoodbycat_title.add("Indian Starters");
        viewallfoodbycat_title.add("Chinese Food");

        viewallfoodbycat_title.add("Welcome Drinks");
        viewallfoodbycat_title.add("Non-Veg Starters");
        viewallfoodbycat_title.add("Barbeque Starters");
        viewallfoodbycat_title.add("Sweet Dishes");


        //Subtitles
        viewallfoodbycat_sub_title.add("Pizza, Burger, French Fries, Sandwiches, And Many More...");
        viewallfoodbycat_sub_title.add("Samosa, Bhel Puri, Sev Puri, Pani Puri, Aloo Tikki, And Many More...");
        viewallfoodbycat_sub_title.add("Manchurian, Hakka noodles, Momos, Fried Rice, And Many More...");

        viewallfoodbycat_sub_title.add("Masala Chai, Coffee, Masala Chaas, Lassi, And Many More...");
        viewallfoodbycat_sub_title.add("Chicken spring rolls, Chicken Manchurian, Chicken Pakora,Chicken Kebab, And Many More...");
        viewallfoodbycat_sub_title.add("Paneer Tikka, Barbequed Pineapple Slices, Grilled Sweet Potato, Mexican Kebab, And Many More...");
        viewallfoodbycat_sub_title.add("Gulab Jamun, Gajar Ka Halwa, Sandesh, Kaju ki Barfi, Malai Ghevar, And Many More...");


        //Image Slider
        List<SlideModel> slide_image_models_1 = new ArrayList<>();
        slide_image_models_1.add(new SlideModel(R.drawable.ff_1));
        slide_image_models_1.add(new SlideModel(R.drawable.ff_2));
        slide_image_models_1.add(new SlideModel(R.drawable.ff_3));

        List<SlideModel> slide_image_models_2 = new ArrayList<>();
        slide_image_models_2.add(new SlideModel(R.drawable.is_1));
        slide_image_models_2.add(new SlideModel(R.drawable.is_2));
        slide_image_models_2.add(new SlideModel(R.drawable.is_3));

        List<SlideModel> slide_image_models_3 = new ArrayList<>();
        slide_image_models_3.add(new SlideModel(R.drawable.chinese_1));
        slide_image_models_3.add(new SlideModel(R.drawable.chinese_2));
        slide_image_models_3.add(new SlideModel(R.drawable.chinese_3));

        List<SlideModel> slide_image_models_4 = new ArrayList<>();
        slide_image_models_4.add(new SlideModel(R.drawable.drinks_1));
        slide_image_models_4.add(new SlideModel(R.drawable.drinks_2));
        slide_image_models_4.add(new SlideModel(R.drawable.drinks_3));

        List<SlideModel> slide_image_models_5 = new ArrayList<>();
        slide_image_models_5.add(new SlideModel(R.drawable.nv_3));
        slide_image_models_5.add(new SlideModel(R.drawable.nv_2));
        slide_image_models_5.add(new SlideModel(R.drawable.nv_1));

        List<SlideModel> slide_image_models_6 = new ArrayList<>();
        slide_image_models_6.add(new SlideModel(R.drawable.bar_2));
        slide_image_models_6.add(new SlideModel(R.drawable.bar_1));

        List<SlideModel> slide_image_models_7 = new ArrayList<>();
        slide_image_models_7.add(new SlideModel(R.drawable.sweet_1));
        slide_image_models_7.add(new SlideModel(R.drawable.sweet_2));
        slide_image_models_7.add(new SlideModel(R.drawable.sweet_3));

        List<List<SlideModel>> slide_image_models = new ArrayList<>();

        slide_image_models.add(slide_image_models_1);
        slide_image_models.add(slide_image_models_2);
        slide_image_models.add(slide_image_models_3);
        slide_image_models.add(slide_image_models_4);
        slide_image_models.add(slide_image_models_5);
        slide_image_models.add(slide_image_models_6);
        slide_image_models.add(slide_image_models_7);

        //recyclerViewAdapter=new RecyclerViewAdapter(viewallfoodbycat_title,viewallfoodbycat_sub_title,viewallfoodbycat_img,this,40);
        recyclerViewAdapter=new RecyclerViewAdapter(viewallfoodbycat_title,viewallfoodbycat_sub_title,this,slide_image_models,40);
        recyclerView_viewallfoodbycat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_viewallfoodbycat.setAdapter(recyclerViewAdapter);



    }
}