package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewAllThaliActivity extends AppCompatActivity {


    private static final String URL_PRODUCTS ="https://preetojhadatabasetrail.000webhostapp.com/catering_project/fetch_thali_data.php";
    List<ModelClass> thalis_data_list;

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView_viewallthali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_thali);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_viewallthali);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Order By Thali");

        recyclerView_viewallthali=(RecyclerView)findViewById(R.id.recyclerview_view_all_Thali);
        recyclerView_viewallthali.setHasFixedSize(true);
        recyclerView_viewallthali.setLayoutManager(new LinearLayoutManager(this));

        thalis_data_list = new ArrayList<>();

        loadThalisData();

        /*
        viewallthali_title = new ArrayList<>();
        viewallthali_sub_title = new ArrayList<>();
        viewallthali_img  = new ArrayList<>();

        viewallthali_title.add("Basic Thali");
        viewallthali_title.add("Indian Thali");
        viewallthali_title.add("Nawab Thali");

        viewallthali_title.add("Maharaja Thali");
        viewallthali_title.add("Party Thali");
        viewallthali_title.add("South Indian Thali");
        viewallthali_title.add("Punjabi Thali ");

        viewallthali_sub_title.add("2 Types of Subzi, 1 Types of Bread, 1 Types of Salad, 1 Types of Kadhi, 1 Types of Rice, 2 Types Of Aachar");
        viewallthali_sub_title.add("1 Types of Sweet, 3 Types of Subzi, 2 Types of Bread, Multiple Option of Papad, Raita, 2 Types of Salad, 2 Types of Dal, 1 Types of Rice");
        viewallthali_sub_title.add("2 Types of Veg Subzi, 1 Types of Non-Veg Subzi, 2 Types of Dal,  1 Types of Rice, Raita,  1 Types of Chatani, 3 Types of Bread");
        viewallthali_sub_title.add("2 Types of Sweets, 3 Types of Subji, 2 Types of Farshan, 2 Types of Chatni, 3 Types of Salad, 2 Types of Rayta, 2 Types of Dal, 2 Types of Rice, 4 Types of Bread");

        viewallthali_sub_title.add("1 Types of Sweet, 2 Types of Subzi, 3 Types of Bread, 2 Types of Salad, 3 Types of Aachar, 1 Types of Rayta");
        viewallthali_sub_title.add("1 Types of Sweet, 1 Types of Idli, 1 Types of Dosa, Sambhar Dal, 2 Types of Chatni, 1 Types of Rice, Dahi");
        viewallthali_sub_title.add("2 Types of Sweet, 2 Types of Subji, 2 Types of Bread, 2 Types of Dal, 1 Types of Rice, 2 Types of Salad, Papad, 1 Types of Raita");

        viewallthali_img.add(R.drawable.basic_thali);
        viewallthali_img.add(R.drawable.india_thali);
        viewallthali_img.add(R.drawable.delux_thali);
        viewallthali_img.add(R.drawable.maha_raja);

        viewallthali_img.add(R.drawable.party_thali);
        viewallthali_img.add(R.drawable.south_thali);
        viewallthali_img.add(R.drawable.punjabi_thali);
        //viewallthali_img.add(R.drawable.chinese);

        recyclerViewAdapter=new RecyclerViewAdapter(viewallthali_title,viewallthali_sub_title,viewallthali_img,this,50);
        recyclerView_viewallthali.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_viewallthali.setAdapter(recyclerViewAdapter);
        */




    }

    private void loadThalisData()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject thalis_data_obj = array.getJSONObject(i);

                        //adding the product to product list
                        thalis_data_list.add(new ModelClass(
                                thalis_data_obj.getInt("thali_id"),
                                thalis_data_obj.getString("thali_name"),
                                thalis_data_obj.getString("thali_desc"),
                                thalis_data_obj.getString("thali_img_link")

                        ));
                    }
                    /*ProductsAdapter adapter = new ProductsAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(adapter);*/

                    recyclerViewAdapter = new RecyclerViewAdapter(ViewAllThaliActivity.this, thalis_data_list,50);
                    recyclerView_viewallthali.setAdapter(recyclerViewAdapter);


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