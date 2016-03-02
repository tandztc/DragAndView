package com.tanyong.dragandview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by baidu on 16/3/2.
 * 自定义视图类
 */
public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";
    private Paint mBackgroundPaint;
    private Paint mBoxPaint;
    private Box mCurrentBox;
    private ArrayList<Box> mBoxes;

    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(Color.GRAY);
        mBoxPaint = new Paint();
        mBoxPaint.setColor(Color.RED);
        mBoxPaint.setAlpha(100);
        mBoxes = new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentBox = new Box(current);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if (mCurrentBox != null) {
                    mCurrentBox.setCurrent(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                //mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
        }

        Log.i(TAG, action + " at x=" + current.x + ", y=" + current.y);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);
        if (mCurrentBox != null) {
            float left = Math.min(mCurrentBox.getOrigin().x, mCurrentBox.getCurrent().x);
            float right = Math.max(mCurrentBox.getOrigin().x, mCurrentBox.getCurrent().x);
            float top = Math.min(mCurrentBox.getOrigin().y, mCurrentBox.getCurrent().y);
            float bottom = Math.max(mCurrentBox.getOrigin().y, mCurrentBox.getCurrent().y);
            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }
}
