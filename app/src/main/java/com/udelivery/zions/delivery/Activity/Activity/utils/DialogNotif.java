package com.udelivery.zions.delivery.Activity.Activity.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback;
import com.udelivery.zions.delivery.R;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class DialogNotif {

  MaterialDialog.Builder builder;
  Context context;
  ChangeOrderStatus listener;

  public DialogNotif(Context context) {
    builder = new MaterialDialog.Builder(context);
    this.context = context;
  }

  public void setListener(ChangeOrderStatus listener){
    this.listener=listener;
  }

  public void showBasicDismissDialog(String title, String msg) {

    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(context.getString(R.string.ok))
          .onAny(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              dialog.dismiss();
            }
          });
    } else {
      builder.content(msg)
          .positiveText(context.getString(R.string.ok))
          .onAny(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              dialog.dismiss();
            }
          });
    }
    builder.show();
  }

  public void showChooseDismissDialog(String title, String msg){

    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(context.getString(R.string.co))
          .negativeText(context.getString(R.string.khong))
          .onNegative(new SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              dialog.dismiss();
            }
          })
          .onPositive(new SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              listener.handleOrderStatus();
            }
          });
    } else {
      builder.content(msg)
          .positiveText(context.getString(R.string.ok))
          .onAny(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
              dialog.dismiss();
            }
          });
    }
    builder.show();

  }

  interface ChangeOrderStatus {
    void handleOrderStatus();
  }


}
