package com.richluick.foode.homepage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.richluick.foode.utils.Constants;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 */
public class HomepagePresenterImpl implements HomepagePresenter {

    private HomepageView homepageView;
    private FirebaseRemoteConfig firebaseRemoteConfig;

    @Inject
    public HomepagePresenterImpl(HomepageView homepageView, FirebaseRemoteConfig firebaseRemoteConfig) {
        this.homepageView = homepageView;
        this.firebaseRemoteConfig = firebaseRemoteConfig;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    /**
     * Gets the String list of element types from Firebase RC and returns it to the HomepageView to
     * use to set up the element list on the homepage
     */
    @Override
    public void getHomepageElementList() {
        String elementTypes = firebaseRemoteConfig.getString(Constants.FIREBASE_ELEMENT_LIST);
        List<String> elementTypeArray = Arrays.asList(elementTypes.split(","));
        for (String elementType : elementTypeArray) {

        }
    }
}
