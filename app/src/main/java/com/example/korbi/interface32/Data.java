package com.example.korbi.interface32;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
/**
 * Created by Korbi on 22.10.2016.
 */

public class Data {

    protected void onCreate(){
        getData();
    }

    public static ArrayList<Information> getData() {

            ArrayList<Information> data = new ArrayList<>();


            String[] Categories = {"Beachvolleyball", "Laufen", "Beachvolleyball", "Fußball", "Laufen"};
            String[] Start = {"12:00", "11:00", "17:00", "19:00", "11:00", "17:00", "19:00", "11:00", "17:00", "19:00", "11:00", "17:00", "19:00", "11:00", "17:00", "19:00"};
            String[] Stop = {"11:00", "12:00", "19:00", "17:00", "19:00", "17:00", "19:00", "17:00", "19:00", "17:00", "19:00", "17:00", "19:00", "17:00", "19:00", "17:00"};
            String[] Datum = {"5.7", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4", "4.8", "10.9", "4.4"};


            for (int i = 0; i < Categories.length; i++) {

                Information current = new Information();
                current.title = Categories[i];
                current.start = Start[i];
                current.stop = Stop[i];
                current.datum = Datum[i];

                data.add(current);
            }

            return data;
    }


}
