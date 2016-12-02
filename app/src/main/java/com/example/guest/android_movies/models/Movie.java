package com.example.guest.android_movies.models;

import org.parceler.Parcel;

@Parcel
public class Movie {
    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public boolean getmAdult() {
        return mAdult;
    }

    public void setmAdult(boolean mAdult) {
        this.mAdult = mAdult;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(int mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public int getmVoteCount() {
        return mVoteCount;
    }

    public void setmVoteCount(int mVoteCount) {
        this.mVoteCount = mVoteCount;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    private String mPoster;
    private boolean mAdult;
    private String mOverview;
    private String mDate;
    private String mTitle;
    private int mVoteCount;
    private int mVoteAverage;
    private int mId;

    public Movie() {}

    public Movie(String mPoster, boolean mAdult, String mOverview, String mDate, String mTitle, int mVoteCount, int mVoteAverage, int id) {
        this.mPoster = mPoster;
        this.mAdult = mAdult;
        this.mOverview = mOverview;
        this.mDate = mDate;
        this.mTitle = mTitle;
        this.mVoteCount = mVoteCount;
        this.mVoteAverage = mVoteAverage;
        this.mId = id;
    }
}
