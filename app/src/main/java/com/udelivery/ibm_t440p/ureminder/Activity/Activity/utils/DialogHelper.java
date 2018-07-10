package com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.StackingBehavior;
import com.udelivery.ibm_t440p.ureminder.R;

/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public class DialogHelper {

  public static void showSuccessTickView(Context context, String content, MaterialDialog.SingleButtonCallback singleButtonCallback){
    MaterialDialog dialog = new MaterialDialog.Builder(context)
        .customView(R.layout.dialog_success_tickview, true)
        .positiveText(context.getString(R.string.ok))
        .onPositive(singleButtonCallback).build();
    TextView vContent = (TextView) dialog.findViewById(R.id.content);
    vContent.setText(content);

    final SuccessTickView successTickView = (SuccessTickView) dialog.findViewById(R.id.success_tickview);
    final View mSuccessRightMask = dialog.findViewById(R.id.mask_right);
    final AnimationSet animSuccessBow = (AnimationSet) OptAnimationLoader.loadAnimation(context, R.anim.success_bow_roate);

    dialog.show();
    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
      @Override
      public void onShow(DialogInterface dialogInterface) {
        successTickView.startTickAnim();
        mSuccessRightMask.startAnimation(animSuccessBow);
      }
    });
  }

  public static void showEditTextDialog(Context context, String title, String msg, String hint, MaterialDialog.InputCallback inputCallback) {
    new MaterialDialog.Builder(context)
        .title(title)
        .content(msg)
        .inputType(InputType.TYPE_CLASS_TEXT |
            InputType.TYPE_TEXT_VARIATION_PERSON_NAME |
            InputType.TYPE_TEXT_FLAG_CAP_WORDS)
        .positiveText(R.string.done)
        .input(hint, hint, false, inputCallback)
        .show();
  }

  public static void showStackedDialog(Context context, String title, String msg, String action1, String action2,String action3, MaterialDialog.SingleButtonCallback singleButtonCallback) {
    new MaterialDialog.Builder(context)
        .title(title)
        .content(msg)
        .positiveText(action1)
        .negativeText(action2)
        .neutralText(action3)
        .btnStackedGravity(GravityEnum.END)
        .stackingBehavior(StackingBehavior.ALWAYS)  // this generally should not be forced, but is used for demo purposes
        .onAny(singleButtonCallback)
        .show();
  }
  public static void showStackedDialog(Context context, String title, String msg, String action1, String action2,MaterialDialog.SingleButtonCallback singleButtonCallback) {
    new MaterialDialog.Builder(context)
        .title(title)
        .content(msg)
        .positiveText(action1)
        .negativeText(action2)
        .btnStackedGravity(GravityEnum.END)
        .stackingBehavior(StackingBehavior.ALWAYS)  // this generally should not be forced, but is used for demo purposes
        .onAny(singleButtonCallback)
        .show();
  }

  public static void showBasicDismissDialog(Context context, String title, String msg) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
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

  public static void showBasicDismissDialogClick(Context context, String title, String msg, MaterialDialog.SingleButtonCallback callback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .cancelable(false)
          .positiveText(context.getString(R.string.ok))
          .onAny(callback);
    } else {
      builder.content(msg)
          .cancelable(false)
          .positiveText(context.getString(R.string.ok))
          .onAny(callback);
    }
    builder.show();
  }

  public static void showBasicDismissDialogClick(Context context, String title, String msg,
      String positiveText,
      MaterialDialog.SingleButtonCallback callback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .onAny(callback);
    } else {
      builder.content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .onAny(callback);
    }
    builder.show();
  }

  public static void showBasicDismissDialogClick(Context context, String title, String msg,
      String positiveText, String negativeText,
      MaterialDialog.SingleButtonCallback callback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .onAny(callback);
    } else {
      builder.content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .onAny(callback);
    }
    builder.show();
  }

  public static void showBasicDismissDialogClick(Context context, String title, String msg,
      String positiveText, String negativeText, String neutralText,
      MaterialDialog.SingleButtonCallback callback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .neutralText(neutralText)
          .onAny(callback);
    } else {
      builder.content(msg)
          .cancelable(false)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .neutralText(neutralText)
          .onAny(callback);
    }
    builder.show();
  }

  public static void showBasicDismissDialogWithCallbacks(Context context, String title, String msg, MaterialDialog.SingleButtonCallback singleButtonCallback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);

    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(context.getString(R.string.ok))
          .cancelable(false)
          .onAny(singleButtonCallback);
    } else {
      builder.content(msg)
          .positiveText(context.getString(R.string.ok))
          .onAny(singleButtonCallback);
    }
    builder.show();
  }

  public static void showBasicDialog(Context context, String title, String msg) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(context.getString(R.string.ok))
          .negativeText(context.getString(R.string.cancel));
    } else {
      builder.content(msg)
          .positiveText(context.getString(R.string.ok))
          .negativeText(context.getString(R.string.cancel));
    }
    builder.show();
  }


  public static void showBasicDialogWithCallbacks(Context context, String title, String msg, MaterialDialog.SingleButtonCallback singleButtonCallback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(context.getString(R.string.ok))
          .negativeText(context.getString(R.string.cancel))
          .onAny(singleButtonCallback);
    } else {
      builder.content(msg)
          .positiveText(context.getString(R.string.ok))
          .negativeText(context.getString(R.string.cancel))
          .onAny(singleButtonCallback);
    }
    builder.show();
  }

  public static void showBasicDialogFullWithCallbacks(Context context, String title, String msg,
      String positiveText, String negativeText,
      MaterialDialog.SingleButtonCallback singleButtonCallback) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .onAny(singleButtonCallback);
    } else {
      builder.content(msg)
          .positiveText(positiveText)
          .negativeText(negativeText)
          .onAny(singleButtonCallback);
    }
    builder.show();
  }

  public static MaterialDialog getProgressDialog(Context context, String title, String msg, boolean cancelable) {
    MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
    if (!TextUtils.isEmpty(title)) {
      builder.title(title)
          .content(msg)
          .progress(true, 0)
          .cancelable(cancelable)
          .progressIndeterminateStyle(false);
    } else {
      builder.content(msg)
          .progress(true, 0)
          .cancelable(cancelable)
          .progressIndeterminateStyle(false);
    }
    return builder.build();
  }

    /*------------------------------------------------------------------------------------------*/

  public static void showInformationDialog(Context context, String title, String msg) {
    android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(
        context);
    // set title
    alertDialogBuilder.setTitle(title);
    // set dialog message
    alertDialogBuilder
        .setMessage(msg)
        .setCancelable(false)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
          }
        });
    // create alert dialog
    android.app.AlertDialog alertDialog = alertDialogBuilder.create();
    // show it
    alertDialog.show();
  }

  public static void showInformationDialog(Context context, String title, String msg, DialogInterface.OnClickListener confirmListener) {
    android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(
        context);
    // set title
    alertDialogBuilder.setTitle(title);
    // set dialog message
    alertDialogBuilder
        .setMessage(msg)
        .setCancelable(false)
        .setPositiveButton("OK", confirmListener);
    // create alert dialog
    android.app.AlertDialog alertDialog = alertDialogBuilder.create();
    // show it
    alertDialog.show();
  }

  public static void showSingleChoiceDialog(Context context, MaterialDialog.ListCallbackSingleChoice callbackSingleChoice,
      int index,boolean isCancelable ,CharSequence title, CharSequence... items) {
    MaterialDialog alertDialog = new MaterialDialog.Builder(context)
        .title(title)
        .items(items)
        .cancelable(isCancelable)
        .itemsCallbackSingleChoice(index, callbackSingleChoice).build();
    alertDialog.show();
  }
}
