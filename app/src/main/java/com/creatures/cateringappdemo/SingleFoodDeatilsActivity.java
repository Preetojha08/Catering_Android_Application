package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SingleFoodDeatilsActivity extends AppCompatActivity {

    ImageSlider singlefooddetails_imageSlider;
    TextView textview_heading,textview_items,textview_counters,textview_money;
    ImageView singlefooddetails_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_deatils);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_single_food_deatils);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Order By Categories");

        int foodcatitem_number = getIntent().getExtras().getInt("food_cat_item");

        textview_heading=(TextView)findViewById(R.id.textview_heading_singlefooddeatils);
        textview_counters=(TextView)findViewById(R.id.textview_counters_singlefooddeatils);
        textview_items=(TextView)findViewById(R.id.textview_items_singlefooddeatils);
        textview_money=(TextView)findViewById(R.id.textview_money_singlefooddeatils);
        singlefooddetails_imageview=(ImageView)findViewById(R.id.image_view_single_food_details);

        singlefooddetails_imageSlider=(ImageSlider)findViewById(R.id.image_slider_single_food_details);

        List<SlideModel> slide_image_models = new ArrayList<>();

        if (foodcatitem_number==1){

            singlefooddetails_imageview.setVisibility(View.GONE);
            textview_heading.setText("Fast Food");
            textview_items.setText("Pizza, Burgers, French Fries, Sandwiches, Kurtoshes, Tacos, Hamburgers, Pancakes ,Pasta  And Many More...");
            textview_counters.setText("3 - 4 Counters Required");
            textview_money.setText("Approx 20₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.ff_4));
            slide_image_models.add(new SlideModel(R.drawable.ff_2));
            slide_image_models.add(new SlideModel(R.drawable.ff_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==2){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Indian Starters");
            textview_items.setText("Samosa, Bhel Puri, Sev Puri, Pani Puri, Aloo Tikki, Ragda Pattice, Chaat, Vada Pav, Dabeli, Pakoda, Kanda Poha And Many More...");
            textview_counters.setText("3 - 4 Counters Required");
            textview_money.setText("Approx 15₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.is_1));
            slide_image_models.add(new SlideModel(R.drawable.is_2));
            slide_image_models.add(new SlideModel(R.drawable.is_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==3){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Chinese Food");
            textview_items.setText("Schezwan Noodles, Schezwan Fried Rice, Paneer Fried Rice, Paneer Manchurian Dry, Veg Spring Rolls, Manchurian, Hakka noodles, Momos, Fried Rice, And Many More... ");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 18₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.chinese_1));
            slide_image_models.add(new SlideModel(R.drawable.chinese_2));
            slide_image_models.add(new SlideModel(R.drawable.chinese_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==4){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Welcome Drinks");
            textview_items.setText("Aam panna, Sugarcane Juice, Jal-Jeera, Rooh Afza Sharbat, Shikanjvi, Masala Chai, Coffee, Masala Chaas, Lassi, And Many More...");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 12₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.drinks_1));
            slide_image_models.add(new SlideModel(R.drawable.drinks_2));
            slide_image_models.add(new SlideModel(R.drawable.drinks_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==5){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Non-Veg Starters");
            textview_items.setText("Chicken Spring Rolls, Chicken Pakora, Chilli Chicken, Chicken Manchurian, Meatballs, Vegetable Cheese Omelets, Chicken Kebab And Many More...");
            textview_counters.setText("1 - 2 Counters Required");
            textview_money.setText("Approx 24₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.nv_1));
            slide_image_models.add(new SlideModel(R.drawable.nv_3));
            slide_image_models.add(new SlideModel(R.drawable.nv_2));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==6){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Barbeque Starters");
            textview_items.setText("Paneer Tikka, Barbequed Pineapple Slices, Grilled Sweet Potato, Mexican Kebab, Paneer Afghan, Mix Vegetables and Cheese Skewers And Many More...");
            textview_counters.setText("1 Counters Required");
            textview_money.setText("Approx 22₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.bar_1));
            slide_image_models.add(new SlideModel(R.drawable.bar_2));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }
        else if (foodcatitem_number==7){

            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Sweet Dishes");
            textview_items.setText("Gulab Jamun, Gajar Ka Halwa, Rasgulla, Sandesh, Kaju ki Barfi, Malai Ghevar, Shrikhand, Phirni, Puran Poli, Besan Ke Ladoo, Modak And Many More... ");
            textview_counters.setText("1 - 2 Counters Required");
            textview_money.setText("Approx 20₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.sweet_1));
            slide_image_models.add(new SlideModel(R.drawable.sweet_2));
            slide_image_models.add(new SlideModel(R.drawable.sweet_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);

        }

        else
        {
            singlefooddetails_imageview.setVisibility(View.GONE);
            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            textview_heading.setText("Text Fail");
            textview_items.setText("Test Fail");
            textview_counters.setText("3 - 4 Counters Required");
            textview_money.setText("Approx 20₹ Per Item");

            slide_image_models.add(new SlideModel(R.drawable.ff_4));
            slide_image_models.add(new SlideModel(R.drawable.ff_2));
            slide_image_models.add(new SlideModel(R.drawable.ff_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);
        }


        //Thalis

        int thalidetails_number = getIntent().getExtras().getInt("thali_deatils");

        if (thalidetails_number==11){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);

            textview_heading.setText("Basic Thali");
            textview_items.setText("2 Types of Subzi, 1 Types of Bread, 1 Types of Salad, 1 Types of Kadhi, 1 Types of Rice, 2 Types Of Aachar");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 200₹ Per Item");

           singlefooddetails_imageview.setImageResource(R.drawable.basic_thali);


        }

        else if (thalidetails_number==12){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("Indian Thali");
            textview_items.setText(" Types of Sweet, 3 Types of Subzi, 2 Types of Bread, Multiple Option of Papad, Raita, 2 Types of Salad, 2 Types of Dal, 1 Types of Rice");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 250₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.india_thali);

        }

        else if (thalidetails_number==13){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("Nawab Thali");
            textview_items.setText("2 Types of Veg Subzi, 1 Types of Non-Veg Subzi, 2 Types of Dal,  1 Types of Rice, Raita,  1 Types of Chatani, 3 Types of Bread");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 400₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.delux_thali);

        }

        else if (thalidetails_number==14){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("Maharaja Thali");
            textview_items.setText("2 Types of Sweets, 3 Types of Subji, 2 Types of Farshan, 2 Types of Chatni, 3 Types of Salad, 2 Types of Rayta, 2 Types of Dal, 2 Types of Rice, 4 Types of Bread");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 600₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.maha_raja);

        }

        else if (thalidetails_number==15){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("Party Thali");
            textview_items.setText("1 Types of Sweet, 2 Types of Subzi, 3 Types of Bread, 2 Types of Salad, 3 Types of Aachar, 1 Types of Rayta");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 120₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.party_thali);

        }

        else if (thalidetails_number==16){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("South Indian Thali");
            textview_items.setText("1 Types of Sweet, 1 Types of Idli, 1 Types of Dosa, Sambhar Dal, 2 Types of Chatni, 1 Types of Rice, Dahi");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 200₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.south_thali);

        }

        else if (thalidetails_number==17){

            singlefooddetails_imageSlider.setVisibility(View.GONE);
            singlefooddetails_imageview.setVisibility(View.VISIBLE);
            textview_heading.setText("Punjabi Thali");
            textview_items.setText("2 Types of Sweet, 2 Types of Subji, 2 Types of Bread, 2 Types of Dal, 1 Types of Rice, 2 Types of Salad, Papad, 1 Types of Raita");
            textview_counters.setText("2 - 3 Counters Required");
            textview_money.setText("Approx 200₹ Per Item");

            singlefooddetails_imageview.setImageResource(R.drawable.punjabi_thali);

        }

        else
        {
            textview_heading.setText("Text Fail");
            textview_items.setText("Test Fail");
            textview_counters.setText("3 - 4 Counters Required");
            textview_money.setText("Approx 20₹ Per Item");


            singlefooddetails_imageSlider.setVisibility(View.VISIBLE);
            singlefooddetails_imageview.setVisibility(View.GONE);

            slide_image_models.add(new SlideModel(R.drawable.ff_4));
            slide_image_models.add(new SlideModel(R.drawable.ff_2));
            slide_image_models.add(new SlideModel(R.drawable.ff_3));

            singlefooddetails_imageSlider.setImageList(slide_image_models);
        }







    }
}