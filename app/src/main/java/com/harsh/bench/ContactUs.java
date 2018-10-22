package com.harsh.bench;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cu_gmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "17it012@charusat.edu.in", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "µBench");
                intent.putExtra(Intent.EXTRA_TEXT, "Your Queries:");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                break;

            case R.id.cu_telegram:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.t.me/cn_mido/")));
                break;
            case R.id.cu_share:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_TEXT, "I found this amazing app to Benchmark " +
                        "your Android Device. https://harshhchaudhary.github.io/");
                startActivity(Intent.createChooser(intent1, "Share with"));
        }
    }
}
