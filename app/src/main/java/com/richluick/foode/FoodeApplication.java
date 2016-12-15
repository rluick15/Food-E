package com.richluick.foode;

import android.app.Application;

import com.richluick.foode.di.component.DaggerGlobalComponent;
import com.richluick.foode.di.module.AndroidContextModule;
import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.di.subcomponent.SubcomponentBuilderProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by rluick on 12/14/2016.
 *
 * The application class for the app. Handles any library and misc instantiations
 */
public class FoodeApplication extends Application implements SubcomponentBuilderProvider {

    @Inject
    Map<Class<?>, Provider<SubcomponentBuilder>> subcomponentBuilders;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerGlobalComponent.builder()
                .androidContextModule(new AndroidContextModule(this))
                .build().inject(this);
    }

    @Override
    public SubcomponentBuilder getSubcomponentBuilder(Class<?> builderClass) {
        return subcomponentBuilders.get(builderClass).get();
    }
}
