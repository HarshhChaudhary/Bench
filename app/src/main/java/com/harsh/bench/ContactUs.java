package com.harsh.bench;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }
    public void onClick(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","email@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "hi");
        intent.putExtra(Intent.EXTRA_TEXT, "hi");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
}
