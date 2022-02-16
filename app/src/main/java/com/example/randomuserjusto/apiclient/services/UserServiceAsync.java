package com.example.randomuserjusto.apiclient.services;

import com.example.randomuserjusto.apiclient.entities.UserRandomResponse;

import retrofit.Callback;
import retrofit.http.GET;

public interface UserServiceAsync {

    /**
     * Returns a random user asynchronously.
     *
     * @param callback
     */
    @GET("/api/")
    public void getUser(Callback<UserRandomResponse> callback);

}
