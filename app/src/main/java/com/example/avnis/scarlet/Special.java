package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Special extends AppCompatActivity {
    ImageButton back,magic,quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back=(ImageButton)findViewById(R.id.imageButton);
        quiz=(ImageButton)findViewById(R.id.imageButton9);
        magic=(ImageButton)findViewById(R.id.imageButton10);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Special.this, "Home", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(Special.this,Home.class);
                startActivity(i);
                finish();
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Special.this, "Quiz", Toast.LENGTH_SHORT).show();
                Intent j=new Intent(Special.this,Quiz.class);
                startActivity(j);
                finish();
            }
        });
        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Special.this, "Magical Music Player", Toast.LENGTH_SHORT).show();
                Intent j=new Intent(Special.this,Magic.class);
                startActivity(j);
                finish();
            }
        });
    }
}
