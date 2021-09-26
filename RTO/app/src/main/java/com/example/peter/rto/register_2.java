package com.example.peter.rto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class register_2 extends AppCompatActivity {

    FirebaseAuth auth;
    EditText e1, e2;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    String verification_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_2);
        e1 = (EditText) findViewById(R.id.editText9);
        e2 = (EditText) findViewById(R.id.editText26);
        auth = FirebaseAuth.getInstance();


        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verification_code = s;
                Toast.makeText(getApplicationContext(), "code sent to the number", Toast.LENGTH_SHORT).show();

            }
        };
    }

    public void send_sms(View v) {
        String number = e1.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number, 60, TimeUnit.SECONDS, this, mCallback

        );

    }

    public void sign_in_with_fone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i=new Intent(register_2.this,register_1.class);
                            startActivity(i);
                            Toast msg = Toast.makeText(getApplicationContext(), "Verified user", Toast.LENGTH_SHORT);
                            msg.show();

                        }
                    }
                });
    }

    public void verify(View v) {
        String input_code = e2.getText().toString();

            verifyPhoneNumber(verification_code, input_code);


    }

    private void verifyPhoneNumber(String verifycode, String input_code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifycode, input_code);
        sign_in_with_fone(credential);
    }
}