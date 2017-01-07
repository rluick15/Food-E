package com.richluick.foode.elements;

/**
 * Created by rluic on 1/7/2017.
 */

public interface ElementCreator<V extends ElementView> {

    V create();
}
