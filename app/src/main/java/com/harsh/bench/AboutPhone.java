package com.harsh.bench;

import android.app.ApplicationErrorReport;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_phone);
        ListView listView_aboutphone=(ListView)findViewById(R.id.list_aboutphone);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        String[] properties={"Locale: "+getResources().getConfiguration().locale.toString(),
        "Board: "+android.os.Build.BOARD, "Brand: "+android.os.Build.BRAND,
        "Codename: "+android.os.Build.DEVICE,"Model: "+android.os.Build.MODEL,
         "Product: "+android.os.Build.PRODUCT,"TAGS: "+android.os.Build.TAGS,
        "Build release "+android.os.Build.VERSION.RELEASE + ", Inc: '"+
        android.os.Build.VERSION.INCREMENTAL+"'", "Display build: "+android.os.Build.DISPLAY,
        "Finger print: "+android.os.Build.FINGERPRINT,"Build ID: "+android.os.Build.ID,
        "Time: "+android.os.Build.TIME,"Type: "+android.os.Build.TYPE,
        "User: "+android.os.Build.USER,"density: "+metrics.density,
        "densityDpi: "+metrics.densityDpi,"scaledDensity: "+metrics.scaledDensity,
        "xdpi: "+metrics.xdpi,"ydpi: "+metrics.ydpi,
        "DENSITY_DEFAULT: "+DisplayMetrics.DENSITY_DEFAULT,
        "DENSITY_LOW: "+DisplayMetrics.DENSITY_LOW,
        "DENSITY_MEDIUM: " +DisplayMetrics.DENSITY_MEDIUM,
        "DENSITY_HIGH: "+DisplayMetrics.DENSITY_HIGH, "heightPixels: "+metrics.heightPixels,
        "widthPixels: "+metrics.widthPixels};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listview_aboutphone,properties);
        listView_aboutphone.setAdapter(adapter);

    }
}
