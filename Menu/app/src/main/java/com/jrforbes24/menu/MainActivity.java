package com.jrforbes24.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView menu1 = (TextView) findViewById(R.id.menu_item_1);
        String menuItem1 = menu1.getText().toString();
        Log.v("MainActivity", menuItem1);
        // Find second menu item TextView and print the text to the logs
        TextView menu2 = (TextView) findViewById(R.id.menu_item_2);
        String menuItem2 = menu2.getText().toString();
        Log.v("MainActivity", menuItem2);
        // Find third menu item TextView and print the text to the logs
        TextView menu3 = (TextView) findViewById(R.id.menu_item_3);
        String menuItem3 = menu3.getText().toString();
        Log.v("MainActivity", menuItem3);
    }
}