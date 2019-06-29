package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button home;
    ImageButton facebook,twitter,netcamp;
    TextView result;
    WebView w;
    String s1="https://www.facebook.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        result=(TextView)findViewById(R.id.textView7);
        facebook=(ImageButton)findViewById(R.id.imageButton11);
        twitter=(ImageButton)findViewById(R.id.imageButton12);
        netcamp=(ImageButton)findViewById(R.id.imageButton13);
        home=(Button)findViewById(R.id.button8);
        w=(WebView)findViewById(R.id.webview);
        result.setText("YOU SCORED "+ Quiz.score);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Result.this,Home.class);
                startActivity(i);
                finish();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 s1="https://www.facebook.com";
                w.loadUrl(s1);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1="https://twitter.com";
                w.loadUrl(s1);
            }
        });
        netcamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.netcamp.in"));
                startActivity(browserIntent);
            }
        });

    }
}
