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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Welcome_Activity extends AppCompatActivity {

    LinearLayout login_layout,registration_layout,welcome_layout;
    Button welcome_login_btn,welcome_registration_btn;

    TextView register_textview,login_textview;

    ImageView welcome_skip_iv;

    TextInputEditText tiet_username,tiet_password,tiet_mobile_no,tiet_con_password;
    Button sign_up_btn;

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


        //Registration Process

        tiet_username=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_name);
        tiet_mobile_no=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_mobile);
        tiet_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_password);
        tiet_con_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_confirm_password);

        sign_up_btn=(Button)findViewById(R.id.sign_up_button);

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username,mobile_no,password,con_password;

                username=tiet_username.getText().toString().trim();
                mobile_no=tiet_mobile_no.getText().toString().trim();
                password=tiet_password.getText().toString().trim();
                con_password=tiet_con_password.getText().toString().trim();

                if (username.isEmpty() || username.equals(" ") || mobile_no.isEmpty() || mobile_no.equals(" ") || password.isEmpty() || password.equals(" ") || con_password.isEmpty() || con_password.equals(" "))
                {
                   if (username.isEmpty() || username.equals(" "))
                   {
                       tiet_username.setError("Enter Usernmae");
                   }

                   if (mobile_no.isEmpty() || mobile_no.equals(" "))
                   {
                       tiet_mobile_no.setError("Enter Mobile NO");
                   }

                   if (password.isEmpty() || password.equals(" "))
                   {
                       tiet_password.setError("Enter Password");
                   }

                   if (con_password.isEmpty() || con_password.equals(" "))
                   {
                       tiet_con_password.setError("Enter Password");
                   }

                    Toast.makeText(Welcome_Activity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

                }




            }
        });





    }
}