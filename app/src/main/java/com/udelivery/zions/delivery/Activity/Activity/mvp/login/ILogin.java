package com.udelivery.zions.delivery.Activity.Activity.mvp.login;

import com.udelivery.zions.delivery.Activity.Activity.base.BasePresenter;
import com.udelivery.zions.delivery.Activity.Activity.base.BaseView;


/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public interface ILogin {
  interface View extends BaseView<Presenter> {
    void onShowLoadingProgress(boolean isShow);
    void onLoginFail(String msg);
    void onLoginSuccess(String token);

  }

  interface Presenter extends BasePresenter {

    void authenticationUser(String username, String password);

  }

}
