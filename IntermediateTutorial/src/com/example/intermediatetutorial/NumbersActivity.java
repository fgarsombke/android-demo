package com.example.intermediatetutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NumbersActivity extends Activity  implements OnClickListener {

  EditText number;
  Button sendInfo;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.numbers);
    number = (EditText)findViewById(R.id.editText1);
    sendInfo = (Button)findViewById(R.id.button1);
    sendInfo.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    String s = number.getText().toString();
    // this data is put into the intent from MainActivity - intent.putExtra("numbers", "width")
    Intent intent = getIntent();
    String msg = intent.getStringExtra("numbers");
    if(msg.contentEquals("width")) {
      intent.putExtra("widthInfo", s);
      setResult(RESULT_OK, intent);
      finish();
    }
    if(msg.contentEquals("height")) {
      intent.putExtra("heightInfo", s);
      setResult(RESULT_OK, intent);      
      finish();
    }    
  }
}
