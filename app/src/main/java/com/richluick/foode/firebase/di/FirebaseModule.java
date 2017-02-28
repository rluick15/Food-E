package com.richluick.foode.firebase.di;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.richluick.foode.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 12/15/2016.
 *
 * Contains all firebase related dependencies
 */
@Module
public class FirebaseModule {

    @Provides
    @ApplicationScope
    FirebaseRemoteConfig provideFirebaseRemoteConfig() {
        return FirebaseRemoteConfig.getInstance();
    }
}
