package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {

    TextInputEditText tiet_pro_uname,tiet_pro_email,tiet_pro_number,tiet_pro_password;
    TextView pro_title_textview;

    SharedPreferences pro_shared_preferences;

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

        pro_title_textview=(TextView)findViewById(R.id.text_view_username_profile_title);

        pro_shared_preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_MULTI_PROCESS);

        String name,mail,number,password;
        int a;

        name=pro_shared_preferences.getString("nameKey",null);
        mail=pro_shared_preferences.getString("emailKey",null);
        number=pro_shared_preferences.getString("phoneKey",null);
        password=pro_shared_preferences.getString("passwordKey",null);

        pro_title_textview.setText(name);
        tiet_pro_uname.setText(name);
        tiet_pro_email.setText(mail);
        tiet_pro_number.setText(number);
        tiet_pro_password.setText(password);



        /*
        name=InquiryDataPass.u_name;
        mail=InquiryDataPass.u_email;
        number=InquiryDataPass.u_mobile_no;
        password=InquiryDataPass.u_password;
         a=InquiryDataPass.profile_activitor;


        if (a==100)
        {
            pro_title_textview.setText(name);
            tiet_pro_uname.setText(name);
            tiet_pro_email.setText(mail);
            tiet_pro_number.setText(number);
            tiet_pro_password.setText(password);
        }
        */




    }
}