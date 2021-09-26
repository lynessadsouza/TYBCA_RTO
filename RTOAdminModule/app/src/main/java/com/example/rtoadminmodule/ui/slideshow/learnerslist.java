package com.example.rtoadminmodule.ui.slideshow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rtoadminmodule.R;

import java.util.List;


public class learnerslist extends ArrayAdapter<UserlicInformation> {

    public Activity context;
    public List<UserlicInformation> userlicInformationList;

    public learnerslist(Activity context,List<UserlicInformation> userlicInformationList
    ){
        super(context, R.layout.list_layout,userlicInformationList);
        this.context = context;
        this.userlicInformationList = userlicInformationList;
    }






    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listliclayout,null,true);


        TextView appname = (TextView) listViewItem.findViewById(R.id.appname);

        TextView bgroup = (TextView) listViewItem.findViewById(R.id.bgroup);
        TextView dateofconviction = (TextView) listViewItem.findViewById(R.id.dateofconviction);
        TextView disqualificationdetails = (TextView) listViewItem.findViewById(R.id.disqualificationdetails);
        TextView dob = (TextView) listViewItem.findViewById(R.id.dob);


        TextView drivingtest = (TextView) listViewItem.findViewById(R.id.drivingtest);
        TextView equalification = (TextView) listViewItem.findViewById(R.id.equalification);

        TextView existingdrivinglicence = (TextView) listViewItem.findViewById(R.id.dob);
        TextView gdianName = (TextView) listViewItem.findViewById(R.id.bgroup);
        TextView idmark = (TextView) listViewItem.findViewById(R.id.dateofconviction);
        TextView mig = (TextView) listViewItem.findViewById(R.id.disqualificationdetails);
        TextView paddress = (TextView) listViewItem.findViewById(R.id.dob);
        TextView taddress = (TextView) listViewItem.findViewById(R.id.dob);




        UserlicInformation userlicInformation = userlicInformationList.get(position);

        appname.setText(userlicInformation.getAppname());
        bgroup.setText(userlicInformation.getBgroup());
        dateofconviction.setText(userlicInformation.getDateofconviction());
        disqualificationdetails.setText(userlicInformation.getDisqualificationdetails());
        dob.setText(userlicInformation.getDob());

        drivingtest.setText(userlicInformation.getDrivingtest());
        equalification.setText(userlicInformation.getEqualification());
        existingdrivinglicence.setText(userlicInformation.getExistingdrivinglicence());
        gdianName.setText(userlicInformation.getGdianName());
        idmark.setText(userlicInformation.getIdmark());
        mig.setText(userlicInformation.getMig());
        paddress.setText(userlicInformation.getPaddress());
        taddress.setText(userlicInformation.getTaddress());
        return listViewItem;
    }
}



