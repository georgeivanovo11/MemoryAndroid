package com.example.george.mymemory.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static android.R.attr.id;

public class EngWord
{
    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("title")
    @Expose
    private String Title;

    @SerializedName("transcription")
    @Expose
    private String Transcription;

    @SerializedName("partOfSpeech")
    @Expose
    private PartOfSpeech pos;

    public EngWord() {
    }

    public EngWord(int id, String title, String transcription, PartOfSpeech pos) {
        Id = id;
        Title = title;
        Transcription = transcription;
        this.pos = pos;
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

    public String getTranscription() {
        return Transcription;
    }

    public void setTranscription(String transcription) {
        Transcription = transcription;
    }

    public PartOfSpeech getPos() {
        return pos;
    }

    public void setPos(PartOfSpeech pos) {
        this.pos = pos;
    }
}
