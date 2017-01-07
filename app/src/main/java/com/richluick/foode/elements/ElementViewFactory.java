package com.richluick.foode.elements;

import com.richluick.foode.utils.Converter;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by rluick on 1/7/2017.
 */
public class ElementViewFactory implements Converter<String, ElementView> {

    private Map<String, Provider<ElementCreator>> elementViewCreatorwMap;

    @Inject
    public ElementViewFactory(Map<String, Provider<ElementCreator>> elementViewMap) {
        this.elementViewCreatorwMap = elementViewMap;
    }

    @Override
    public ElementView convert(String object) {
        ElementView elementView = null;
        if (elementViewCreatorwMap.containsKey(object)) {
            elementView = elementViewCreatorwMap.get(object).get().create();
        }
        return elementView;
    }
}
