package com.github.jerrysun.studyandroid.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title
 * @Author  sw840227@gmail.com
 * @Date    Dec-30-2017
 * @Version 1.0
 * @Github  https://github.com/Jerrysun0227/
 */

public class StringUtils {

    /**
     *
     * @param   str
     * @return
     */
    public static boolean stringIsNull(String str) {
        return TextUtils.isEmpty(str);
    }

    /**
     *
     * @param   str
     * @return
     */
    public static boolean stringIsNumber(String str) {
        if (stringIsNull(str)) {
            return false;
        }

        String regStr = "^[1-9][0-9]+";
        if (str.length() == 1) {
            regStr = "[0-9]";
        } else if (str.startsWith("0.")) {
            regStr = "^[0-9]\\.?[0-9]+";
        } else if (str.contains(".")) {
            if (str.split("\\.")[0].length() > 1) {
                regStr = "^[1-9][0-9]+\\.?[0-9]+";
            } else {
                regStr = "^[0-9]\\.?[0-9]+";
            }
        }

        Pattern p = Pattern.compile(regStr);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
