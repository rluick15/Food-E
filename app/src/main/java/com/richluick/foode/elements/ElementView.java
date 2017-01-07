package com.richluick.foode.elements;

import android.view.View;

/**
 * Created by rluick on 1/7/2017.
 */
public interface ElementView {

    int getLayoutResId();

    void bindElementView(View view);
}
