package com.richluick.foode.splash;

import android.os.Handler;

import com.richluick.foode.usecase.UseCaseCallback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rluick on 12/15/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterImplTest {

    @Mock
    SplashView splashView;
    @Mock
    SplashNavigator splashNavigator;
    @Mock
    FirebaseRCUseCase firebaseRCUseCase;
    @Mock
    Handler handler;

    private SplashPresenterImpl splashPresenter;

    @Before
    public void setUp() {
        splashPresenter = new SplashPresenterImpl(splashView, splashNavigator, firebaseRCUseCase, handler);
    }

    @Test
    public void startTest() {
        splashPresenter.start();
        //nothing yet to verify
    }

    @Test
    public void stopTest() {
        splashPresenter.stop();
        //nothing yet to verify
    }

    @Test
    public void downloadSettingsFromFirebaseTest() {
        splashPresenter.downloadSettingsFromFirebase();
        verify(firebaseRCUseCase).execute(any(UseCaseCallback.class));
    }

    @Test
    public void onCompletedTest() {
        when(handler.postDelayed(any(Runnable.class), anyLong())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Runnable) invocation.getArguments()[0]).run();
                return null;
            }
        });
        splashPresenter.onCompleted(new Object());
        verify(splashNavigator).goToMainPage();
    }

    @Test
    public void onErrorTest() {
        splashPresenter.onError("");
        //nothing yet to verify
    }
}
