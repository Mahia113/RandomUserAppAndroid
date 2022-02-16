package com.example.randomuserjusto.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.randomuserjusto.apiclient.entities.UserRandomResponse;
import com.example.randomuserjusto.apiclient.services.RandomUserService;
import com.example.randomuserjusto.apiclient.services.UserServiceAsync;
import com.example.randomuserjusto.view.MainViewInterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainPresenter {

    private final MainViewInterface mainViewInterface;
    RandomUserService randomUserService = new RandomUserService();

    public MainPresenter(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
        randomUserService.setIsDebug(true);
    }

    public void getUserData(){
        UserServiceAsync userService = randomUserService.userServicesAsync();

        userService.getUser(new Callback<UserRandomResponse>() {
            @Override
            public void success(UserRandomResponse userRandomResponse, Response response) {
                mainViewInterface.displayUserData(userRandomResponse.getResults().get(0));
            }

            @Override
            public void failure(RetrofitError error) {
                mainViewInterface.errorFetchingUserData(error);
            }
        });
    }

    public void loadAvatar(String URL){

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {

            try {
                URL newurl = new URL(URL);
                Bitmap image = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
                mainViewInterface.displayUserImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
