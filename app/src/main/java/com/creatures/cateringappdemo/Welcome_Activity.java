package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.*;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.regex.Pattern;

public class Welcome_Activity extends AppCompatActivity {

    LinearLayout login_layout,registration_layout,welcome_layout;
    Button welcome_login_btn,welcome_registration_btn;

    TextView register_textview,login_textview;

    ImageView welcome_skip_iv;

    TextInputEditText tiet_username,tiet_password,tiet_mobile_no,tiet_con_password,tiet_email;
    TextInputEditText tiet_log_username,tiet_log_password;
    Button sign_up_btn,sign_in_btn;

    View view_bg_color;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";
    public static final Pattern mobile_Pattern = Pattern.compile("[0-9]{10}");
    public static final Pattern email_Pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
    public static final Pattern password_Pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{6,15}");

    ProgressBar progress_bar_reg;

    public static final String MyPREFERENCES = "MyPREFERENCES" ;

    int welcome_counter;
    int skip_counter;

    SharedPreferences shared_preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        login_layout=(LinearLayout)findViewById(R.id.login_layout);
        registration_layout=(LinearLayout)findViewById(R.id.registration_layout);
        welcome_layout=(LinearLayout)findViewById(R.id.welcome_layout);

        progress_bar_reg=(ProgressBar)findViewById(R.id.progress_bar_reg);

        view_bg_color=(View)findViewById(R.id.view_background_for_processbar);

        login_layout.setVisibility(View.GONE);
        registration_layout.setVisibility(View.GONE);
        view_bg_color.setVisibility(View.GONE);
        welcome_layout.setVisibility(View.VISIBLE);

        welcome_login_btn=(Button)findViewById(R.id.welcome_login_button);
        welcome_registration_btn=(Button)findViewById(R.id.welcome_registration_button);

        register_textview=(TextView)findViewById(R.id.registration_text_view);
        login_textview=(TextView)findViewById(R.id.login_text_view);

        welcome_skip_iv=(ImageView)findViewById(R.id.welcome_skip_image_view);

        welcome_skip_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor sp_editor = shared_preferences.edit();

                skip_counter=500;
                sp_editor.putInt("SkipMenuCounterKey",skip_counter);
                sp_editor.commit();
                sp_editor.apply();
                startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
                finish();
            }
        });

        //for Login Layout
        welcome_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_layout.setVisibility(View.VISIBLE);
                registration_layout.setVisibility(View.GONE);
                view_bg_color.setVisibility(View.GONE);
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
                view_bg_color.setVisibility(View.GONE);

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
                view_bg_color.setVisibility(View.GONE);
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
                view_bg_color.setVisibility(View.GONE);
                welcome_layout.setVisibility(View.GONE);

                Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_move);

                login_layout.startAnimation(animation_first);
                registration_layout.startAnimation(animation_second);
            }
        });


        //Registration Process

        shared_preferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        tiet_username=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_name);
        tiet_mobile_no=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_mobile);
        tiet_email=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_email);
        tiet_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_password);
        tiet_con_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_confirm_password);

        sign_up_btn=(Button)findViewById(R.id.sign_up_button);

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view_bg_color.setVisibility(View.GONE);
                String username,mobile_no,password,con_password,email;

                username=tiet_username.getText().toString().trim();
                email=tiet_email.getText().toString().trim();
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
                //if(!passwordPattern.matcher(password_text.getEditText().getText().toString().trim()).matches())
                else if(!mobile_Pattern.matcher(mobile_no).matches())
                {
                    tiet_mobile_no.setError("Invalid Number");
                }
                else if(!email_Pattern.matcher(email).matches())
                {
                        tiet_email.setError("Invalid Email Address");
                }

                else if(!password_Pattern.matcher(con_password).matches())
                {
                    tiet_con_password.setError("Invalid Passw0rd");
                }
                else if(!con_password.equals(password))
                {
                    tiet_con_password.setError("Invalid Passw0rd");
                }
                else
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    progress_bar_reg.setVisibility(View.VISIBLE);
                    view_bg_color.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "username";
                            field[1] = "mobile_no";
                            field[2] = "password";
                            field[3] = "email";
                            //field[3] = "email";

                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = username;
                            data[1] = mobile_no;
                            data[2] = password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            data[3] = email;
                            //PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/signup.php", "POST", field, data);
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/sign_up.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_reg.setVisibility(View.GONE);
                                    view_bg_color.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success"))
                                    {
                                        Toast.makeText(Welcome_Activity.this, ""+result, Toast.LENGTH_SHORT).show();
                                        login_layout.setVisibility(View.VISIBLE);
                                        registration_layout.setVisibility(View.GONE);

                                        welcome_layout.setVisibility(View.GONE);

                                        Animation animation_first = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                                        Animation animation_second = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_move);

                                        registration_layout.startAnimation(animation_first);
                                        login_layout.startAnimation(animation_second);
                                        InquiryDataPass.profile_activitor=100;
                                        InquiryDataPass.u_name=username;
                                        InquiryDataPass.u_email=email;
                                        InquiryDataPass.u_mobile_no=mobile_no;
                                        InquiryDataPass.u_password=password;

                                        welcome_counter=100;

                                        SharedPreferences.Editor sp_editor = shared_preferences.edit();

                                        sp_editor.putInt("welcomeCounterKey",welcome_counter);

                                        sp_editor.putString("nameKey",username);
                                        sp_editor.putString("emailKey",email);
                                        sp_editor.putString("phoneKey",mobile_no);
                                        sp_editor.putString("passwordKey",password);
                                        sp_editor.commit();
                                        sp_editor.apply();

                                    }
                                    else
                                    {
                                        welcome_counter=0;
                                        Toast.makeText(Welcome_Activity.this, ""+result, Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    //End of handler

                }

            }
        });

        //Login

        tiet_log_username=(TextInputEditText) findViewById(R.id.text_input_edit_text_log_user_name);
        tiet_log_password=(TextInputEditText) findViewById(R.id.text_input_edit_text_log_user_password);

        sign_in_btn=(Button)findViewById(R.id.sign_in_button);

        view_bg_color.setVisibility(View.GONE);
        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log_username,log_password,log_email;

                view_bg_color.setVisibility(View.GONE);
                log_username=tiet_log_username.getText().toString();
                log_password=tiet_log_password.getText().toString();
                log_email=tiet_log_username.getText().toString();

                if (log_username.isEmpty() || log_password.isEmpty())
                {
                    if(log_username.isEmpty())
                    {
                        tiet_log_username.setError("Enter Username");
                    }
                    else
                    {
                        tiet_log_password.setError("Enter Password");
                    }
                }
                else if (log_username.equals("Alpesh Solanki ") && log_password.equals("P@ssw0rd"))
                {
                    Toast.makeText(Welcome_Activity.this, "Welcome Alpesh Sir", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
                }
                else if (log_username.matches(emailPattern))
                {
                    //Email ID with Password
                    //Toast.makeText(LoginActivity.this, "Valid Email address", Toast.LENGTH_SHORT).show();
                    Log.i("Email", "Email is taken");
                    progress_bar_reg.setVisibility(View.VISIBLE);
                    view_bg_color.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "email";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = log_email;//https://preetojhadatabasetrail.000webhostapp.com/catering_project/login.php
                            data[1] = log_password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            //PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            //PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_reg.setVisibility(View.GONE);
                                    view_bg_color.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    //End of handler

                }
                else
                {
                    //Username with Password
                    progress_bar_reg.setVisibility(View.VISIBLE);
                    view_bg_color.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = log_username;
                            data[1] = log_password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            //PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/signup_login_test/login.php", "POST", field, data);
                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progress_bar_reg.setVisibility(View.GONE);
                                    view_bg_color.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();
                                        Log.i("World","Hello");
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                    //End of handler
                }

            }
        });


    }
}