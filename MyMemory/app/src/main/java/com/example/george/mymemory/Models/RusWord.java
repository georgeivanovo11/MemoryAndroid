package com.example.george.mymemory.Models;

import static android.R.attr.id;

public class RusWord
{
    private int Id;
    private String Title;

    public RusWord(int id, String title) {
        this.Id = id;
        this.Title = title;
    }

    public RusWord(String title) {
        this.Id = -1;
        this.Title = title;
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
