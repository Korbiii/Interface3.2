package com.example.korbi.interface32;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Korbi on 22.10.2016.
 */

public class Pop extends Activity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Button button_stdp;
    static final int DIALOG_ID = 0;
    static final int DIALOG_ID2 = 1;
    static final int DIALOG_ID3 = 2;
    int hour_a,minute_a,day_a,month_a,year_a;
    int art = -1;
    Button b;
    Boolean ende = true;
    ArrayList<Information> d1;
    Project project;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup1);

        d1 = new ArrayList<>();
        d1 = Home.get();
        project = new Project();
        //Popup größe
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .3));

        //sportartID
        Bundle b = getIntent().getExtras();
        if (b != null) {
            art = b.getInt("sportart");
        }

    }

    public void beginn(View v) {

        Calendar c = Calendar.getInstance();
        hour_a=c.get(Calendar.HOUR);
        minute_a=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,this,hour_a,minute_a,true);
        timePickerDialog.show();
        b = (Button) v;
        project.begin_h = hour_a;
        project.begin_m = minute_a;
        ende = false;
    }

    public void ende(View v) {

        Calendar c = Calendar.getInstance();
        hour_a=c.get(Calendar.HOUR);
        minute_a=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,this,hour_a,minute_a,true);
        timePickerDialog.show();
        project.end_h = hour_a;
        project.end_m = minute_a;

        b = (Button) v;
        ende = true;
    }

    public void datum(View v) {

        Calendar c = Calendar.getInstance();
        year_a = c.get(Calendar.YEAR);
        month_a = c.get(Calendar.MONTH);
        day_a = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year_a, month_a, day_a);
        datePickerDialog.show();
        project.day = day_a;
        project.month = month_a;
        project.year=year_a;
        b = (Button) v;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        year_a = year;
        month_a = month;
        day_a = dayOfMonth;
        b.setText(day_a+"."+month_a+"."+year_a);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        NumberFormat f = new DecimalFormat("00");
        hour_a=hourOfDay;
        minute_a=minute;
        b.setText(f.format(hour_a)+":"+f.format(minute_a));
    }

    public void cancel(){
        finish();
    }

    public void ok(View v) {

        //fertiges Projekt in Datenbank übertragen
        //pushProject(project);
        finish();
    }


}
