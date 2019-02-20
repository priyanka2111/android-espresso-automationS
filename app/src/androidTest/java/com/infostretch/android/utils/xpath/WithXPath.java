package com.infostretch.android.utils.xpath;
import android.support.annotation.Nullable;
import android.view.View;

import com.infostretch.android.exceptions.AutomationError;
import com.infostretch.android.exceptions.AutomationException;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.ArrayList;
import java.util.List;


public class WithXPath {
    public static Matcher<View> withXPath(@Nullable final View root, final String xpath,
                                          @Nullable final Integer index){

        final List<View> matchedXPathViews = new ArrayList<>();
        try{
            matchedXPathViews.addAll(new SourceDocument(root).findViewsByXPath(xpath));
        }catch(AutomationException exception){
            throw new AutomationError(exception);
        }

        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if (index != null) {
                    // If index is not null, match it with the xpath in the list at the provided index
                    return index < matchedXPathViews.size() && matchedXPathViews.get(index).equals(item);
                }

                // If index is null, then we only check that the view is contained in the list of matched xpaths
                return matchedXPathViews.contains(item);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("Looked for element with XPath %s", xpath));
            }
        };
    }

    public static Matcher<View> withXPath(@Nullable final View root, final String xpath){
        return withXPath(root, xpath, null);
    }

    public static Matcher<View> withXPath(final String xpath){
        return withXPath(new ViewGetter().getRootView(), xpath, null);
    }
}