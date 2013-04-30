package com.h2lo;

import android.app.Activity;
import android.os.Bundle;

// Learn Android Tutorial 1.25- Custom View and Constructors
// http://www.youtube.com/watch?v=vOY2AxbnRyc&list=SPB03EA9545DD188C3

// Learn Android Tutorial 1.26- Drawing Rectangles on a Canvas
// http://www.youtube.com/watch?v=IUGRQqfHb8k&list=SPB03EA9545DD188C3
public class TutorialFourActivity extends Activity {

  DrawingTheBall view;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    view = new DrawingTheBall(this);
    setContentView(view);
  }
}
