package com.github.jerrysun.studyandroid.utils;

import android.util.Log;
import com.github.jerrysun.studyandroid.BuildConfig;

/**
 * @Title   Logger.
 * @Author  sw840227@126.com
 * @Date    Nov-29-2017
 * @Version 1.0
 */
public class Logger {

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg);
        }
    }
}