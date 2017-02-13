package com.jmajyo.happylevel.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmajyo.happylevel.R;
import com.jmajyo.happylevel.model.Entry;
import com.jmajyo.happylevel.view.EntryViewholder;

import io.realm.RealmResults;

public class EntryAdapter extends RecyclerView.Adapter<EntryViewholder>{
    private RealmResults<Entry> listOfEntry;
    private LayoutInflater layoutInflater;

    public EntryAdapter(Context context, RealmResults<Entry> listOfEntry) {
        this.listOfEntry = listOfEntry;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public EntryViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new EntryViewholder(view);
    }

    @Override
    public void onBindViewHolder(EntryViewholder holder, int position) {
        holder.setEntry(listOfEntry.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfEntry.size();
    }
}
