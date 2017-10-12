package com.example.android.bakingapp.modules.recipes;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.android.bakingapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecipeListActivityTest {

    @Rule
    public ActivityTestRule<RecipeListActivity> mActivityTestRule = new ActivityTestRule<>(RecipeListActivity.class);

    @Test
    public void recipeListActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
            allOf(withId(R.id.recipeNameTextView), withText("Nutella Pie"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                        0),
                    0),
                isDisplayed()));
        textView.check(matches(withText("Nutella Pie")));

        ViewInteraction textView2 = onView(
            allOf(withId(R.id.recipeStepCountTextView), withText("7 Steps"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                        0),
                    1),
                isDisplayed()));
        textView2.check(matches(withText("7 Steps")));

        ViewInteraction textView3 = onView(
            allOf(withId(R.id.recipeStepCountTextView), withText("7 Steps"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                        0),
                    1),
                isDisplayed()));
        textView3.check(matches(withText("7 Steps")));

        ViewInteraction recyclerView = onView(
            allOf(withId(R.id.recipeRecyclerView),
                withParent(allOf(withId(R.id.recipeListFragment),
                    withParent(withId(android.R.id.content)))),
                isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView4 = onView(
            allOf(withId(R.id.ingredientListHeader), withText("Ingredients"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.ingredientListFragmentContainer),
                        0),
                    0),
                isDisplayed()));
        textView4.check(matches(withText("Ingredients")));

        ViewInteraction textView5 = onView(
            allOf(withId(R.id.ingredientNameTextView), withText("2.0 CUP of Graham Cracker crumbs"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.ingredientRecyclerView),
                        0),
                    0),
                isDisplayed()));
        textView5.check(matches(withText("2.0 CUP of Graham Cracker crumbs")));

        ViewInteraction textView6 = onView(
            allOf(withId(R.id.recipeStepListHeader), withText("Steps"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recipeStepListFragmentContainer),
                        0),
                    0),
                isDisplayed()));
        textView6.check(matches(withText("Steps")));

        ViewInteraction textView7 = onView(
            allOf(withId(R.id.recipeStepShortDescription), withText("Recipe Introduction"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recipeStepRecyclerView),
                        0),
                    0),
                isDisplayed()));
        textView7.check(matches(withText("Recipe Introduction")));

        ViewInteraction textView8 = onView(
            allOf(withId(R.id.recipeStepShortDescription), withText("1. Starting prep"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recipeStepRecyclerView),
                        1),
                    0),
                isDisplayed()));
        textView8.check(matches(withText("1. Starting prep")));

        ViewInteraction appCompatButton = onView(
            allOf(withId(R.id.toNextRecipeButton), withText("Brownies")));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton2 = onView(
            allOf(withId(R.id.toPreviousRecipeButton), withText("Nutella Pie")));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction recyclerView2 = onView(
            allOf(withId(R.id.recipeStepRecyclerView), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton3 = onView(
            allOf(withId(R.id.toNextRecipeStepButton), withText("Next Step")));
        appCompatButton3.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageView = onView(
            allOf(withId(R.id.defaultMediaImageView),
                childAtPosition(
                    allOf(withId(R.id.mediajContainerView),
                        childAtPosition(
                            IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                            0)),
                    0),
                isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView12 = onView(
            allOf(withId(R.id.recipeStepDescriptionTextView), withText("1. Preheat the oven to 350°F. Butter a 9\" deep dish pie pan."),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recipeStepDetailFragmentContainer),
                        0),
                    1),
                isDisplayed()));
        textView12.check(matches(withText("1. Preheat the oven to 350°F. Butter a 9\" deep dish pie pan.")));

        ViewInteraction button5 = onView(
            allOf(withId(R.id.toPreviousRecipeStepButton),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recipeStepScrollView),
                        0),
                    1),
                isDisplayed()));
        button5.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
        final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                    && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
