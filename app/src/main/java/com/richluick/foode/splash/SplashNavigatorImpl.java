package com.richluick.foode.splash;

import android.app.Activity;
import android.content.Intent;

import com.richluick.foode.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by rluic on 12/15/2016.
 */
public class SplashNavigatorImpl implements SplashNavigator {

    private Activity context;

    @Inject
    public SplashNavigatorImpl(Activity context) {
        this.context = context;
    }

    @Override
    public void goToMainPage() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        context.finish();
    }
}
