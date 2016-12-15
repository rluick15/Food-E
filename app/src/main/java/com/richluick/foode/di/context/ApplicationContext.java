package com.richluick.foode.di.context;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by rluick on 12/14/2016.
 *
 * Qualifier annotation used to specify to use the application context in case there is a dagger
 * conflict with activity based context
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
