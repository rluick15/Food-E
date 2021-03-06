package com.richluick.foode.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richluick.foode.R;
import com.richluick.foode.di.subcomponent.SubcomponentBuilderProvider;
import com.richluick.foode.elements.ElementView;
import com.richluick.foode.elements.adapter.ElementRecyclerViewAdapter;
import com.richluick.foode.fragment.BaseFragment;
import com.richluick.foode.homepage.di.HomepageComponent;
import com.richluick.foode.homepage.di.HomepageModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The fragment containing the view for the homepage
 */
public class HomepageFragment extends BaseFragment implements HomepageView {

    @Inject
    HomepagePresenter homepagePresenter;
    @Inject
    ElementRecyclerViewAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public HomepageFragment() {} // Required empty public constructor

    public static HomepageFragment newInstance() {
        return new HomepageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        injectDependencies();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        homepagePresenter.getHomepageElementList();
    }

    @Override
    public void onStart() {
        super.onStart();
        homepagePresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        homepagePresenter.stop();
    }

    /**
     * Performs the dagger injecting operation for this activity class
     */
    private void injectDependencies() {
        HomepageComponent.Builder builder = (HomepageComponent.Builder)
                ((SubcomponentBuilderProvider) getActivity()).getSubcomponentBuilder(HomepageComponent.Builder.class);
        builder.buildHomepageComponent(new HomepageModule(this)).build().inject(this);
    }

    @Override
    public void setupElementViewAdapter(List<ElementView> elementViewList) {
        adapter.setElementViewList(elementViewList);
    }
}
