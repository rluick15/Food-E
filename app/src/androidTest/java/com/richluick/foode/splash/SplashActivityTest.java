package com.richluick.foode.splash;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.richluick.foode.R;
import com.richluick.foode.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasFlag;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by rluick on 12/17/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashActivityTest {

    private static final int SPLASH_DELAY_TIME_MILLIS = 3000;

    @Rule
    public IntentsTestRule<SplashActivity> splashActivityRule = new IntentsTestRule<>(SplashActivity.class);

    @Test
    public void splashDisplayedTest() throws InterruptedException {
        //todo: text will be temporary, will likely be an imageview
        onView(withId(R.id.splashText)).check(matches(isDisplayed()));

        Thread.sleep(SPLASH_DELAY_TIME_MILLIS);
        intended(allOf(
                hasComponent(MainActivity.class.getName()),
                hasFlag(Intent.FLAG_ACTIVITY_NEW_TASK),
                hasFlag(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        ));
    }
}
