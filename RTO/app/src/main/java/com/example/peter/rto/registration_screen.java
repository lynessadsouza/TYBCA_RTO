package com.example.peter.rto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class registration_screen extends AppCompatActivity {


    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    EditText e6;
    EditText e7;
    EditText e8;
    EditText e9;
    EditText e10;
    Button b1;
    Spinner s1;
    Spinner s2;
    Spinner s3;
    DatePicker d1;
    EditText e11;

    String typeofbody, makersname, axeltype, noofcylinder, ownersname, cc, chassisno, engineno, unladenweigh, color;
    String dateofbirth;
    String classofvehicle, purpose, fuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
        e1 = (EditText) findViewById(R.id.editText13);
        e2 = (EditText) findViewById(R.id.editText15);
        e3 = (EditText) findViewById(R.id.editText18);
        e4 = (EditText) findViewById(R.id.editText20);
        e5 = (EditText) findViewById(R.id.editText21);
        e6 = (EditText) findViewById(R.id.editText33);
        e7 = (EditText) findViewById(R.id.editText14);
        e8 = (EditText) findViewById(R.id.editText17);
        e9 = (EditText) findViewById(R.id.editText19);
        e10 = (EditText) findViewById(R.id.editText16);
        b1 = (Button) findViewById(R.id.button5);
        s1 = (Spinner) findViewById(R.id.spinner);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);
        d1 = (DatePicker) findViewById(R.id.datePicker);
//e11=(EditText)findViewById(R.id.editText11);


        additemsonspinners1();
        additemsonspinner2();
        additemsonspinner3();


    }

    public void additemsonspinners1() {
        List<String> list = new ArrayList<String>();

        list.add("LMW");
        list.add("HMV");
        list.add("MCWG");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter);

    }

    public void additemsonspinner2() {
        List<String> list = new ArrayList<String>();
        list.add("Commercial");
        list.add("Non-Commercial");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter);

    }

    public void additemsonspinner3() {
        List<String> list = new ArrayList<String>();
        list.add("Petrol");
        list.add("Diesel");
        list.add("CNG");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(dataAdapter);

    }

    public void regveh (View View)
    {

        classofvehicle=s1.getSelectedItem().toString();
        typeofbody= e1.getText().toString();
        makersname=e2.getText().toString();
        purpose=s2.getSelectedItem().toString();
        axeltype=e3.getText().toString();
        noofcylinder=e4.getText().toString();
        ownersname=e5.getText().toString();
        cc=e6.getText().toString();
        chassisno=e7.getText().toString();
        unladenweigh=e8.getText().toString();
        color  =e9.getText().toString();
        fuel=s3.getSelectedItem().toString();
        engineno=e10.getText().toString();

        String method="vehregister";
        Backgroundvehicle backgroundvehicle=new Backgroundvehicle(this);
        backgroundvehicle.execute(method,classofvehicle, typeofbody,makersname,purpose,axeltype,noofcylinder ,cc,chassisno,engineno,unladenweigh,fuel,color,ownersname);

        finish();

    }
}