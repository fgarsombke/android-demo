package com.h2lo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;

// Learn Android Tutorial 1.21- Setting up XML for Wallpaper App
// http://www.youtube.com/watch?v=wp5sORsPopw&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.22- Using an ImageView as a Button
// http://www.youtube.com/watch?v=n0n3NRf-6JI&list=SPB03EA9545DD188C3
public class TutorialThreeActivity extends Activity implements OnClickListener {

  ImageView display;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    
    // Learn Android Tutorial 1.24- Setting Fullscreen and Fixed Screen
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    
    setContentView(R.layout.wallpaper);

    display = (ImageView) findViewById(R.id.IVDisplay);
    ImageView image1 = (ImageView) findViewById(R.id.IVImage1);
    ImageView image2 = (ImageView) findViewById(R.id.IVImage2);
    ImageView image3 = (ImageView) findViewById(R.id.IVImage3);
    ImageView image4 = (ImageView) findViewById(R.id.IVImage4);
    ImageView image5 = (ImageView) findViewById(R.id.IVImage5);
    
    image1.setOnClickListener(this);
    image2.setOnClickListener(this);
    image3.setOnClickListener(this);
    image4.setOnClickListener(this);
    image5.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
    case R.id.IVImage1:
      display.setImageResource(R.drawable.img1);
      break;
    case R.id.IVImage2:
      display.setImageResource(R.drawable.img2);
      break;
    case R.id.IVImage3:
      display.setImageResource(R.drawable.img3);
      break;
    case R.id.IVImage4:
      display.setImageResource(R.drawable.img4);
      break;
    case R.id.IVImage5:
      display.setImageResource(R.drawable.img5);
      break;
    default:
      break;
    }
  }
  
  
}
