package com.richluick.foode.main.di;

import com.richluick.foode.di.scope.ActivityScope;
import com.richluick.foode.elements.ElementView;
import com.richluick.foode.elements.ElementViewFactory;
import com.richluick.foode.utils.Converter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 1/7/2017.
 */
@Module
public class ElementViewFactoryModule {

    @Provides
    @ActivityScope
    Converter<String, ElementView> provideElementViewFactory(ElementViewFactory elementViewFactory) {
        return elementViewFactory;
    }
}
