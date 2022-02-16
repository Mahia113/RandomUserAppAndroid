package com.example.randomuserjusto.view;

import android.graphics.Bitmap;

import com.example.randomuserjusto.apiclient.entities.User;

import retrofit.RetrofitError;

public interface MainViewInterface {

    void displayUserData(User user);
    void displayUserImage(Bitmap image);
    void errorFetchingUserData(RetrofitError error);

}
