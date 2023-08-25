#include <Arduino.h>
#include "SimpleLED.h"

SimpleLED led1(LED_BUILTIN, false, 100, 400);
SimpleLED led2(LED_BUILTIN_AUX, false, 100, 300);

void setup()
{
  long start = millis();
  led1.setup(start);
  led2.setup(start);
}

void loop()
{
  long now = millis();
  led1.update(now);
  led2.update(now);
}
