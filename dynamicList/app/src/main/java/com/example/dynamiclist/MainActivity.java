package com.example.dynamiclist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

        final ArrayList<String> familyArray = new ArrayList<String> ();

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
        familyArray.add("Sven");

        final ArrayList<String> familyResponses = new ArrayList<String> ();
        familyResponses.add("John was clicked on.");
        familyResponses.add("Lucinda was clicked on.");
        familyResponses.add("JT was clicked on.");
        familyResponses.add("Maddie was clicked on.");
        familyResponses.add("Jason was clicked on.");
        familyResponses.add("Emma was clicked on.");
        familyResponses.add("Elder Forbes was clicked on.");
        familyResponses.add("Zeke was clicked on.");
        familyResponses.add("Kyra was clicked on.");
        familyResponses.add("Lucie was clicked on.");
        familyResponses.add("Sven was clicked on.");




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, familyArray);

        theListView.setAdapter(arrayAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("", familyArray.get(i-1) + "This was the int sent " + i);
            }
        });


    }
}