package com.example.a21myapplication0406;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button button1; //main camera 버튼
    Button button2; //main temp 버튼
    Button button3; // music 버튼

    Button button_end;
    Toolbar toolbar; //툴바
    BroadcastReceiver receiver;

    //문자열 "1"은 dht 온습도 센서
    //문자열 "2"는 체온

    public static Context funC;



    BluetoothAdapter btAdapter;
    int paireDeviceCount=0; //블루투스에 연결된 장치 수
    Set<BluetoothDevice> devices; //블루투스 장치
    BluetoothDevice remoteDevice; //내가 사용할 블루투스 장치
    BluetoothSocket bluetoothSocket; //블루투스 통신
    OutputStream outputStream=null;
    InputStream inputStream=null;
    Thread wokerThread=null;
    String strDelimiter="\n";
    char charDelimiter='\n';
    byte readBuffer[];
    int readBufferPosition;

    ImageView imageView;
    ImageView gif;

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#87CEFA"));
        }

        imageView=findViewById(R.id.imageView);


        TimerTask tt = new TimerTask() {
            //TimerTask 추상클래스를 선언하자마자 run()을 강제로 정의하도록 한다.
            @Override
            public void run() {
                /////////////////// 추가한 코드 ////////////////////
                //Log.d("test", "10초마다");
                sendDate("6");
                Log.d("test", "6 보내기");


                /////////////////////////////////////////////////


            }
        };
        Timer timer = new Timer();
        timer.schedule(tt, 10000, 2000);
        //TimerTask 주기적으로 하고 싶은 일,처음에 몇 초를 기다렸다가 실행할까? ,얼마마다 한번씩 실행할까?



        funC=this;





        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, filter);






        checkBluetooth();



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        ImageView gom=(ImageView)findViewById(R.id.gif);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(gom);
        Glide.with(this).load(R.drawable.gifgommmm).into(gifImage);






        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(Color.rgb(255, 255, 255));
                Intent intent = new Intent(MainActivity.this, Camera.class); //*/
               startActivity(intent);

            }
        });
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button1.setBackgroundColor(Color.rgb(255, 255, 255));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button1.setBackgroundColor(Color.rgb(255, 255, 255));
                }
                return false;
            }
        });

        setSupportActionBar(toolbar);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button2.setBackgroundColor(Color.rgb(255, 255, 255));
                Intent intent=new Intent(MainActivity.this,activity_temp.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button2.setBackgroundColor(Color.rgb(255, 255, 255));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button2.setBackgroundColor(Color.rgb(255, 255, 255));
                }
                return false;
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button3.setBackgroundColor(Color.rgb(255, 255, 255));

                Intent intent = new Intent(MainActivity.this, Music.class);
               startActivity(intent);
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button3.setBackgroundColor(Color.rgb(255, 255, 255));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button3.setBackgroundColor(Color.rgb(255, 255, 255));
                }
                return false;
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
     switch (item.getItemId()) {
           case R.id.menu:
              checkBluetooth();
               break;
        }
        return true;
    }


    public void checkBluetooth(){
        btAdapter=BluetoothAdapter.getDefaultAdapter();
        if(btAdapter==null){
            showToast("블루투스를 지원하지 않는 장치입니다.");
        }else {
            //장치가 블루투스를 지원하는 경우
            if(!btAdapter.isEnabled()){
                Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, 10);
            } else{
                selectDevice();
            }
        }
    }

    //페어링된 장치 목록 출력 및 선택
    void selectDevice(){
        devices=btAdapter.getBondedDevices(); //블루투스 장치 목록 가져옴
        paireDeviceCount=devices.size();
        if(paireDeviceCount==0){
            //연결된 장치가 없음
            showToast("페어링된 장치가 없습니다.");
        }else{
            //연결된 장치가 있을 경우
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("블루투스 장치 선택");
            List<String> listItems=new ArrayList<String>();
            for(BluetoothDevice device:devices){
                listItems.add((device.getName()));
            }
            listItems.add("취소");
            final CharSequence[] items=listItems.toArray(new CharSequence[listItems.size()]);
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(which==paireDeviceCount){
                        showToast("연결할 장치를 선택하지 않았습니다.");
                    }else{
                        connectToSelectedDevice(items[which].toString());
                    }
                }
            });
            builder.setCancelable(false); //뒤로가기 버튼 금지
            AlertDialog dlg=builder.create();
            dlg.show();
        }
    }

    //선택한 블루투스 장치와의 연결
    void connectToSelectedDevice(String selectedDeviceName){
        remoteDevice=getDeviceFormBoundedList(selectedDeviceName);
        UUID uuid=UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //블루투스 장치 고유번호
        try{
            bluetoothSocket=remoteDevice.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();//기기와 연결이 완료
            showToast("블루투스가 연결되었습니다.");
           // ivConnect.setImageResource(R.drawable.bluetooth_on);
            outputStream=bluetoothSocket.getOutputStream();
            inputStream=bluetoothSocket.getInputStream();
            beginListenForData();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //페어링된 블루투스 장치를 이름으로 찾기
    BluetoothDevice getDeviceFormBoundedList(String name){
        BluetoothDevice selectedDevice=null;
        for(BluetoothDevice device : devices){
            if(name.equals(device.getName())){ //대화상자에서 선태한 리스트 이름
                selectedDevice=device;
                break;
            }
        }
        return selectedDevice;
    }


    //데이터 수신 준비 및 처리
    public void beginListenForData(){

        final Handler handler=new Handler();
        readBuffer=new byte[1024]; //아두이노에서 받는 수신버퍼 크기
        readBufferPosition=0; //버퍼 내 수신 문자 저장 위치
        //문자열 수신 쓰레드
        wokerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){ //쓰레드가 중단된 상태가 아닐 경우
                    try{
                        int byteAvailalbe=inputStream.available(); //수신데이터가 있는지 확인
                        if(byteAvailalbe>0){
                            //아두이노에서 보낸 데이터가 있음
                            byte[] packetBytes=new byte[byteAvailalbe];
                            inputStream.read(packetBytes);
                            for(int i=0; i<byteAvailalbe; i++){
                                byte b=packetBytes[i];
                                if(b==charDelimiter){
                                    byte[] encodeByte=new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodeByte, 0, encodeByte.length);
                                    final String data=new String(encodeByte, "UTF-8");

                                    //inent추가
                                    readBufferPosition=0;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            //data변수에 수신된 문자열에 대한 처리 작업

                                            if(data.contains("z")){

                                                alart();


                                               String ddata = data.replace("z", "");


                                                Intent intent=new Intent(MainActivity.this, activity_temp.class);
                                                intent.putExtra("d_data",ddata); //(key값, 전달값)
                                                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                                intent.addFlags (Intent.FLAG_ACTIVITY_NO_HISTORY);
                                                startActivity(intent);


                                            }
                                           else{
                                                Intent intent=new Intent(MainActivity.this, activity_temp.class);
                                                intent.putExtra("d_data",data); //(key값, 전달값)
                                                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);

                                                intent.addFlags (Intent.FLAG_ACTIVITY_NO_HISTORY);
                                                startActivity(intent);

                                            }

                                           /* Intent intent=new Intent(MainActivity.this, activity_temp.class);
                                            intent.putExtra("d_data",data); //(key값, 전달값)
                                            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);

                                                intent.addFlags (Intent.FLAG_ACTIVITY_NO_HISTORY);
                                            startActivity(intent);*/




                                        }
                                    });
                                }else{
                                    readBuffer[readBufferPosition++]=b;
                                }
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        wokerThread.start();

    }






    //데이터 송신(아두이노로 전송)
    public void sendDate(String msg) {
        msg+=strDelimiter;
        try{
            outputStream.write(msg.getBytes()); //문자열 전송
        }catch (Exception e){
            showToast("연결을 확인해주세요");
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        try{
            wokerThread.interrupt();
            inputStream.close();
            outputStream.close();
            bluetoothSocket.close();
        }catch (Exception e){
            showToast("앱 종료 중 에러 발생");
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    selectDevice();
                } else if(resultCode==RESULT_CANCELED){
                    showToast("블루투스 활성화를 취소했습니다.");
                }
                break;
        }
    }




    private long time= 0;
    @Override

    public void onBackPressed(){

        if(System.currentTimeMillis() - time >= 2000){
            time=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

        else if(System.currentTimeMillis() - time < 2000 ){

            finish();
        }
    }



    void showToast(String str){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        }, 100);

    }

    public void alart(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("소리 감지");
        builder.setMessage("큰 소리가 감지 되었습니다.");
        builder.setPositiveButton("카메라", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"카메라 연결",Toast.LENGTH_LONG);
                Intent intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"닫기", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        AlertDialog alertD = builder.create();
        alertD.show();
    }

    }
