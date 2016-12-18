package com.richluick.foode;

import android.app.Application;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
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
    @Inject
    FirebaseRemoteConfig firebaseRemoteConfig;

    @Override
    public void onCreate() {
        super.onCreate();

        //setup and inject dagger
        DaggerGlobalComponent.builder()
                .androidContextModule(new AndroidContextModule(this))
                .build().inject(this);

        //setup Firebase Remote Config
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        firebaseRemoteConfig.setConfigSettings(configSettings);
        firebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
    }

    @Override
    public SubcomponentBuilder getSubcomponentBuilder(Class<?> builderClass) {
        return subcomponentBuilders.get(builderClass).get();
    }
}
