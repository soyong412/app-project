package com.example.a21myapplication0406;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Camera extends AppCompatActivity {

    Button connect; //연결버튼
    Button back; //메인으로 버튼
    WebView webView; //웹뷰
    EditText url; // 입력칸
    Button motor_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        url=(EditText)findViewById(R.id.url);
        connect=(Button)findViewById(R.id.connect);
        back=(Button)findViewById(R.id.back);
        webView=(WebView)findViewById(R.id.webView);


        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#87CEFA"));
        }

        WebSettings webSettings=webView.getSettings(); //웹뷰 세팅
        webSettings.setJavaScriptEnabled(true); //웹뷰 자바스크립트 허용

        webView.getSettings().setUserAgentString(String.valueOf(1)); //웹뷰 pc 모드 고정


        motor_btn=(Button)findViewById(R.id.motor_btn);
        motor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //motor_btn.setBackgroundColor(Color.rgb(135, 206, 255));
                ((MainActivity) MainActivity.funC).sendDate("e");

            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // back.setBackgroundColor(Color.rgb(135, 206, 255));
                finish();
            }
        });


        connect.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    connect.setBackgroundColor(Color.rgb(255, 255, 255));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    connect.setBackgroundColor(Color.rgb(255, 255, 255));
                }
                return false;
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view,url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){

            }
        });

        url.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_GO){
                    connect.callOnClick();
                    //키보드 내리기
                    InputMethodManager keyboard=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    keyboard.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }


    public void onClick(View view){
        String address=url.getText().toString();
        back.setBackgroundColor(Color.rgb(135, 206, 255));
        if(address.startsWith("http://")==false){ //http://를 쓰지않았을 때
            address="http://" +address;
        }


        if(address.endsWith(":81/stream")==false){ //esp32 cam은 ip뒤 :81/stream 을 쓰면 스트리밍 화면만 출력됨 스트리밍 화면만 나오도록 설정한 문장
            address=address+":81/stream";
        }
        webView.loadUrl(address); //to.String()받은 텍스트 -> address ->address 주소로 이동



    }





}