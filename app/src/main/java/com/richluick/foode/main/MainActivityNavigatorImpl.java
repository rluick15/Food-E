package com.richluick.foode.main;

import com.richluick.foode.R;
import com.richluick.foode.homepage.HomepageFragment;

import javax.inject.Inject;

/**
 * Created by rluickk on 1/5/2017.
 *
 * Implementation of all navigation logic for the homepage
 */
public class MainActivityNavigatorImpl implements MainActivityNavigator {

    private MainActivity activity;

    @Inject
    public MainActivityNavigatorImpl(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void launchHomepage() {
        activity.inflateFragment(HomepageFragment.newInstance(), R.id.content_main, false,
                HomepageFragment.class.getSimpleName());
    }
}
