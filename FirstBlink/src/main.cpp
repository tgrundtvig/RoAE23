#include <Arduino.h>

int LED1 = LED_BUILTIN;
int LED2 = LED_BUILTIN_AUX;


class MyClass
{

};

void setup()
{
  // put your setup code here, to run once:
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
}

void loop()
{
  digitalWrite(LED1, HIGH);
  digitalWrite(LED2, LOW);
  delay(1000);
  digitalWrite(LED1, LOW);
  digitalWrite(LED2, HIGH);
  delay(500);
}
