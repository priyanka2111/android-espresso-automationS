package com.fastaccess.helper;

import org.kohsuke.github.GHGist;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

import java.io.IOException;

public class GithubHelper {
    static GitHub github;

    public static void initialize(){
        try {
            github = GitHub.connectUsingPassword("tttcx","qazwsxedcrfv123123123");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int getFollowingCount(){
        try {
            initialize();
            return github.getMyself().getFollowingCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getFollowersCount(){
        try {
            initialize();
            return github.getMyself().getFollowersCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getCompanyName(){
        try {
            initialize();
            return github.getMyself().getCompany();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static String getLocation(){
        initialize();
        try {
            return github.getMyself().getLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getEmail(){
        initialize();
        try {
            return github.getMyself().getEmail();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBlog(){
        initialize();
        try {
            return github.getMyself().getBlog();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getName(){
        initialize();
        try {
            return github.getMyself().getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getGistCount(){
        initialize();
        try {
           return github.getMyself().getPublicGistCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static PagedIterable<GHGist> getGistList(){
        initialize();
        try {
            return github.getMyself().listGists();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isGistPresent(String title){

        PagedIterable<GHGist> myGistList = getGistList();
        for(GHGist gist : myGistList){
            if(gist.getDescription().equals(title)) return true;
        }
        return false;
    }
}
