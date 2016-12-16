package com.richluick.foode.di.module;

import com.richluick.foode.di.scope.ApplicationScope;
import com.richluick.foode.splash.FirebaseRCUseCase;
import com.richluick.foode.splash.FirebaseRCUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 12/15/2016.
 *
 * Contains all firebase related dependencies
 */
@Module
public class FirebaseModule {

    @Provides
    @ApplicationScope
    FirebaseRCUseCase provideFirebaseRCUseCase(FirebaseRCUseCaseImpl useCase) {
        return useCase;
    }

}
