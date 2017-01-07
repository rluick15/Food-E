package com.richluick.foode.elements;

import com.richluick.foode.utils.Converter;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 */
public class ElementViewFactory implements Converter<String, ElementView> {

    @Inject
    public ElementViewFactory() {}

    @Override
    public ElementView convert(String object) {
        return null;
    }
}
