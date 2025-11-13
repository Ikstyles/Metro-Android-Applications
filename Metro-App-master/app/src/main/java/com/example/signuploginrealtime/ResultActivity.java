package com.example.signuploginrealtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView resultListView = findViewById(R.id.resultListView);

        // Retrieve data from intent
        String[] resultArray = getIntent().getStringArrayExtra("resultArray");

        // Check if resultArray is null or empty
        if (resultArray == null || resultArray.length == 0) {
            // Show a message indicating no results
            TextView noResultsTextView = findViewById(R.id.noResultsTextView);
            noResultsTextView.setVisibility(View.VISIBLE);
            resultListView.setVisibility(View.GONE);
        } else {
            // Initialize custom adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_layout, resultArray);
            resultListView.setAdapter(adapter);
        }
        //return false;
    }
}
