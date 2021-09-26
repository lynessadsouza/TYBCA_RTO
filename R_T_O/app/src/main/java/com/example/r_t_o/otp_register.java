package com.example.r_t_o;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class otp_register extends AppCompatActivity {
    //These are the objects needed
    //It is the verification id that will be sent to the user
    private String mVerificationId;

    //The edittext to input the code
    private EditText editTextCode;

    //firebase auth object
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;


    //for database
    DatabaseReference databaseReference;

    public String name, username, dob, email, password, voterid, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_register);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        //initializing objects
        mAuth = FirebaseAuth.getInstance();
        progressbar = findViewById(R.id.progressbar);
        editTextCode = findViewById(R.id.editTextCode);


        //getting mobile number from the previous activity
        //and sending the verification code to the number

        //error is over here

        Intent intent = getIntent();

        name = intent.getStringExtra("name ");
        username = intent.getStringExtra("username ");
        dob = intent.getStringExtra("dob ");
        email = intent.getStringExtra("email ");
        password = intent.getStringExtra("password ");
        voterid = intent.getStringExtra("voterid ");
        mobile = intent.getStringExtra("mobile");


        sendVerificationCode(mobile);


        //if the automatic sms detection did not work, user can also enter the code manually
        //so adding a click listener to the button
        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextCode.getText().toString().trim();
                if (code.isEmpty() || code.length() < 6) {
                    editTextCode.setError("Enter valid code");
                    editTextCode.requestFocus();
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);


                //verifying the code entered manually


                verifyVerificationCode(code);


                //for database


            }


        });

    }

    //the method is sending verification code
    //the country id is concatenated
    //you can take the country id as user input as well
    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                //time duration
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
        return;
    }


    //the callback to detect the verification status
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            //Getting the code sent by SMS
            String code= null;
            code = phoneAuthCredential.getSmsCode();

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                editTextCode.setText(code);
                //verifying the code
                progressbar.setVisibility(View.VISIBLE);
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(otp_register.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            //storing the verification id that is sent to the user
            mVerificationId = s;
        }
    };


    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(otp_register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            String name1 = name;
                            String username1 = username;
                            String dob1 = dob;
                            String email1 = email;
                            String password1 = password;
                            String voterid1 = voterid;
                            String mobile1 = mobile;

                            String id = databaseReference.push().getKey();
                            UserInformation userInformation = new UserInformation(id, name1, username1, dob1, email1, password1, voterid1, mobile1);
                            databaseReference.child(id).setValue(userInformation);
                            Toast.makeText(getApplicationContext(), "Stored successfully", Toast.LENGTH_LONG).show();


                            Intent intent = new Intent(otp_register.this, justtesting.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {

                            //verification unsuccessful.. display an error message

                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }

                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
                            snackbar.setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });
                            snackbar.show();
                        }
                    }
                });
    }
}
   /*  public void saveInfo()
            {


                Toast.makeText(getApplicationContext(),"Save info " , Toast.LENGTH_LONG).show();
                String name1=name;
                String username1=username;
              String dob1=dob;
                String email1=email;
               String password1=password;
                String voterid1=voterid;
                String mobile1=mobile;

               String id=databaseReference.push().getKey();
         //       UserInformation=new user
                UserInformation userInformation= new UserInformation(id , name1, username1, dob1, email1, password1, voterid1 ,mobile1);
                databaseReference.child(id).setValue(userInformation);
              Toast.makeText(getApplicationContext(),"Stored successfully",Toast.LENGTH_LONG).show();
            }
*/


