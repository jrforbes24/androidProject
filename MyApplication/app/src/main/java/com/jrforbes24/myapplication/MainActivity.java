package com.jrforbes24.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView myNewView = new TextView(this);
        myNewView.setText("Loyalty!");
        myNewView.setTextColor(Color.BLUE);
        myNewView.setTextSize(48);
        myNewView.setLetterSpacing(1);

        setContentView(myNewView);
    }
}
