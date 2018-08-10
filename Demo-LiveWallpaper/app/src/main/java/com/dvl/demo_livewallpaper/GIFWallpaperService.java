package com.dvl.demo_livewallpaper;

import android.app.Service;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.os.IBinder;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.view.View;

import java.io.IOException;

public class GIFWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        try{
            Movie movie=Movie.decodeStream(getResources().getAssets().open("wallpaper.gif"));
            return new GIFWallpaperEngine(movie);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class GIFWallpaperEngine extends Engine
    {
        private final int frameDuration=20;
        private SurfaceHolder holder;
        private Movie movie;
        private boolean visible;
        private Handler handler;

        private GIFWallpaperEngine(Movie movie) {
            this.movie = movie;
            handler=new Handler();
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            this.holder=surfaceHolder;
        }
        private Runnable drawGIF=new Runnable() {
            @Override
            public void run() {
                draw();
            }
        };

        private void draw()
        {
            float scaleHeight;
            float scaleWidth;
            if(visible) {
                Canvas canvas=holder.lockCanvas();
                canvas.save();

                //--------------------------------------------------
                //tinh scale
                int movieWidth=movie.width();
                int movieHeight=movie.height();

                if(canvas.getHeight()<movieHeight) scaleHeight=(float)(movieHeight)/(float)(canvas.getHeight());
                else scaleHeight=(float)(canvas.getHeight())/(float)(movieHeight);

                if(canvas.getWidth()<movieWidth) scaleWidth=(float)(movieWidth) /(float)(canvas.getWidth());
                else scaleWidth=(float)(canvas.getWidth()) /(float)(movieWidth);
                //-----------------------------------------------------
                //canvas.scale(1.0f,2.0f);
                canvas.scale(scaleWidth,scaleHeight);


                movie.draw(canvas,0,0);
                canvas.restore();
                holder.unlockCanvasAndPost(canvas);
                movie.setTime((int)(System.currentTimeMillis())%movie.duration());

                handler.removeCallbacks(drawGIF);
                handler.postDelayed(drawGIF,frameDuration);
            }
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible=visible;
            if(visible){handler.post(drawGIF);}
            else {
                handler.removeCallbacks(drawGIF);
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(drawGIF);
        }
    }

}
