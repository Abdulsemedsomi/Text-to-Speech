package com.somiman73gmail.speech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Abdulsemed Mohammed on 9/2/2018.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent en = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(en);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
t.start();
    }
}
