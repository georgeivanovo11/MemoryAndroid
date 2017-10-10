package com.example.george.mymemory.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartOfSpeech
{
    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("title")
    @Expose
    private String Title;

    public PartOfSpeech() {
    }

    public PartOfSpeech(int id, String title) {
        Id = id;
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
