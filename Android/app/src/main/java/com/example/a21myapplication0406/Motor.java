package com.example.a21myapplication0406;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Motor extends AppCompatActivity {
    Button back4; //메인으로 버튼
    Button dc_start;  //움직이기
    Button dc_stop;   //정지하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        back4=(Button)findViewById(R.id.back4);
        dc_start=(Button)findViewById(R.id.dc_start);
        dc_stop=(Button)findViewById(R.id.dc_stop);


        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#87CEFA"));
        }



        //뒤로가기
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back4.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });
        back4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back4.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back4.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        //첫번째 버튼 클릭하면 움직이기
        dc_start.setOnClickListener(new View.OnClickListener() {  //음악 켜기
            @Override
            public void onClick(View v) {

                dc_start.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("e");
                Toast.makeText(Motor.this, "움직이기", Toast.LENGTH_SHORT).show();

                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
              /*  Intent intent1 = new Intent(activity_temp.this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);*/

            }

        });
        dc_start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    dc_start.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    dc_start.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });

        //두번째 버튼 클릭하면 멈추기
        dc_stop.setOnClickListener(new View.OnClickListener() {  //음악 끄기
            @Override
            public void onClick(View v) {
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                dc_stop.setBackgroundColor(Color.rgb(135, 206, 255));
                Toast.makeText(Motor.this, "정지하기", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.funC).sendDate("k");


            }
        });
        dc_stop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    dc_stop.setBackgroundColor(Color.rgb(63, 81, 181));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    dc_stop.setBackgroundColor(Color.rgb(63, 81, 181));
                }
                return false;
            }
        });


    }
    void showToast(String str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    //침대 모터 제어//
    //속도 제어하기




}