package com.example.randomuserjusto.apiclient.services;

import retrofit.RestAdapter;

public class RandomUserService {

    // END POINT
    public static final String END_POINT = "https://randomuser.me";

    private boolean isDebug;
    private RestAdapter restAdapter;

    /**
     * Default constructor
     */
    public RandomUserService() {}

    /**
     * Set the {@link retrofit.RestAdapter} log level.
     *
     * @param isDebug If true, the log level is set to {@link retrofit.RestAdapter.LogLevel#FULL}.
     *                Otherwise {@link retrofit.RestAdapter.LogLevel#NONE}.
     */
    public RandomUserService setIsDebug (boolean isDebug) {
        this.isDebug = isDebug;
        if (restAdapter != null) {
            restAdapter.setLogLevel(isDebug ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
        }
        return this;
    }

    /**
     * Create a new {@link retrofit.RestAdapter.Builder}. Override this to e.g. set your own client or executor.
     *
     * @return A {@link retrofit.RestAdapter.Builder} with no modifications.
     */
    protected RestAdapter.Builder newRestAdapterBuilder () {
        return new RestAdapter.Builder();
    }

    /**
     * Return the current {@link retrofit.RestAdapter} instance. If none exists builds a new one.
     */
    protected RestAdapter getRestAdapter () {
        if (restAdapter == null) {
            RestAdapter.Builder builder = newRestAdapterBuilder();
            builder.setEndpoint(END_POINT);

            if (isDebug) {
                builder.setLogLevel(RestAdapter.LogLevel.FULL);
            }

            restAdapter = builder.build();
        }

        return restAdapter;
    }

    /**
     * Return a userServicesAsync instance.
     *
     */
    public UserServiceAsync userServicesAsync () {
        return getRestAdapter().create(UserServiceAsync.class);
    }

}
