package com.example.intermediatetutorial;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

// Learn Android Tutorial 2.6 - Shared Preferences Example 2
// http://www.youtube.com/watch?v=woM5qbRBNe8&list=SP667C75EE599C22C6
public class SettingsActivity extends Activity implements OnClickListener {

  CheckBox checkBox;
  EditText editText;
  Button button;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settings);
    checkBox = (CheckBox) findViewById(R.id.checkBox1);
    editText = (EditText) findViewById(R.id.editText1);
    button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(this);
    loadPrefs();
  }
  
  @Override
  public void onClick(View v) {
    savePrefs("CHECKBOX", checkBox.isChecked());
    if(checkBox.isChecked()) {
      savePrefs("NAME", editText.getText().toString());      
    }
    // goes to main activity - this closes the current activity
    finish();
  }

  private void loadPrefs() {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    boolean cBox = sharedPreferences.getBoolean("CHECKBOX", false);
    String name = sharedPreferences.getString("NAME", "No Name.");
    checkBox.setChecked(cBox);
    editText.setText(name);
  }
  
  private void savePrefs(String key, boolean value) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    Editor editor = sharedPreferences.edit();
    editor.putBoolean(key, value);
    editor.commit();
  }
  
  private void savePrefs(String key, String value) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    Editor editor = sharedPreferences.edit();
    editor.putString(key, value);
    editor.commit();    
  }

}
