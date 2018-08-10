package com.dvl.bubbles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.LinkedList;

/**
 * Created by Admin on 5/8/2016.
 */
public class BubblesView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Bitmap bubbleBitmap;
    private Paint backgroundPaint = new Paint();
    private float BUBBLE_FREQUENCY = 0.3f;
    private LinkedList<Bubble> bubbles = new LinkedList<Bubble>();
    private GameLoop gameLoop;

    public BubblesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        backgroundPaint.setColor(Color.rgb(51,51,204));
        bubbleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bubbles);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder = holder;
        myStartAnimation();
    }

    public void myStartAnimation() {
        synchronized (this) {
            if (gameLoop == null) {
                gameLoop = new GameLoop();
                gameLoop.start();
            }
        }
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopAnimation();
    }

    public void stopAnimation() {
        synchronized (this) {
            boolean retry = true;
            if (gameLoop != null) {
                gameLoop.running = false;
                while (retry) {
                    try {
                        gameLoop.join();
                        retry = false;
                    } catch (InterruptedException e) {
                    }
                }
            }
            gameLoop = null;
        }
    }


    private void drawScreen(Canvas c) {
        c.drawRect(
                0, 0,
                c.getWidth(),
                c.getHeight(), backgroundPaint);

        for (Bubble bubble : bubbles) {
            bubble.draw(c);
        }
    }

    private void calculateDisplay(Canvas c) {
        randomlyAddBubbles(c.getWidth(), c.getHeight());
        LinkedList<Bubble> bubblesToRemove = new LinkedList<Bubble>();
        for (Bubble bubble : bubbles) {
            bubble.move();
            if (bubble.outOfRange()) bubblesToRemove.add(bubble);
        }
        for (Bubble bubble : bubblesToRemove) {
            bubbles.remove(bubble);
        }
    }

    public void randomlyAddBubbles(int screenWidth, int screenHeight) {
        if (Math.random() > BUBBLE_FREQUENCY) return;
        bubbles.add(new Bubble(
                (int) (screenWidth * Math.random()), screenHeight + Bubble.RADIUS,
                (int) ((Bubble.MAX_SPEED - 0.1) * Math.random() + 0.1), bubbleBitmap));

    }

    private class GameLoop extends Thread {
        private long msPerFrame = 1000 / 25;
        public boolean running = true;
        long frameTime = 0;

        public void run() {
            Canvas canvas = null;
            frameTime = System.currentTimeMillis();
            final SurfaceHolder surfaceHolder = BubblesView.this.surfaceHolder;
            while (running) {
                try {
                    canvas = surfaceHolder.lockCanvas();
                    synchronized (surfaceHolder) {
                        calculateDisplay(canvas);
                        drawScreen(canvas);
                    }
                } finally {
                    if (canvas != null)
                        surfaceHolder.unlockCanvasAndPost(canvas);
                }
                waitTillNextFrame();
            }
        }

        private void waitTillNextFrame() {
            long nextSleep = 0;
            frameTime += msPerFrame;
            nextSleep = frameTime - System.currentTimeMillis();
            if (nextSleep > 0) {
                try {
                    sleep(nextSleep);
                } catch (InterruptedException e) {
                }
            }
        }

    }


}
