package com.richluick.foode.presenter;

/**
 * Created by rluick on 12/14/2016.
 *
 * The base class for all Presenter interfaces. Holds any common methods shared among presenters
 */
public interface Presenter {

    //used to initialize any values in the presenter on the onstart method. Things like EventBus or Butterknife
    void start();

    //used to cancel or reset any values in the presenter
    void stop();
}
