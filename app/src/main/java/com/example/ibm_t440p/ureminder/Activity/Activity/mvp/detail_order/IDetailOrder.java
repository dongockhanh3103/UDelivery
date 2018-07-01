package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.detail_order;

import com.example.ibm_t440p.ureminder.Activity.Activity.base.BasePresenter;
import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseView;

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
