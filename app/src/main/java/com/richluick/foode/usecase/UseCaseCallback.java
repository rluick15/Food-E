package com.richluick.foode.usecase;

/**
 * Created by rluic on 12/15/2016.
 *
 * A basic callback interface for use cases. Can be extended for additional functionality
 */
public interface UseCaseCallback<R> {

    void onCompleted(R result);

    void onError(String error);
}
