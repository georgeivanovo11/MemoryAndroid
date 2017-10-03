package com.example.george.mymemory.Models;

public class Segment
{
    private EngWord EngWord;
    private RusWord RusWord;

    public Segment(EngWord engWord, RusWord rusWord)
    {
        EngWord = engWord;
        RusWord = rusWord;
    }

    public EngWord getEngWord() {
        return EngWord;
    }

    public void setEngWord(EngWord engWord) {
        EngWord = engWord;
    }

    public RusWord getRusWord() {
        return RusWord;
    }

    public void setRusWord(RusWord rusWord) {
        RusWord = rusWord;
    }
}
