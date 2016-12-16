package com.richluick.foode.di.component;

import com.richluick.foode.FoodeApplication;
import com.richluick.foode.di.module.AndroidContextModule;
import com.richluick.foode.di.module.FirebaseModule;
import com.richluick.foode.di.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by rluick on 12/14/2016.
 *
 * The parent Dagger component for all dependencies in the app. All activity and fragment components
 * are subcomponents of this, direct and indirect. All modules in this component contain global
 * dependencies
 */
@Component(modules = {
        GlobalComponentBinders.class,
        AndroidContextModule.class,
        FirebaseModule.class
})
@ApplicationScope
public interface GlobalComponent {

    void inject(FoodeApplication application);
}
