package com.example.clipstacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class MainHomeActivity extends AppCompatActivity {
    protected String API_Path = "http://10.0.0.1/ClipStacksAPI/";

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.main_home);

        String UserName = getIntent().getStringExtra("UserName");

        TextView NameLabel = findViewById(R.id.UserNameLabel);
        NameLabel.setText("@"+UserName);

        Button WATCH_CEREAL = findViewById(R.id.WATCH_CEREAL);
        WATCH_CEREAL.setOnClickListener(v -> {
            Intent Go = new Intent(this, VideoPlayerActivity.class);
            Go.putExtra("VideoTitle", "CEREAL!!");
            Go.putExtra("VideoUrl",
                    API_Path+"LoadVideo.php?file=CEREAL.mp4"
            );
            startActivity(Go);
        });

        Button WATCH_CharacterCreator = findViewById(R.id.WATCH_CharacterCreator);
        WATCH_CharacterCreator.setOnClickListener(v -> {
            Intent Go = new Intent(this, VideoPlayerActivity.class);
            Go.putExtra("VideoTitle", "Character Creator | Flipa Clip");
            Go.putExtra("VideoUrl",
                    API_Path+"LoadVideo.php?file=CharacterCreator.mp4"
            );
            startActivity(Go);
        });

    }
}
