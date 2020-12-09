package com.example.dynamiclist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nameListView =  (ListView)findViewById(R.id.holdNames);

        final ArrayList <String> myHeroes = new ArrayList<String>();
        myHeroes.add("Ghandi");
        myHeroes.add("Moroni");
        myHeroes.add("Thoams S. Monson");
        myHeroes.add("Elder Bednar");
        myHeroes.add("Elder Holland");
        myHeroes.add("Bishop Kirk");
        myHeroes.add("Bishop Gordon");

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myHeroes);

        nameListView.setAdapter(myAdapter);

        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i( "Hero chosen: ", myHeroes.get(i));
                Toast.makeText(getApplicationContext(), myHeroes.get(i) + " has been chosen.", Toast.LENGTH_LONG).show();
            }
        });

        }
    }
