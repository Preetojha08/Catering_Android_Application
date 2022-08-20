package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView event_recyclerView;
    List<ModelClass> events_data_list;



    private static final String URL_PRODUCTS ="https://preetojhadatabasetrail.000webhostapp.com/catering_project/fetch_event_data.php";
    ProgressBar progressbar_events_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_event);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   About Evnets");

        event_recyclerView=(RecyclerView)findViewById(R.id.event_recycler_view);

        event_recyclerView.setHasFixedSize(true);
        event_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressbar_events_data=(ProgressBar)findViewById(R.id.spin_kit_progress_bar_events_data);
        Sprite wave = new DoubleBounce();
        progressbar_events_data.setIndeterminateDrawable(wave);
        progressbar_events_data.setVisibility(View.VISIBLE);
        /*

         List<String> event_title;
         List<Integer> event_img;

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

        */

        events_data_list = new ArrayList<>();

        LoadEventData();

    }

    private void LoadEventData()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject events_data_obj = array.getJSONObject(i);

                        //adding the product to product list
                        events_data_list.add(new ModelClass(
                                events_data_obj.getInt("event_id"),
                                events_data_obj.getString("event_name"),
                                events_data_obj.getString("event_img_link")

                        ));
                    }
                    /*ProductsAdapter adapter = new ProductsAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(adapter);*/

                    recyclerViewAdapter = new RecyclerViewAdapter(EventActivity.this, events_data_list,30);
                    event_recyclerView.setAdapter(recyclerViewAdapter);
                    progressbar_events_data.setVisibility(View.GONE);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}