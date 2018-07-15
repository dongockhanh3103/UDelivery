package com.udelivery.zions.delivery.Activity.Activity.retrofit;


import com.udelivery.zions.delivery.Activity.Activity.application.model.User;
import com.udelivery.zions.delivery.Activity.Activity.mvp.home.model.ShipperResponse;
import com.udelivery.zions.delivery.Activity.Activity.mvp.login.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public interface ShipperService {

  @FormUrlEncoded
  @POST("msg")
  Call<User> saveToken(@Field("Username") String Username, @Field("RegTokens") String RegTokens);

  @FormUrlEncoded
  @POST("api/shippers/login")
  Call<LoginResponse> authenticationUser(@Field("Username") String username, @Field("Password") String password);

  @GET("/api/shippers/my")
  Call<ShipperResponse> getShipperInfo();
}
