package com.example.guest.android_movies.services;

import com.example.guest.android_movies.Constants;
import com.example.guest.android_movies.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieService {

    public static void findMovies(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SEARCH_QUERY, title);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY, Constants.API_KEY);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void findMovies(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TOP_MOVIE_API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY, Constants.API_KEY);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject moviedbJSON = new JSONObject(jsonData);
                JSONArray moviesJSON = moviedbJSON.getJSONArray("results");
                for (int i = 0; i < moviesJSON.length(); i++) {
                    JSONObject movieJSON = moviesJSON.getJSONObject(i);
                    String poster = movieJSON.getString("poster_path");
                    boolean adult = movieJSON.getBoolean("adult");
                    String overview = movieJSON.getString("overview");
                    String date = movieJSON.getString("release_date");
                    String title = movieJSON.getString("title");
                    int voteCount = movieJSON.getInt("vote_count");
                    int voteAverage = movieJSON.getInt("vote_average");
                    int id = movieJSON.getInt("id");
                    if (poster.equals("null")) {
                        poster = "http://www.interlog.com/~tfs/images/posters/TFSMoviePosterUnavailable.jpg";
                    }else{
                        poster = "https://image.tmdb.org/t/p/w500" + poster;
                    }
                    Movie movie = new Movie(poster, adult, overview, date, title, voteCount, voteAverage, id);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }

}
