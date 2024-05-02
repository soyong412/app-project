#include<SoftwareSerial.h>  //소프트웨어 시리얼 라이브러리 


//온습도 관련//
#include <DHT.h> 
#include <DHT_U.h> 
#define DHTPIN 4 //온습도 센서 연결 포트
#define DHTTYPE DHT11//온습도 센서 종류
DHT dht(DHTPIN,DHTTYPE);


//체온 관련//
#include <Wire.h>
#include <Adafruit_MLX90614.h>
Adafruit_MLX90614 mlx = Adafruit_MLX90614();


//블루투스 관련//
SoftwareSerial bluetooth(2,3);//Tx,Rx 연결 포트



//mp3 플레이어, 스피커 관련//
#include "DFRobotDFPlayerMini.h"
SoftwareSerial mySoftwareSerial(10, 11); // Rx, Tx 연결 포트
DFRobotDFPlayerMini myDFPlayer;



//모터 관련//

#include <Servo.h>

Servo myservo1;
Servo myservo2;// 


int pos = 0; //각도

void setup() {
  dht.begin(9600); //온습도
  mlx.begin(); //체온
  Serial.begin(9600); //시리얼 통신 시작
 
  


}


//온습도 함수//
void dhtF(){
  float humid=dht.readHumidity();
  float temp=dht.readTemperature();
  String s="습도: ";
  String t="온도: ";
  Serial.println("dht");
  bluetooth.print(s);
  bluetooth.print(humid);
  bluetooth.print("        ");
  bluetooth.print(t);
  bluetooth.println(temp);
}


//체온 함수//
void babytF(){
  Serial.println("temp");
  bluetooth.print("아기체온: ");
  bluetooth.println(mlx.readObjectTempC());  
}

//사운드 감지//
const int SOUND_SENSOR_PIN = A0; //사운드센서 핀
int sensorValue; //센서값 변수
int threshold=270; //270 기준


void soundF(){
  if(sensorValue>=threshold){
    //bluetooth.print("큰 소리 감지,"); 
    Serial.println("sound");
    Serial.println(sensorValue);
    bluetooth.print("z");
    delay(100);// 
    }
  }


  
void motorS(){
     for (pos = 0; pos <= 180; pos += 1) {
    // in steps of 1 degree
    myservo1.write(pos); 
    myservo2.write(pos);
    delay(15);                       // 180도 회전
  }
  for (pos = 180; pos >= 0; pos -= 1) { 
    myservo1.write(pos); 
    myservo2.write(pos);            
    delay(15);                     
  }
}


void loop() {
 
  bluetooth.begin(9600); //블루투스 통신
   sensorValue = analogRead(SOUND_SENSOR_PIN); //사운드 센서


  if (bluetooth.available()){ // 블루투스로 데이터 수신
    byte data=bluetooth.read();
    
    if(data=='a'){
      dhtF();   //a수신 시 온습도 함수 실행
    }
    
    else if(data=='b'){
      babytF(); //b수신 시 체온 함수 실행
    }
    
    else if(data=='c'){ //c
      mySoftwareSerial.begin(9600);
  if (!myDFPlayer.begin(mySoftwareSerial)) {  //mp3플레이어 실행
    
  
  }
      myDFPlayer.play(1); //음악재생 기본 1번으로 시작
     myDFPlayer.volume(20); //볼륨 20으로 설정
   
    }
    
    else if(data=='d'){
      myDFPlayer.pause(); //정지
      Serial.println("pause");
   
    }
    else if(data=='f'){
      myDFPlayer.previous(); //이전
      Serial.println("previous");
      
    }
    else if(data=='g'){
      myDFPlayer.next(); ..//다음
      Serial.println("next");                                                   
    }
    else if(data=='1'){ //볼륨 10설정
      myDFPlayer.volume(10);
      
    }
     else if(data=='2'){ //볼륨 15설정
      myDFPlayer.volume(15);
     
    }
     else if(data=='3'){ //볼륨 20설정
      myDFPlayer.volume(20);
     
    }
     else if(data=='4'){ //볼륨 25설정
      myDFPlayer.volume(25);
      
    }
     else if(data=='5'){ //볼륨 30설정
      myDFPlayer.volume(30);
      
    }
  
    
    else if(data=='e'){ //모터 작동
      Serial.println("move");
    myservo1.attach(9);
    myservo2.attach(8);
     motorS();
     motorS();
     motorS();


      
       myservo1.detach();
       myservo2.detach();
      
     
              
  }
  
  
    

      
    }
    
  
    }
    

   
   
