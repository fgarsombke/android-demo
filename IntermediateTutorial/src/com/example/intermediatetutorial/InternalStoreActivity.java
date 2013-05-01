package com.example.intermediatetutorial;

import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

// Learn Android Tutorial 2.9 - Intro to Internal Storage
// http://www.youtube.com/watch?v=7dakMg41j1Q&list=SP667C75EE599C22C6
public class InternalStoreActivity extends Activity implements OnClickListener {

  Button save;
  EditText filename, entry;
  String FILENAME, JOURNAL;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.internal_store);
    save = (Button) findViewById(R.id.button1);
    filename = (EditText) findViewById(R.id.editText1);
    entry = (EditText) findViewById(R.id.editText2);
    save.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    FILENAME = filename.getText().toString();
    if (FILENAME.contentEquals("")) {
      FILENAME = "Untitled";
    }
    JOURNAL = entry.getText().toString();
    try {
      FileOutputStream fileOutputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
      fileOutputStream.write(JOURNAL.getBytes());
      fileOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
