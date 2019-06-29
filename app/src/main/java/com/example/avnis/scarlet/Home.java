package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    ImageButton im1,im2,im3,im4,im5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        im1=(ImageButton)findViewById(R.id.imageButton);
        im2=(ImageButton)findViewById(R.id.imageButton2);
        im3=(ImageButton)findViewById(R.id.imageButton3);
        im4=(ImageButton)findViewById(R.id.imageButton4);
        im5=(ImageButton)findViewById(R.id.imageButton5);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Home.this,MainActivity.class);
                Toast.makeText(Home.this, "Login page", Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Home.this,Calculator.class);
                Toast.makeText(Home.this, "Calculator", Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Home.this,Music.class);
                Toast.makeText(Home.this, "Music", Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Home.this,Camera.class);
                Toast.makeText(Home.this, "Camera", Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Home.this,Special.class);
                Toast.makeText(Home.this, "Special", Toast.LENGTH_SHORT).show();
                startActivity(j);
                finish();
            }
        });

    }
}
