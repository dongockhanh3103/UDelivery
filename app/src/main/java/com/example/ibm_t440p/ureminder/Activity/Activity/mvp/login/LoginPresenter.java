package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.login;

import android.support.annotation.NonNull;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.login.model.LoginResponse;
import com.example.ibm_t440p.ureminder.Activity.Activity.retrofit.RetrofitService;
import com.example.ibm_t440p.ureminder.Activity.Activity.retrofit.ShipperService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public class LoginPresenter implements ILogin.Presenter {

  private final ILogin.View mLoginView;

  public LoginPresenter(@NonNull ILogin.View mLoginView) {
    this.mLoginView = mLoginView;
  }


  @Override
  public void authenticationUser(String username, String password) {
    final ShipperService mShipperService = RetrofitService.getInstance().getRetrofitUGaoServer()
        .create(ShipperService.class);
    mLoginView.onShowLoadingProgress(true);
    Call<LoginResponse> loginResponse= mShipperService.authenticationUser(username,password);
    loginResponse.enqueue(new Callback<LoginResponse>() {
      @Override
      public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

        if(response.isSuccessful()){

          if(response.body().getStatus()==1){
            mLoginView.onLoginSuccess(response.body().getToken().getToken());
            mLoginView.onShowLoadingProgress(false);
          }
          else {
            mLoginView.onLoginFail(response.body().getMsg());
            mLoginView.onShowLoadingProgress(false);
          }
        }
      }
      @Override
      public void onFailure(Call<LoginResponse> call, Throwable t) {
        mLoginView.onLoginFail("The errors are not defined "+t);
        mLoginView.onShowLoadingProgress(false);
      }
    });
  }
}
