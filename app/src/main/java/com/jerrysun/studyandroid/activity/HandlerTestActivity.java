package com.jerrysun.studyandroid.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.jerrysun.studyandroid.R;
import java.lang.ref.WeakReference;

public class HandlerTestActivity extends AppCompatActivity {

    private static final int MSG_SEND_MESSAGE = 1;
    private static final int MSG_SEND_MESSAGE_DELAY = 2;

    private MyHandler mMyHandler;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        initView();
        initHandler();
    }

    private void initView() {
        mTextView = findViewById(R.id.tv_handler_label);
        findViewById(R.id.btn_send_message).setOnClickListener(v -> sendMessage());
        findViewById(R.id.btn_send_message_delay).setOnClickListener(v -> sendMessageDelay());
    }

    private void initHandler() {
        mMyHandler = new MyHandler(this);
    }

    private void sendMessage() {
        mMyHandler.sendEmptyMessage(MSG_SEND_MESSAGE);
    }

    private void sendMessageDelay() {
        mMyHandler.sendEmptyMessageDelayed(MSG_SEND_MESSAGE_DELAY, 2000);
    }

    static class MyHandler extends Handler {

        private final WeakReference<HandlerTestActivity> mActivityRef;

        public MyHandler(HandlerTestActivity activity) {
            mActivityRef = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final HandlerTestActivity activity = mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                removeCallbacksAndMessages(null);
                return;
            }

            switch (msg.what) {
                case MSG_SEND_MESSAGE:
                    activity.mTextView.setText("sendmessage  msg.what ===" + msg.what);
                   break;
                case MSG_SEND_MESSAGE_DELAY:
                    activity.mTextView.setText("sendmessagedelay msg.what ===" + msg.what);
                    break;
            }
        }
    }
}
