package com.example.a21myapplication0406;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_temp extends AppCompatActivity {


    Button temp,dht,back2;
    TextView tvRecive;

    public String getString;

    public String s;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);


        temp = (Button) findViewById(R.id.temp);
        dht = (Button) findViewById(R.id.dht);
        back2 = (Button) findViewById(R.id.back2);
        tvRecive = (TextView) findViewById(R.id.tvReceive);


        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#87CEFA"));
        }



        Intent intent = getIntent();  //intent 가져옴
        getString = intent.getStringExtra("d_data");







        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back2.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });
        back2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back2.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back2.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {  //온습도 버튼
            @Override
            public void onClick(View v) {

                temp.setBackgroundColor(Color.rgb(135, 206, 255));

                ((MainActivity) MainActivity.funC).sendDate("b");



            }

        });
        temp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    temp.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    temp.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        dht.setOnClickListener(new View.OnClickListener() {  //체온 버튼
            @Override
            public void onClick(View v) {
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                dht.setBackgroundColor(Color.rgb(135, 206, 255));

                ((MainActivity) MainActivity.funC).sendDate("a");


            }
        });
        dht.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    dht.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    dht.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });


        //





        tvRecive.setText(getString);





    }






}