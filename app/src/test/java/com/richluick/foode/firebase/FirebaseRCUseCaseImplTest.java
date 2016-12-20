package com.richluick.foode.firebase;

import android.app.Activity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.richluick.foode.usecase.UseCaseCallback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rluick on 12/19/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class FirebaseRCUseCaseImplTest {

    @Mock
    FirebaseRemoteConfig firebaseRemoteConfig;
    @Mock
    Activity context;

    private FirebaseRCUseCaseImpl firebaseRCUseCase;

    @Before
    public void setUp() {
        firebaseRCUseCase = new FirebaseRCUseCaseImpl(firebaseRemoteConfig, context);
    }

    @Test
    public void executeTest() {
        UseCaseCallback caseCallback = mock(UseCaseCallback.class);
        Task<Void> task = mock(Task.class);
        when(firebaseRemoteConfig.fetch()).thenReturn(task);

        firebaseRCUseCase.execute(caseCallback);
        verify(firebaseRemoteConfig).fetch();
        verify(task).addOnCompleteListener(eq(context), any(OnCompleteListener.class));
    }

    @Test
    public void firebaseOnCompleteCallbackSuccessTest() {
        UseCaseCallback caseCallback = mock(UseCaseCallback.class);

        final Task<Void> task = mock(Task.class);
        when(task.isSuccessful()).thenReturn(true);
        when(task.addOnCompleteListener(eq(context), any(OnCompleteListener.class))).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((OnCompleteListener) invocation.getArguments()[1]).onComplete(task);
                return null;
            }
        });
        when(firebaseRemoteConfig.fetch()).thenReturn(task);

        //todo: currently calling at least once due to firebase bug workaround. Will remove when remedied
        firebaseRCUseCase.execute(caseCallback);
        verify(firebaseRemoteConfig, atLeastOnce()).activateFetched();
        verify(caseCallback, atLeastOnce()).onCompleted(null);
    }

    @Test
    public void firebaseOnCompleteCallbackErrorTest() {
        UseCaseCallback caseCallback = mock(UseCaseCallback.class);

        final Task<Void> task = mock(Task.class);
        when(task.isSuccessful()).thenReturn(false);
        when(task.addOnCompleteListener(eq(context), any(OnCompleteListener.class))).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((OnCompleteListener) invocation.getArguments()[1]).onComplete(task);
                return null;
            }
        });
        when(firebaseRemoteConfig.fetch()).thenReturn(task);

        firebaseRCUseCase.execute(caseCallback);
        verify(caseCallback).onError("");
    }
}
