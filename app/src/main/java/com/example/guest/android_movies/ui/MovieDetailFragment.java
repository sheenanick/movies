package com.example.guest.android_movies.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.android_movies.R;
import com.example.guest.android_movies.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.movieImageView) ImageView mMovieImage;
    @Bind(R.id.movieTitleTextView) TextView mTitle;
    @Bind(R.id.overviewTextView) TextView mOverview;
    @Bind(R.id.ratingTextView) TextView mRating;

    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);
        mMovieImage.setOnClickListener(this);
        Picasso.with(view.getContext()).load(mMovie.getmPoster()).into(mMovieImage);

        mTitle.setText(mMovie.getmTitle());
        mOverview.setText(mMovie.getmOverview());
        mRating.setText(mMovie.getmVoteAverage() + "/10");
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.themoviedb.org/movie/" + mMovie.getmId()));
        startActivity(webIntent);
    }

}
