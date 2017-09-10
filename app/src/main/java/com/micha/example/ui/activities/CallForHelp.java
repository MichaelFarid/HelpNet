package com.micha.example.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.micha.example.R;

public class CallForHelp extends AppCompatActivity {

    public static final String EXTRA_HELP_CODE = "com.micha.example.ui.activities.HELP_CODE";
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_for_help);
    }
    public static void startActivity(Context context, int flags) {
        Intent intent = new Intent(context, CallForHelp.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }

    public void requestAid(View view)
    {
        int help_code = 0;
        Intent intent = new Intent(this, HelpLoading.class);

        switch(view.getId())
        {
            case R.id.cpr_aed_b:
                help_code = 1;
                break;
            case R.id.epi_b:
                help_code = 2;
                break;
            case R.id.ins_b:
                help_code = 3;
                break;
            case R.id.od_b:
                help_code = 4;
                break;
        }

        intent.putExtra(EXTRA_HELP_CODE, help_code);
        startActivity(intent);
    }


    public void chatRoom(View view)
    {
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
        UserListingActivity.startActivity(this);
    }
}
