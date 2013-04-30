package com.h2lo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

// Learn Android Tutorial 1.27- Animating a Bitmap
// http://www.youtube.com/watch?v=UlOFYp7ayZ4&list=SPB03EA9545DD188C3&index=27
public class DrawingTheBall extends View {

  Bitmap blueBall;
  int x,y;
  
  public DrawingTheBall(Context context) {
    super(context);
    blueBall = BitmapFactory.decodeResource(getResources(), R.drawable.blue_ball);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Rect ourRect = new Rect();
    ourRect.set(0, 0, canvas.getWidth(), canvas.getHeight()/2);
    Paint blue = new Paint();
    blue.setColor(Color.BLUE);
    blue.setStyle(Paint.Style.FILL);
    canvas.drawRect(ourRect, blue);
    if(x < canvas.getWidth()) {
      x += 10;      
    } else {
      x = 0;
    }
    if(y < canvas.getHeight()) {
      y += 10;      
    } else {
      y = 0;
    }
    canvas.drawBitmap(blueBall, x, y, new Paint());
    // makes it loop through and moves the ball
    invalidate();
  }
  
}
