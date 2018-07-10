package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order;

import com.udelivery.ibm_t440p.ureminder.Activity.Activity.base.BasePresenter;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.base.BaseView;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrdersList;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/20/2018.
 */

public interface IOrderList{
  interface View extends BaseView<Presenter>{
    void onShowLoadingProgress(boolean isShow);
    void onGetOrdersSuccess(List<OrdersList> orderItems);
    void onGetOrderFailure(String msg);

  }

  interface Presenter extends BasePresenter{
    void getAllOrdersByShipper();

  }
}
