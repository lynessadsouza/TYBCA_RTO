package com.example.rtoadminmodule.ui.tools;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rtoadminmodule.R;
import com.example.rtoadminmodule.ui.tools.UserfedInformation;

import java.util.List;
public class feedbackList extends ArrayAdapter<UserfedInformation> {

    public Activity context;
    public List<UserfedInformation> userfedInformationList;

    public feedbackList(Activity context,List<UserfedInformation> userfedInformationList)
    {
        super(context, R.layout.listfeedback,userfedInformationList);
        this.context = context;
        this.userfedInformationList = userfedInformationList;
    }



///////iui


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listfeedback,null,true);
        TextView id = (TextView) listViewItem.findViewById(R.id.id);
        TextView rating = (TextView) listViewItem.findViewById(R.id.rating);
        UserfedInformation userfedInformation = userfedInformationList.get(position);

        id.setText(userfedInformation.getId());
       // rating.setText(userfedInformation.getFeedback());
        String feedback=(String.valueOf(userfedInformation.getFeedback()));
        //Toast.makeText(getContext(),""+feedback,Toast.LENGTH_LONG).show();
   // rating.setText(String.valueOf(userfedInformation.getFeedback()));
        return listViewItem;
    }
}



