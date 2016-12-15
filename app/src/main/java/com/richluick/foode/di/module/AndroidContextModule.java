package com.richluick.foode.di.module;

import android.content.Context;

import com.richluick.foode.di.context.ApplicationContext;
import com.richluick.foode.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 12/14/2016.
 *
 * Provides the application context through dagger
 */
@Module
public class AndroidContextModule {

    private Context context;

    public AndroidContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context provideApplicationContext() {
        return context;
    }
}
