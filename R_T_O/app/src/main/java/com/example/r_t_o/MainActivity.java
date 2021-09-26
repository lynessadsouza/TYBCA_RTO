package com.example.r_t_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e2, e4, e5, e6, e7, e8, e10, e25;
    Button register;


 //   String name, username, dob, email, password, confirmpass, voterid, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    //    Intent i= new Intent(MainActivity.this,testActivity.class);
    //    startActivity(i);

//name
        e2 = (EditText) findViewById(R.id.editText2);
     //   name=e2.getText().toString().trim();

        //username
        e4 = (EditText) findViewById(R.id.editText4);
 //       username=e4.getText().toString().trim();

        //dob
        e5 = (EditText) findViewById(R.id.editText5);
  //     dob=e5.getText().toString().trim();

        //email
        e6 = (EditText) findViewById(R.id.editText6);
       // email=e6.getText().toString().trim();

        //password
        e7 = (EditText) findViewById(R.id.editText7);
       // password=e7.getText().toString().trim();

        //confirmpass
        e8 = (EditText) findViewById(R.id.editText8);
       // confirmpass=e8.getText().toString().trim();

        //voterid
        e10 = (EditText) findViewById(R.id.editText10);
  //      voterid=e8.getText().toString().trim();

        //mobile
        e25 = findViewById(R.id.editText25);
       // mobile=e25.getText().toString().trim();

        register = (Button) findViewById(R.id.button2);
                    register.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                          String  name=e2.getText().toString().trim();
                          String  username=e4.getText().toString().trim();
                            String  dob=e5.getText().toString().trim();
                            String   email=e6.getText().toString().trim();
                            String   password=e7.getText().toString().trim();
                            String   confirmpass=e8.getText().toString().trim();
                            String voterid=e10.getText().toString().trim();
                            String  mobile=e25.getText().toString().trim();

                            if(name.isEmpty())
                            {
                                e2.setError("Please enter your name ");
                                e2.requestFocus();
                                return;
                            }
                             if (username.isEmpty())
                            {
                                e4.setError("Username cannot be empty");
                                e25.requestFocus();
                                return;
                            }
                             if(dob.isEmpty())

                            {
                                e5.setError("Username cannot be empty");
                                e5.requestFocus();
                                return;
                            }
                             if(email.isEmpty())
                            {
                                e6.setError("Email address cannot be empty");
                                e6.requestFocus();
                                return;
                            }
                             if (password.isEmpty())

                            {
                                e7.setError("please enter your password");
                                e7.requestFocus();
                                return;
                            }
                             if(confirmpass.isEmpty())

                            {
                                e8.setError("confirm password cannnot be empty");
                                e8.requestFocus();
                                return;
                            }
                          //   if(e7.getText().toString()!= e8.getText().toString())
                          //   {
                          //       e8.setError("confirm password should be same ");
                          //       e8.requestFocus();
                          //       return;
                          //   }

                             if (voterid.isEmpty())
                            {
                                e10.setError("Voters id is mandatory");
                                e10.requestFocus();
                                return;
                            }
                            if  (mobile.isEmpty()||mobile.length()<10)
                            {
                                e25.setError("Enter a valid mobile");
                                e25.requestFocus();
                                return;
                            }


                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);


                          intent.putExtra("name ", name);
                            intent.putExtra("username ", username);
                            intent.putExtra("dob ", dob);
                            intent.putExtra("email ", email);
                            intent.putExtra("password ", password);
                            intent.putExtra("voterid", voterid);
                            intent.putExtra("mobile", mobile);
                            startActivity(intent);


                        }

                    });


    }

}















