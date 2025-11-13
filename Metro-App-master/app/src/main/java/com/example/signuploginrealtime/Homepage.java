package com.example.signuploginrealtime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.signuploginrealtime.MainShortest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {

    TextView userName;
    Button logout;
    GoogleSignInClient gClient;
    GoogleSignInOptions gOptions;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        logout = findViewById(R.id.logout);
        userName = findViewById(R.id.userName);
        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClient = GoogleSignIn.getClient(this, gOptions);

        // Check if the user is logged in via Google
        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (gAccount != null){
            // If logged in via Google, set the user's name
            String gName = gAccount.getDisplayName();
            userName.setText(gName);
        } else {
            // If not logged in via Google, check for user's name passed from the login activity
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String displayName = user.getDisplayName();
                if (displayName != null && !displayName.isEmpty()) {
                    // If display name is not null or empty, set it in TextView
                    userName.setText("Hi " + displayName);
                } else {
                    // If display name is null or empty, set a default greeting or handle it as per your app logic
                    userName.setText("Hi there!"); // Or any other default greeting
                }
            }

        }

        // Set click listener for logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign out from Google and navigate back to LoginActivity
                gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                        startActivity(new Intent(Homepage.this, LoginActivity.class));
                    }
                });
            }
        });

        // Initialize VideoView
        videoView = findViewById(R.id.video_station);

// Set the video source (replace "your_video_file_name" with your actual video file name)
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.delhi_metro;
        videoView.setVideoURI(Uri.parse(videoPath));

// Set a prepared listener to enable looping and mute the video
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // Enable looping
                mediaPlayer.setLooping(true);
                // Mute the video (set volume to zero)
                mediaPlayer.setVolume(0f, 0f);
            }
        });

// Start playing the video
        videoView.start();

        // Initialize UI elements
        ImageView img_plan_your_route = findViewById(R.id.imageImageFour);
        ImageView img_metro_map = findViewById(R.id.imageImageFourOne);
        ImageView img_foodImageView = findViewById(R.id.imageIcon);
        ImageView img_metro_card = findViewById(R.id.imageImageFive);

        // Set click listeners for image views
        img_plan_your_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on img_stationImageView
                // For example, open a new activity
                Intent intent = new Intent(Homepage.this, MainShortest.class);
                startActivity(intent);
            }
        });


        //return false;
    }
}
