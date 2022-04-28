package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button button;
   VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notitlebar();
        btn1Click();
        btn2Click();
        videoview();
    }

    public void btn1Click(){
        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage2(); }
        });
    }
    public void openPage2(){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
    public void btn2Click(){
        button = (Button) findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginactivity(); }
        });
    }
    public void openloginactivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void notitlebar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
    public void videoview() {videoview = (VideoView) findViewById(R.id.video_view);

    String path = "android.resource://com.example.dietapp/"+R.raw.video;
    Uri u= Uri.parse(path);
    videoview.setVideoURI(u);
    videoview.start();

    videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(true);
        }
    });}

    @Override
    protected void onResume(){
        videoview.resume();
        super.onResume();
    }
    @Override
    protected void onPause(){
        videoview.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        videoview.stopPlayback();
        super.onDestroy();
    }
}