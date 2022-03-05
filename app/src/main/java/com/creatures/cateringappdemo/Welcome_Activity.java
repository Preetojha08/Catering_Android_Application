package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Welcome_Activity extends AppCompatActivity {

    LinearLayout login_layout,registration_layout,welcome_layout;
    Button welcome_login_btn,welcome_registration_btn;

    TextView register_textview,login_textview;

    ImageView welcome_skip_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        login_layout=(LinearLayout)findViewById(R.id.login_layout);
        registration_layout=(LinearLayout)findViewById(R.id.registration_layout);
        welcome_layout=(LinearLayout)findViewById(R.id.welcome_layout);

        login_layout.setVisibility(View.GONE);
        registration_layout.setVisibility(View.GONE);
        welcome_layout.setVisibility(View.VISIBLE);

        welcome_login_btn=(Button)findViewById(R.id.welcome_login_button);
        welcome_registration_btn=(Button)findViewById(R.id.welcome_registration_button);

        register_textview=(TextView)findViewById(R.id.registration_text_view);
        login_textview=(TextView)findViewById(R.id.login_text_view);

        welcome_skip_iv=(ImageView)findViewById(R.id.welcome_skip_image_view);

        welcome_skip_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
            }
        });

        //for Login Layout
        welcome_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_layout.setVisibility(View.VISIBLE);
                registration_layout.setVisibility(View.GONE);
                welcome_layout.setVisibility(View.GONE);

                Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_move);
                Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right_move);

                welcome_layout.startAnimation(animation_first);
                login_layout.startAnimation(animation_second);

            }
        });

        login_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_layout.setVisibility(View.VISIBLE);
                registration_layout.setVisibility(View.GONE);

                welcome_layout.setVisibility(View.GONE);

                Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_move);

                registration_layout.startAnimation(animation_first);
                login_layout.startAnimation(animation_second);
            }
        });

        //for Registration Layout
        welcome_registration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_layout.setVisibility(View.GONE);
                registration_layout.setVisibility(View.VISIBLE);
                welcome_layout.setVisibility(View.GONE);

                Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_move);
                Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right_move);

                welcome_layout.startAnimation(animation_first);
                registration_layout.startAnimation(animation_second);

            }
        });

        register_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_layout.setVisibility(View.GONE);
                registration_layout.setVisibility(View.VISIBLE);

                welcome_layout.setVisibility(View.GONE);

                Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_move);

                login_layout.startAnimation(animation_first);
                registration_layout.startAnimation(animation_second);
            }
        });




    }
}