package com.example.julian.callforhelp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpLoading extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_loading);

        // Retrieve help code data to identify which type of aid is required
        Intent intent = getIntent();
        int help_code = intent.getIntExtra(HelpCall.EXTRA_HELP_CODE, 0);


        // Display profile info of rescuer
        TextView profile = (TextView) findViewById(R.id.textView2);





        // Make call to 911 -- for now Michael's phone
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("4695447925"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            return;

        startActivity(phoneIntent);
    }
}
