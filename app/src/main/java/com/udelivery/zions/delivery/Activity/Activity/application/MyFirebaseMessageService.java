package com.udelivery.zions.delivery.Activity.Activity.application;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.udelivery.zions.delivery.Activity.Activity.application.model.NotificationData;
import com.udelivery.zions.delivery.Activity.Activity.mvp.order.OrderListActivity;
import com.udelivery.zions.delivery.R;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Ngoc Khanh on 7/14/2018.
 */

public class MyFirebaseMessageService extends FirebaseMessagingService {
  int NOTIFICATION_ID = 234;
  @Override
  public void onMessageReceived(RemoteMessage message) {
    super.onMessageReceived(message);
    String image = message.getNotification().getIcon();
    String title = message.getNotification().getTitle();
    String text = message.getNotification().getBody();
    String sound=  message.getNotification().getSound();
    int id = 0;
    Object obj = message.getData().get("id");
    if (obj != null) {
      id = Integer.valueOf(obj.toString());
    }
    this.sendNotification(new NotificationData(image, id, title, text, sound));

  }

  private void sendNotification(NotificationData notificationData) {

    Intent intent = new Intent(this, OrderListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    intent.putExtra(NotificationData.TEXT, notificationData.getTextMessage());

    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
        PendingIntent.FLAG_ONE_SHOT);


    NotificationManager notificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    String CHANNEL_ID = "my_channel_01";
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

      CharSequence name = "my_channel";
      String Description = "This is my channel";
      int importance = NotificationManager.IMPORTANCE_HIGH;
      NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
      mChannel.setDescription(Description);
      mChannel.enableLights(true);
      mChannel.setLightColor(Color.RED);
      mChannel.enableVibration(true);
      mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
      mChannel.setShowBadge(false);
      notificationManager.createNotificationChannel(mChannel);
    }
    NotificationCompat.Builder notificationBuilder = null;
    try {

      notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
          .setSmallIcon(R.drawable.ic_delivery_truck)
          .setLargeIcon(
              BitmapFactory.decodeResource(getResources(), R.drawable.delivery_truck_large))
          .setContentTitle(URLDecoder.decode("Thông báo", "UTF-8"))
          .setContentText(URLDecoder.decode(notificationData.getTextMessage(), "UTF-8"))
          .setAutoCancel(true)
          .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
          .setContentIntent(pendingIntent);


    } catch (UnsupportedEncodingException e) {
      Log.e("AAAAAAAAAAAA", "sendNotification: ", e);
      e.printStackTrace();
    }

    if (notificationBuilder != null) {

      notificationManager.notify(notificationData.getId(), notificationBuilder.build());
    } else {
      Log.d("Yes", "Não foi possível criar objeto notificationBuilder");
    }
  }
}
