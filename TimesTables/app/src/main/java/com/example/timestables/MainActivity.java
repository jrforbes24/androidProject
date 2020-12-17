package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    int[] myNumbers = {1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    Getting the ListView
        ListView theListView = findViewById(R.id.timesTableList);
//        Getting the seekbar
        SeekBar timesBar = (SeekBar) findViewById(R.id.seekBar);
//        Setting a listener for the seekbar
        timesBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seekbar changed", Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // List to hold the numbers 1 - 10
        final ArrayList<Integer> timesList = new ArrayList<Integer> ();
// actually putting the numbers in the array list
        for(int myNumber:myNumbers){
            timesList.add(myNumber);
        }
// setting the array adapter
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, timesList);
        theListView.setAdapter(arrayAdapter);

    }
}