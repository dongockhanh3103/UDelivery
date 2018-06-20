package com.example.ibm_t440p.ureminder.Activity.Activity.constant;

import android.app.Application;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class App extends Application {
  private static App mSelf;

  public static App self() {
    return mSelf;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mSelf = this;
  }
}