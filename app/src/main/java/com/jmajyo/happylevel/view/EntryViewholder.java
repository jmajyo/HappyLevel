package com.jmajyo.happylevel.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmajyo.happylevel.R;
import com.jmajyo.happylevel.model.Entry;

import java.text.SimpleDateFormat;

public class EntryViewholder extends RecyclerView.ViewHolder{

    private ImageView sadView;
    private ImageView neutralView;
    private ImageView happyView;
    private TextView hora;
    private TextView fecha;

    private Entry entry;



    public EntryViewholder(View itemView) {
        super(itemView);
        sadView = (ImageView) itemView.findViewById(R.id.row_layout___sad_icon);
        neutralView = (ImageView) itemView.findViewById(R.id.row_layout___neutral_icon);
        happyView = (ImageView) itemView.findViewById(R.id.row_layout___happy_icon);

        hora = (TextView) itemView.findViewById(R.id.row_layout___hours_text);
        fecha = (TextView) itemView.findViewById(R.id.row_layout___date_text);

    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
        showIconLight(entry);
    }

    private void showIconLight(Entry entry) {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MMM");
        String formattedDate = dt1.format(entry.getDate());

        SimpleDateFormat dt2 = new SimpleDateFormat("HH:mm");
        String formattedHour = dt2.format(entry.getDate());

        fecha.setText(formattedDate);
        hora.setText(formattedHour);

        switch (entry.getState()){
            case 0:
                sadView.setImageResource(R.drawable.sad_color);
                break;
            case 1:
                neutralView.setImageResource(R.drawable.normal_color);
                break;
            case 2:
                happyView.setImageResource(R.drawable.happy_color);
                break;
        }
    }
}
