package com.example.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBase {
    public boolean isNumber(String str) {
        String regexp = "[0-9]*[1-9][0-9]*";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public boolean isTelPhoneNumber(String str) {
        String regexp = "1\\d{10}";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public boolean isIdNumber(String str) {
        String regexp = "[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
