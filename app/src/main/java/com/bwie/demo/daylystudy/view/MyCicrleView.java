package com.bwie.demo.daylystudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qwe on 2017/1/17.
 */

public class MyCicrleView extends View {
    public MyCicrleView(Context context) {
        super(context);
    }

    public MyCicrleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCicrleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawCircle(getMeasuredHeight() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2 - 1, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
