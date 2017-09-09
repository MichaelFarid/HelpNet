package com.example.julian.callforhelp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpCall extends AppCompatActivity {

    public static final String EXTRA_HELP_CODE = "com.example.myfirstapp.HELP_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_call);

        Button cpr = (Button) findViewById(R.id.cpr_aed_b);
        Button epi = (Button) findViewById(R.id.epi_b);
        Button ins = (Button) findViewById(R.id.insulin_b);
        Button od = (Button) findViewById(R.id.od_b);
        Button idk = (Button) findViewById(R.id.idk_b);


    }

    public void call(View view)
    {
        int help_code = 0;
        Intent intent = new Intent(this, HelpLoading.class);

        switch(view.getId())
        {
            case R.id.cpr_aed_b:
                // send int value to indicate that cpr/aed requested
                help_code = 1;
                break;
            case R.id.epi_b:
                // send int value to indicate that epipen requested
                help_code = 2;
                break;
            case R.id.insulin_b:
                // send int value to indicate that insulin requested
                help_code = 3;
                break;
            case R.id.od_b:
                // send int value to indicate that od help requested
                help_code = 4;
                break;
            case R.id.idk_b:
                // send int value to indicate that other help requested
                help_code = 5;
                break;
        }

        intent.putExtra(EXTRA_HELP_CODE, help_code);
        startActivity(intent);
    }
}
