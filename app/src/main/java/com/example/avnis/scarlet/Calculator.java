package com.example.avnis.scarlet;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculator extends AppCompatActivity{
    EditText e1,e2;
    TextView t1,t2;
    ImageButton im;
    Integer i=0;
    TextToSpeech text;
    Button add,sub,multi,div,reset,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        e1=(EditText)findViewById(R.id.editText8);
        e2=(EditText)findViewById(R.id.editText9);
        t1=(TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView4);
        add=(Button)findViewById(R.id.cal_button5);
        sub=(Button)findViewById(R.id.cal_button8);
        multi=(Button)findViewById(R.id.cal_button);
        div=(Button)findViewById(R.id.cal_button4);
        result=(Button)findViewById(R.id.cal_button7);
        reset=(Button)findViewById(R.id.cal_button6);
        im=(ImageButton)findViewById(R.id.cal_imageButton);
        text=new TextToSpeech(Calculator.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                text.setLanguage(Locale.ENGLISH);
                text.setSpeechRate(0.8f);
            }
        });
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Calculator.this,Home.class);
                startActivity(i);
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               t1.setText("+");
                i=1;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("-");
                i=2;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("/");
                i=3;
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("*");
                i=4;
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s4=" ";
                String s7=" ";
                if(s1.equals("") || s2.equals("")) {
                    Toast.makeText(Calculator.this, "Fill required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Float i1=Float.parseFloat(s1);
                    Float i2=Float.parseFloat(s2);
                    Float i3=i1 * i2;
                    String s3=Float.toString(i3);

                    if(i==1)
                    {
                        i3=i1 + i2;
                        s4=" + ";
                        s7=" plus ";
                        s3=Float.toString(i3);
                    }
                    if(i==2)
                    {
                        i3=i1 - i2;
                        s4=" - ";
                        s7=" minus ";
                        s3=Float.toString(i3);
                    }
                    if(i==3)
                    {
                        i3=i1 / i2;
                        s4=" / ";
                        s7=" divide ";
                        s3=Float.toString(i3);
                    }
                    if(i==4)
                    {
                        i3=i1 * i2;
                        s4=" * ";
                        s7=" multiply ";
                        s3=Float.toString(i3);
                    }
                    String s5=s1+s4+s2+" = "+s3;
                    String s6=s1+s7+s2+" = "+s3;
                    text.speak(s6,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), s5, Toast.LENGTH_SHORT).show();
                    t2.setText(s3);
                }
            }

        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                t1.setText("");
                t2.setText("");
            }
        });


    }
}
