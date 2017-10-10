package com.example.george.mymemory.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.george.mymemory.Models.EngWord;
import com.example.george.mymemory.Models.PartOfSpeech;
import com.example.george.mymemory.Models.Segment;
import com.example.george.mymemory.R;

import static android.media.CamcorderProfile.get;

public class DictionaryAdapter extends ArrayAdapter<EngWord>
{
    private LayoutInflater inflater;
    private int layout;
    private List<EngWord> words;

    public DictionaryAdapter(Context context, int resource, List<EngWord> words) {
        super(context, resource, words);

        this.words = words;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView engTextView = (TextView) view.findViewById(R.id.engWord_textview);
        TextView posTextView = (TextView) view.findViewById(R.id.partofspeech_textview);

        EngWord word = words.get(position);

        engTextView.setText(word.getTitle());
        posTextView.setText(word.getPos().getTitle());

        return view;
    }
}
