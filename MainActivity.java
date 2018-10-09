package com.example.vatsc.widgetdemoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;
import android.app.Activity;
import android.content.*;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp3;
    Button btn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn.setOnCreateContextMenuListener(this);

        }
     //dialog bar
     public void onBackPressed()
     {
         builder = new AlertDialog.Builder(MainActivity.this);
         builder.setMessage("Do you really want to exit?");
         builder.setCancelable(true);

         builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 finish();
             }
         });
         builder.setNegativeButton("No",new DialogInterface.OnClickListener()
         {
             public void onClick(DialogInterface dialoginterface,int i)
             {
                 dialoginterface.cancel();
             }
         });
         AlertDialog alertDialog = builder.create();
         alertDialog.show();
     }




    //context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu, v, menuInfo);
        createMenu(menu);

    }
    public boolean onContextItemSelected(MenuItem item) {
        return menuChoice(item);
    }


    private void createMenu(Menu menu)
    {
        MenuItem menu1 = menu.add(0, 0, 0, "Time Picker Widget");
        MenuItem menu2 = menu.add(0, 1, 1, "date Picker Widget");
        MenuItem menu3 = menu.add(0, 2, 2, "Play Song");
        MenuItem menu4 = menu.add(0, 3, 3, "Stop Song");
        MenuItem menu5 = menu.add(0,4,4,"Exit");
    }

    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Intent timepicker = new Intent(MainActivity.this,Timepicker.class);
                startActivity(timepicker);
                return true;

            case 1:
                Intent datepicker  =new Intent(MainActivity.this,Datepicker.class);
                startActivity(datepicker);

                return true;
            case 2:
                mp3 = MediaPlayer.create(this,R.raw.vaishnavjan);
                mp3.start();

                return true;
            case 3:
                mp3.stop();

                return true;
            case 4:
               onBackPressed();
               return true;

        }
        return true;
    }
    //option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id =item.getItemId();
        if(id==R.id.id_time_picker)
        {
            Intent timepicker = new Intent(MainActivity.this,Timepicker.class);
            startActivity(timepicker);
            return true;

        }
        if(id==R.id.id_date_picker)
        {   Intent datepicker  =new Intent(MainActivity.this,Datepicker.class);
            startActivity(datepicker);
            return true;

        }
        if(id==R.id.id_play_song)
        {
            mp3 = MediaPlayer.create(this,R.raw.vaishnavjan);
            mp3.start();
            return true;

        }
        if(id==R.id.id_stop_song)
        {   mp3.stop();
            return true;

        }
        if(id==R.id.id_exit)
        { onBackPressed();
            return true;

        }
        return  true;

    }

}
