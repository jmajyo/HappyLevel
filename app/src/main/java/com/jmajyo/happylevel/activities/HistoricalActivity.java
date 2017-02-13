package com.jmajyo.happylevel.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jmajyo.happylevel.R;
import com.jmajyo.happylevel.adapters.EntryAdapter;
import com.jmajyo.happylevel.model.Entry;

import io.realm.Realm;
import io.realm.RealmResults;

public class HistoricalActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EntryAdapter adapter;
    Realm realm = Realm.getDefaultInstance();
    private RealmResults<Entry> entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical);

        entry = realm.where(Entry.class).findAllSorted("date");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EntryAdapter(this, entry);
        recyclerView.setAdapter(adapter);


    }
}
