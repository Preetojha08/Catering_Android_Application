package com.creatures.cateringappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {

    LinearLayout contact_us_mail_ll,contact_us_phone_ll,contact_us_add_ll;
    TextView textView_mail,textView_call;
    private static final int REQUEST_CODE_telephony = 101;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String st1 = "tel: 8530680851";
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        contact_us_mail_ll=(LinearLayout) findViewById(R.id.contact_us_mail);
        contact_us_phone_ll=(LinearLayout) findViewById(R.id.contact_us_phone);
        contact_us_add_ll=(LinearLayout) findViewById(R.id.contact_us_address);

        textView_mail=(TextView)findViewById(R.id.text_view_contact_us_mail);
        textView_call=(TextView)findViewById(R.id.text_view_contact_us_call);

        //call kare ga
        contact_us_phone_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               textView_call.callOnClick();
            }
        });

        textView_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();

            }
        });

        String subject="Inquiry Mail";
        String message="This is an Inquiry Mail to know we are inquiry about your firm";
        String to ="cateringapplication@gmail.com";

        //mail jaaye ga
        contact_us_mail_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_mail.callOnClick();
            }
        });

        textView_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] to = new String[1];
                String to_mail = "catering@gmail.com";
                String subject_mail = "Inquiry For Catering Service";
                String message_mail = "This is Users from Android Application of that application.";

                to[0] = to_mail;

                Intent intent_mail = new Intent(Intent.ACTION_SEND);
                intent_mail.setData(Uri.parse("mailto:"));

                intent_mail.putExtra(Intent.EXTRA_EMAIL, to);
                intent_mail.putExtra(Intent.EXTRA_SUBJECT, subject_mail);
                intent_mail.putExtra(Intent.EXTRA_TEXT, message_mail);

                intent_mail.setType("message/rfc822");

                try {
                    startActivity(Intent.createChooser(intent_mail, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }

        switch (requestCode) {
            case REQUEST_CODE_telephony: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted.", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void makePhoneCall() {
        String st1 = "tel: 8530680851";
        String dial = st1;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
    }

}