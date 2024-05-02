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

        //Intent sintent = getIntent();  //intent 가져옴
       // s = intent.getStringExtra("s");

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
                //back2.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });


        temp.setOnClickListener(new View.OnClickListener() {  //온습도 버튼
            @Override
            public void onClick(View v) {

               // temp.setBackgroundColor(Color.rgb(135, 206, 255));

                ((MainActivity) MainActivity.funC).sendDate("b");

                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
              /*  Intent intent1 = new Intent(activity_temp.this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);*/

            }

        });


        dht.setOnClickListener(new View.OnClickListener() {  //체온 버튼
            @Override
            public void onClick(View v) {
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
               // dht.setBackgroundColor(Color.rgb(135, 206, 255));

                ((MainActivity) MainActivity.funC).sendDate("a");


            }
        });



        //





        tvRecive.setText(getString);





    }






}