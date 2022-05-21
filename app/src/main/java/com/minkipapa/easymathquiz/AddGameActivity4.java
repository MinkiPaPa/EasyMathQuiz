package com.minkipapa.easymathquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AddGameActivity4 extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3, btn_back;
    TextView tv_score, tv_question, tv_timer, tv_bottom;
    ProgressBar prog_timer;

    Game4 g = new Game4();

    int secondsRemaining = 60;
    CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + " 초");
            prog_timer.setProgress(60 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);

            tv_bottom.setText("시간이 종료되었습니다!  " + g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1));

            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_answer0.setVisibility(View.INVISIBLE);
                    btn_answer1.setVisibility(View.INVISIBLE);
                    btn_answer2.setVisibility(View.INVISIBLE);
                    btn_answer3.setVisibility(View.INVISIBLE);

                    btn_back.setVisibility(View.VISIBLE);
                    btn_back.setOnClickListener(view -> {
                        Intent intent10 = new Intent(AddGameActivity4.this , SubActivity.class);
                        startActivity(intent10);
                    });
                }
            } , 4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game4);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_back = findViewById(R.id.btn_back);

        tv_score = findViewById(R.id.tv_score);
        tv_question = findViewById(R.id.tv_question);
        tv_bottom = findViewById(R.id.tv_bottom);
        tv_timer = findViewById(R.id.tv_timer);
        prog_timer = findViewById(R.id.prog_timer);

        tv_question.setText("문제가 표시됩니다");
        tv_timer.setText(" 시간 ");
        tv_bottom.setText("시작을 클릭하세요");
        tv_score.setText(" 점수 ");
        prog_timer.setProgress(0);

        View.OnClickListener startButtonClickListener = v -> {
            Button start_button = (Button) v;
            start_button.setVisibility(View.INVISIBLE);
            btn_answer0.setVisibility(View.VISIBLE);
            btn_answer1.setVisibility(View.VISIBLE);
            btn_answer2.setVisibility(View.VISIBLE);
            btn_answer3.setVisibility(View.VISIBLE);

            secondsRemaining = 60;
            tv_score.setText("0 점");
            g = new Game4();

            nextTurn();
            timer.start();
        };

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                // Toast.makeText(AddGameActivity1.this, "선택한 정답은" + answerSelected, Toast.LENGTH_SHORT).show();

                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()) + " 점");
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }

    private void nextTurn() {

        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_question.setText(g.getCurrentQuestion().getQuestionPhrase());

        tv_bottom.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1));

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}