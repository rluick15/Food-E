package com.richluick.foode.elements;

import android.view.View;

/**
 * Created by rluic on 1/7/2017.
 */

public interface ElementView<L extends View> {

    int getLayoutResId();

    void bindElementView(L layout);
}
