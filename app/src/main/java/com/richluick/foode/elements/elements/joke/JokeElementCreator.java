package com.richluick.foode.elements.elements.joke;

import com.richluick.foode.elements.ElementCreator;

import javax.inject.Inject;

/**
 * Created by rluic on 1/7/2017.
 */

public class JokeElementCreator implements ElementCreator<JokeElementView> {

    private JokeElementViewImpl view;
    private JokeElementPresenterImpl presenter;

    @Inject
    public JokeElementCreator(JokeElementViewImpl view, JokeElementPresenterImpl presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public JokeElementView create() {
        view.jokeElementPresenter = presenter;
        presenter.jokeElementView = view;
        return view;
    }
}
