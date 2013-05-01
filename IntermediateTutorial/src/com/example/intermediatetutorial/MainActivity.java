package com.example.intermediatetutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// Learn Android Tutorial 2.2- Getting Intent information (messages)
// http://www.youtube.com/watch?v=jw3Pzn16t8Y&list=SP667C75EE599C22C6

// Learn Android Tutorial 2.3 - onActivityResult Example
// http://www.youtube.com/watch?v=X0iv2BoxfRQ&list=SP667C75EE599C22C6
public class MainActivity extends Activity implements OnClickListener {

  Button width, height, calculate, preferences, internalStore;
  TextView area;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    width = (Button)findViewById(R.id.button1);
    height = (Button)findViewById(R.id.button2);
    calculate = (Button)findViewById(R.id.button3);
    area = (TextView)findViewById(R.id.textView1);
    
    width.setOnClickListener(this);
    height.setOnClickListener(this);
    calculate.setOnClickListener(this);
    preferences.setOnClickListener(this);
    internalStore.setOnClickListener(this);    
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, NumbersActivity.class);
    switch (v.getId()) {
    case R.id.button1:
      // width
      intent.putExtra("numbers", "width");
      // code will be returned in onActivityResult()
      startActivityForResult(intent, 1);
      break;
    case R.id.button2:
      // height
      intent.putExtra("numbers", "height");         
      // code will be returned in onActivityResult()
      startActivityForResult(intent, 1);
      break;
    case R.id.button3:
      int a = Integer.parseInt(width.getText().toString());
      int b = Integer.parseInt(height.getText().toString());
      area.setText(a*b + " sq ft");
      break;
    default:
      break;
    }    
  }
  
  // these results are provided from the NumbersActivity
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(data.getExtras().containsKey("widthInfo")) {
      width.setText(data.getStringExtra("widthInfo"));
    }
    if(data.getExtras().containsKey("heightInfo")) {
      height.setText(data.getStringExtra("heightInfo"));
    }
  }
  
}
