package com.example.george.mymemory.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.george.mymemory.Models.Segment;
import com.example.george.mymemory.R;

public class DictionaryAdapter extends ArrayAdapter<Segment>
{
    private LayoutInflater inflater;
    private int layout;
    private List<Segment> segments;

    public DictionaryAdapter(Context context, int resource, List<Segment> segments) {
        super(context, resource, segments);
        this.segments = segments;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView engTextView = (TextView) view.findViewById(R.id.engWord_textview);
        TextView rusTextView = (TextView) view.findViewById(R.id.rusWord_textview);

        Segment segment = segments.get(position);

        engTextView.setText(segment.getEngWord().getTitle());
        rusTextView.setText(segment.getRusWord().getTitle());

        return view;
    }
}
