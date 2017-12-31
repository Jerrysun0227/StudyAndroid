package com.github.jerrysun.studyandroid.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.github.jerrysun.studyandroid.R;
import com.github.jerrysun.studyandroid.views.followup.FollowUpView;

/**
 * @Title
 * @Author sw840227@gmail.com
 * @Date 十二月-30-2017
 * @Version 1.0
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FollowUpView mFollowUpView;
    private EditText etNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.findViewById(R.id.btn_test).setOnClickListener(this);

        mFollowUpView = this.findViewById(R.id.follow_up_view);
        etNumber = this.findViewById(R.id.et_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                mFollowUpView.setText(etNumber.getText().toString());
                break;
        }
    }
}
