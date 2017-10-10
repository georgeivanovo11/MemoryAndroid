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
import com.example.george.mymemory.Services.EngWordService;
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
    ListView mWordListView;
    EditText mEditText;
    Button mSearchButton;

    EngWordService mEngWordService;

    DictionaryAdapter adapter;

    List<EngWord> mWordList = new ArrayList<EngWord>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mWordListView = (ListView) findViewById(R.id.word_listview);
        mEditText = (EditText) findViewById(R.id.search_textedit);
        mSearchButton = (Button) findViewById(R.id.search_button);

        mEngWordService = APIUtils.getEngWordService();

        getAllEngWord();

        mWordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l)
            {
                EngWord selected = (EngWord) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                               "You've chosen " +  selected.getTitle(),
                               Toast.LENGTH_SHORT).show();
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(mEditText.getText().toString() != " ")
//                    Log.i("hi", "+" + mEditText.getText().toString() + "+");
                findEngWordsBy(mEditText.getText().toString());
            }
        });

    }

    public void getAllEngWord()
    {
        Call<List<EngWord>> call = mEngWordService.getAllEngWords();
        call.enqueue(new Callback<List<EngWord>>()
        {
            @Override
            public void onResponse(Call<List<EngWord>> call, Response<List<EngWord>> response)
            {
                if(response.body() == null)
                {
                    mWordList.removeAll(mWordList);
                }
                else
                {
                    mWordList = response.body();
                }

                mWordListView.setAdapter(new DictionaryAdapter(
                        DictionaryActivity.this,
                        R.layout.dictionary_list_item,
                        mWordList)
                );
            }

            @Override
            public void onFailure(Call<List<EngWord>> call, Throwable t)
            {
                Toast.makeText(
                        getApplicationContext(),
                        "Error with server!",
                        Toast.LENGTH_SHORT
                ).show();
                Log.e("Error",t.getMessage());
            }
        });
    }

    public void findEngWordsBy(String partOfWord)
    {
        Call<List<EngWord>> call = mEngWordService.findEngWordsBy(partOfWord);
        call.enqueue(new Callback<List<EngWord>>()
        {
            @Override
            public void onResponse(Call<List<EngWord>> call, Response<List<EngWord>> response)
            {
                if(response.body() == null)
                {
                    mWordList.removeAll(mWordList);
                }
                else
                {
                    mWordList = response.body();
                }

                mWordListView.setAdapter(new DictionaryAdapter(
                        DictionaryActivity.this,
                        R.layout.dictionary_list_item,
                        mWordList)
                );
            }

            @Override
            public void onFailure(Call<List<EngWord>> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(), "Error with server!", Toast.LENGTH_SHORT).show();
                Log.e("Error",t.getMessage());
            }
        });
    }



}
