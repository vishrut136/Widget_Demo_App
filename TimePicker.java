package com.example.vatsc.widgetdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class Timepicker extends AppCompatActivity {
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);
        tp = (TimePicker)findViewById(R.id.timePicker);
        Toast.makeText(getApplicationContext(), "Current Time : " +
                        tp.getHour()+"Hrs : "+tp.getMinute()+"min",
                Toast.LENGTH_LONG).show();
    }
    public void changeTime(View view) {
        Toast.makeText(getApplicationContext(), "Changed Time : " +
                tp.getHour() + "Hrs : " + tp.getMinute() +
                "min", Toast.LENGTH_LONG).show();
    }
}
