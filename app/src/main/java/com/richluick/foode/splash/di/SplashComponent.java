package com.richluick.foode.splash.di;

import com.richluick.foode.di.scope.ScreenScope;
import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by rluick on 12/14/2016.
 *
 * The dagger component for the Splash Screen
 */
@ScreenScope
@Subcomponent(modules = {
    SplashModule.class
})
public interface SplashComponent {

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<SplashComponent> {
        Builder buildSplashModule(SplashModule splashModule);
    }

    void inject(SplashActivity splashActivity);
}
