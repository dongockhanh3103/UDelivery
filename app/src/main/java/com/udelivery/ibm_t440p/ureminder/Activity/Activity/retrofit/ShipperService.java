package com.udelivery.ibm_t440p.ureminder.Activity.Activity.retrofit;


import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.home.model.ShipperResponse;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.login.model.LoginResponse;
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
  @POST("api/shippers/login")
  Call<LoginResponse> authenticationUser(@Field("Username") String username, @Field("Password") String password);

  @GET("/api/shippers/my")
  Call<ShipperResponse> getShipperInfo();
}
