package com.github.jerrysun.studyandroid.views.followup;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.github.jerrysun.studyandroid.R;
import com.github.jerrysun.studyandroid.utils.StringUtils;
import com.github.jerrysun.studyandroid.utils.UIHelper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Title
 * @Author  sw840227@gmail.com
 * @Date    Dec-30-2017
 * @Version 1.0
 */

public class FollowUpView extends LinearLayout implements View.OnClickListener {

    private static final String LOG_TAG = "FollowUpView";

    private int number;

    private ImageView mIvIcon;
    private FollowUpNumber mTvNumber;

    private int mState;

    private int[] mIcons;
    private boolean hasIcon;

    private int mTextColor;
    private float mTextSize;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({UNFOLLOWED, FOLLOWED})
    public @interface State{}

    public static final int UNFOLLOWED = 0;
    public static final int FOLLOWED = 1;

    public FollowUpView(Context context) {
        this(context, null);
    }

    public FollowUpView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowUpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FollowUpView);

        mTextSize = typedArray.getDimensionPixelSize(R.styleable.FollowUpView_text_size, 14);
        mTextColor = typedArray.getColor(R.styleable.FollowUpView_text_color, 0X000000);

        typedArray.recycle();

        initView(context);
    }

    private void initView(Context context) {
        /** icon */
        mIvIcon = new ImageView(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.rightMargin = UIHelper.dipToPx(context, 5f);
        mIvIcon.setLayoutParams(params);
        mIvIcon.setVisibility(GONE);

        /** text */
        mTvNumber = new FollowUpNumber(context);
        params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTvNumber.setLayoutParams(params);
        mTvNumber.setTextSize(mTextSize);
        mTvNumber.setTextColor(mTextColor);
        mTvNumber.setOnClickListener(this);
        mTvNumber.setText(0);
        mState = UNFOLLOWED;

        setOrientation(HORIZONTAL);

        addView(mIvIcon);
        addView(mTvNumber);
    }

    public void setText(@NonNull String str) {
        if (!StringUtils.stringIsNumber(str)) {
            Toast.makeText(getContext(), "please input a number!", Toast.LENGTH_SHORT).show();
            return;
        }
        mTvNumber.setText(Integer.parseInt(str));
    }

    @Override
    public void onClick(View v) {
        if (mState == UNFOLLOWED) {
            mState = FOLLOWED;
            mTvNumber.setState(FollowUpNumber.ADD);
        } else {
            mState = UNFOLLOWED;
            mTvNumber.setState(FollowUpNumber.SUBTRACT);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int num) {
        this.number = num;
        mTvNumber.setText(number);
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public float getTextSize() {
        return mTextSize;
    }

    public void setTextSize(float textSize) {
        mTextSize = textSize;
        if (mTvNumber != null) {
            mTvNumber.setTextSize(textSize);
        }
    }

    public void setIcons(int[] iconResIds) {
        mIcons = iconResIds;
        if (mIvIcon != null) {
            mIvIcon.setVisibility(VISIBLE);
        }
    }
}
