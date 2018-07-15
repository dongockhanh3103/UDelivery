package com.udelivery.zions.delivery.Activity.Activity.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.udelivery.zions.delivery.R;

/**
 * Created by Ngoc Khanh on 7/1/2018.
 */

public class DialogVerifyChangeStatusCode  extends AlertDialog{

  Context context;
  EditText inputNote;
  TextView btnCancel;
  TextView btnVerify;

  TextView.OnClickListener verifyListener;
  TextView.OnClickListener cancelListener;
  public DialogVerifyChangeStatusCode(Context context) {
    super(context);
    this.context = context;
  }
  @Override
  protected void onStart() {
    super.onStart();
    if (verifyListener != null) {
      btnVerify.setOnClickListener(verifyListener);
    }
    if (cancelListener != null) {
      btnCancel.setOnClickListener(cancelListener);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.chang_order_status_dialog);
    inputNote = findViewById(R.id.input_note);
    btnCancel = findViewById(R.id.btn_cancel);
    btnVerify = findViewById(R.id.btn_verify);
    this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
  }

  public DialogVerifyChangeStatusCode setNote(String message) {
    this.inputNote.setText(message);
    return this;
  }

  public String getNote(){
    return this.inputNote.getText().toString();
  }
  public DialogVerifyChangeStatusCode setSendMentorCodeButton(TextView.OnClickListener listener) {
    this.verifyListener = listener;
    return this;
  }

  public DialogVerifyChangeStatusCode setCancel(TextView.OnClickListener listener) {
    this.cancelListener = listener;
    return this;
  }
}
