package com.harsh.bench;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    DatabaseHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        myDB = new DatabaseHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDB.getData();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(History.this, "No Records Found!",
                    Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                user = new User(data.getString(1), data.getString(2));
                userList.add(user);
            }
            TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(this,
                    R.layout.list_adapter_history, userList);
            listView = (ListView) findViewById(R.id.list_history);
            listView.setAdapter(adapter);
        }
    }
}
