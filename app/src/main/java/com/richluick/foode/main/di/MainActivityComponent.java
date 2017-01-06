package com.richluick.foode.main.di;

import com.richluick.foode.di.scope.ActivityScope;
import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by rluick on 1/5/2017.
 */
@ActivityScope
@Subcomponent(modules = {
        MainActivityComponentBinders.class,
        MainActivityModule.class
})
public interface MainActivityComponent {

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<MainActivityComponent> {
        MainActivityComponent.Builder buildMainActivityComponent(MainActivityModule mainActivityModule);
    }

    void inject(MainActivity mainActivity);
}
