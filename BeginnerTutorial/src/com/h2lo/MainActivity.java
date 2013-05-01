package com.h2lo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    Thread logoTimer = new Thread() {
      public void run() {
        try {
          sleep(1000);
          Intent menuIntent = new Intent("com.h2lo.MENU");
          startActivity(menuIntent);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          finish();
        }
      }
    };
    logoTimer.start();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

}
