package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView event_recyclerView;

    List<String> event_title;
    List<Integer> event_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_event);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Evnets");

        event_recyclerView=(RecyclerView)findViewById(R.id.event_recycler_view);

        event_title = new ArrayList<>();
        event_img = new ArrayList<>();


        event_title.add("Reception Ceremony");
        event_title.add("Engagement Ceremony");

        event_title.add("Birthday Party");
        event_title.add("Wedding Ceremony");
        event_title.add("Corporate Event");
        event_title.add("Inauguration Ceremony");


        event_img.add(R.drawable.eeception);
        event_img.add(R.drawable.engagement);

        event_img.add(R.drawable.party);
        event_img.add(R.drawable.wedding);
        event_img.add(R.drawable.corporate);
        event_img.add(R.drawable.inauguration);



        recyclerViewAdapter=new RecyclerViewAdapter(event_title,event_img,this,30);
        event_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        event_recyclerView.setAdapter(recyclerViewAdapter);






    }
}