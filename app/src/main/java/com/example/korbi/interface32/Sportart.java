package com.example.korbi.interface32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sportart extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;
    String[] beach = {"1", "8", "145", "4", "5"};
    String[] fuss = {"0", "7", "125", "8", "2"};
    Button training;
    Button fSpiel;
    Button lSpiel;
    RelativeLayout rangLayout;
    RelativeLayout gelaufen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ich bin ein Nutzloser Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mySpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapater = new ArrayAdapter<String>(Sportart.this, R.layout.custom_spinner_item, getResources().getStringArray(R.array.names));
        myAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapater);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Sportart.this, mySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                update(mySpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        training = (Button) findViewById(R.id.button_training);
        fSpiel = (Button) findViewById(R.id.button_fSpiel);
        lSpiel = (Button) findViewById(R.id.button_lSpiel);
        rangLayout = (RelativeLayout) findViewById(R.id.layout_top);
        gelaufen = (RelativeLayout) findViewById(R.id.layout_laufen);
    }

    public void freund(View v) {
        Intent intent = new Intent(this, Pop.class);
        startActivity(intent);
    }

    private void update(String string) {
        TextView siege = (TextView) findViewById(R.id.textview_siege);
        TextView niederlage = (TextView) findViewById(R.id.textiview_niederlage);
        TextView rang = (TextView) findViewById(R.id.textview_rang2);
        TextView weltweit = (TextView) findViewById(R.id.textview_weltweit);
        if (string.equals("Beachen")) {
            training.setVisibility(View.GONE);
            fSpiel.setVisibility(View.VISIBLE);
            lSpiel.setVisibility(View.VISIBLE);
            siege.setText(beach[1]);
            niederlage.setText(beach[2]);
            rang.setText(beach[3]);
            weltweit.setText(beach[4]);
            rangLayout.setVisibility(RelativeLayout.VISIBLE);

            gelaufen.setVisibility(RelativeLayout.GONE);
        } else if (string.equals("Fußball")) {
            training.setVisibility(View.GONE);
            fSpiel.setVisibility(View.VISIBLE);
            lSpiel.setVisibility(View.VISIBLE);
            siege.setText(fuss[1]);
            niederlage.setText(fuss[2]);
            rang.setText(fuss[3]);
            weltweit.setText(fuss[4]);
            gelaufen.setVisibility(RelativeLayout.GONE);
            rangLayout.setVisibility(RelativeLayout.VISIBLE);

        } else if (string.equals("Laufen")) {
            training.setVisibility(View.VISIBLE);
            fSpiel.setVisibility(View.GONE);
            lSpiel.setVisibility(View.GONE);
            rangLayout.setVisibility(RelativeLayout.GONE);
            gelaufen.setVisibility(RelativeLayout.VISIBLE);
        }
    }


}
