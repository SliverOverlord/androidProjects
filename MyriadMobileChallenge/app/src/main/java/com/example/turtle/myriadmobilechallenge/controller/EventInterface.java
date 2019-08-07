package com.example.turtle.myriadmobilechallenge.controller;

import com.example.turtle.myriadmobilechallenge.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface EventInterface {
    @GET("events")
   Call<ArrayList<Event>> getAllEvents(@Header("Authorization") String tokenKey);
}
