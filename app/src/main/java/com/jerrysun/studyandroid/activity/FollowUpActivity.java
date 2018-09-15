package com.jerrysun.studyandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.jerrysun.studyandroid.R;
import com.jerrysun.studyandroid.utils.UIHelper;
import com.jerrysun.studyandroid.views.followup.FollowUpView;

public class FollowUpActivity extends AppCompatActivity {

    private FollowUpView mFollowUpView;
    private EditText etNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up);

        initView();
    }

    private void initView() {
        this.findViewById(R.id.btn_test).setOnClickListener(v -> {
            mFollowUpView.setText(etNumber.getText().toString());
            UIHelper.hideInputMethod(etNumber);
        });

        mFollowUpView = this.findViewById(R.id.follow_up_view);
        etNumber = this.findViewById(R.id.et_number);
    }
}
