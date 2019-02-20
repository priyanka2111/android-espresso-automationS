package com.fastaccess.github.steps;

public class RepositorySteps {

    // assume that you are in a repo... then perform this steps

    public void watchTheRepo(){
        // steps to click on watch button
    }
    public void starRepo(){
        // steps to star the repo
    }

    public void openLicense(){
        // steps to open the licencse
    }

    public void openTitleMessage(){
        // steps to open the title message
        // the (i) at top-right
     }
     public void pinRepo(){
        // pin the repo
     }

     /*
        Input params : tabName => ['README', 'FILES','COMMITS','RELEASES','CONTRIBUTINS']
      */
     public void openCodeTab(String tabName){
                // logic to open respective tab
     }

     /*
        Input params : tabName => ['Code','Issues','Pull Requests','Projects']
      */
     public void openBottomTab(String tabName){

     }
     /*
        Input params : tabName => ['Opened', 'Closed']
      */
     public void openPullRequestTab(String tabName){

     }

     /*
        Input params : tabName => ['Opened','Closed']
      */
     public void openProjectsTab(String tabName){

     }

    public void addAnIssue(){
         // steps to add an issue
    }

    public void searchForIssue(){
        // search for an issue
    }

    public void searchForPullRequest(){
            // search for pull request...
    }
}
