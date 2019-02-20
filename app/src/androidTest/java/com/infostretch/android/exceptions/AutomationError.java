package com.infostretch.android.exceptions;

public class AutomationError extends RuntimeException {

    public AutomationError() {
        super();
    }

    public AutomationError(String reason) {
        super(reason);
    }

    public AutomationError(Throwable e) {
        super(e);
    }

    public AutomationError(String reason, Throwable e) {
        super(reason, e);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
