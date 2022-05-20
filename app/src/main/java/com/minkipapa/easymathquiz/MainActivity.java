package com.minkipapa.easymathquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(view -> {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.sound1);
            mp.start();
            Intent menuIntent = new Intent(MainActivity.this , SubActivity.class);
            startActivity(menuIntent);
        });
    }

    private class val {
    }
}