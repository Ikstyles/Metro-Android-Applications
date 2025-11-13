package com.example.signuploginrealtime;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainShortest extends AppCompatActivity {
//
//    private Graph_M metroGraph;
//
//    private void launchResultActivity(String result) {
//        Intent intent = new Intent(MainShortest.this, ResultActivity.class);
//        intent.putExtra("RESULT", result);
//        startActivity(intent);
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mainn);
//
//        // Initialize Graph_M and load metro map data
//        metroGraph = new Graph_M();
//        metroGraph.loadMetroMapData();
//
//        // Find views from XML layout
//        EditText sourceEditText = findViewById(R.id.sourceEditText);
//        EditText destinationEditText = findViewById(R.id.destinationEditText);
//        Button listStationsButton = findViewById(R.id.listStationsButton);
//        Button displayMapButton = findViewById(R.id.displayMapButton);
//        Button findShortestDistanceButton = findViewById(R.id.findShortestDistanceButton);
//        Button findShortestTimeButton = findViewById(R.id.findShortestTimeButton);
//        Button findShortestPathDistanceButton = findViewById(R.id.findShortestPathDistanceButton);
//        Button findShortestPathTimeButton = findViewById(R.id.findShortestPathTimeButton);
//        TextView resultTextView = findViewById(R.id.resultTextView);
//
//        listStationsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String stationList = metroGraph.listAllStations();
//                resultTextView.setText(stationList);
//            }
//        });
//
//        displayMapButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mapData = metroGraph.display_Map();
//                resultTextView.setText(mapData);
//            }
//        });
//
//        findShortestDistanceButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String source = sourceEditText.getText().toString();
//                String destination = destinationEditText.getText().toString();
//                String shortestDistance = metroGraph.Get_Minimum_Distance(source, destination);
//                launchResultActivity(shortestDistance);
//            }
//        });
//
//        findShortestTimeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String source = sourceEditText.getText().toString();
//                String destination = destinationEditText.getText().toString();
//                String shortestTime = metroGraph.Get_Minimum_Time(source, destination);
//                launchResultActivity(shortestTime);
//            }
//        });
//
//        findShortestPathDistanceButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String source = sourceEditText.getText().toString();
//                String destination = destinationEditText.getText().toString();
//                String shortestPathDistance = metroGraph.findShortestPathDistance(source, destination);
//                launchResultActivity(shortestPathDistance);
//            }
//        });
//
//
//        findShortestPathTimeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String source = sourceEditText.getText().toString();
//                String destination = destinationEditText.getText().toString();
//                String shortestPathTime = metroGraph.findShortestPathTime(source, destination);
//                launchResultActivity(shortestPathTime);
//            }
//        });
//    }
//}


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainShortest extends AppCompatActivity {

    private Graph_M metroGraph;
    private ListView resultListView;
    private CustomArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);

        // Initialize Graph_M and load metro map data
        metroGraph = new Graph_M();
        metroGraph.loadMetroMapData();

        // Find views from XML layout
        EditText sourceEditText = findViewById(R.id.sourceEditText);
        EditText destinationEditText = findViewById(R.id.destinationEditText);
        Button listStationsButton = findViewById(R.id.listStationsButton);
        Button displayMapButton = findViewById(R.id.displayMapButton);
        Button findShortestDistanceButton = findViewById(R.id.findShortestDistanceButton);
        Button findShortestTimeButton = findViewById(R.id.findShortestTimeButton);
        Button findShortestPathDistanceButton = findViewById(R.id.findShortestPathDistanceButton);
        Button findShortestPathTimeButton = findViewById(R.id.findShortestPathTimeButton);
        resultListView = findViewById(R.id.resultListView);

        // Set background color or divider for the ListView
        //resultListView.setBackgroundColor(Color.WHITE);
        //resultListView.setDividerHeight(2);
        //resultListView.setDivider(ContextCompat.getDrawable(this, R.drawable.list_divider));

        // Initialize custom adapter
        adapter = new CustomArrayAdapter(this, R.layout.list_item_layout, new ArrayList<>());
        resultListView.setAdapter(adapter);


        listStationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stationList = metroGraph.listAllStations();
                // Assuming result is a list of strings
                String[] resultArray = stationList.split("\n"); // Change delimiter as per your data
                // Create an adapter with the array of stations
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainShortest.this, android.R.layout.simple_list_item_1, resultArray);
                // Set the adapter to the ListView
                resultListView.setAdapter(adapter);
                // Clear the adapter and add the station list to the ListView
//                adapter.clear();
//                adapter.addAll(resultArray);
//                adapter.notifyDataSetChanged();
            }
        });

        displayMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapData = metroGraph.display_Map();
                // Assuming result is a list of strings
                String[] resultArray = mapData.split(","); // Change delimiter as per your data
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainShortest.this, android.R.layout.simple_list_item_1, resultArray);
                // Set the adapter to the ListView
                resultListView.setAdapter(adapter);
                // Clear the adapter and add the station list to the ListView
//                adapter.clear();
//                adapter.addAll(resultArray);
//                adapter.notifyDataSetChanged();
            }
        });



        findShortestDistanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = sourceEditText.getText().toString();
                String destination = destinationEditText.getText().toString();

                // Check if source or destination is empty
                if (source.isEmpty() || destination.isEmpty()) {
                    if (source.isEmpty()) {
                        sourceEditText.setError("Source cannot be empty");
                    }
                    if (destination.isEmpty()) {
                        destinationEditText.setError("Destination cannot be empty");
                    }
                    return;
                }

                try {
                    String shortestDistance = metroGraph.Get_Minimum_Distance(source, destination);
                    displayResult(shortestDistance);
                } catch (Exception e) {
                    Toast.makeText(MainShortest.this, "Invalid source or destination", Toast.LENGTH_SHORT).show();
                    sourceEditText.setError("Invalid source");
                    destinationEditText.setError("Invalid destination");
                    e.printStackTrace(); // Log the exception for debugging purposes
                }
            }
        });


        findShortestTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = sourceEditText.getText().toString();
                String destination = destinationEditText.getText().toString();

                // Check if source or destination is empty
                if (source.isEmpty() || destination.isEmpty()) {
                    if (source.isEmpty()) {
                        sourceEditText.setError("Source cannot be empty");
                    }
                    if (destination.isEmpty()) {
                        destinationEditText.setError("Destination cannot be empty");
                    }
                    return;
                }

                try {
                    String shortestTime = metroGraph.Get_Minimum_Time(source, destination);
                    displayResult(shortestTime);
                } catch (Exception e) {
                    sourceEditText.setError("Invalid source");
                    destinationEditText.setError("Invalid destination");
                    e.printStackTrace(); // Log the exception for debugging purposes
                }
            }
        });

        findShortestPathDistanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = sourceEditText.getText().toString();
                String destination = destinationEditText.getText().toString();

                // Check if source or destination is empty
                if (source.isEmpty() || destination.isEmpty()) {
                    if (source.isEmpty()) {
                        sourceEditText.setError("Source cannot be empty");
                    }
                    if (destination.isEmpty()) {
                        destinationEditText.setError("Destination cannot be empty");
                    }
                    return;
                }

                try {
                    String shortestPathDistance = metroGraph.findShortestPathDistance(source, destination);
                    displayResult(shortestPathDistance);
                } catch (Exception e) {
                    sourceEditText.setError("Invalid source");
                    destinationEditText.setError("Invalid destination");
                    e.printStackTrace(); // Log the exception for debugging purposes
                }
            }
        });

        findShortestPathTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = sourceEditText.getText().toString();
                String destination = destinationEditText.getText().toString();

                // Check if source or destination is empty
                if (source.isEmpty() || destination.isEmpty()) {
                    if (source.isEmpty()) {
                        sourceEditText.setError("Source cannot be empty");
                    }
                    if (destination.isEmpty()) {
                        destinationEditText.setError("Destination cannot be empty");
                    }
                    return;
                }

                try {
                    String shortestPathTime = metroGraph.findShortestPathTime(source, destination);
                    displayResult(shortestPathTime);
                } catch (Exception e) {
                    sourceEditText.setError("Invalid source");
                    destinationEditText.setError("Invalid destination");
                    e.printStackTrace(); // Log the exception for debugging purposes
                }
            }
        });
        //return false;
    }

    private void displayResult(String result) {
        // Assuming result is a list of strings
        String[] resultArray = result.split("\n"); // Change delimiter as per your data
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("resultArray", resultArray);
        startActivity(intent);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultArray);
//        adapter.clear();
//        adapter.addAll(resultArray);
//        adapter.notifyDataSetChanged();
//        resultListView.setAdapter(adapter);
        // Pass data to ResultActivity

    }

}

