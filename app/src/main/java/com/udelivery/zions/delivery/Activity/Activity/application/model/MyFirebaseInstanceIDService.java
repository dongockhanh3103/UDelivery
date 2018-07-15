package com.udelivery.zions.delivery.Activity.Activity.application.model;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.RetrofitService;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.ShipperService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ngoc Khanh on 7/14/2018.
 */

public class MyFirebaseInstanceIDService extends com.google.firebase.iid.FirebaseInstanceIdService  {

  private static String TAG = "Registration";

  @Override
  public void onTokenRefresh() {
    // Get updated InstanceID token.
    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    Log.d(TAG, "Refreshed token: " + refreshedToken);

    // TODO: Implement this method to send any registration to your app's servers.
    sendRegistrationToServer(refreshedToken);
    System.out.println("Registration.onTokenRefresh TOKEN: " + refreshedToken );
  }

  private void sendRegistrationToServer(String refreshedToken) {
    SharedPreferences userDetails = getSharedPreferences("customer", MODE_PRIVATE);
    String username = userDetails.getString("username", "");
   ShipperService shipperService= RetrofitService.getInstance().getRetrofitUGaoServer().create(ShipperService.class);


    shipperService.saveToken(username, refreshedToken).enqueue(new Callback<User>() {
      @Override
      public void onResponse(Call<User> call, Response<User> response) {
        if(response.isSuccessful()) {
          User user = (User) response.body();
          if(user.getStatus() == 1) // Thanh cong
          {
            Log.d("FCM_TOKEN","Thanh cong");
          }else{
            Log.d("FCM_TOKEN","That bai");
          }

        } else {
          int statusCode  = response.code();
          // handle request errors depending on status code
        }
      }

      @Override
      public void onFailure(Call<User> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }





}