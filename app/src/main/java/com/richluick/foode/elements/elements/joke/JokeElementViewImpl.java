package com.richluick.foode.elements.elements.joke;

import android.view.View;

import com.richluick.foode.R;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 */
public class JokeElementViewImpl implements JokeElementView {

    protected JokeElementPresenter jokeElementPresenter;

    @Inject
    public JokeElementViewImpl() {
    }

    @Override
    public int getLayoutResId() {
        return R.layout.joke_element;
    }

    //todo: might want to move Butterknife bind to a custom view passed into this method. This
    //todo: will avoid binding every time which is a heavy operation
    @Override
    public void bindElementView(View view) {

    }
}
