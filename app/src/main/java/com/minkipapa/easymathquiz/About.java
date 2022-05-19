package com.minkipapa.easymathquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    private ImageButton back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back_home = findViewById(R.id.back_home);
        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent13 = new Intent(About.this, SubActivity.class);
                startActivity(intent13);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("알 림");
//        builder.setMessage("앱을 종료하시겠습니까?");
//        builder.setNegativeButton("취소", null);
//        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                startActivity(intent);
//                android.os.Process.killProcess(android.os.Process.myPid());
//            }
//        });
//        builder.show();
//    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About.this, SubActivity.class);
        startActivity(intent);
    }

}