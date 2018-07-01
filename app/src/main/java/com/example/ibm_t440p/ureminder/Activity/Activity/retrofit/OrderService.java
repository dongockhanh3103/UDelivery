package com.example.ibm_t440p.ureminder.Activity.Activity.retrofit;

import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseResponse;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.CustomerOrdersResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ngoc Khanh on 6/4/2018.
 */

public interface OrderService {
  @GET("/api/orders")
  Call<CustomerOrdersResponse> getAllOrderForShipper();

  @FormUrlEncoded
  @POST("/api/orders/status")
  Call<BaseResponse> changeOrderStatus(@Field("IDOrder") String idOrder,
                                        @Field("StatusCode") int statusCode,
                                        @Field("Note") String note);

}
