package com.harsh.bench;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_phone);
        ListView listView_aboutphone = (ListView) findViewById(R.id.list_aboutphone);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        String[] properties = {"Locale: " + getResources().getConfiguration().locale.toString(),
                "Board: " + Build.BOARD, "Brand: " + Build.BRAND, "Codename: " + Build.DEVICE,
                "Model: " + Build.MODEL, "Product: " + Build.PRODUCT, "TAGS: " + Build.TAGS,
                "Build release " + Build.VERSION.RELEASE + ", Inc: '" + Build.VERSION.INCREMENTAL
                        + "'",
                "Display build: " + Build.DISPLAY, "Finger print: " + Build.FINGERPRINT,
                "Build ID: " + Build.ID, "Time: " + Build.TIME, "Type: " + Build.TYPE,
                "User: " + Build.USER, "density: " + metrics.density,
                "densityDpi: " + metrics.densityDpi, "scaledDensity: " + metrics.scaledDensity,
                "xdpi: " + metrics.xdpi, "ydpi: " + metrics.ydpi,
                "DENSITY_DEFAULT: " + DisplayMetrics.DENSITY_DEFAULT,
                "DENSITY_LOW: " + DisplayMetrics.DENSITY_LOW,
                "DENSITY_MEDIUM: " + DisplayMetrics.DENSITY_MEDIUM,
                "DENSITY_HIGH: " + DisplayMetrics.DENSITY_HIGH,
                "heightPixels: " + metrics.heightPixels, "widthPixels: " + metrics.widthPixels};
        ArrayAdapter adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, properties);
        listView_aboutphone.setAdapter(adapter);

    }
}
