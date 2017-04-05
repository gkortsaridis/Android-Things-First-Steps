package com.gkortsaridis.androidthingsfirststeps;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.gkortsaridis.androidthingsfirststeps.Music.AdvancedSpeaker;
import com.gkortsaridis.androidthingsfirststeps.Music.Notes;
import com.google.android.things.contrib.driver.button.Button;
import com.google.android.things.contrib.driver.button.ButtonInputDriver;
import com.google.android.things.contrib.driver.pwmspeaker.Speaker;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;
import com.google.android.things.pio.Pwm;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MainActivity extends Activity {

    private static final String GPIO_RGB_RED = "BCM19";
    private static final String GPIO_RGB_GREEN = "BCM6";
    private static final String GPIO_RGB_BLUE = "BCM5";
    private static final String GPIO_BUTTON = "BCM21";

    private Switch redSw,blueSw, greenSw;

    private Gpio mLedGpioRed,mLedGpioGreen,mLedGpioBlue;
    private Gpio led1,led2,led3,led4,led5,led6,led7;
    private ButtonInputDriver mButtonInputDriver;

    Thread custListLoadThread;

    int rgbState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgbSwitches();

        PeripheralManagerService service = new PeripheralManagerService();
        Log.i("Available GPIOs",service.getGpioList().toString());

        try {

            led1 = service.openGpio("BCM23");
            led1.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led2 = service.openGpio("BCM24");
            led2.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led3 = service.openGpio("BCM25");
            led3.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led4 = service.openGpio("BCM12");
            led4.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led5 = service.openGpio("BCM16");
            led5.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led6 = service.openGpio("BCM20");
            led6.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            led7 = service.openGpio("BCM26");
            led7.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            mLedGpioRed = service.openGpio(GPIO_RGB_RED);
            mLedGpioGreen = service.openGpio(GPIO_RGB_GREEN);
            mLedGpioBlue = service.openGpio(GPIO_RGB_BLUE);

            mLedGpioRed.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            mLedGpioGreen.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            mLedGpioBlue.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

            mButtonInputDriver = new ButtonInputDriver(
                    GPIO_BUTTON,
                    Button.LogicState.PRESSED_WHEN_LOW,
                    KeyEvent.KEYCODE_0);
            mButtonInputDriver.register();

        } catch (IOException e) {
            e.printStackTrace();
        }

        final Handler handler = new Handler();


        Runnable r=new Runnable() {
            public void run() {
                try {
                    loop();
                    custListLoadThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        custListLoadThread = new Thread(r);
        custListLoadThread.start();



    }

    public void rgbSwitches(){
        redSw = (Switch) findViewById(R.id.swRed);
        greenSw = (Switch) findViewById(R.id.swGreen);
        blueSw = (Switch) findViewById(R.id.swBlue);

        redSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mLedGpioRed.setValue(!isChecked);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        greenSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mLedGpioGreen.setValue(!isChecked);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        blueSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mLedGpioBlue.setValue(!isChecked);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void loop() throws IOException {
        int del = 150;

        led1.setValue(true);
        delay(del);
        led2.setValue(true);
        delay(del);
        led3.setValue(true);
        delay(del);
        led4.setValue(true);
        delay(del);
        led5.setValue(true);
        delay(del);
        led6.setValue(true);
        delay(del);
        led7.setValue(true);
        delay(del);

        led1.setValue(false);
        delay(del);
        led2.setValue(false);
        delay(del);
        led3.setValue(false);
        delay(del);
        led4.setValue(false);
        delay(del);
        led5.setValue(false);
        delay(del);
        led6.setValue(false);
        delay(del);
        led7.setValue(false);
        delay(del);

    }

    public void delay(long milis){
        try{
            sleep(milis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_0) {
            Log.i("ON KEY","DOWN");
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_0) {
            Log.i("ON KEY","UP");
            try {
                changeRGBstate();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    private void changeRGBstate() throws IOException {
        if(rgbState < 3){
            rgbState++;
        }else{
            rgbState = 0;
        }

        if(rgbState == 0){
            redSw.setChecked(false);
            greenSw.setChecked(false);
            blueSw.setChecked(false);
            mLedGpioRed.setValue(true);
            mLedGpioGreen.setValue(true);
            mLedGpioBlue.setValue(true);
        }else if(rgbState == 1){
            redSw.setChecked(true);
            greenSw.setChecked(false);
            blueSw.setChecked(false);
            mLedGpioRed.setValue(false);
            mLedGpioGreen.setValue(true);
            mLedGpioBlue.setValue(true);
        }else if(rgbState == 2){
            redSw.setChecked(false);
            greenSw.setChecked(true);
            blueSw.setChecked(false);
            mLedGpioRed.setValue(true);
            mLedGpioGreen.setValue(false);
            mLedGpioBlue.setValue(true);
        }else if(rgbState == 3){
            redSw.setChecked(false);
            greenSw.setChecked(false);
            blueSw.setChecked(true);
            mLedGpioRed.setValue(true);
            mLedGpioGreen.setValue(true);
            mLedGpioBlue.setValue(false);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mLedGpioRed!=null){
            try {
                mLedGpioRed.close();
                mLedGpioBlue.close();
                mLedGpioGreen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
