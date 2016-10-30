package com.example.korbi.interface32;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

   static ArrayList<Information> d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        buttons();
        if(d1==null){
        d1 = Data.getData();
        d2= new ArrayList<>();
        }
    }

    public static ArrayList<Information> get(){
        return d1;
    }

    public static ArrayList<Information> get2(){
        return d2;
    }

    public static void zeitPlan(Information info){
        d2.add(info);

    }


    private void buttons() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double width = size.x;
        width = width * 0.9;
        int widthh = (int) width;
        int height = size.y;
        Button sport = (Button) findViewById(R.id.sportart_button);
        Button einlad = (Button) findViewById(R.id.einladungen_button);
        Button nachr = (Button) findViewById(R.id.nachrichten_button);
        Button zeitP = (Button) findViewById(R.id.zeitplan_button);
        sport.setWidth(widthh / 2);
        sport.setHeight(widthh / 2);

        einlad.setWidth(widthh / 2);
        einlad.setHeight(widthh / 2);

        nachr.setWidth(widthh / 2);
        nachr.setHeight(widthh / 2);

        zeitP.setWidth(widthh / 2);
        zeitP.setHeight(widthh / 2);

    }
    public void sportart(View view){
        Intent intent = new Intent(this,  Sportart.class);
        startActivity(intent);

    }
    public void einladungen(View view){
        Intent intent = new Intent(this, Einladungen.class);
        startActivity(intent);

    }
    public void zeitplan(View view){
        Intent intent = new Intent(this, ZeitplanListe.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
