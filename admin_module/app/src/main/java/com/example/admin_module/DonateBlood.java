package com.example.admin_module;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonateBlood extends AppCompatActivity {

    DatabaseReference databaseReference;


    ListView listViewUser;
    List<UserInformation> userInformationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_layout);

       databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");



        listViewUser = (ListView) findViewById(R.id.listViewUsers);
        userInformationList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userInformationList.clear();
                for (DataSnapshot donorSnapshot: dataSnapshot.getChildren()){
                    UserInformation userInformation = donorSnapshot.getValue(UserInformation.class);
                    userInformationList.add(userInformation);
                }
                DonorList adapter = new DonorList(DonateBlood.this,userInformationList);
                listViewUser.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}



