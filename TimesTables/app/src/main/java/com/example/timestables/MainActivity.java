package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView theListView;

    public final void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 100; j++) {
            timesTableContent.add(String.valueOf(j * timesTableNumber));
        }
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        theListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        Getting the ListView
        theListView = findViewById(R.id.timesTableList);

//        Getting the seekbar and setting it up.
        final SeekBar timesBar = (SeekBar) findViewById(R.id.seekBar);
        int max = 20;
        int startingPositon = 10;

        timesBar.setMax(max);
        timesBar.setProgress(startingPositon);

        generateTimesTable(startingPositon);

        timesBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if ( i < min) {
                    timesTableNumber = min;
                    timesBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }
                Log.i( "Seekbar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}