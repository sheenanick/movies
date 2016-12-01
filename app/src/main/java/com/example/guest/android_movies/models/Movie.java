package com.example.guest.android_movies.models;

/**
 * Created by Guest on 12/1/16.
 */
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

    private String mPoster;
    private boolean mAdult;
    private String mOverview;
    private String mDate;
    private String mTitle;
    private int mVoteCount;
    private int mVoteAverage;


    public Movie(String mPoster, boolean mAdult, String mOverview, String mDate, String mTitle, int mVoteCount, int mVoteAverage) {
        this.mPoster = "https://image.tmdb.org/t/p/w500" + mPoster;
        this.mAdult = mAdult;
        this.mOverview = mOverview;
        this.mDate = mDate;
        this.mTitle = mTitle;
        this.mVoteCount = mVoteCount;
        this.mVoteAverage = mVoteAverage;
    }
}
