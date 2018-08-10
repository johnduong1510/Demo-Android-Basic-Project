package com.dvl.demo_pinchtozoomimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by Admin on 8/8/2016.
 */
public class MyZoom extends View {
    float x,y;
    float move_x,move_y;
    float lech_x,lech_y;
    float lasttouch_x,lasttouch_y;
    Drawable hinh;
    float tile=1.0f;//ti le zoom
    ScaleGestureDetector scale;



    public MyZoom(Context context) {
        super(context);
        hinh=context.getResources().getDrawable(R.drawable.ic_launcher);
        setFocusable(true);
        //set hinh
        hinh.setBounds(0,0,hinh.getIntrinsicWidth(),hinh.getIntrinsicHeight());
        scale=new ScaleGestureDetector(context,new sukienscale());
    }

    public MyZoom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(tile,tile);
        canvas.translate(move_x/tile,move_y/tile);
        hinh.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scale.onTouchEvent(event);
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                lasttouch_x=event.getX();
                lasttouch_y=event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                x=event.getX();
                y=event.getY();
                if(!scale.isInProgress())//neu khong phai la scale
                {
                    lech_x=x-lasttouch_x;
                    lech_y=y-lasttouch_y;
                    move_x+=lech_x;
                    move_y+=lech_y;
                }
                lasttouch_y=y;
                lasttouch_x=x;
                break;
            case MotionEvent.ACTION_UP:break;
            default:break;
        }
        invalidate();
        return true;
        //return super.onTouchEvent(event);
    }

    class sukienscale extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            tile=tile*detector.getScaleFactor();//lay ve ti le co gian
            tile=Math.max(0.1f,Math.min(tile,5.0f));//gioi han ti le co gian,   0.1f<tile<5.0f
            invalidate();
            return true;
            //return super.onScale(detector);
        }
    }
}
