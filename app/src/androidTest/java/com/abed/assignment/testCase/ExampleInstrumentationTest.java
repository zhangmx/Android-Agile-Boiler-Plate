package com.abed.assignment.testcase;

import androidx.test.filters.MediumTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.view.KeyEvent;
import android.widget.EditText;

import com.abed.assignment.R;
import com.abed.assignment.assertion.RecyclerViewItemCountAssertion;
import com.abed.assignment.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.injection.component.TestApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;
import com.abed.assignment.rule.DaggerActivityTestRule;
import com.abed.assignment.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new DaggerActivityTestRule<>(MainActivity.class, (application, activity) -> {
                TestApplicationComponent mApplicationComponent = DaggerTestApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(application))
                        .build();
                application.setComponent(mApplicationComponent);
            });

    @Test
    public void fabClick() {
        onView(withId(R.id.fab)).perform(click());
    }

    @Test
    public void searchForItems() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withId(R.id.recylcer_imgs)).check(new RecyclerViewItemCountAssertion(6));

    }
}