package com.infostretch.android.utils;

import android.support.annotation.Nullable;

public class StringUtils {
    public static String abbreviate(@Nullable String str, int len) {
        return str != null && str.length() > len ? str.substring(0, len) + "\u2026" : str;
    }
}
