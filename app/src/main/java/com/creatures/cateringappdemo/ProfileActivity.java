package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.regex.Pattern;

public class ProfileActivity extends AppCompatActivity {

    TextInputEditText tiet_pro_uname,tiet_pro_email,tiet_pro_number,tiet_pro_password;
    TextView pro_title_textview;

    SharedPreferences pro_shared_preferences;
    Button profile_update_btn;

    String name,mail,number,password,id;

    ProgressBar profile_progress_bar;

    public static final Pattern mobile_Pattern = Pattern.compile("[0-9]{10}");
    public static final Pattern email_Pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
    public static final Pattern password_Pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{6,15}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Profile");

        tiet_pro_uname=(TextInputEditText) findViewById(R.id.text_input_edit_text_profile_user_name);
        tiet_pro_email=(TextInputEditText) findViewById(R.id.text_input_edit_text_profile_user_mail);
        tiet_pro_number=(TextInputEditText) findViewById(R.id.text_input_edit_text_profile_user_mobile);
        tiet_pro_password=(TextInputEditText) findViewById(R.id.text_input_edit_text_profile_user_password);

        profile_update_btn=(Button)findViewById(R.id.profile_update_button);

        pro_title_textview=(TextView)findViewById(R.id.text_view_username_profile_title);

        profile_progress_bar=(ProgressBar)findViewById(R.id.progress_bar_profile);
        profile_progress_bar.setVisibility(View.GONE);

        pro_shared_preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_MULTI_PROCESS);



        id=pro_shared_preferences.getString("userIdKey",null);
        name=pro_shared_preferences.getString("nameKey",null);
        mail=pro_shared_preferences.getString("emailKey",null);
        number=pro_shared_preferences.getString("phoneKey",null);
        password=pro_shared_preferences.getString("passwordKey",null);

        pro_title_textview.setText(name);
        tiet_pro_uname.setText(name);
        tiet_pro_email.setText(mail);
        tiet_pro_number.setText(number);
        tiet_pro_password.setText(password);


        profile_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String new_uname,new_mail,new_number,new_password;

                new_uname=tiet_pro_uname.getText().toString().trim();
                new_mail=tiet_pro_email.getText().toString().trim();
                new_number=tiet_pro_number.getText().toString().trim();
                new_password=tiet_pro_password.getText().toString().trim();

                if (new_uname.equals(name) && new_mail.equals(mail) && new_number.equals(number) && new_password.equals(password))
                {
                    Toast.makeText(ProfileActivity.this, "Update Not Detected", Toast.LENGTH_SHORT).show();
                }
                else if (new_uname.isEmpty() || new_uname.equals(" ") || new_number.isEmpty() || new_number.equals(" ") || password.isEmpty() || password.equals(" ") )
                {
                    if (new_uname.isEmpty() || new_uname.equals(" "))
                    {
                        tiet_pro_uname.setError("Enter Usernmae");
                    }

                    if (new_mail.isEmpty() || new_mail.equals(" "))
                    {
                        tiet_pro_email.setError("Enter Mail ID");
                    }

                    if (new_number.isEmpty() || new_number.equals(" "))
                    {
                        tiet_pro_number.setError("Enter Mobile NO");
                    }

                    if (password.isEmpty() || password.equals(" "))
                    {
                        tiet_pro_password.setError("Enter Password");
                    }

                    Toast.makeText(ProfileActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if(!email_Pattern.matcher(new_mail).matches())
                {
                    tiet_pro_email.setError("Invalid Email Address");
                }
                else if(!mobile_Pattern.matcher(new_number).matches())
                {
                    tiet_pro_number.setError("Invalid Number");
                }
                else if(!password_Pattern.matcher(new_password).matches())
                {
                    tiet_pro_password.setError("Invalid Passw0rd");
                }
                else
                {
                    //Start ProgressBar first (Set visibility VISIBLE)

                    profile_progress_bar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "user_id";
                            field[1] = "username";
                            field[2] = "mobile_no";
                            field[3] = "password";
                            field[4] = "email";
                            //field[3] = "email";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = id;
                            data[1] = new_uname;
                            data[2] = new_number;
                            data[3] = new_password;   //192.168.1.101 http://192.168.64.2/test_login/signup.php http://192.168.64.2/ http://192.168.64.2/new_post_test/post_signup.php http://192.168.64.2/test_login/signup.php
                            data[4] = new_mail;

                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/update_data.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    String result = putData.getResult();
                                    if (result.equals("Data Updated Sucessfully"))
                                    {
                                        Toast.makeText(ProfileActivity.this, ""+result, Toast.LENGTH_SHORT).show();

                                        SharedPreferences.Editor sp_editor = pro_shared_preferences.edit();

                                        sp_editor.putString("nameKey",new_uname);
                                        sp_editor.putString("emailKey",new_mail);
                                        sp_editor.putString("phoneKey",new_number);
                                        sp_editor.putString("passwordKey",new_password);
                                        sp_editor.commit();
                                        sp_editor.apply();

                                        name=pro_shared_preferences.getString("nameKey",null);
                                        mail=pro_shared_preferences.getString("emailKey",null);
                                        number=pro_shared_preferences.getString("phoneKey",null);
                                        password=pro_shared_preferences.getString("passwordKey",null);

                                        pro_title_textview.setText(name);
                                        tiet_pro_uname.setText(name);
                                        tiet_pro_email.setText(mail);
                                        tiet_pro_number.setText(number);
                                        tiet_pro_password.setText(password);
                                        profile_progress_bar.setVisibility(View.GONE);
                                    }
                                    else
                                    {
                                        Toast.makeText(ProfileActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                                        profile_progress_bar.setVisibility(View.GONE);
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