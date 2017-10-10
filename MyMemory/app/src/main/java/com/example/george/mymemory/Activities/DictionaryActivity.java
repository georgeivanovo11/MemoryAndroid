package com.example.george.mymemory.Activities;

import android.icu.text.MessagePattern;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.example.george.mymemory.Models.PartOfSpeech;
import com.example.george.mymemory.Models.RusWord;
import com.example.george.mymemory.Models.Segment;
import com.example.george.mymemory.R;
import com.example.george.mymemory.Retrofit.APIUtils;
import com.example.george.mymemory.Services.PosService;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class DictionaryActivity extends AppCompatActivity
{
    ListView mSegmentsListView;
    EditText mEditText;
    Button mAddButton;

    PosService mPosService;

    DictionaryAdapter adapter;

    List<PartOfSpeech> mList = new ArrayList<PartOfSpeech>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mSegmentsListView = (ListView) findViewById(R.id.segments_listview);
        mEditText = (EditText) findViewById(R.id.search_textedit);
        mAddButton = (Button) findViewById(R.id.add_button);

        mPosService = APIUtils.getPosService();


        mSegmentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l)
            {
                PartOfSpeech selected = (PartOfSpeech) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                               "You've chosen " +  selected.getTitle(),
                               Toast.LENGTH_SHORT).show();
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPosList();


            }
        });

    }

    public void getPosList()
    {
        Call<List<PartOfSpeech>> call = mPosService.getPos();
        call.enqueue(new Callback<List<PartOfSpeech>>() {
            @Override
            public void onResponse(Call<List<PartOfSpeech>> call, Response<List<PartOfSpeech>> response) {
                if(response.isSuccessful()){
                    mList = response.body();
                    Log.i("ok", mList.get(0).getTitle());
                    mSegmentsListView.setAdapter(new DictionaryAdapter(DictionaryActivity.this,
                            R.layout.dictionary_list_item, mList));
                }
            }

            @Override
            public void onFailure(Call<List<PartOfSpeech>> call, Throwable t) {
                    Log.e("Error",t.getMessage());
            }
        });
    }



}
