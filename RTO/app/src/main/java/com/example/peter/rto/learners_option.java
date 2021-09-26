package com.example.peter.rto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class learners_option extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learners_option);
        b1=(Button)findViewById(R.id.button9);
        b2=(Button)findViewById(R.id.button10);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(learners_option.this,learners_licence_screen.class);
                startActivity(i);

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent a=new Intent(learners_option.this,renewal_of_licence_screen.class);
                        startActivity(a);

                    }
                });
            }


        });

    }
}
