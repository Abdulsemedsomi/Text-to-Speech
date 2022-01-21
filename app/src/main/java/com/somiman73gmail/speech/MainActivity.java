package com.somiman73gmail.speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

import static com.somiman73gmail.speech.R.id.buk;
import static com.somiman73gmail.speech.R.id.bus;

public class MainActivity extends AppCompatActivity  {
    ImageButton bukc,busc;

    EditText et;
    TextToSpeech ts ,tk ;
    String def ="No Input detected";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bukc= (ImageButton) findViewById(buk);
        et= (EditText) findViewById(R.id.txt);
        busc= (ImageButton) findViewById(bus);



       ts =new TextToSpeech(MainActivity.this ,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int i) {
                if (i !=TextToSpeech.ERROR  ) {

                    ts.setLanguage(Locale.US);
                }}
        });

        tk =new TextToSpeech(MainActivity.this ,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int i) {
                if (i !=TextToSpeech.ERROR  ){

                    tk.setLanguage(Locale.UK );
                    tk.setPitch(0);

                }}
        });

busc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String v = et.getText().toString();
        if (v.equalsIgnoreCase("")){
            ts.speak(def, TextToSpeech.QUEUE_FLUSH, null);
        }
else
        ts.speak(v, TextToSpeech.QUEUE_FLUSH, null);
    }
});
        bukc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String v = et.getText().toString();
                if (v.equalsIgnoreCase("")){
                    tk.speak(def, TextToSpeech.QUEUE_FLUSH, null);
                }else
                tk.speak(v, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    protected void onPause() {
        if (ts != null ){
            ts.stop();
            ts.shutdown();

        } if (tk != null ){
            tk.stop();
            tk.shutdown();

        }
        super.onPause();
    }

}
