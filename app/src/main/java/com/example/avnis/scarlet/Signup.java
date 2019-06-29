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
import android.widget.ImageButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    ImageButton im;
    Button b1;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        b1=(Button)findViewById(R.id.button3);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e5=(EditText)findViewById(R.id.editText7);
        im=(ImageButton)findViewById(R.id.imageButton);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Signup.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals(""))
                {
                    Toast.makeText(Signup.this,"FILL REQUIRED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase user= openOrCreateDatabase("data",MODE_PRIVATE,null);
                    user.execSQL("create table if not exists id(username varcahr,password varchar,email varchar,city varchar,phone int)");
                    String s6="select * from id where username=='"+s1+"' and password=='"+s2+"'";
                    Cursor cursor=user.rawQuery(s6,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        user.execSQL("insert into id values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Signup.this, "Successfully Signed up", Toast.LENGTH_SHORT).show();
                        Intent i3=new Intent(Signup.this,MainActivity.class);
                        startActivity(i3);
                        finish();
                    }
                }
            }
        });
    }
}
