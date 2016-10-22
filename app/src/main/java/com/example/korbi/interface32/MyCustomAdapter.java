package com.example.korbi.interface32;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Korbi on 22.10.2016.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;

    public MyCustomAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.einladungen_item,parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.textview.setText(data.get(position).title);
        myViewHolder.start.setText(data.get(position).start);
        myViewHolder.stopp.setText(data.get(position).stop);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textview;
        TextView start;
        TextView stopp;
        ImageView imageview;

        public MyViewHolder (View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.txv_row);
            start = (TextView) itemView.findViewById(R.id.startzeit);
            stopp = (TextView) itemView.findViewById(R.id.stoppzeit);
        }
    }
}
