package com.github.jerrysun.studyandroid.views.followup;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.github.jerrysun.studyandroid.R;

/**
 * @Title
 * @Author  sw840227@gmail.com
 * @Date    Dec-31-2017
 * @Version 1.0
 * @Github  https://github.com/Jerrysun0227/
 */

public class FollowUpNumber extends View {

    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#000000");
    private static final int DEFAULT_TEXT_SIZE = 16;
    private int mTextColor;
    private float mTextSize;

    private Paint normalTextPaint;
    private Paint originTextPaint;
    private Paint newTextPaint;

    public static final int NORMAL = 0;
    public static final int ADD = 1;
    public static final int SUBTRACT = 2;
    private int mState;

    // the value is after clicked view
    private int mNumber;

    private int textY;
    private int textYOffest = 0;
    
    public FollowUpNumber(Context context) {
        this(context, null);
    }

    public FollowUpNumber(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowUpNumber(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FollowUpView);

        mTextSize = typedArray.getDimensionPixelSize(R.styleable.FollowUpView_text_size, DEFAULT_TEXT_SIZE);
        mTextColor = typedArray.getColor(R.styleable.FollowUpView_text_color, DEFAULT_TEXT_COLOR);

        typedArray.recycle();

        normalTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        normalTextPaint.setTextSize(mTextSize);
        normalTextPaint.setColor(mTextColor);

        originTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        originTextPaint.setTextSize(mTextSize);
        originTextPaint.setColor(mTextColor);

        newTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        newTextPaint.setTextSize(mTextSize);
        newTextPaint.setColor(mTextColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        String number = String.valueOf(mNumber);
        Rect bounds = new Rect();
        normalTextPaint.getTextBounds(number, 0, number.length(), bounds);

        int viewHeight = bounds.height() * 3;
        int viewWidth = (int) normalTextPaint.measureText(number);
        setMeasuredDimension(viewWidth, viewHeight);

        textY = bounds.height() * 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String strNumber = String.valueOf(mNumber);

        float startX = 0f;
        if (mState == NORMAL) {
            canvas.drawText(strNumber, startX, textY, normalTextPaint);
        } else if (mState == ADD || mState == SUBTRACT) {

            // get the number before clicked view
            String strLastNumber;
            if (mState == ADD) {
                strLastNumber = String.valueOf(mNumber - 1);
            } else {
                strLastNumber = String.valueOf(mNumber + 1);
            }

            // store the changed number's position
            int changePosition = 0;
            for (int i = 0; i < strNumber.length(); i++) {
                char char1 = strNumber.charAt(i);
                char char2 = strLastNumber.charAt(i);
                if (char1 != char2) {
                    changePosition = i;
                    break;
                }
            }

            // normal text
            String strOrigin = strNumber.substring(0, changePosition);
            canvas.drawText(strOrigin, startX, textY, normalTextPaint);

            // animation effect text
            String outText = strLastNumber.substring(changePosition, strLastNumber.length());
            String inText = strNumber.substring(changePosition, strNumber.length());

            startX = startX + normalTextPaint.measureText(strOrigin, 0, strOrigin.length());
            Rect bounds = new Rect();
            originTextPaint.getTextBounds(strNumber, 0, strNumber.length(), bounds);
            int height = bounds.height();

            if (mState == ADD) {
                float degree = Math.abs(textYOffest) / (height * 1f);
                int originAlpha = (int) ((1 - degree) * 255);
                originTextPaint.setAlpha(originAlpha);

                int newAlpha = (int) (degree * 255);
                newTextPaint.setAlpha(newAlpha);

                canvas.drawText(outText, startX, textY + textYOffest, originTextPaint);
                canvas.drawText(inText, startX, textY + textYOffest + height, newTextPaint);

                textYOffest--;
                if (Math.abs(textYOffest) <= height) {
                    invalidate();
                } else {
                    textYOffest = 0;
                }

            } else if (mState == SUBTRACT) {
                float degree = Math.abs(textYOffest) / (height * 1f);
                int originAlpha = (int) ((1 - degree) * 255);
                originTextPaint.setAlpha(originAlpha);

                int newAlpha = (int) (degree * 255);
                newTextPaint.setAlpha(newAlpha);

                canvas.drawText(outText, startX, textY + textYOffest, originTextPaint);
                canvas.drawText(inText, startX, textY + textYOffest - height, newTextPaint);

                textYOffest++;
                if (Math.abs(textYOffest) <= height) {
                    invalidate();
                } else {
                    textYOffest = 0;
                }
            }
        }
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
        normalTextPaint.setColor(mTextColor);
        originTextPaint.setColor(mTextColor);
        newTextPaint.setColor(mTextColor);
    }

    public void setTextSize(float textSize) {
        mTextSize = textSize;
        normalTextPaint.setTextSize(mTextSize);
        originTextPaint.setTextSize(mTextSize);
        newTextPaint.setTextSize(mTextSize);
    }

    public void setText(int text) {
        mNumber = text;
        setState(NORMAL);
    }

    public void setState(int state) {
        if (mNumber == 0 && state == SUBTRACT) {
            return;
        }
        mState = state;
        if (mState == ADD) {
            mNumber++;
        } else if (mState == SUBTRACT) {
            mNumber--;
            if (mNumber < 0) {
                return;
            }
        }

        requestLayout();
        invalidate();
    }
}
