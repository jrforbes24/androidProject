package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saySometing(View view) {
        Button buttonClicked =(Button) view;
        Log.i("Button clicked", buttonClicked.getTag().toString() );
        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonClicked.getTag().toString(), "raw", getPackageName()));
        mediaPlayer.start();
    }
}