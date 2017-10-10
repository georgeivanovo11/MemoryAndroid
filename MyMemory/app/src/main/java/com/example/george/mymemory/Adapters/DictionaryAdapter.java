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

import com.example.george.mymemory.Models.PartOfSpeech;
import com.example.george.mymemory.Models.Segment;
import com.example.george.mymemory.R;

import static android.media.CamcorderProfile.get;

public class DictionaryAdapter extends ArrayAdapter<PartOfSpeech>
{
    private LayoutInflater inflater;
    private int layout;
    private List<PartOfSpeech> pos;

    public DictionaryAdapter(Context context, int resource, List<PartOfSpeech> pos) {
        super(context, resource, pos);

        this.pos = pos;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView engTextView = (TextView) view.findViewById(R.id.engWord_textview);
        TextView rusTextView = (TextView) view.findViewById(R.id.rusWord_textview);

        PartOfSpeech p = pos.get(position);

        
        engTextView.setText(p.getTitle());
        rusTextView.setText(Integer.toString( p.getId()));

        return view;
    }
}
