package com.infostretch.android.utils.xpath;


import com.infostretch.android.exceptions.AutomationException;

public class XPathLookupException extends AutomationException {
    public XPathLookupException(String xpath, String reason) {
        super(String.format("Could not parse XPath %s: %s", xpath, reason));
    }
}