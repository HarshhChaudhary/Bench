package com.harsh.bench;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Benchmark extends AppCompatActivity {
    Long timestart, testtime;
    String test_string = "A Quick Brown Fox jumped over the lazy Dog.";
    Integer score, s;
    Double time, t;
    int acc = 100000;
    DatabaseHelper mDatabaseHelper;
    private TextView c1_status, c1_score, c1_time, c2_status, c2_score, c2_time, c3_status,
            c3_score, c3_time, c4_status, c4_score, c4_time, c_totalscore, c_totaltime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmark);
        c1_status = (TextView) findViewById(R.id.test1_status);
        c1_score = (TextView) findViewById(R.id.test1_score);
        c1_time = (TextView) findViewById(R.id.test1_time);
        c2_status = (TextView) findViewById(R.id.test2_status);
        c2_score = (TextView) findViewById(R.id.test2_score);
        c2_time = (TextView) findViewById(R.id.test2_time);
        c3_status = (TextView) findViewById(R.id.test3_status);
        c3_score = (TextView) findViewById(R.id.test3_score);
        c3_time = (TextView) findViewById(R.id.test3_time);
        c4_status = (TextView) findViewById(R.id.test4_status);
        c4_score = (TextView) findViewById(R.id.test4_score);
        c4_time = (TextView) findViewById(R.id.test4_time);
        c_totalscore = (TextView) findViewById(R.id.totalscore);
        c_totaltime = (TextView) findViewById(R.id.totaltime);
        mDatabaseHelper = new DatabaseHelper(this);
    }

    public void onClick(View view) {
        calcScore();
    }

    public void AddData(String sc, String ti) {
        boolean insertData = mDatabaseHelper.addData(sc, ti);
        if (insertData == true) {
            toastMessage("Success!");
        } else {
            toastMessage("Failed!");
        }
    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void calcScore() {
        s = 0;
        t = 0.0;
        Tests tests = new Tests(test_string);
        timestart = System.nanoTime();
        for (Integer i = 0; i < acc; i++) {
            tests.SH1Encryption();
        }
        testtime = System.nanoTime() - timestart;

        time = (double) (testtime) / 1000000000;
        score = Math.round(testtime / 1000000);
        score = 3000 - score;
        c1_status.setText("Success!");
        c1_score.setText(score.toString());
        c1_time.setText(new DecimalFormat("##.#").format(time) + " s");
        s = s + score;
        t = t + time;

        timestart = System.nanoTime();
        for (Integer i = 0; i < acc; i++) {
            tests.MD5Encrypation();
        }
        testtime = System.nanoTime() - timestart;

        time = (double) (testtime) / 1000000000;
        score = Math.round(testtime / 1000000);
        score = 3000 - score;
        c2_status.setText("Success!");
        c2_score.setText(score.toString());
        c2_time.setText(new DecimalFormat("##.#").format(time) + " s");
        s = s + score;
        t = t + time;

        timestart = System.nanoTime();
        for (Integer i = 0; i < acc; i++) {
            tests.SHA256Encryption();
        }
        testtime = System.nanoTime() - timestart;

        time = (double) (testtime) / 1000000000;
        score = Math.round(testtime / 1000000);
        score = 3000 - score;
        c3_status.setText("Success!");
        c3_score.setText(score.toString());
        c3_time.setText(new DecimalFormat("##.#").format(time) + " s");
        s = s + score;
        t = t + time;

        timestart = System.nanoTime();
        for (Integer i = 0; i < acc; i++) {
            tests.primeNumber(i);
        }
        testtime = System.nanoTime() - timestart;

        time = (double) (testtime) / 1000000000;
        score = Math.round(testtime / 1000000);
        score = 3000 - score;
        c4_status.setText("Success!");
        c4_score.setText(score.toString());
        c4_time.setText(new DecimalFormat("##.#").format(time) + " s");
        s = s + score;
        t = t + time;
        s = s / 4;

        c_totalscore.setText(s.toString());
        c_totaltime.setText(new DecimalFormat("##.#").format(t) + " s");
        AddData("Score: " + s, "Time Taken: " +
                new DecimalFormat("##.#").format(t) + " s");
    }
}

