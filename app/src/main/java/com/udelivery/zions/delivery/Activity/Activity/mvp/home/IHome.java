package com.udelivery.zions.delivery.Activity.Activity.mvp.home;

import com.udelivery.zions.delivery.Activity.Activity.base.BasePresenter;
import com.udelivery.zions.delivery.Activity.Activity.base.BaseView;
import com.udelivery.zions.delivery.Activity.Activity.mvp.home.model.ShipperInfo;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public interface IHome {

  interface View extends BaseView<Presenter>{
    void onShowLoadingProgress(boolean isShow);
    void onGetShipperInfoSuccess(ShipperInfo shipper);
    void onGetShipperInfoFailure(String msg);

  }
  interface Presenter extends BasePresenter{
    void getShipperInfo();

  }

}
