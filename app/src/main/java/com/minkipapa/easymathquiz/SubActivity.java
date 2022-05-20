// 퀴즈 선택 메뉴

package com.minkipapa.easymathquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button add1 = findViewById(R.id.add1);
        add1.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent add1Intent = new Intent(SubActivity.this, AddGameActivity1.class);
            startActivity(add1Intent);
        });

        Button add2 = findViewById(R.id.add2);
        add2.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent add2Intent = new Intent(SubActivity.this, AddGameActivity2.class);
            startActivity(add2Intent);
        });

        Button minus1 = findViewById(R.id.minus1);
        minus1.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent minus1Intent = new Intent(SubActivity.this, AddGameActivity3.class);
            startActivity(minus1Intent);
        });

        Button minus2 = findViewById(R.id.minus2);
        minus2.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent minus2Intent = new Intent(SubActivity.this, AddGameActivity4.class);
            startActivity(minus2Intent);
        });

        Button gop1 = findViewById(R.id.gop1);
        gop1.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent gop1Intent = new Intent(SubActivity.this, AddGameActivity5.class);
            startActivity(gop1Intent);
        });

        Button gop2 = findViewById(R.id.gop2);
        gop1.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent gop2Intent = new Intent(SubActivity.this, AddGameActivity6.class);
            startActivity(gop2Intent);
        });

        Button about = findViewById(R.id.about);
        about.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
            mp.start();
            Intent aboutIntent = new Intent(SubActivity.this, About.class);
            startActivity(aboutIntent);
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알 림");
        builder.setMessage("\n\n여러분 즐겁게 사용하셨나요?\n\n공부도 중요하지만 가끔은 밖에서 친구들과 즐겁게 놀는 것도 중요하답니다!\n\n앱을 종료하시겠습니까?");
        builder.setNegativeButton("취소", null);
        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent closeIntent = new Intent();
                closeIntent.setAction(Intent.ACTION_MAIN);
                closeIntent.addCategory(Intent.CATEGORY_HOME);
                startActivity(closeIntent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        builder.show();
    }
}