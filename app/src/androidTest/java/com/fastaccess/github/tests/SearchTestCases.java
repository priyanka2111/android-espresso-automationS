package com.fastaccess.github.tests;

import com.infostretch.android.core.BaseTestCase;

import org.junit.Before;
import org.junit.Test;

import static com.fastaccess.github.steps.LoginSteps.openApp;
import static com.fastaccess.github.steps.searchSteps.clickOnCode;
import static com.fastaccess.github.steps.searchSteps.clickOnIssues;
import static com.fastaccess.github.steps.searchSteps.clickOnRepo;
import static com.fastaccess.github.steps.searchSteps.clickOnSearch;
import static com.fastaccess.github.steps.searchSteps.clickOnUsers;
import static com.fastaccess.github.steps.searchSteps.searchText;
import static com.fastaccess.github.steps.searchSteps.selectRecyclerViewListItem;
import static com.fastaccess.github.steps.searchSteps.verifyEditTextError;
import static com.fastaccess.github.steps.searchSteps.verifySearchEditText;


public class SearchTestCases extends BaseTestCase {
    @Before
    public void open() {
        openApp();
    }
    @Test
    public void selectSearch(){
        clickOnSearch();
        verifySearchEditText();

    }

    @Test
    public void verifySearchError() {
        clickOnSearch();
        verifyEditTextError();
    }

    @Test
    public void searchUser()  {
        clickOnSearch();
        searchText();
        clickOnUsers();
        selectRecyclerViewListItem(12);
    }

    @Test
    public void searchRepositary(){
        clickOnSearch();
        searchText();
        clickOnRepo();
        selectRecyclerViewListItem(3);
    }

    @Test
    public void searchIssues(){
        clickOnSearch();
        searchText();
        clickOnIssues();
        selectRecyclerViewListItem(1);
    }
    @Test
    public void searchCode(){
        clickOnSearch();
        searchText();
        clickOnCode();
        selectRecyclerViewListItem(6);
    }

}
