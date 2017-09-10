package com.micha.example.ui.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.micha.example.Manifest;
import com.micha.example.R;

public class HelpLoading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_loading);

        Intent intent = getIntent();
        int help_code = intent.getIntExtra(CallForHelp.EXTRA_HELP_CODE, 0);

        // Display profile info


        // Make call to 911
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("4695447925"));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            return;

        startActivity(phoneIntent);
    }
}
