package com.jerrysun.studyandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.jerrysun.studyandroid.R;

/**
 * @Title
 * @Author sw840227@gmail.com
 * @Date 十二月-30-2017
 * @Version 1.0
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        // 即刻点赞效果
        this.findViewById(R.id.btn_follow_up).setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, FollowUpActivity.class)));
        // Touch事件传递
        this.findViewById(R.id.btn_touch_event).setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, TouchEventActivity.class)));
        // Handler机制
        this.findViewById(R.id.btn_handler).setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, HandlerTestActivity.class)));
    }
}
