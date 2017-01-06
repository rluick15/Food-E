package com.richluick.foode.main;

import javax.inject.Inject;

/**
 * Created by rluick on 1/5/2017.
 */

public class MainActivityNavigatorImpl implements MainActivityNavigator {

    private MainActivity activity;

    @Inject
    public MainActivityNavigatorImpl(MainActivity activity) {
        this.activity = activity;
    }

    @Inject


    @Override
    public void launchHomepage() {
        //activity.inflateFragment();
    }
}
