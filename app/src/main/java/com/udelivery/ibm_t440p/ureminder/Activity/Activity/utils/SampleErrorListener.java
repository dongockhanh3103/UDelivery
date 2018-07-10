package com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils;

import android.util.Log;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;

/**
 * Created by Ngoc Khanh on 7/1/2018.
 */

public class SampleErrorListener implements PermissionRequestErrorListener {
  @Override public void onError(DexterError error) {
    Log.e("Dexter", "There was an error: " + error.toString());
  }
}