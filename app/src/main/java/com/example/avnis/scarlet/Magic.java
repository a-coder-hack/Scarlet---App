package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;


public class Magic extends AppCompatActivity implements SensorEventListener {
    ImageButton back;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mp=MediaPlayer.create(this,R.raw.mahi);
        back=(ImageButton)findViewById(R.id.imageButton);
        Toast.makeText(Magic.this, "Light controls the music", Toast.LENGTH_LONG).show();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Magic.this, "Special", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(Magic.this,Special.class);
                mp.stop();
                startActivity(i);
                finish();
            }
        });
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>10)
        {
            mp.start();
        }
        else
        {
            Toast.makeText(Magic.this, "Music paused", Toast.LENGTH_SHORT).show();
            mp.pause();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
