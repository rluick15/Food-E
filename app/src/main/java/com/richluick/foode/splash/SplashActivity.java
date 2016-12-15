package com.richluick.foode.splash;

import android.os.Bundle;

import com.richluick.foode.R;
import com.richluick.foode.activity.BaseActivity;
import com.richluick.foode.di.subcomponent.SubcomponentBuilderProvider;
import com.richluick.foode.splash.di.SplashComponent;
import com.richluick.foode.splash.di.SplashModule;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);;

        injectDependencies();
    }

    /**
     * Performs the dagger injecting operation for this activity class
     */
    private void injectDependencies() {
        SplashComponent.Builder builder = (SplashComponent.Builder)
                ((SubcomponentBuilderProvider) getApplication()).getSubcomponentBuilder(SplashComponent.Builder.class);
        builder.buildSplashModule(new SplashModule(this)).build().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        splashPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        splashPresenter.stop();
    }
}
