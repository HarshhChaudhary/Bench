package com.harsh.bench;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Benchmark extends AppCompatActivity implements View.OnClickListener{
    private TextView c1_status,c1_score,c1_time,c2_status,c2_score,c2_time,c3_status,c3_score,
            c3_time,c4_status,c4_score,c4_time,c_totalscore,c_totaltime;
    String HashValue,MD5Value;
    Long timestart_long,test1time_long,test2time_long,test3time_long,
        test4time_long;
    String test1time_string,test2time_string,test3time_string, test4time_string,totaltime_string,
        test1score_string,test2score_string,test3score_string,test4score_string,totalscore_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmark);
        c1_status=(TextView)findViewById(R.id.test1_status);
        c1_score=(TextView)findViewById(R.id.test1_score);
        c1_time=(TextView)findViewById(R.id.test1_time);
        c2_status=(TextView)findViewById(R.id.test2_status);
        c2_score=(TextView)findViewById(R.id.test2_score);
        c2_time=(TextView)findViewById(R.id.test2_time);
        c3_status=(TextView)findViewById(R.id.test3_status);
        c3_score=(TextView)findViewById(R.id.test3_score);
        c3_time=(TextView)findViewById(R.id.test3_time);
        c4_status=(TextView)findViewById(R.id.test4_status);
        c4_score=(TextView)findViewById(R.id.test4_score);
        c4_time=(TextView)findViewById(R.id.test4_time);
        c_totalscore=(TextView)findViewById(R.id.totalscore);
        c_totaltime=(TextView)findViewById(R.id.totaltime);
    }


    public void SH1Encryption(String test_string)
    {

        MessageDigest mdSh=null;
        try
        {
            mdSh= MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e1) {
            Log.e("Benchmark", "Error initializing SHA1");
        }
        try {
            mdSh.update(test_string.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data=mdSh.digest();
        StringBuffer sh1_stringbuffer = new StringBuffer();
        String hex=null;
        hex = Base64.encodeToString(data, 0, data.length, 0);
        sh1_stringbuffer.append(hex);
        HashValue = sh1_stringbuffer.toString();
    }


    public void MD5Encrypation(String test_string)
    {
        try {
            MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            md5.update(test_string.getBytes());
            byte messageDigest[] = md5.digest();

            StringBuffer md5_stringbuffer = new StringBuffer();
            for(int i=0;i<messageDigest.length; i++)
            {
                String hex=Integer.toHexString(0xFF & messageDigest[i]);
                while (hex.length() < 2)
                    hex="0"+hex;
                md5_stringbuffer.append(hex);
            }
            MD5Value = md5_stringbuffer.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            Log.e("Benchmark", "Error initializing MD5");
        }
    }


    @Override
    public void onClick(View view){
        String test_string="A Quick Brown Fox jumped over the lazy Dog.";
        timestart_long = System.nanoTime();
        for (Integer i = 0; i<40000; i++) {
            SH1Encryption(test_string);
        }
        test1time_long= System.nanoTime()-timestart_long;
        Integer ttr1=Math.round(test1time_long/100000000);
        Double tts1=(double)(ttr1)/10;
        test1time_string = tts1.toString();

        Integer roundnumber = Math.round(test1time_long/1000000);
        test1score_string= roundnumber.toString();
        c1_status.setText("Success!");
        c1_score.setText(test1score_string);
        c1_time.setText(test1time_string+" s");


        timestart_long=System.nanoTime();
        for (Integer i = 0; i<40000; i++) {
            MD5Encrypation(test_string);
        }
        test2time_long=System.nanoTime()-timestart_long;
        Integer ttr2=Math.round(test2time_long/100000000);
        Double tts2=(double)(ttr2)/10;
        test2time_string=tts2.toString();

        Integer roundnumber2 = Math.round(test2time_long/1000000);
        test2score_string=roundnumber2.toString();
        c2_status.setText("Success!");
        c2_score.setText(test2score_string);
        c2_time.setText(test2time_string+" s");

        Double ttt=((double)ttr1/10)+((double)ttr2/10);
        Integer totalscore =(roundnumber+ roundnumber2)/2;
        totalscore_string=totalscore.toString();
        totaltime_string=ttt.toString();
        c_totalscore.setText(totalscore_string);
        c_totaltime.setText(totaltime_string+" s");
    }
}
