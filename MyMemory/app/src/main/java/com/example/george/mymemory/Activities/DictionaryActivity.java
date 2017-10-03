package com.example.george.mymemory.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.george.mymemory.Adapters.DictionaryAdapter;
import com.example.george.mymemory.Models.EngWord;
import com.example.george.mymemory.Models.RusWord;
import com.example.george.mymemory.Models.Segment;
import com.example.george.mymemory.R;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import static android.R.id.list;

public class DictionaryActivity extends AppCompatActivity
{
    ListView mSegmentsListView;
    EditText mEditText;
    Button mAddButton;

    DictionaryAdapter adapter;

    private List<Segment> mSegments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        setInitialDataset();

        mSegmentsListView = (ListView) findViewById(R.id.segments_list);
        mEditText = (EditText) findViewById(R.id.search_textedit);
        mAddButton = (Button) findViewById(R.id.add_button);

        adapter = new DictionaryAdapter(this, R.layout.dictionary_list_item, mSegments);
        mSegmentsListView.setAdapter(adapter);

        mSegmentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l)
            {
                Segment selectedSegment = (Segment) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                               "You've chosen " + selectedSegment.getEngWord().getTitle(),
                               Toast.LENGTH_SHORT).show();
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_segment(mEditText.getText().toString());
            }
        });

    }

    private void setInitialDataset()
    {
        RusWord rus1 = new RusWord("отправить");
        RusWord rus2 = new RusWord("жить");
        EngWord eng1 = new EngWord("offensive");
        mSegments.add(new Segment(new EngWord("send"), rus1));
        mSegments.add(new Segment(new EngWord("dispatch"),rus1));
        mSegments.add(new Segment(new EngWord("live"),rus2));
        mSegments.add(new Segment(new EngWord("reside"),rus2));
        mSegments.add(new Segment(eng1,new RusWord("оскорбительный")));
        mSegments.add(new Segment(eng1,new RusWord("наступательный")));
    }

    private void add_segment(String str)
    {
        if(!str.isEmpty()) {
            if (!str.contains("-")) {
                Toast.makeText(getApplicationContext(),
                        "Enter eng and rus words!",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String[] parts = str.split("-");
            String engTitle = parts[0];
            String rusTitle = parts[1];

            EngWord eng = null;
            RusWord rus = null;

            for (Segment item : mSegments) {
                if (item.getEngWord().getTitle() == engTitle)
                    eng = item.getEngWord();
                if (item.getRusWord().getTitle() == rusTitle)
                    rus = item.getRusWord();
            }

            if (eng == null) {
                eng = new EngWord(engTitle);
            }

            if (rus == null) {
                rus = new RusWord(rusTitle);
            }

            Segment segment = new Segment(eng, rus);
            adapter.add(segment);
            adapter.notifyDataSetChanged();
            mEditText.setText("");
        }
    }
}
