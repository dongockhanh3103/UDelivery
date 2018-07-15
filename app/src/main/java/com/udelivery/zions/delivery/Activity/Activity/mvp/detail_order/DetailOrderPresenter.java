package com.udelivery.zions.delivery.Activity.Activity.mvp.detail_order;

import com.udelivery.zions.delivery.Activity.Activity.base.BaseResponse;
import com.udelivery.zions.delivery.Activity.Activity.mvp.detail_order.IDetailOrder.Presenter;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.OrderService;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ngoc Khanh on 7/1/2018.
 */

public class DetailOrderPresenter implements Presenter {
  private final IDetailOrder.View mView;

  public DetailOrderPresenter(IDetailOrder.View mView) {
    this.mView = mView;
  }

  @Override
  public void changeOrderStatus(String idOrder, final int statusCode, String note) {
    final OrderService mOrderService = RetrofitService.getInstance().getRetrofitUGaoServer()
        .create(OrderService.class);
    mView.onShowLoadingProgress(true);
    Call<BaseResponse> changeOrderStatusRes= mOrderService.changeOrderStatus(idOrder,statusCode,note);
    changeOrderStatusRes.enqueue(new Callback<BaseResponse>() {
      @Override
      public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
        if(response.isSuccessful()){

          if(response.body().getStatus()==1){
            mView.changeOrderStatusSuccess(statusCode);
            mView.onShowLoadingProgress(false);
          }
          else {
            mView.changeOrderStatusFailure(response.body().getMsg());
            mView.onShowLoadingProgress(false);
          }
        }
      }

      @Override
      public void onFailure(Call<BaseResponse> call, Throwable t) {
        mView.changeOrderStatusFailure(t.toString());
        mView.onShowLoadingProgress(false);
      }
    });


  }
}
