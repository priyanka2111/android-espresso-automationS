package com.infostretch.android.exceptions;

public class AutomationException extends Exception {
    public AutomationException() {
        super();
    }

    public AutomationException(String reason) {
        super(reason);
    }

    public AutomationException(Throwable e) {
        super(e);
    }

    public AutomationException(String reason, Throwable e) {
        super(reason, e);
    }
}
