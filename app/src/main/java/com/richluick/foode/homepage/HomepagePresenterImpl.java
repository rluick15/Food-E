package com.richluick.foode.homepage;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 */
public class HomepagePresenterImpl implements HomepagePresenter {

    private HomepageView homepageView;

    @Inject
    public HomepagePresenterImpl(HomepageView homepageView) {
        this.homepageView = homepageView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
