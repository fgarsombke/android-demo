package com.h2lo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button tutorial1 = (Button) findViewById(R.id.radioViewButton);
    Button tutorial2 = (Button) findViewById(R.id.listViewButton);
    Button tutorial3 = (Button) findViewById(R.id.imageViewButton);
    Button tutorial4 = (Button) findViewById(R.id.customViewButton);
    Button surfaceViewButton = (Button) findViewById(R.id.surfaceViewButton);

    tutorial1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent("com.h2lo.TUTORIALONE");
        startActivity(intent);
      }
    });
    
    tutorial2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent("com.h2lo.TUTORIALTWO");
        startActivity(intent);
      }
    });
    
    tutorial3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent("com.h2lo.TUTORIALTHREE");
        startActivity(intent);
      }
    });     

    tutorial4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent("com.h2lo.TUTORIALFOUR");
        startActivity(intent);
      }
    });     

    surfaceViewButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent("com.h2lo.SURFACEVIEW");
        startActivity(intent);
      }
    });     

  }

  @Override
  protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    // these are menu items when you press menu button (lower left hand corner on phone)
    MenuInflater awesome = getMenuInflater();
    awesome.inflate(R.menu.main_menu, menu);
    return true;
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem menuItem) {
    switch (menuItem.getItemId()) {
    case R.id.menuSweet:
      startActivity(new Intent("com.h2lo.SWEET"));
      return true;          
    case R.id.menuToast:
      Toast andEggs = Toast.makeText(MenuActivity.this, "This is a toast", Toast.LENGTH_LONG);
      andEggs.show();
      return true;          
    default:
      break;
    }
    return true;    
  }
}
