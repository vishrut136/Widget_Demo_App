package com.example.vatsc.widgetdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class Datepicker extends AppCompatActivity {
    DatePicker dtp;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        dtp = (DatePicker)findViewById(R.id.datePicker);
        str = dtp.getDayOfMonth()+"/"+(dtp.getMonth()+1)+"/"+ dtp.getYear();
        Toast.makeText(getApplicationContext(), "System Date : " + str, Toast.LENGTH_LONG).show();
    }
    public void setNewDate(View view) {
        str = dtp.getDayOfMonth() + "/" + (dtp.getMonth() + 1) + "/" + dtp.getYear();
        Toast.makeText(getApplicationContext(), "New Date : " + str, Toast.LENGTH_LONG).show();
    }
}
