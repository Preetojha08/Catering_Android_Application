package com.creatures.cateringappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
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

    AppCompatButton contact_us_btn;

    SharedPreferences home_shared_preferences;
    SharedPreferences.Editor home_sp_editor;
    public static final String MyPREFERENCES = "MyPREFERENCES" ;
    int logout_counter=0;

    ImageView singleeventdetails_imageview;
    int event_id;
    String event_name,event_Desc,event_ImgLink;
    private static final String URL_PRODUCTS ="https://preetojhadatabasetrail.000webhostapp.com/catering_project/notification_event.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        home_shared_preferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        home_sp_editor = home_shared_preferences.edit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home_portal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Catering App");

        contact_us_btn=(AppCompatButton)findViewById(R.id.direct_contact_us_button);


        rv_food_by_cat=(RecyclerView)findViewById(R.id.recyclerView_food_by_cat);
        rv_book_by_thali=(RecyclerView)findViewById(R.id.recyclerView_book_by_thali);
        tv_viewall_cat=(TextView)findViewById(R.id.tv_view_all_category);
        tv_viewall_thali=(TextView)findViewById(R.id.tv_view_all_thali);

        contact_us_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this,ContactUsActivity.class));
            }
        });

        tv_viewall_thali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this,ViewAllThaliActivity.class));
            }
        });

        tv_viewall_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this,ViewAllCategoriesActivity.class));
            }
        });

        //Food by Cat
        foodbycat_img = new ArrayList<>();
        foodbycat_title = new ArrayList<>();

        foodbycat_title.add("Fast Food");
        foodbycat_title.add("Chinese Food");
        foodbycat_title.add("Welcome Drinks");
        foodbycat_title.add("Non Veg Food");
        foodbycat_title.add("Sweet Dish");

        foodbycat_img.add(R.drawable.fastfood);
        foodbycat_img.add(R.drawable.chinese);
        foodbycat_img.add(R.drawable.drinks);
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

        int skip_c;
        skip_c=home_shared_preferences.getInt("SkipMenuCounterKey",-1);

        if (skip_c==500)
        {
            //Toast.makeText(this, ""+skip_c, Toast.LENGTH_SHORT).show();
            navigationView.inflateMenu(R.menu.skip_nav_home_menu_drawer);
        }
        else
        {
            navigationView.inflateMenu(R.menu.nav_home_menu_drawer);
        }


        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        LoadEventData();

        /////
        NotificationChannel();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);

        if (Calendar.getInstance().after(calendar)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(Home_Activity.this, MemoBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        }
        /////

    }

    ////
    private void NotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CATERINGAPP";
            String description = "CATERINGAPP`S CHANNEL";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Notification", name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
    ////

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


                        event_id=events_data_obj.getInt("event_id");
                        event_name=events_data_obj.getString("event_name");
                        event_Desc=events_data_obj.getString("event_desc");
                        event_ImgLink=events_data_obj.getString("event_img_link");


                        Notification(event_name,event_Desc,event_ImgLink);
                        Log.i("Notification Data","Event Details: "+event_id+" "+event_name+" ");

                    }


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

    public void Notification(String ename,String eventdesc,String imagelink) {
        // Set Notification Title
        String strtitle = ename;
        String strtext = eventdesc;
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.catering_application)
                .setContentTitle(strtitle)
                .setContentText(strtext)
                .addAction(R.drawable.catering_application, "Action Button", pIntent)
                .setContentIntent(pIntent) .setAutoCancel(true);
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationmanager.notify(0, builder.build());
        Log.i("Notification Data 2:","Event Details: "+event_id+" "+event_name+" ");
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.top_menu, menu);

        MenuItem item=menu.findItem(R.id.nav_search);
       *//* SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*//*
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case (R.id.nav_search):
                Toast.makeText(this , "Your Search" , Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        home_shared_preferences=getSharedPreferences("MyPREFERENCES",Context.MODE_MULTI_PROCESS);
        int login_c=home_shared_preferences.getInt("LoginCounterKey",0);

        switch (item.getItemId())
        {
            case (R.id.nav_profile):
                Toast.makeText(this, "Manage Your Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this,ProfileActivity.class));
                break;

            case (R.id.nav_menu):
                Toast.makeText(this, "Choose Your Food", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this,MenuActivity.class));
                break;

            case (R.id.nav_contact_us):
                Toast.makeText(this, "Wide your Network", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this,ContactUsActivity.class));
                break;

            case (R.id.nav_registration):
                Toast.makeText(this, "Register Yourself", Toast.LENGTH_SHORT).show();
                InquiryDataPass.registration_layout++;
                startActivity(new Intent(Home_Activity.this,Welcome_Activity.class));
                finishAffinity();
                break;

            case (R.id.nav_login):
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                InquiryDataPass.login_layout++;
                startActivity(new Intent(Home_Activity.this,Welcome_Activity.class));
                finishAffinity();
                break;

            case (R.id.nav_add_inquiry):
                if (login_c==1000)
                {
                    startActivity(new Intent(Home_Activity.this,AddInquiryActivity.class));
                    break;
                }
                Toast.makeText(this, "To use this Feature you need to LOGIN first", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_logout):
                logout_counter=0;

                home_sp_editor.remove("welcomeCounterKey");
                home_sp_editor.remove("nameKey");
                home_sp_editor.remove("emailKey");
                home_sp_editor.remove("phoneKey");
                home_sp_editor.remove("passwordKey");
                home_sp_editor.remove("SkipMenuCounterKey");

                home_sp_editor.putInt("welcomeCounterKey",logout_counter);
                home_sp_editor.commit();
                home_sp_editor.apply();

                Toast.makeText(this, "Bye, \uD83D\uDC4B\uD83C ", Toast.LENGTH_SHORT).show();
                finish();

                break;

            case (R.id.nav_Events):
                startActivity(new Intent(Home_Activity.this,EventActivity.class));
                break;

            case (R.id.nav_home):
                Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}