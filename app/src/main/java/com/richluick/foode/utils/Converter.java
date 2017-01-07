package com.richluick.foode.utils;

/**
 * Created by rluick on 1/7/2017.
 */
public interface Converter<I, O> {

    O convert(I object);
}
