int leido;
int red = 13;
int blue = 12;

int red2 = 11;
int blue2 = 10;


int red3 = 9;
int blue3 = 8;

int red4 = 7;
int blue4 = 6;

int red5 = 5;
int blue5 = 4;

int red6 = 3;
int blue6 = 2;

int red7 = 30;
int blue7 = 31;

int red8 = 32;
int blue8 = 33;

int red9 = 34;
int blue9 = 35;

void setup() {
  Serial.begin(9600);
  pinMode(red, OUTPUT);
  pinMode(blue, OUTPUT);

  pinMode(red2, OUTPUT);
  pinMode(blue2, OUTPUT);

  pinMode(red3, OUTPUT);
  pinMode(blue3, OUTPUT);

  pinMode(red4, OUTPUT);
  pinMode(blue4, OUTPUT);

  pinMode(red5, OUTPUT);
  pinMode(blue5, OUTPUT);

  pinMode(red6, OUTPUT);
  pinMode(blue6, OUTPUT);

  pinMode(red7, OUTPUT);
  pinMode(blue7, OUTPUT);

  pinMode(red8, OUTPUT);
  pinMode(blue8, OUTPUT);

  pinMode(red9, OUTPUT);
  pinMode(blue9, OUTPUT);
  leido=0;

}

void loop() {
  if(Serial.available() == 1){
    if(Serial.read()==HIGH){
      delay(500);
      analogWrite(red,0);
      analogWrite(blue,255);
      Serial.println(1,DEC);

     analogWrite(red2,0);
     analogWrite(blue2,255);

     analogWrite(red3,0);
     analogWrite(blue3,255);  

     analogWrite(red4,0);
     analogWrite(blue4,255); 

     analogWrite(red5,0);
     analogWrite(blue5,255);

     analogWrite(red6,0);
     analogWrite(blue6,255);

     analogWrite(red7,0);
     analogWrite(blue7,255);

     analogWrite(red8,0);
     analogWrite(blue8,255);

     analogWrite(red9,0);
     analogWrite(blue9,255);

      leido=1;
    }
    else if(Serial.available() == 0){
     analogWrite(red,255);
     analogWrite(blue,0);

      analogWrite(red2,255);
      analogWrite(blue2,0);

     analogWrite(red3,255);
     analogWrite(blue3,0);

     analogWrite(red4,255);
     analogWrite(blue4,0);

     analogWrite(red5,255);
     analogWrite(blue5,0);

     analogWrite(red6,255);
     analogWrite(blue6,0);

     analogWrite(red7,255);
     analogWrite(blue7,0);

     analogWrite(red8,255);
     analogWrite(blue8,0);

     analogWrite(red9,255);
     analogWrite(blue9,0);
     leido=0;
    }
      else if(Serial.available() == (-127)){
 
   analogWrite(red,255);
   analogWrite(blue,255);

   analogWrite(red2,255);
   analogWrite(blue2, 255);
  }
  }


}
