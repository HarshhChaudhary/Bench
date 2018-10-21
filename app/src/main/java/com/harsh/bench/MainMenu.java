package com.harsh.bench;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private CardView benchmark, history, aboutPhone, settings, contactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        benchmark = (CardView) findViewById(R.id.benchamrk);
        history = (CardView) findViewById(R.id.history);
        aboutPhone = (CardView) findViewById(R.id.about_phone);
        settings = (CardView) findViewById(R.id.settings);
        contactUs = (CardView) findViewById(R.id.contact_us);
        benchmark.setOnClickListener(this);
        history.setOnClickListener(this);
        aboutPhone.setOnClickListener(this);
        settings.setOnClickListener(this);
        contactUs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.benchamrk:
                i = new Intent(this, Benchmark.class);
                startActivity(i);
                break;

            case R.id.history:
                i = new Intent(this, History.class);
                startActivity(i);
                break;

            case R.id.about_phone:
                i = new Intent(this, AboutPhone.class);
                startActivity(i);
                break;

            case R.id.settings:
                i = new Intent(this, Settings.class);
                startActivity(i);
                break;

            case R.id.contact_us:
                i = new Intent(this, ContactUs.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainMenu.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
