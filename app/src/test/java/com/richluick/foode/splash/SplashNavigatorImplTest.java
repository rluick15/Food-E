package com.richluick.foode.splash;

import android.app.Activity;
import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by rluick on 12/15/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashNavigatorImplTest {

    @Mock
    Activity context;

    SplashNavigatorImpl splashNavigator;

    @Before
    public void setUp() {
        splashNavigator = new SplashNavigatorImpl(context);
    }

    @Test
    public void goToMainPageTest() {
        splashNavigator.goToMainPage();
        verify(context).startActivity(any(Intent.class));
        verify(context).finish();
    }
}
