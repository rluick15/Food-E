package com.richluick.foode.usecase;

import io.reactivex.Observer;

/**
 * Created by rluic on 2/28/2017.
 */

public interface UseCase<I> {

    void execute(Observer<I> observer);
}
