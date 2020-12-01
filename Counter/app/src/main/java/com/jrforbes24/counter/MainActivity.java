package com.jrforbes24.counter;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //    The counter variable that keeps the total
    int counterValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * Increments counterValue by 1
     */
    public void plusOne(View v) {
        counterValue += 1;
        displayCounterValue(counterValue);
    }

    /**
     * Increments counterValue by 5
     */
    public void plusFive(View v) {
        counterValue += 5;
        displayCounterValue(counterValue);
    }

    /**
     * Decrements counterValue by 1
     */
    public void minusOne(View v) {
        counterValue -= 1;
        displayCounterValue(counterValue);
    }

    /**
     * Reset counterValue to 0
     */
    public void resetCounter(View v) {
        counterValue = 0;
        displayCounterValue(counterValue);
    }

    /**
     * Displays the counterValue
     */
    public void displayCounterValue(int counterValue) {
        TextView counterView = (TextView) findViewById(R.id.the_score);
        counterView.setText(String.valueOf(counterValue));
    }


}
