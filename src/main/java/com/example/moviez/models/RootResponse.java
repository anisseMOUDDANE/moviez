package com.example.moviez.models;

import java.util.ArrayList;
import com.example.moviez.models.Result;

public class RootResponse{
    public int page;
    public ArrayList<Result> results;
    public int total_pages;
    public int total_results;

    @Override
    public String toString() {
        return "RootResponse{" +
                "page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}