package com.h2lo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.h2lo.SurfaceViewExampleActivity.OurView;

// http://www.youtube.com/watch?v=J29V0nvmZ2M&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.36- Creating a sprite update method for animation
public class Sprite {

  int x, y;
  int xSpeed, ySpeed;
  int height, width;
  Bitmap b;
  OurView ov;
  
  public Sprite(OurView ourView, Bitmap blob) {
    b = blob;
    ov = ourView;
    height = blob.getHeight();
    width = blob.getWidth();
    xSpeed = 5;
    ySpeed = 0;
  }

  public void onDraw(Canvas canvas) {
    update();
    Rect src = new Rect(0,0,width,height);
    Rect dst = new Rect(x,y,x+width,y+height);
    canvas.drawBitmap(b, src, dst, null);
  }

  private void update() {
    if(x > ov.getWidth() - width - xSpeed) {
      xSpeed = 0;
      ySpeed = 5;
    }
    if(y > ov.getHeight() - height - ySpeed) {
      xSpeed = -5;
      ySpeed = 0;
    }
    if(x + xSpeed < 0) {
      x = 0;
      xSpeed = 0;
      ySpeed = -5;
    }
    if(y + ySpeed < 0 ) {
      y = 0;
      xSpeed = 5;
      ySpeed = 0;
    }
    x += xSpeed;
    y += ySpeed;
  }

}
