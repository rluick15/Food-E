package com.richluick.foode.usecase;

/**
 * Created by rluick on 12/15/2016.
 *
 * A simpified version of the UseCase interface. This is used for more custom scenarios that will
 * not require the UseCaseExecutor framework, which is ideal for retrofit related api calls. This
 * is used for most non-retrofit api calls for example, firebase remote config which has its own
 * sdk. This directly takes the UseCaseCallback as a parameter of the execute method so we have
 * more control over where the onCompleted and onError methods are called
 */
public interface SimpleUseCase<I> {

    void execute(UseCaseCallback<I> callback);
}
