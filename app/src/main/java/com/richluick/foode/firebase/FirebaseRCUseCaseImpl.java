package com.richluick.foode.firebase;

import android.app.Activity;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.richluick.foode.usecase.UseCaseCallback;

import javax.inject.Inject;

/**
 * Created by rluic on 12/15/2016.
 */

public class FirebaseRCUseCaseImpl implements FirebaseRCUseCase {

    private FirebaseRemoteConfig firebaseRemoteConfig;
    private Activity context;

    @Inject
    public FirebaseRCUseCaseImpl(FirebaseRemoteConfig firebaseRemoteConfig, Activity context) {
        this.firebaseRemoteConfig = firebaseRemoteConfig;
        this.context = context;
    }

    @Override
    public void execute(final UseCaseCallback<Object> callback) {
//        long cacheExpiration = 3600; // 1 hour in seconds.
//        if (firebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
//            cacheExpiration = 0;
//        }
//
//        firebaseRemoteConfig.fetch(cacheExpiration).addOnCompleteListener(context, new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    firebaseRemoteConfig.activateFetched();
//                    callback.onCompleted(null); //no return value
//                } else {
//                    callback.onError("");
//                }
//            }
//        });

        //todo: remove this. There is currently a bug in firebase where the fetch callbacks are not called
        //todo: see http://stackoverflow.com/questions/37311582/firebase-remote-config-cant-read-any-values-but-fetch-is-successful
        firebaseRemoteConfig.activateFetched();
        callback.onCompleted(null); //no return value
    }
}
