package com.example.listycity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testActivitySwitch() {
        // Click on the first item in the list (Edmonton)
        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());

        // Check if ShowActivity is started
        intended(hasComponent(ShowActivity.class.getName()));
    }

    @Test
    public void testCityNameConsistency() {
        String cityName = "Edmonton";
        // Click on "Edmonton"
        onData(is(cityName)).inAdapterView(withId(R.id.city_list)).perform(click());

        // Check if the Intent has the correct extra
        intended(allOf(
                hasComponent(ShowActivity.class.getName()),
                hasExtra("CITY_NAME", cityName)
        ));

        // Check if the TextView in ShowActivity displays the correct city name
        onView(withId(R.id.city_name_textview)).check(matches(withText(cityName)));
    }

    @Test
    public void testBackButton() {
        // Click on "Edmonton" to go to ShowActivity
        onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());

        // Verify we are in ShowActivity
        onView(withId(R.id.city_name_textview)).check(matches(isDisplayed()));

        // Click the back button
        onView(withId(R.id.back_button)).perform(click());

        // Verify we are back in MainActivity (city_list should be visible)
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
