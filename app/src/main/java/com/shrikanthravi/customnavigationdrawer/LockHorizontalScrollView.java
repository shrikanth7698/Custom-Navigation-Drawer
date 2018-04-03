package com.shrikanthravi.customnavigationdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class LockHorizontalScrollView extends HorizontalScrollView {
    public LockHorizontalScrollView(Context context) {
        super(context);
    }

    public LockHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LockHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
