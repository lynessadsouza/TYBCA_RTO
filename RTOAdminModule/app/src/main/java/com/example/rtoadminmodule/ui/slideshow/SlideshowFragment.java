package com.example.rtoadminmodule.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rtoadminmodule.R;
import com.example.rtoadminmodule.ui.slideshow.UserlicInformation;
import com.example.rtoadminmodule.ui.slideshow.learnerslist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    DatabaseReference databaseReference;

    ListView listViewlic;
    List<UserlicInformation> userlicInformationList;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Learners_Lic");



        listViewlic = root.findViewById(R.id.listViewLic);
        userlicInformationList = new ArrayList<>();





        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                userlicInformationList.clear();
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren())
                {
                    UserlicInformation userlicInformation = userSnapshot.getValue(UserlicInformation.class);
                    userlicInformationList.add(userlicInformation);

                    learnerslist adapter = new learnerslist(getActivity(),userlicInformationList);
                    listViewlic.setAdapter(adapter);
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