package com.minkipapa.easymathquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    //Sound
    //SoundPool soundPool;
    //int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //Sound
        //soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        //soundID = soundPool.load(this, R.raw.buttonSound,1);

        Button add1 = findViewById(R.id.add1);
        add1.setOnClickListener(v -> {
            //soundPool.play(soundID,1f,1f,0,0,1f);
            Intent intent02 = new Intent(SubActivity.this, AddGameActivity1.class);
            startActivity(intent02);
        });

        Button add2 = findViewById(R.id.add2);
        add2.setOnClickListener(v -> {
            Intent intent03 = new Intent(SubActivity.this, AddGameActivity2.class);
            startActivity(intent03);
        });

        Button minus1 = findViewById(R.id.minus1);
        minus1.setOnClickListener(v -> {
            Intent intent04 = new Intent(SubActivity.this, AddGameActivity3.class);
            startActivity(intent04);
        });

        Button minus2 = findViewById(R.id.minus2);
        minus2.setOnClickListener(v -> {
            Intent intent05 = new Intent(SubActivity.this, AddGameActivity4.class);
            startActivity(intent05);
        });

        Button gop1 = findViewById(R.id.gop1);
        gop1.setOnClickListener(v -> {
            Intent intent06 = new Intent(SubActivity.this, AddGameActivity5.class);
            startActivity(intent06);
        });

        ImageButton about = findViewById(R.id.about);
        about.setOnClickListener(v -> {
            Intent intent12 = new Intent(SubActivity.this, About.class);
            startActivity(intent12);
        });
    }
}