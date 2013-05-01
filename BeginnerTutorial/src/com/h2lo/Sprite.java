package com.h2lo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.h2lo.SurfaceViewExampleActivity.OurView;

// http://www.youtube.com/watch?v=J29V0nvmZ2M&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.36- Creating a sprite update method for animation

// Learn Android Tutorial 1.37- Changing Sprite's Direction (row)
// http://www.youtube.com/watch?v=fM0_hqGuYtw&list=SPB03EA9545DD188C3&index=37

// Learn Android Tutorial 1.38- Finalizing our sprite sheet animation (modulus)
// http://www.youtube.com/watch?v=s8IJkexsjlI&list=SPB03EA9545DD188C3
public class Sprite {

  int x, y;
  int xSpeed, ySpeed;
  int height, width;
  Bitmap b;
  OurView ov;
  int currentFrame = 0;
  int direction = 0;
  
  public Sprite(OurView ourView, Bitmap blob) {
    b = blob;
    ov = ourView;
    // 4 rows - this gets us one sprite image
    height = blob.getHeight() /3;
    // 4 columns - this gets us one sprite image
    width = blob.getWidth() / 4;
    xSpeed = 5;
    ySpeed = 0;
  }

  public void onDraw(Canvas canvas) {
    update();
    int srcY = direction * height;
    int srcX = currentFrame * width;
    Rect src = new Rect(srcX,srcY,srcX + width,srcY + height);
    Rect dst = new Rect(x,y,x+width,y+height);
    canvas.drawBitmap(b, src, dst, null);
  }

  private void update() {
    // 0 = up
    // 1 = down
    // 2 = left
    // 3 = right
    // facing down 
    if(x > ov.getWidth() - width - xSpeed) {
      xSpeed = 0;
      ySpeed = 5;
      direction = 1;
    }
    // facing left
    if(y > ov.getHeight() - height - ySpeed) {
      xSpeed = -5;
      ySpeed = 0;
      direction = 2;
    }
    // facing up
    if(x + xSpeed < 0) {
      x = 0;
      xSpeed = 0;
      ySpeed = -5;
      direction = 0;
    }
    // facing right
    if(y + ySpeed < 0 ) {
      y = 0;
      xSpeed = 5;
      ySpeed = 0;
      direction = 3;
    }
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    currentFrame = ++currentFrame % 4;
    x += xSpeed;
    y += ySpeed;
  }

}
