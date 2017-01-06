package com.richluick.foode.homepage.di;

import com.richluick.foode.di.scope.ScreenScope;
import com.richluick.foode.di.subcomponent.SubcomponentBuilder;
import com.richluick.foode.homepage.HomepageFragment;

import dagger.Subcomponent;

/**
 * Created by rluick on 1/5/2017.
 */
@ScreenScope
@Subcomponent(modules = {
        HomepageModule.class
})
public interface HomepageComponent {

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<HomepageComponent> {
        HomepageComponent.Builder buildHomepageComponent(HomepageModule homepageModule);
    }

    void inject(HomepageFragment homepageFragment);
}
