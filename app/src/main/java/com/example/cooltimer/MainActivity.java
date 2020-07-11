package com.example.cooltimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);

        seekBar.setMax(600);
        seekBar.setProgress(60);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int minutes = progress / 60;
                int seconds = progress - (minutes * 60);

                String minutesString = "";
                String secondsString = "";

                if (minutes < 10) {
                    minutesString = "0" + minutes;
                } else {
                    minutesString = String.valueOf(minutes);
                }

                if (seconds < 10) {
                    minutesString = "0" + seconds;
                } else {
                    secondsString = String.valueOf(seconds);
                }

                textView.setText(minutesString + ":" + secondsString);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void start(View view) {

        new CountDownTimer(seekBar.getProgress() * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int minutes = (int) millisUntilFinished/1000/ 60;
                int seconds = (int) millisUntilFinished/1000 - (minutes * 60);

                String minutesString = "";
                String secondsString = "";

                if (minutes < 10) {
                    minutesString = "0" + minutes;
                } else {
                    minutesString = String.valueOf(minutes);
                }

                if (seconds < 10) {
                    minutesString = "0" + seconds;
                } else {
                    secondsString = String.valueOf(seconds);
                }

                textView.setText(minutesString + ":" + secondsString);

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}