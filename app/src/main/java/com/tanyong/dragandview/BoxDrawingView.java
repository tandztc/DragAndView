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

/**
 * Created by baidu on 16/3/2.
 * 自定义视图类
 */
public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";
    private Paint mBackgroundPaint;
    private Paint mBoxPaint;
    private Box mBox;

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mBox = new Box(current);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                mBox.setCurrent(current);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mBox = null;
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
        if (mBox != null) {
            float left = Math.min(mBox.getOrigin().x, mBox.getCurrent().x);
            float right = Math.max(mBox.getOrigin().x, mBox.getCurrent().x);
            float top = Math.min(mBox.getOrigin().y, mBox.getCurrent().y);
            float bottom = Math.max(mBox.getOrigin().y, mBox.getCurrent().y);
            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }
}
