package com.example.intermediatetutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Menu extends Activity implements OnClickListener {

  String activities[] = { "PASSINGDATA", "SETTINGS", "INTERNALSTORE", "READING" };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu);

  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    for (int i = 0; i < activities.length; i++) {
      if (id == getResources().getIdentifier("b" + i, "id", "com.example.intermediatetutorial")) {
        Intent intent = new Intent("com.example.intermediatetutorial." + activities[i]);
        startActivity(intent);
      }
    }

  }
}
