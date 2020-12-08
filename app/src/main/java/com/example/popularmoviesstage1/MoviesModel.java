package com.example.popularmoviesstage1;

import android.os.LocaleList;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MoviesModel {

    private ArrayList<String> poster_path;
    private ArrayList<String> original_title;
    private ArrayList<String> overview ;
    private ArrayList<String> release_date ;
    private ArrayList<String> vote_count;


    public MoviesModel(){

    }


    public MoviesModel(ArrayList<String> poster_path, ArrayList<String> original_title, ArrayList<String> overview, ArrayList<String> release_date, ArrayList<String> vote_count) {
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_count = vote_count;
    }

    public ArrayList<String> getPoster_path() {
        return poster_path;
    }

    public ArrayList<String> getOriginal_title() {
        return this.original_title;
    }

    public ArrayList<String> getOverview() {
        return overview;
    }

    public ArrayList<String> getRelease_date() {
        return release_date;
    }

    public ArrayList<String> getVote_count() {
        return vote_count;
    }


    public void setPoster_path(ArrayList<String> poster_path) {
        this.poster_path = poster_path;
    }

    public void setOriginal_title(ArrayList<String> original_title) {
        this.original_title = original_title;
    }

    public void setOverview(ArrayList<String> overview) {
        this.overview = overview;
    }

    public void setRelease_date(ArrayList<String> release_date) {
        this.release_date = release_date;
    }

    public void setVote_count(ArrayList<String> vote_count) {
        this.vote_count = vote_count;
    }


}
