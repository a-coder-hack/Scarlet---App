package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    ImageButton back;

    RadioButton r1,r2,r3,r4;
    Button next;
    static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back=(ImageButton)findViewById(R.id.imageButton);
        next=(Button)findViewById(R.id.button4);
        r1=(RadioButton)findViewById(R.id.quiz_radioButton);
        r2=(RadioButton)findViewById(R.id.quiz_radioButton2);
        r3=(RadioButton)findViewById(R.id.quiz_radioButton3);
        r4=(RadioButton)findViewById(R.id.quiz_radioButton4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Quiz.this, "Special", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(Quiz.this,Special.class);
                startActivity(i);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                if(r4.isChecked())
                {
                    ++score;
                }
                else
                {
                    --score;
                }
                Intent i=new Intent(Quiz.this,Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}
