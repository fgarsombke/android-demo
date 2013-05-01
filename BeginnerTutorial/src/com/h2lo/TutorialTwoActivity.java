package com.h2lo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// Learn Android Tutorial 1.19- String Array and ListView
// http://www.youtube.com/watch?v=32M8ikeXppQ&list=SPB03EA9545DD188C3
// Learn Android Tutorial 1.20- Using ListView to open Activities
// http://www.youtube.com/watch?v=-j-TDnKgUL0&list=SPB03EA9545DD188C3
public class TutorialTwoActivity extends ListActivity {

  String classNames[] = { "MainActivity", "MenuActivity", "SweetActivity", "TutorialOneActivity" };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames));
  }
  
  @Override
  protected void onListItemClick(ListView listView, View view, int position, long id) {
    super.onListItemClick(listView, view, position, id);
    String openClass = classNames[position];
    try {
      Class selected = Class.forName("com.h2lo." + openClass);
      Intent selectedIntent = new Intent(this, selected);
      startActivity(selectedIntent);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    finish();
  }
  
  
}
