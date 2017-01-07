package com.richluick.foode.homepage.di;

import com.richluick.foode.di.scope.ScreenScope;
import com.richluick.foode.homepage.HomepagePresenter;
import com.richluick.foode.homepage.HomepagePresenterImpl;
import com.richluick.foode.homepage.HomepageView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 1/5/2017.
 */
@Module
public class HomepageModule {

    private HomepageView homepageView;

    public HomepageModule(HomepageView homepageView) {
        this.homepageView = homepageView;
    }

    @Provides
    @ScreenScope
    HomepageView provideHomepageView() {
        return homepageView;
    }

    @Provides
    @ScreenScope
    HomepagePresenter provideHomepagePresenter(HomepagePresenterImpl homepagePresenter) {
        return homepagePresenter;
    }
}
