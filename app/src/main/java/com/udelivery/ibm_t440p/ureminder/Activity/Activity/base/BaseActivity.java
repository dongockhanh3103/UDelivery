package com.udelivery.ibm_t440p.ureminder.Activity.Activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils.SimpleProgressDialog;

/**
 * Created by Ngoc Khanh on 3/25/2018.
 */

public class BaseActivity extends AppCompatActivity {
  private SimpleProgressDialog simpleProgressDialog;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    simpleProgressDialog=new SimpleProgressDialog(this);
  }
  private void showProgressDialog() {
    simpleProgressDialog.show();
  }

  private void dismissProgressDialog() {
    if (simpleProgressDialog != null && simpleProgressDialog.isShow()) {
      simpleProgressDialog.dismiss();
    }
  }
  public void onShowProgressBar(boolean isShow){
    if(isShow)
      showProgressDialog();
    else
      dismissProgressDialog();
  }

}
