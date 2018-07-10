package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order;

import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.CustomerOrdersResponse;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.retrofit.OrderService;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ngoc Khanh on 6/20/2018.
 */

public class OrderListPresenter implements IOrderList.Presenter {
  final IOrderList.View mView;

  public OrderListPresenter(IOrderList.View mView) {
    this.mView = mView;
  }


  @Override
  public void getAllOrdersByShipper() {
    mView.onShowLoadingProgress(true);
    final OrderService mOrderService = RetrofitService.getInstance().getRetrofitUGaoServer()
        .create(OrderService.class);
    Call<CustomerOrdersResponse> orderResponse = mOrderService.getAllOrderForShipper();
    orderResponse.enqueue(new Callback<CustomerOrdersResponse>() {
      @Override
      public void onResponse(Call<CustomerOrdersResponse> call,
          Response<CustomerOrdersResponse> response) {
        if(response.isSuccessful()){
          if(response.body().status==1){

            mView.onShowLoadingProgress(false);
            mView.onGetOrdersSuccess(response.body().ordersList);
          }
          else {
            mView.onShowLoadingProgress(false);
            mView.onGetOrderFailure(response.body().msg);
          }
        }

      }

      @Override
      public void onFailure(Call<CustomerOrdersResponse> call, Throwable t) {
        mView.onShowLoadingProgress(false);
        mView.onGetOrderFailure("The errors are not defined"+ t);
      }
    });

  }
}
