package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ContactUsActivity extends AppCompatActivity {

    LinearLayout contact_us_mail_ll,contact_us_phone_ll,contact_us_add_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        contact_us_mail_ll=(LinearLayout) findViewById(R.id.contact_us_mail);
        contact_us_phone_ll=(LinearLayout) findViewById(R.id.contact_us_phone);
        contact_us_add_ll=(LinearLayout) findViewById(R.id.contact_us_address);

        //call kare ga
        contact_us_phone_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+1234678909));
                startActivity(callIntent);
            }
        });

        String subject="Inquiry Mail";
        String message="This is an Inquiry Mail to know we are inquiry about your firm";
        String to ="cateringapplication@gmail.com";

        //mail jaaye ga
        contact_us_mail_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, to);
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


    }
}