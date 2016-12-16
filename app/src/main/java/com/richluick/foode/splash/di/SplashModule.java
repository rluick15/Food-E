package com.richluick.foode.splash.di;

import android.content.Context;
import android.os.Handler;

import com.richluick.foode.di.scope.ScreenScope;
import com.richluick.foode.splash.SplashNavigator;
import com.richluick.foode.splash.SplashNavigatorImpl;
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
    private Context context;

    public SplashModule(SplashView splashView, Context context) {
        this.splashView = splashView;
        this.context = context;
    }

    @Provides
    @ScreenScope
    Context provideSplashContext() {
        return context;
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

    @Provides
    @ScreenScope
    SplashNavigator provideSplashNavigator(SplashNavigatorImpl splashNavigator) {
        return splashNavigator;
    }

    @Provides
    @ScreenScope
    Handler provideSplashHandler() {
        return new Handler();
    }
}
