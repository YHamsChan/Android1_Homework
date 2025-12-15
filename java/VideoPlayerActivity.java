package com.example.clipstacks;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView VideoPlayer;
    private TextView TitleLabel;
    private Button LeaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        VideoPlayer = findViewById(R.id.VideoPlayer);
        LeaveButton = findViewById(R.id.LeaveButton);
        TitleLabel = findViewById(R.id.Title);

        String VideoUrl = getIntent().getStringExtra("VideoUrl");
        String VideoTitle = getIntent().getStringExtra("VideoTitle");

        TitleLabel.setText(VideoTitle);

        MediaController Controller = new MediaController(this);
        Controller.setAnchorView(VideoPlayer);
        VideoPlayer.setMediaController(Controller);
        VideoPlayer.setVideoURI(Uri.parse(VideoUrl));
        VideoPlayer.start();

        LeaveButton.setOnClickListener(View -> {
            finish();
        });
    }
}
