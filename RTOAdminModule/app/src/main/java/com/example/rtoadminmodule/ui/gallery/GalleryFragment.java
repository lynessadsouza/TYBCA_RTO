package com.example.rtoadminmodule.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.rtoadminmodule.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    DatabaseReference databaseReference;



    ListView listViewUser;
    List<UserInformation> userInformationList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
      //  final TextView textView = root.findViewById(R.id.text_gallery);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");



        listViewUser = root.findViewById(R.id.listViewUsers);
        userInformationList = new ArrayList<>();





        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                userInformationList.clear();
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren())
                {
                    UserInformation userInformation = userSnapshot.getValue(UserInformation.class);
                    userInformationList.add(userInformation);

                    userList adapter = new userList(getActivity(),userInformationList);
                    listViewUser.setAdapter(adapter);
                }





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        return root;

    }
}