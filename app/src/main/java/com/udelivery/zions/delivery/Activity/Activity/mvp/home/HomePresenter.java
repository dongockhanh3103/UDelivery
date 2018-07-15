package com.udelivery.zions.delivery.Activity.Activity.mvp.home;

import android.support.annotation.NonNull;
import com.udelivery.zions.delivery.Activity.Activity.mvp.home.IHome.Presenter;
import com.udelivery.zions.delivery.Activity.Activity.mvp.home.model.ShipperResponse;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.RetrofitService;
import com.udelivery.zions.delivery.Activity.Activity.retrofit.ShipperService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class HomePresenter implements Presenter {
  private final IHome.View mHomeView;

  public HomePresenter(@NonNull IHome.View mHomeView) {
    this.mHomeView = mHomeView;
  }

  @Override
  public void getShipperInfo() {
    mHomeView.onShowLoadingProgress(true);
    final ShipperService mShipperService = RetrofitService.getInstance().getRetrofitUGaoServer()
        .create(ShipperService.class);
    Call<ShipperResponse> shipperResponse = mShipperService.getShipperInfo();
    shipperResponse.enqueue(new Callback<ShipperResponse>() {
      @Override
      public void onResponse(Call<ShipperResponse> call, Response<ShipperResponse> response) {
        if(response.isSuccessful()){
          if(response.body().getStatus()==1){
            mHomeView.onShowLoadingProgress(false);
            mHomeView.onGetShipperInfoSuccess(response.body().getShipperInfo());
          }
          else {
            mHomeView.onShowLoadingProgress(false);
            mHomeView.onGetShipperInfoFailure(response.body().getMsg());
          }
        }

      }

      @Override
      public void onFailure(Call<ShipperResponse> call, Throwable t) {
        mHomeView.onShowLoadingProgress(false);
        mHomeView.onGetShipperInfoFailure("The errors are not define");

      }
    });


  }
}
