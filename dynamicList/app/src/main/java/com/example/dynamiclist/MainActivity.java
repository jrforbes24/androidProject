package com.example.dynamiclist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);


        ListView theListView = findViewById(R.id.nameListView);
        theListView.addHeaderView(textView);

        ArrayList<String> familyArray = new ArrayList<String> ();
        familyArray.add("John");
        familyArray.add("Lucinda");
        familyArray.add("JT");
        familyArray.add("Maddie");
        familyArray.add("Jason");
        familyArray.add("Emma");
        familyArray.add("Elder Forbes");
        familyArray.add("Zeke");
        familyArray.add("Kyra");
        familyArray.add("Lucie");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, familyArray);

        theListView.setAdapter(arrayAdapter);


    }
}