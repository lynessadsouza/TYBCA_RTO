package com.example.admin_module;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DonorList extends ArrayAdapter<UserInformation> {

    private Activity context;
    private List<UserInformation> userInformationList;

    public DonorList(Activity context,List<UserInformation> userInformationList){
        super(context,R.layout.list_layout,userInformationList);
        this.context = context;
        this.userInformationList = userInformationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);


        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);

        TextView textViewdob = (TextView) listViewItem.findViewById(R.id.textViewdob);
        TextView textViewphone = (TextView) listViewItem.findViewById(R.id.textViewphone);
        TextView textViewusername = (TextView) listViewItem.findViewById(R.id.textViewusername);
        TextView textViewid = (TextView) listViewItem.findViewById(R.id.textViewid);







        UserInformation userInformation = userInformationList.get(position);

        textViewName.setText(userInformation.getName());
        textViewdob.setText(userInformation.getDob());
        textViewphone.setText(userInformation.getPhone());
        textViewusername.setText(userInformation.getUsername());
        textViewid.setText(userInformation.getId());



        return listViewItem;
    }
}
