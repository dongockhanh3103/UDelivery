package com.example.ibm_t440p.ureminder.Activity.Activity.retrofit;

import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.CustomerOrder;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ngoc Khanh on 6/4/2018.
 */

public interface OrderService {
  @GET("/api/orders")
  Call<CustomerOrder>  getAllCustomersOrder();

}
