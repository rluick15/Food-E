package com.richluick.foode.splash;

import android.os.Handler;

import com.richluick.foode.usecase.UseCaseCallback;

import javax.inject.Inject;

/**
 * Created by rluick on 12/14/2016.
 *
 * The splash presenter interface implementaion containg logic for the splash screen page
 */
public class SplashPresenterImpl implements SplashPresenter, UseCaseCallback {

    private static final int SPLASH_DELAY_TIME_MILLIS = 4000;

    private SplashView splashView;
    private SplashNavigator splashNavigator;

    @Inject
    public SplashPresenterImpl(SplashView splashView, SplashNavigator splashNavigator) {
        this.splashView = splashView;
        this.splashNavigator = splashNavigator;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    /**
     * Initiates a use case request to fetch the application settings from Firebase remote config
     */
    @Override
    public void downloadSettingsFromFirebase() {

    }

    @Override
    public void onCompleted(Object result) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashNavigator.goToMainPage();
            }
        }, SPLASH_DELAY_TIME_MILLIS);
    }

    @Override
    public void onError(String error) {
        //todo: handle error
    }
}
