package com.richluick.foode.splash;

import android.os.Handler;

import com.richluick.foode.firebase.FirebaseRCUseCase;
import com.richluick.foode.usecase.UseCaseCallback;

import javax.inject.Inject;

/**
 * Created by rluick on 12/14/2016.
 *
 * The splash presenter interface implementation containg logic for the splash screen page
 */
public class SplashPresenterImpl implements SplashPresenter, UseCaseCallback<Object> {

    private static final int SPLASH_DELAY_TIME_MILLIS = 3000;

    private SplashView splashView;
    private SplashNavigator splashNavigator;
    private FirebaseRCUseCase firebaseRCUseCase;
    private Handler handler;

    @Inject
    public SplashPresenterImpl(SplashView splashView, SplashNavigator splashNavigator,
                               FirebaseRCUseCase firebaseRCUseCase, Handler handler) {
        this.splashView = splashView;
        this.splashNavigator = splashNavigator;
        this.firebaseRCUseCase = firebaseRCUseCase;
        this.handler = handler;
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
        firebaseRCUseCase.execute(this);
    }

    @Override
    public void onCompleted(Object result) {
        handler.postDelayed(new Runnable() {
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
