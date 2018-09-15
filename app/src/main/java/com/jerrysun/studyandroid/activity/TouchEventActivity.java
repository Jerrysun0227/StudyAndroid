package com.jerrysun.studyandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.jerrysun.studyandroid.R;
import com.jerrysun.studyandroid.utils.Logger;
import com.jerrysun.studyandroid.views.touchevent.TouchEventTestTextView;

public class TouchEventActivity extends AppCompatActivity implements OnClickListener,
    OnTouchListener {

    private static final String LOG_TAG = TouchEventActivity.class.getSimpleName();

    private TouchEventTestTextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        initView();
    }

    private void initView() {
        mTextView = this.findViewById(R.id.tv_touch_event_test);
        mTextView.setOnClickListener(this);
        mTextView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.v(LOG_TAG, "Activity dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.v(LOG_TAG, "Activity dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.v(LOG_TAG, "Activity dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.v(LOG_TAG, "Activity onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.v(LOG_TAG, "Activity onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.v(LOG_TAG, "Activity onTouchEvent ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_touch_event_test:
                Logger.v(LOG_TAG, "TextView onClick");
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.tv_touch_event_test:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Logger.v(LOG_TAG, "TextView onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Logger.v(LOG_TAG, "TextView onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Logger.v(LOG_TAG, "TextView onTouch ACTION_UP");
                        break;
                }
                break;
        }
        return false;
    }
}
