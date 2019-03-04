package com.fastaccess.github.steps;

import android.support.test.espresso.ViewInteraction;
import android.view.View;
import com.fastaccess.R;
import com.infostretch.android.steps.EspressoSteps;
import com.infostretch.android.utils.GetChildViewMatcher;
import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.infostretch.android.steps.EspressoSteps.getElement;
import static com.infostretch.android.steps.EspressoSteps.sendKeys;
import static com.infostretch.android.steps.EspressoSteps.typeText;

public class searchSteps {
        public static void clickOnSearch() {
            EspressoSteps.click("search.ui.btn.loc");
        }


        public static void verifySearchEditText() {
            EspressoSteps.isDisplayed("search.text.loc");
        }

        public static void verifyEditTextError() {

            ViewInteraction editText = getElement("search.text.loc");
            typeText("search.text.loc", "");
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
            Matcher<View> linearlayoutmatcher = GetChildViewMatcher.nthChildOf(withId(R.id.tabs), 0);
            Matcher<View> tabmatcher = GetChildViewMatcher.nthChildOf(linearlayoutmatcher,pos);
            ViewInteraction created = onView(tabmatcher);
            created.perform(click());
        }

        public static void searchTypeText(String text) {
            sendKeys("search.text.loc",text);
            clickOnSearch();
        }

        public static void selectRecyclerViewListItem(int pos) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  UiAutomatorSteps.scrollVertical("search.recyclerview.scrollview.loc");
            EspressoSteps.clickOnRecyclerViewChild("recycler",pos);

        }

        public static void searchFile(){
            selectTab(1);
            EspressoSteps.click("search.repoFile.loc");
            searchTypeText("code");
            EspressoSteps.click("search.repoFile.searchOption.loc");
            EspressoSteps.click("search.repofile.searchInPath.loc");
//            EspressoSteps.click("search.repoFile.searchInFile.loc");
//            EspressoSteps.click("search.repoFile.searchInAll");
        }

    }
