package com.android.a19870101_jayasakthivelrajasekaran_nycshools;

import android.app.Application;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.rest.RestFactory;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.rest.RestInterface;

public class App extends Application {

    public static App app;
    public RestInterface rest;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        rest = createRest();
    }

    protected RestInterface createRest() {
        return RestFactory.build(RestInterface.class);
    }
}
