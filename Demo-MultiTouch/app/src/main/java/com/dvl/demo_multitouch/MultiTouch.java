package com.dvl.demo_multitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Admin on 8/8/2016.
 */

public class MultiTouch extends View {
    Paint paint = new Paint();
    ArrayList<Float> x = new ArrayList<Float>();
    ArrayList<Float> y = new ArrayList<Float>();
    ArrayList<Boolean> isTouch = new ArrayList<Boolean>();


    public MultiTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiTouch(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        int index = MotionEventCompat.getActionIndex(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isTouch.add(true);
                x.add(event.getX(index));
                y.add(event.getY(index));
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                isTouch.add(true);
                x.add(event.getX(index));
                y.add(event.getY(index));
                break;
            case MotionEvent.ACTION_MOVE:
                int count = event.getPointerCount();
                for (int i = 0; i < count; i++) {
                    index = i;
                    x.set(index, event.getX(index));
                    y.set(index, event.getY(index));
                }
                break;
            case MotionEvent.ACTION_UP:
                isTouch.remove(index);
                x.remove(index);
                y.remove(index);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                isTouch.remove(index);
                x.remove(index);
                y.remove(index);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<x.size();i++)
        {
            if(isTouch.get(i)==true)
                canvas.drawCircle(x.get(i),y.get(i),80f,paint);
        }
    }
}
