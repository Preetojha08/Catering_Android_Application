package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SingleFoodDeatilsActivity extends AppCompatActivity {

    ImageSlider singlefooddetails_imageSlider;
    TextView textview_heading,textview_items,textview_counters,textview_money;
    ImageView singlefooddetails_imageview;
    Button add_inquiry_btn;

    int foodcatitem_number;
    int thalidetails_number;

    InquiryDataPass inquiryDataPass;

    SharedPreferences sfd_shared_preferences;
    SharedPreferences.Editor sfd_sp_editor;
    public static final String MyPREFERENCESFOOD = "MyPREFERENCESFOOD" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_deatils);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_single_food_deatils);
        setSupportActionBar(toolbar);

        add_inquiry_btn=(Button) findViewById(R.id.add_inquiry_button_sfd);

        //rva_sp_editor= recylerviewadpter_shared_preferences.edit();

        sfd_shared_preferences=getSharedPreferences(MyPREFERENCESFOOD, Context.MODE_PRIVATE);

        foodcatitem_number = getIntent().getExtras().getInt("food_cat_item");

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
            Log.e("Error","Error");
        }


        //Thalis

        thalidetails_number = getIntent().getExtras().getInt("thali_deatils");

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
            Log.e("Error","Error");
        }

        add_inquiry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfd_sp_editor=sfd_shared_preferences.edit();

                //inquiryDataPass.thali_category = thalidetails_number;
                //inquiryDataPass.food_category = foodcatitem_number;
                //Toast.makeText(SingleFoodDeatilsActivity.this, " Thali: "+thalidetails_number+" Categories:"+foodcatitem_number, Toast.LENGTH_SHORT).show();
                //Toast.makeText(SingleFoodDeatilsActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                //ab kya kar na just if me woh number check kar re ga toh woh number chage kar dega 1 se agar 1 hogaya mat woh item add hogaya

                sfd_shared_preferences=getSharedPreferences("MyPREFERENCES",Context.MODE_MULTI_PROCESS);
                int login_c=sfd_shared_preferences.getInt("LoginCounterKey",0);
               if (login_c==1000)
               {
                   if(foodcatitem_number==1)
                   {
                       inquiryDataPass.food_category_ff=1;
                       sfd_sp_editor.putInt("food_item_details_ff",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==2)
                   {
                       inquiryDataPass.food_category_is=2;
                       sfd_sp_editor.putInt("food_item_details_is",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==3)
                   {
                       inquiryDataPass.food_category_cf=3;
                       sfd_sp_editor.putInt("food_item_details_cf",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==4)
                   {
                       inquiryDataPass.food_category_wd=4;
                       sfd_sp_editor.putInt("food_item_details_wd",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==5)
                   {
                       inquiryDataPass.food_category_nvs=5;
                       sfd_sp_editor.putInt("food_item_details_nvs",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==6)
                   {
                       inquiryDataPass.food_category_bs=6;
                       sfd_sp_editor.putInt("food_item_details_bs",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if(foodcatitem_number==7)
                   {
                       inquiryDataPass.food_category_sd=7;
                       sfd_sp_editor.putInt("food_item_details_sd",foodcatitem_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else
                   {
                    /*inquiryDataPass.food_category_sd=0;
                    inquiryDataPass.food_category_bs=0;
                    inquiryDataPass.food_category_nvs=0;
                    inquiryDataPass.food_category_wd=0;
                    inquiryDataPass.food_category_cf=0;
                    inquiryDataPass.food_category_is=0;
                    inquiryDataPass.food_category_ff=0;*/

                       Log.e("Error","Error");
                   }

                /*public static int thali_category_BT = 0;
                public static int thali_category_IT = 0;
                public static int thali_category_NT = 0;
                public static int thali_category_MT = 0;

                public static int thali_category_PARTT = 0;
                public static int thali_category_SIT = 0;
                public static int thali_category_PT = 0;*/

                   if (thalidetails_number==11)
                   {
                       inquiryDataPass.thali_category_BT=11;
                       sfd_sp_editor.putInt("food_item_details_thali_bt",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==12)
                   {
                       inquiryDataPass.thali_category_IT=12;
                       sfd_sp_editor.putInt("food_item_details_thali_it",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==13)
                   {
                       inquiryDataPass.thali_category_NT=13;
                       sfd_sp_editor.putInt("food_item_details_thali_nt",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==14)
                   {
                       inquiryDataPass.thali_category_MT=14;
                       sfd_sp_editor.putInt("food_item_details_thali_mt",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==15)
                   {
                       inquiryDataPass.thali_category_PARTT=15;
                       sfd_sp_editor.putInt("food_item_details_thali_partt",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==16)
                   {
                       inquiryDataPass.thali_category_SIT=16;
                       sfd_sp_editor.putInt("food_item_details_thali_sit",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else if (thalidetails_number==17)
                   {
                       inquiryDataPass.thali_category_PT=17;
                       sfd_sp_editor.putInt("food_item_details_thali_pt",thalidetails_number);
                       sfd_sp_editor.commit();
                       sfd_sp_editor.apply();
                   }
                   else
                   {
                    /*inquiryDataPass.thali_category_BT=0;
                    inquiryDataPass.thali_category_IT=0;
                    inquiryDataPass.thali_category_NT=0;
                    inquiryDataPass.thali_category_MT=0;
                    inquiryDataPass.thali_category_PARTT=0;
                    inquiryDataPass.thali_category_SIT=0;
                    inquiryDataPass.thali_category_PT=0;*/
                       Log.e("Error","Error");
                   }
                   Toast.makeText(SingleFoodDeatilsActivity.this, "Item is Added in Your Inquiry", Toast.LENGTH_SHORT).show();

               }
               else
               {
                   Toast.makeText(SingleFoodDeatilsActivity.this, "To use this Feature you need to LOGIN first", Toast.LENGTH_SHORT).show();
               }



            }
        });







    }
}