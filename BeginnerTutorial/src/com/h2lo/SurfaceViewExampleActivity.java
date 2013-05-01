package com.h2lo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

// http://www.youtube.com/watch?v=Z2YogvILjvo&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.28- Introduction to the SurfaceView

// http://www.youtube.com/watch?v=wOCNnniCJfY&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.30- Canvas Lock, Draw, and Post

// http://www.youtube.com/watch?v=oLf32M6lUKo&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.31- Drawing Bitmaps on a SurfaceView Canvas

// Learn Android Tutorial 1.32- Android's OnTouchListener and MotionEvent
// http://www.youtube.com/watch?v=9d4Wua-cxZs&list=SPB03EA9545DD188C3

// Learn Android Tutorial 1.33- Review of SurfaceView and Thread setup
// http://www.youtube.com/watch?v=QEOpHg7ZMNk&list=SPB03EA9545DD188C3

// Learn Android Tutorial 1.34- Sprites, sprite sheet, & animation on Androi
// http://www.youtube.com/watch?v=WxkuDwJcq6M&list=SPB03EA9545DD188C3

// http://www.youtube.com/watch?v=LHRDeDHW5zI&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.35- Drawing the Spritesheet to Canvas

// Learn Android Tutorial 1.36- Creating a sprite update method for animation
// http://www.youtube.com/watch?v=J29V0nvmZ2M&list=SPB03EA9545DD188C3
public class SurfaceViewExampleActivity extends Activity implements OnTouchListener {

  OurView ourView;
  Bitmap ball, blob;
  float x,y;
  Sprite sprite;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ourView = new OurView(this);
    ourView.setOnTouchListener(this);
    ball = BitmapFactory.decodeResource(getResources(), R.drawable.blue_ball);
    blob = BitmapFactory.decodeResource(getResources(), R.drawable.ninjaspritesheet);
    setContentView(ourView);
  }
  
  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {

    // help with motion
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    switch (motionEvent.getAction()) {
    case MotionEvent.ACTION_DOWN:
      x = motionEvent.getX();
      y = motionEvent.getY();
      break;
    case MotionEvent.ACTION_UP:
      x = motionEvent.getX();
      y = motionEvent.getY();
      break;
    case MotionEvent.ACTION_MOVE:
      x = motionEvent.getX();
      y = motionEvent.getY();
      break;
    default:
      break;
    }
    return true;
  }

  @Override
  protected void onPause() {
    super.onPause();
    ourView.pause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    ourView.resume();
  }

  // make this a thread
  public class OurView extends SurfaceView implements Runnable {
    
    Thread t = null;
    SurfaceHolder surfaceHolder;
    boolean isItOk = false;
    
    public OurView(Context context) {
      super(context);
      surfaceHolder = getHolder();
    }
    
    @Override
    @SuppressLint("WrongCall")
    public void run() {
      sprite = new Sprite(this, blob);
      while(isItOk) {
        // perform canvas drawing
        if(!surfaceHolder.getSurface().isValid()) {
          continue;
        }
        Canvas canvas = surfaceHolder.lockCanvas();
        onDraw(canvas);
        surfaceHolder.unlockCanvasAndPost(canvas);
      }
    }
    
    @SuppressLint("WrongCall")
    protected void onDraw(Canvas canvas) {
      // 0 - 255
      canvas.drawARGB(255, 150, 150, 10);
      canvas.drawBitmap(ball, x-(ball.getWidth()/2), y-(ball.getHeight()/2), null);
      sprite.onDraw(canvas);
    }
    
    public void pause() {
      isItOk = false;
      while(true) {
        try {
          t.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        break;
      }
      t = null;
    }
    
    public void resume() {
      isItOk = true;
      t = new Thread(this);
      t.start();
    }
   }
}