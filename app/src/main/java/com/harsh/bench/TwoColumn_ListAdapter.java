package com.harsh.bench;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoColumn_ListAdapter extends ArrayAdapter<User> {
    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public TwoColumn_ListAdapter(Context contex, int textViewResourceId, ArrayList<User> users) {
        super(contex, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (users != null) {
            TextView sc = (TextView) convertView.findViewById(R.id.textScore);
            TextView ti = (TextView) convertView.findViewById(R.id.textTime);
            if (sc != null) {
                sc.setText((user.getScore()));
            }
            if (ti != null) {
                ti.setText((user.getTime()));
            }
        }
        return convertView;
    }
}
