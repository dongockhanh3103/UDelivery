package com.udelivery.zions.delivery.Activity.Activity.mvp.detail_order;

import com.udelivery.zions.delivery.Activity.Activity.base.BasePresenter;
import com.udelivery.zions.delivery.Activity.Activity.base.BaseView;

/**
 * Created by Ngoc Khanh on 6/30/2018.
 */

public interface IDetailOrder {
  interface View extends BaseView<Presenter>{
    void onShowLoadingProgress(boolean isShow);
    void changeOrderStatusSuccess(int statusCodeChange);
    void changeOrderStatusFailure(String msg);

  }
  interface Presenter extends BasePresenter{
    void changeOrderStatus(String idOrder, int statusCode,String note);
  }

}
