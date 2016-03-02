package com.tanyong.dragandview;

import android.graphics.PointF;

/**
 * Created by baidu on 16/3/2.
 * 画个框，这里是框的数据模型
 */
public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

}
