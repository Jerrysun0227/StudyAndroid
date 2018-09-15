package com.jerrysun.studyandroid.views.touchevent;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.jerrysun.studyandroid.utils.Logger;

/**
 * @Title
 * @Author sw840227@gmail.com
 * @Date 九月-15-2018
 * @Version 1.0
 * @Github https://github.com/Jerrysun0227/
 */
public class TouchEventTestLayout extends ConstraintLayout {

    private static final String LOG_TAG = TouchEventTestLayout.class.getSimpleName();

    public TouchEventTestLayout(Context context) {
        super(context);
    }

    public TouchEventTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventTestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.i(LOG_TAG, "Layout dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.i(LOG_TAG, "Layout dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.i(LOG_TAG, "Layout dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.i(LOG_TAG, "Layout onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.i(LOG_TAG, "Layout onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.i(LOG_TAG, "Layout onInterceptTouchEvent ACTION_UP");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.i(LOG_TAG, "Layout onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.i(LOG_TAG, "Layout onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.i(LOG_TAG, "Layout onTouchEvent ACTION_UP");
                break;
        }
        return true;
    }
}
