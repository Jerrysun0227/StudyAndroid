package com.jerrysun.studyandroid.views.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
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
public class TouchEventTestTextView extends AppCompatTextView {

    private static final String LOG_TAG = TouchEventTestTextView.class.getSimpleName();

    public TouchEventTestTextView(Context context) {
        super(context);
    }

    public TouchEventTestTextView(Context context,
        @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventTestTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(LOG_TAG, "TextView dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(LOG_TAG, "TextView dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(LOG_TAG, "TextView dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(LOG_TAG, "TextView onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(LOG_TAG, "TextView onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(LOG_TAG, "TextView onTouchEvent ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
