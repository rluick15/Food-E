package com.richluick.foode.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rluick on 12/14/2016.
 *
 * The base activity extended by all other activies. Holds common activity logic
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Inflates the fragment into the given container
     *
     * @param fragment the fragment to inflate
     * @param resId the id of the container to inflate the fragment into
     * @param addToBackStack t/f whether to add the fragment to the back stack
     * @param tag the id tag for the fragment. Usually just the simple name
     */
    public void inflateFragment(Fragment fragment, int resId, boolean addToBackStack, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(resId, fragment, tag);
        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.commit();
    }

    //todo: create method for removing and for checking if the app is attempting to launch a duplicate
    //todo: fragment. Also consider moving to helper class
}
