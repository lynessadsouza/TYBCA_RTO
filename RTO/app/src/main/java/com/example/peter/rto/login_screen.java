package com.example.peter.rto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login_screen extends AppCompatActivity {


    EditText e;
    EditText e2;
    Button b1;
    TextView t;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        e = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText3);
        b1 = (Button) findViewById(R.id.button);
        t = (TextView) findViewById(R.id.textView4);
        t1 = (TextView) findViewById(R.id.textView7);





           // String uname = e.getText().toString();
          //  String type = "login";
          //  BackgroundWorker backgroundWorker = new BackgroundWorker(this);
          //  backgroundWorker.execute(type, uname, pwd);



t.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       // Intent i=new Intent(login_screen.this,register_1.class);
   //     startActivity( i);

       Intent t=new Intent(login_screen.this,register_2.class);
       startActivity(t);


    }
});
    }
}
