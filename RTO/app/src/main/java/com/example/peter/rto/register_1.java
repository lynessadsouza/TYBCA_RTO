package com.example.peter.rto;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class register_1 extends AppCompatActivity {



    EditText e,e1,e2,e3,e4,e5,e6,e7;
    String name,username,DOB,email,password,confirmpassword,voterid,phonenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);
        e=(EditText)findViewById(R.id.editText2);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        e3=(EditText)findViewById(R.id.editText6);
        e4=(EditText)findViewById(R.id.editText7);
        e5=(EditText)findViewById(R.id.editText8);
        e6=(EditText)findViewById(R.id.editText10);
        e7=(EditText)findViewById(R.id.editText25);

    }

    public void regUser(View view)
    {
        name= e.getText().toString();
        username=e1.getText().toString();
        DOB=e2.getText().toString();
        email=e3.getText().toString();
        password=e4.getText().toString();
        confirmpassword=e5.getText().toString();
        voterid=e6.getText().toString();
        phonenumber=e7.getText().toString();


        String method="register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,name,password,DOB,email,password,confirmpassword,voterid,phonenumber);
        Intent i=new Intent(register_1.this,login_screen.class);
        startActivity(i);
    }
}




