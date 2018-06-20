package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home;

import com.example.ibm_t440p.ureminder.Activity.Activity.base.BasePresenter;
import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseView;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.model.ShipperInfo;

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
