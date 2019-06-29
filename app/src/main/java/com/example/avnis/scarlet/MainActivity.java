package com.example.avnis.scarlet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signup.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(MainActivity.this,"FILL REQUIRED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase user= openOrCreateDatabase("data",MODE_PRIVATE,null);
                    user.execSQL("create table if not exists id(username varcahr,password varchar,email varchar,city varchar,phone int)");
                    String s3="select * from id where username=='"+s1+"' and password=='"+s2+"'";
                    Cursor cursor=user.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "Succesfully Logined", Toast.LENGTH_SHORT).show();
                        Intent i2=new Intent(MainActivity.this,Home.class);
                        startActivity(i2);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        e2.setText("");
                    }
                }

            }
        });
    }
}
