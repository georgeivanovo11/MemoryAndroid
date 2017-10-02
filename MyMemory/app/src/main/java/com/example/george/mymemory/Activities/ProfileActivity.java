package com.example.george.mymemory.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.george.mymemory.R;

public class ProfileActivity extends AppCompatActivity
{
    Button mDictionaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mDictionaryButton = (Button) findViewById(R.id.dictionary_button);

        mDictionaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DictionaryIntent = new Intent(ProfileActivity.this, DictionaryActivity.class);
                startActivity(DictionaryIntent);
            }
        });
    }
}
