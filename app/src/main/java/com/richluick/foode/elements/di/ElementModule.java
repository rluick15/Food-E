package com.richluick.foode.elements.di;

import android.support.v7.widget.RecyclerView;

import com.richluick.foode.di.scope.ApplicationScope;
import com.richluick.foode.elements.adapter.ElementRecyclerViewAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rluick on 1/7/2017.
 *
 * Holds all app wide generic element dependencies
 */
@Module
public class ElementModule {

    @Provides
    @ApplicationScope
    RecyclerView.Adapter provideElementRecyclerViewAdapter(ElementRecyclerViewAdapter adapter) {
        return adapter;
    }
}
