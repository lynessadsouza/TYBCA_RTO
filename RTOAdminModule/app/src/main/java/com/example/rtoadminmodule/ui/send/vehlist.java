package com.example.rtoadminmodule.ui.send;

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
import com.example.rtoadminmodule.ui.send.UservehInformation;

import java.util.List;

public class vehlist extends ArrayAdapter<UservehInformation> {

    public Activity context;
    public List<UservehInformation> uservehInformationList;

    public vehlist(Activity context,List<UservehInformation> uservehInformationList)
    {
        super(context, R.layout.listvehicle,uservehInformationList);
        this.context = context;
        this.uservehInformationList = uservehInformationList;
    }



///////iui


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listvehicle,null,true);


        TextView axeltype = (TextView) listViewItem.findViewById(R.id.axeltype);
        TextView cc = (TextView) listViewItem.findViewById(R.id.cc);
        TextView chassisnum = (TextView) listViewItem.findViewById(R.id.chassisnum);
        TextView clssofveh = (TextView) listViewItem.findViewById(R.id.clssofveh);
        TextView colour = (TextView) listViewItem.findViewById(R.id.colour);

        TextView engineno  = (TextView) listViewItem.findViewById(R.id.engineno);
        TextView fuel = (TextView) listViewItem.findViewById(R.id.fuel);
        TextView id = (TextView) listViewItem.findViewById(R.id.id);
        TextView makersname = (TextView) listViewItem.findViewById(R.id.makersname);
        TextView noofcyliners  = (TextView) listViewItem.findViewById(R.id.noofcyliners);
        TextView ownersname = (TextView) listViewItem.findViewById(R.id.ownersname);
        TextView purpose = (TextView) listViewItem.findViewById(R.id.purpose);
        TextView typebody = (TextView) listViewItem.findViewById(R.id.typebody);
        TextView unladenweight = (TextView) listViewItem.findViewById(R.id.unladenweight);
        UservehInformation uservehInformation = uservehInformationList.get(position);

String axl=uservehInformation.getAxel_type();
        Toast.makeText(getContext(),""+axl,Toast.LENGTH_LONG).show();
        axeltype.setText(uservehInformation.getAxel_type());
        cc.setText(uservehInformation.getCc());
        chassisnum.setText(uservehInformation.getChassis());
        clssofveh.setText(uservehInformation.getClassveh());
        axeltype.setText(uservehInformation.getAxel_type());
        colour.setText(uservehInformation.getColor());

        engineno.setText(uservehInformation.getEngineno());
        fuel.setText(uservehInformation.getFuel());
        id.setText(uservehInformation.getId());
        makersname.setText(uservehInformation.getMakers_name());
        noofcyliners.setText(uservehInformation.getNoofcyl());

        ownersname.setText(uservehInformation.getOwnersname());
        purpose.setText(uservehInformation.getPurpose());
        typebody.setText(uservehInformation.getTypebody());
        unladenweight.setText(uservehInformation.getUnladenweight());

        return listViewItem;
    }
}


