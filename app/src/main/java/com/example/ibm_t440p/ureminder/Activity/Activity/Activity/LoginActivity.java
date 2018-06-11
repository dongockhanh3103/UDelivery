package com.example.ibm_t440p.ureminder.Activity.Activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.ibm_t440p.ureminder.R;

public class LoginActivity extends AppCompatActivity {
  Button btnEmail;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    btnEmail= findViewById(R.id.email_sign_in_button);
    btnEmail.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
      }
    });

  }
}
