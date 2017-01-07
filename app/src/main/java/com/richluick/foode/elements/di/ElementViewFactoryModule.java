package com.richluick.foode.elements.di;

import com.richluick.foode.di.scope.ActivityScope;
import com.richluick.foode.elements.ElementCreator;
import com.richluick.foode.elements.ElementView;
import com.richluick.foode.elements.ElementViewFactory;
import com.richluick.foode.elements.elements.joke.JokeElementCreator;
import com.richluick.foode.utils.Constants;
import com.richluick.foode.utils.Converter;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * Created by rluick on 1/7/2017.
 */
@Module
public abstract class ElementViewFactoryModule {

    @Binds
    @ActivityScope
    abstract Converter<String, ElementView> provideElementViewFactory(ElementViewFactory elementViewFactory);

    @Binds
    @IntoMap
    @StringKey(Constants.ELEMENT_JOKE)
    abstract ElementCreator provideJokeElement(JokeElementCreator jokeElementCreator);
}
