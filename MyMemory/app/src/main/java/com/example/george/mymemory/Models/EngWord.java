package com.example.george.mymemory.Models;

import static android.R.attr.id;

public class EngWord
{
    private int Id;
    private String Title;

    public EngWord(int id, String title) {
        Id = id;
        Title = title;
    }

    public EngWord(String title) {
        Id = -1;
        Title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
