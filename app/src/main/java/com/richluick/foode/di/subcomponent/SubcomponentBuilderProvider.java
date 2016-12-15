package com.richluick.foode.di.subcomponent;

/**
 * Created by rluick on 12/14/2016.
 */
public interface SubcomponentBuilderProvider {

    SubcomponentBuilder getSubcomponentBuilder(Class<?> builderClass);
}
