package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//        Creating a counter
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Get the timerDisplay field.
        final TextView textView = (TextView) findViewById(R.id.timerDisplay);
        final TextView labelView = (TextView) findViewById(R.id.textLabel);

        /*
//        Creating a handler
        final Handler handler = new Handler();
//        Creating a runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                i++;
                textView.setText(Integer.toString(i));
                handler.postDelayed(this, 1000);
            }
        };
// set the handler to run
        handler.post(runnable);
         */

      new CountDownTimer(10000, 100) {
          public void onTick(long milliSecondsUntilDone) {
            textView.setText(Long.toString(milliSecondsUntilDone / 100 ));
          }

          @Override
          public void onFinish() {
             textView.setVisibility(View.GONE);
             labelView.setVisibility(View.GONE);
          }
      }.start();


    }
}