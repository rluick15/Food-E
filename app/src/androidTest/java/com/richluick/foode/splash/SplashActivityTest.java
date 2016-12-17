package com.richluick.foode.splash;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.richluick.foode.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rluick on 12/17/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashActivityTest {

    @Rule
    public IntentsTestRule<SplashActivity> splashActivityRule = new IntentsTestRule<>(SplashActivity.class);

    @Test
    public void splashDisplayedTest() {
        onView(withId(R.id.splashText)).check(matches(isDisplayed()));
    }
}
