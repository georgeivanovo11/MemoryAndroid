package com.example.george.mymemory.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.george.mymemory.R;

public class DictionaryActivity extends AppCompatActivity
{
    ListView mSegmentsListView;

    String[] countries = {"asd","asd","sadas"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mSegmentsListView = (ListView) findViewById(R.id.segments_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);

        mSegmentsListView.setAdapter(adapter);
    }
}
