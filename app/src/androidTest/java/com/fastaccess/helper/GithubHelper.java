package com.fastaccess.helper;

import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GithubHelper {
    static GitHub github;
    {
        try {
            // this should not be hard coded..
            github = GitHub.connectUsingPassword("tttcx","qazwsxedcrfv123123123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getFollowingCount(){
        try {
            return github.getMyself().getFollowingCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
