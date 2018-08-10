package com.example.john.recycleview_demo_01;

/**
 * Created by John on 1/29/2017.
 */

public class Song {
    private String mCode;
    private String mTitle;
    private String mLycric;
    private String mArtist;

    public  Song(){}
    public  Song(String code, String title, String lycric, String artist)
    {
        mCode=code;
        mTitle=title;
        mLycric=lycric;
        mArtist=artist;
    }

    public String getmCode() {
        return mCode;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmLycric() {
        return mLycric;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmLycric(String mLycric) {
        this.mLycric = mLycric;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }
}
