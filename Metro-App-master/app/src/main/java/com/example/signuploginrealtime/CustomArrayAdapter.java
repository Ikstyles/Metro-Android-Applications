package com.example.signuploginrealtime;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<String> {

    public CustomArrayAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.list_item_layout, parent, false);
        }

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(getItem(position));

        // Center the text vertically within the TextView
        textView.setGravity(Gravity.CENTER_VERTICAL);

        return view;
    }
}
