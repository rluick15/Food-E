package com.richluick.foode.splash;

import com.richluick.foode.usecase.UseCaseCallback;

import javax.inject.Inject;

/**
 * Created by rluic on 12/15/2016.
 */

public class FirebaseRCUseCaseImpl implements FirebaseRCUseCase {

    //todo: inject firebase?? makes more testable
    @Inject
    public FirebaseRCUseCaseImpl() {}

    @Override
    public void execute(UseCaseCallback<Object> callback) {
        callback.onCompleted(new Object()); //todo replace with Firebase
    }
}
