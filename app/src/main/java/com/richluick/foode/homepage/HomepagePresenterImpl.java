package com.richluick.foode.homepage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.richluick.foode.elements.ElementView;
import com.richluick.foode.utils.Constants;
import com.richluick.foode.utils.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 */
public class HomepagePresenterImpl implements HomepagePresenter {

    private HomepageView homepageView;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private Converter<String, ElementView> elementViewFactory;

    @Inject
    public HomepagePresenterImpl(HomepageView homepageView, FirebaseRemoteConfig firebaseRemoteConfig,
                                 Converter<String, ElementView> elementViewFactory) {
        this.homepageView = homepageView;
        this.firebaseRemoteConfig = firebaseRemoteConfig;
        this.elementViewFactory = elementViewFactory;


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

        List<ElementView> elementViewList = new ArrayList<>();
        for (String elementType : elementTypeArray) {
            ElementView elementView = elementViewFactory.convert(elementType);
            if (elementView != null) {
                elementViewList.add(elementView);
            }
        }

        homepageView.setupElementViewAdapter(elementViewList);
    }
}
