package com.richluick.foode.main.di;

import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.di.subcomponent.SubcomponentKey;
import com.richluick.foode.homepage.di.HomepageComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by rluick on 1/5/2017.
 */
@Module(subcomponents = {
        HomepageComponent.class
})
public abstract class MainActivityComponentBinders {

    @Binds
    @IntoMap
    @SubcomponentKey(HomepageComponent.Builder.class)
    public abstract SubcomponentBuilder homepageFragment(HomepageComponent.Builder builder);
}
