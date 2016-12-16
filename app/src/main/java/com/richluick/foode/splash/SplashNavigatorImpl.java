package com.richluick.foode.splash;

import android.content.Context;
import android.content.Intent;

import com.richluick.foode.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by rluic on 12/15/2016.
 */
public class SplashNavigatorImpl implements SplashNavigator {

    private Context context;

    @Inject
    public SplashNavigatorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void goToMainPage() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
