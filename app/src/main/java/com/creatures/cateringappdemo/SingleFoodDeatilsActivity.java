package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class SingleFoodDeatilsActivity extends AppCompatActivity {

    ImageSlider singlefooddetails_imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_deatils);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_single_food_deatils);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Order By Categories");

        singlefooddetails_imageSlider=(ImageSlider)findViewById(R.id.image_slider_single_food_details);

        List<SlideModel> slide_image_models = new ArrayList<>();

        slide_image_models.add(new SlideModel(R.drawable.ff_4));
        slide_image_models.add(new SlideModel(R.drawable.ff_2));
        slide_image_models.add(new SlideModel(R.drawable.ff_3));


        singlefooddetails_imageSlider.setImageList(slide_image_models);


    }
}