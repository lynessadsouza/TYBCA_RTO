package com.example.rtoadminmodule.ui.tools;

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
import com.example.rtoadminmodule.ui.tools.UserfedInformation;
import com.example.rtoadminmodule.ui.tools.feedbackList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    DatabaseReference databaseReference;
    ListView listViewfed;
    List<UserfedInformation> userfedInformationList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Feedback");



        listViewfed = root.findViewById(R.id.listViewfed);
        userfedInformationList = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                userfedInformationList.clear();
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren())
                {
                    UserfedInformation userfedInformation = userSnapshot.getValue(UserfedInformation.class);
                    userfedInformationList.add(userfedInformation);

                    feedbackList adapter = new feedbackList(getActivity(),userfedInformationList);
                    listViewfed.setAdapter(adapter);
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