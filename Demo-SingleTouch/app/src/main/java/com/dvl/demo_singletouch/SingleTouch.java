package com.dvl.demo_singletouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Admin on 8/8/2016.
 */
public class SingleTouch extends View {
    Paint paint=new Paint();
    Path path=new Path();


    public SingleTouch(Context context) {
        super(context);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//khu rang cua => dep hon
        paint.setStyle(Paint.Style.STROKE);//chi ve vien ngoai
        paint.setStrokeJoin(Paint.Join.ROUND);//ve theo kieu vong tron
        paint.setStrokeWidth(6f);

    }

    public SingleTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX=event.getX();
        float eventY=event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX,eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX,eventY);
                break;
            case MotionEvent.ACTION_UP:
                //do nothing
                break;
            default:return false;
        }
        invalidate();//ve lai view
        //neu ve lai view tu UI-thread dung  invalidate()
        //neu ve lai tu non-UI Thread dung view.postInvalidate()
        return true;
    }
}
