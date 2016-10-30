package com.example.korbi.interface32;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        View view = inflater.inflate(R.layout.einladungen_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.textview.setText(data.get(position).title);
        myViewHolder.start.setText(data.get(position).start);
        myViewHolder.stopp.setText(data.get(position).stop);

        final int currentPosition = position;
        final Information infoData = data.get(position);

           myViewHolder.keineZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(infoData);
                data.remove(infoData);
            }


        });

        myViewHolder.habZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(infoData);
                data.remove(infoData);
                Home.zeitPlan(infoData);
            }
        });


    }

    private void removeItem(Information infoData) {
        int position = data.indexOf(infoData);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int pos, Information infoData) {
        data.add(pos, infoData);
        notifyItemInserted(pos);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textview;
        TextView start;
        TextView stopp;
        Button habZ;
        Button keineZ;

        public MyViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.txv_row);
            start = (TextView) itemView.findViewById(R.id.startzeit);
            stopp = (TextView) itemView.findViewById(R.id.stoppzeit);
            habZ = (Button) itemView.findViewById(R.id.habeZ_button);
            keineZ = (Button) itemView.findViewById(R.id.keineZ_button);
        }
    }
}
