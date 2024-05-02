package com.example.a21myapplication0406;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class  Music extends AppCompatActivity {

    Button back3; //메인으로 버튼
    Button music_on;  //음악 켜기, 끄기
    Button music_off;
    Button back_music;
    Button next_music;
    Button vButton1;
    Button vButton2;
    Button vButton3;
    Button vButton4;
    Button vButton5;

    boolean flag = true;


    public int Mnumber = 0;
    SeekBar currentVolumeSeekBar;
    AudioManager audioManager;
    String MusicN;

    //activity_music의 android:progress="10"이 초기값


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#87CEFA"));
        }


        back3 = (Button) findViewById(R.id.back3);
        music_on = (Button) findViewById(R.id.music_on);
        music_off = (Button) findViewById(R.id.music_off);
        back_music = (Button) findViewById(R.id.back_music);
        next_music = (Button) findViewById(R.id.next_music);
        vButton1=(Button)findViewById(R.id.vButton1);
        vButton2=(Button)findViewById(R.id.vButton2);
        vButton3=(Button)findViewById(R.id.vButton3);
        vButton4=(Button)findViewById(R.id.vButton4);
        vButton5=(Button)findViewById(R.id.vButton5);




        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // back3.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });



        back_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //back_music.setBackgroundColor(Color.rgb(234, 122, 160));
                ((MainActivity) MainActivity.funC).sendDate("f");
                Toast.makeText(Music.this, "이전 곡", Toast.LENGTH_SHORT).show();
            }
        });


        next_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // next_music.setBackgroundColor(Color.rgb(234, 122, 160));
                ((MainActivity) MainActivity.funC).sendDate("g");
                Toast.makeText(Music.this, "다음 곡", Toast.LENGTH_SHORT).show();
            }
        });


        music_on.setOnClickListener(new View.OnClickListener() {  //음악 켜기
            @Override
            public void onClick(View v) {

               // music_on.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("c");
                Toast.makeText(Music.this, "켜기", Toast.LENGTH_SHORT).show();

                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
              /*  Intent intent1 = new Intent(activity_temp.this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);*/

            }

        });

        music_off.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // music_off.setBackgroundColor(Color.rgb(135, 206, 255));
                Toast.makeText(Music.this, "끄기", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.funC).sendDate("d");


            }
        });


        vButton1.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                //vButton1.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("1");


            }
        });


        vButton2.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // vButton2.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("2");


            }
        });

        vButton3.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // vButton3.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("3");


            }
        });


        vButton4.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // vButton4.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("4");


            }
        });



        vButton5.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // vButton5.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("5");


            }
        });

    }
}





