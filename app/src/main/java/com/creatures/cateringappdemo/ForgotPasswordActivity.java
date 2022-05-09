package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputEditText tiet_forgot_pass_username,tiet_forgot_pass_user_email,tiet_forgot_pass_user_new_pass,tiet_forgot_pass_user_confirm_pass;

    public static final Pattern email_Pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
    public static final Pattern password_Pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{6,15}");
    Button update_forgotpass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_forgotpassword);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Forgot Password");

        tiet_forgot_pass_username=(TextInputEditText)findViewById(R.id.text_input_edit_text_forgotpass_user_name);
        tiet_forgot_pass_user_email=(TextInputEditText) findViewById(R.id.text_input_edit_text_forgotpass_user_mail);
        tiet_forgot_pass_user_new_pass=(TextInputEditText) findViewById(R.id.text_input_edit_text_forgotpass_user_new_password);
        tiet_forgot_pass_user_confirm_pass=(TextInputEditText) findViewById(R.id.text_input_edit_text_forgotpass_user_con_password);

        update_forgotpass_btn=(Button) findViewById(R.id.button_forgotpass_update_pass);

        update_forgotpass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username,newpass,confirmpass,email;

                username=tiet_forgot_pass_username.getText().toString().trim();
                email=tiet_forgot_pass_user_email.getText().toString().trim();
                newpass=tiet_forgot_pass_user_new_pass.getText().toString().trim();
                confirmpass=tiet_forgot_pass_user_confirm_pass.getText().toString().trim();

                if (username.isEmpty() || username.equals(""))
                {
                    tiet_forgot_pass_username.setError("Enter Username");
                }
                if (email.isEmpty() || email.equals(""))
                {
                    tiet_forgot_pass_user_email.setError("Enter Email ID");
                }
                if (newpass.isEmpty() || newpass.equals(""))
                {
                    tiet_forgot_pass_user_new_pass.setError("Enter New Password");
                }
                if (confirmpass.isEmpty() || confirmpass.equals(""))
                {
                    tiet_forgot_pass_user_confirm_pass.setError("Enter New Password");
                }

                if (!email_Pattern.matcher(email).matches())
                {
                    tiet_forgot_pass_user_email.setError("Enter Valid User Email IS");
                }
                if (!password_Pattern.matcher(newpass).matches())
                {
                    tiet_forgot_pass_user_new_pass.setError("Enter Valid User Password");
                }
                if (!password_Pattern.matcher(confirmpass).matches())
                {
                    tiet_forgot_pass_user_confirm_pass.setError("Enter Valid User Password");
                }
                else
                {

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "username";
                            field[1] = "email";
                            field[2] = "password";

                            //field[3] = "email";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = username;
                            data[1] = email;
                            data[2] = newpass;


                            PutData putData = new PutData("https://preetojhadatabasetrail.000webhostapp.com/catering_project/forgot_password.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    String result = putData.getResult();
                                    if (result.equals("Data Updated Sucessfully"))
                                    {
                                        Toast.makeText(ForgotPasswordActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(ForgotPasswordActivity.this, ""+result, Toast.LENGTH_SHORT).show();
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