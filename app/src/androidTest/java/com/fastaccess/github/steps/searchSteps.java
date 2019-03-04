package com.fastaccess.github.steps;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.view.View;

import com.fastaccess.R;
import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.steps.UiAutomatorSteps;
import com.infostretch.android.utils.GetChildViewMatcher;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static com.infostretch.android.steps.EspressoSteps.TypeText;
import static com.infostretch.android.steps.EspressoSteps.getElement;
import static com.infostretch.android.steps.EspressoSteps.sendKeys;

public class searchSteps {
        public static void clickOnSearch() {
            EspressoSteps.click("search.ui.btn.loc");
        }


        public static void verifySearchEditText() {
            EspressoSteps.IsDisplayed("search.text.loc");
        }

        public static void verifyEditTextError() {
            ViewInteraction editText = getElement("search.text.loc");
            TypeText("search.text.loc", "");
            clickOnSearch();
            editText.check(matches(hasErrorText("Minimum characters (2)")));

        }


        public static void clickOnRepo() {
            selectTab(0);
        }
        public static void clickOnUsers() {
            selectTab(1);
        }

        public static void clickOnIssues() {
            // UiAutomatorSteps.scrollHorizontal("search.recyclerView.scrollVerticle.loc");
            selectTab(2);
        }

        public static void clickOnCode() {
            selectTab(3);
        }

        public static void selectTab(int pos){
            Matcher<View> linearlayoutmatcher = GetChildViewMatcher.nthChildOf(ViewMatchers.withId(R.id.tabs), 0);
            Matcher<View> tabmatcher = GetChildViewMatcher.nthChildOf(linearlayoutmatcher,pos);
            ViewInteraction created = onView(tabmatcher);
            created.perform(click());
        }

        public static void searchText() {
            sendKeys("search.text.loc", "priyanka");
            clickOnSearch();
        }

        public static void selectRecyclerViewListItem(int pos) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  UiAutomatorSteps.scrollVertical("search.recyclerview.scrollview.loc");
            EspressoSteps.ClickOnRecyclerViewChild("recycler",pos);
        }

    }
