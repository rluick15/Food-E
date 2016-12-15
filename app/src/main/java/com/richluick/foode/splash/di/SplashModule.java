package com.richluick.foode.splash.di;

import com.richluick.foode.di.scope.ScreenScope;
import com.richluick.foode.splash.SplashPresenter;
import com.richluick.foode.splash.SplashPresenterImpl;
import com.richluick.foode.splash.SplashView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 12/14/2016.
 *
 * Module holding all dependencies for the splash screen
 */
@Module
public class SplashModule {

    private SplashView splashView;

    public SplashModule(SplashView splashView) {
        this.splashView = splashView;
    }

    @Provides
    @ScreenScope
    SplashView provideSplashView() {
        return splashView;
    }

    @Provides
    @ScreenScope
    SplashPresenter provideSplashPresenter(SplashPresenterImpl presenter) {
        return presenter;
    }
}
