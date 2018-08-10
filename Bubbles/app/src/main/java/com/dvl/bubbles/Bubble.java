package com.dvl.bubbles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;

/**
 * Created by Admin on 5/8/2016.
 */
class Bubble {
    private float x, y, speed;
    private static final Paint bubblePaint = new Paint();
    private float amountOfWobble = 0;
    public static final float WOBBLE_RATE = 1/40;
    public static final int WOBBLE_AMOUNT = 3;
    static {
        bubblePaint.setColor(Color.CYAN);
        bubblePaint.setStyle(Paint.Style.STROKE);
    }

    public static final int RADIUS = 10;
    public static final int MAX_SPEED = 10;
    public static final int MIN_SPEED = 1;
    private Bitmap bubbleBitmap;

    public Bubble(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = Math.max(speed, MIN_SPEED);
    }

    public Bubble(float x, float y, float speed,
                  Bitmap bubbleBitmap) {
        this.x = x;
        this.y = y;
        this.speed = Math.max(speed, MIN_SPEED);
        this.bubbleBitmap = bubbleBitmap;
    }


    public void draw(Canvas c) {
        //c.drawCircle(x, y, RADIUS, bubblePaint);
        c.drawBitmap(bubbleBitmap, x - RADIUS, y - RADIUS, bubblePaint);
    }

    public void move() {
        y -= speed;
        amountOfWobble = (float)Math.sin (y*WOBBLE_RATE);
    }

    public boolean outOfRange() {
        return (y + RADIUS < 0);
    }
}
