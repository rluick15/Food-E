package com.richluick.foode.main.di;

import com.richluick.foode.di.scope.ActivityScope;
import com.richluick.foode.main.MainActivity;
import com.richluick.foode.main.MainActivityNavigator;
import com.richluick.foode.main.MainActivityNavigatorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 1/5/2017.
 */
@Module
public class MainActivityModule {

    private MainActivity activity;

    public MainActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    MainActivityNavigator provideMainActivityNavigator(MainActivityNavigatorImpl mainActivityNavigator) {
        return mainActivityNavigator;
    }
}
