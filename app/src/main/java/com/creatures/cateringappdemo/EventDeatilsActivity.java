package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDeatilsActivity extends AppCompatActivity {


    TextView event_det_textview_heading,event_det_textview_items,event_det_textview_counters,event_det_textview_money;
    ImageView singleeventdetails_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_deatils);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_single_event_deatils);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Event Details");

        event_det_textview_heading=(TextView) findViewById(R.id.textview_heading_single_eventdeatils);
        event_det_textview_items=(TextView) findViewById(R.id.textview_items_single_eventdeatils);
        event_det_textview_counters=(TextView) findViewById(R.id.textview_counters_single_eventdeatils);
        event_det_textview_money=(TextView) findViewById(R.id.textview_money_single_eventdeatils);

        singleeventdetails_imageview=(ImageView) findViewById(R.id.image_view_single_event_details);

        int event_counter = getIntent().getExtras().getInt("event_item");

        if (event_counter == 31)
        {
            event_det_textview_heading.setText("Reception Ceremony");
            event_det_textview_items.setText("Indian Thali, 5 Indian Staters, 3 Sweet Dish");
            event_det_textview_counters.setText("Total 10 Counter");
            event_det_textview_money.setText("Approx Budget is 800 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.eeception);
        }
        else if (event_counter == 32)
        {
            event_det_textview_heading.setText("Engagement Ceremony");
            event_det_textview_items.setText("Basic Thali, 2 Indian Staters, 1 Sweet Dish");
            event_det_textview_counters.setText("Total 8 Counter");
            event_det_textview_money.setText("Approx Budget is 700 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.engagement);

        }
        else if (event_counter == 33)
        {
            event_det_textview_heading.setText("Birthday Party");
            event_det_textview_items.setText("Party Thali, 5 Indian Staters, 3 Sweet Dish");
            event_det_textview_counters.setText("Total 6 Counter");
            event_det_textview_money.setText("Approx Budget is 500 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.party);
        }
        else if (event_counter == 34)
        {
            event_det_textview_heading.setText("Wedding Ceremony");
            event_det_textview_items.setText("Indian Thali,Maharaja Thali, 6 Indian Staters, 4 Sweet Dish");
            event_det_textview_counters.setText("Total 15 Counter");
            event_det_textview_money.setText("Approx Budget is 800 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.wedding);
        }
        else if (event_counter == 35)
        {
            event_det_textview_heading.setText("Corporate Event");
            event_det_textview_items.setText("5 Indian Staters, 3 Sweet Dish");
            event_det_textview_counters.setText("Total 3 Counter");
            event_det_textview_money.setText("Approx Budget is 400 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.corporate);
        }
        else if (event_counter == 36)
        {
            event_det_textview_heading.setText("Inauguration Ceremony");
            event_det_textview_items.setText("Deluxe Thali, 5 Indian Staters, 3 Sweet Dish");
            event_det_textview_counters.setText("Total 4 Counter");
            event_det_textview_money.setText("Approx Budget is 500 Person");
            singleeventdetails_imageview.setImageResource(R.drawable.inauguration);
        }
        else
        {
            Log.e("Error","Error");
        }
    }
}