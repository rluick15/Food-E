package com.richluick.foode.di.component;

import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.di.subcomponent.SubcomponentKey;
import com.richluick.foode.main.di.MainActivityComponent;
import com.richluick.foode.splash.di.SplashComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by rluick on 12/14/2016.
 *
 * Contains all direct subcomponents to the globalcomponent
 */
@Module(subcomponents = {
        SplashComponent.class,
        MainActivityComponent.class
})
public abstract class GlobalComponentBinders {

    @Binds
    @IntoMap
    @SubcomponentKey(SplashComponent.Builder.class)
    public abstract SubcomponentBuilder splashActivity(SplashComponent.Builder builder);

    @Binds
    @IntoMap
    @SubcomponentKey(MainActivityComponent.Builder.class)
    public abstract SubcomponentBuilder mainActivity(MainActivityComponent.Builder builder);
}
