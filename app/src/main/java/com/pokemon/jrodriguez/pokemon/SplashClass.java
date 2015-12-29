package com.pokemon.jrodriguez.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

/**
 * Created by jrodriguez on 24/12/15.
 */
public class SplashClass extends AppCompatActivity {
    private static final int seconds = 8;
    private static final int milliseconds = seconds * 1000;
    private static final int DELAY = 2;

    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        progressbar = (ProgressBar)findViewById(R.id.progressBar);
        progressbar.setMax(MaxProgressBar());

        System.out.println("============================");

    }

    public void StartAnimation(){
        new CountDownTimer(milliseconds, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                progressbar.setProgress(SetProgressBar(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                System.out.println("??????????????????????????????????????");
                Intent game = new Intent(SplashClass.this, MainActivity.class);
                startActivity(game);
                finish();

            }
        }.start();
    }
    public int SetProgressBar(long millis){
        return (int)((milliseconds-millis) / 1000);
    }

    public int MaxProgressBar(){
        return (int)(seconds - DELAY);
    }

}
