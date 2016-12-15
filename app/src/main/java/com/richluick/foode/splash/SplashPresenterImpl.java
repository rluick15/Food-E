package com.richluick.foode.splash;

import javax.inject.Inject;

/**
 * Created by rluick on 12/14/2016.
 *
 * The splash presenter interface implementaion containg logic for the splash screen page
 */
public class SplashPresenterImpl implements SplashPresenter {

    private SplashView splashView;

    @Inject
    public SplashPresenterImpl(SplashView splashView) {
        this.splashView = splashView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
