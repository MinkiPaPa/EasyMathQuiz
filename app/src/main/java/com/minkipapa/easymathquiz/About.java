package com.minkipapa.easymathquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    private Button back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button back_home = findViewById(R.id.back_home);
        back_home.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent aboutIntent = new Intent(About.this, SubActivity.class);
            startActivity(aboutIntent);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}