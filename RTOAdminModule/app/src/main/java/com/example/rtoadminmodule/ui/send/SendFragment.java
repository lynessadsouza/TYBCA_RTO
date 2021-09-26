package com.example.rtoadminmodule.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.rtoadminmodule.R;
import com.example.rtoadminmodule.ui.send.SendViewModel;
import com.example.rtoadminmodule.ui.send.UservehInformation;
import com.example.rtoadminmodule.ui.send.vehlist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SendFragment extends Fragment {




    DatabaseReference databaseReference;
    ListView listViewveh;
    List<UservehInformation> uservehInformationList;

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
       // final TextView textView = root.findViewById(R.id.text_send);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Veh_Reg");



        listViewveh = root.findViewById(R.id.listViewveh);
        uservehInformationList = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                uservehInformationList.clear();
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren())
                {
                    UservehInformation uservehInformation = userSnapshot.getValue(UservehInformation.class);
                    uservehInformationList.add(uservehInformation);

                    vehlist adapter = new vehlist(getActivity(),uservehInformationList);
                    listViewveh.setAdapter(adapter);
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



