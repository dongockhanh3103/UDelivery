package com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils;

import android.app.ProgressDialog;
import android.content.Context;
import com.udelivery.ibm_t440p.ureminder.R;


/**
 * Created by Ngoc Khanh on 3/24/2018.
 */

public class SimpleProgressDialog {
  ProgressDialog progressDialog;
  Context context;
  public SimpleProgressDialog(Context context) {

    this.context = context;
    progressDialog = new ProgressDialog(context, android.R.style.Theme_Translucent);

  }
  public void dismiss() {
    try {
      if (progressDialog != null && progressDialog.isShowing())
        progressDialog.dismiss();
    } catch (Exception exp) {
    }
  }

  public void show() {

    progressDialog.setTitle(null);
    progressDialog.setCancelable(false);
    progressDialog.setCanceledOnTouchOutside(false);
//        progressDialog.setIndeterminate(true);
    progressDialog.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.simple_progress_dialog_bg));
    progressDialog.show();
    progressDialog.setContentView(R.layout.simple_progress_dialog);
  }


  public boolean isShow(){
    return progressDialog!=null?progressDialog.isShowing():false;
  }

}
