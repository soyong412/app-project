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


    String MusicN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);



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
                back3.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });
        back3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back3.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back3.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });


        back_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_music.setBackgroundColor(Color.rgb(234, 122, 160));
                ((MainActivity) MainActivity.funC).sendDate("f");
                Toast.makeText(Music.this, "이전 곡", Toast.LENGTH_SHORT).show();
            }
        });
        back_music.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back_music.setBackgroundColor(Color.rgb(230, 77, 129));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back_music.setBackgroundColor(Color.rgb(230, 77, 129));
                }
                return false;
            }
        });

        next_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_music.setBackgroundColor(Color.rgb(234, 122, 160));
                ((MainActivity) MainActivity.funC).sendDate("g");
                Toast.makeText(Music.this, "다음 곡", Toast.LENGTH_SHORT).show();
            }
        });
        back_music.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    next_music.setBackgroundColor(Color.rgb(230, 77, 129));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    next_music.setBackgroundColor(Color.rgb(230, 77, 129));
                }
                return false;
            }
        });


        music_on.setOnClickListener(new View.OnClickListener() {  //음악 켜기
            @Override
            public void onClick(View v) {

                music_on.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("c");
                Toast.makeText(Music.this, "켜기", Toast.LENGTH_SHORT).show();


            }

        });
        music_on.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    music_on.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    music_on.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        music_off.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                music_off.setBackgroundColor(Color.rgb(135, 206, 255));
                Toast.makeText(Music.this, "끄기", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.funC).sendDate("d");


            }
        });
        music_off.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    music_off.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    music_off.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        vButton1.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                vButton1.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("1");


            }
        });
        vButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vButton1.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vButton1.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        vButton2.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                vButton2.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("2");


            }
        });
        vButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vButton2.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vButton2.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        vButton3.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                vButton3.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("3");


            }
        });
        vButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vButton3.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vButton3.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });


        vButton4.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                vButton4.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("4");


            }
        });
        vButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vButton4.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vButton4.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });



        vButton5.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                vButton5.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("5");


            }
        });
        vButton5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vButton5.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vButton5.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

    }
}





