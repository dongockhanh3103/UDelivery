package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.example.ibm_t440p.ureminder.Activity.Activity.base.BaseActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.IOrderList.Presenter;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.adapter.OrderAdapter;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrdersList;
import com.example.ibm_t440p.ureminder.Activity.Activity.utils.DialogNotif;
import com.example.ibm_t440p.ureminder.R;
import java.util.List;


public class OrderListActivity extends BaseActivity implements IOrderList.View{
  OrderListPresenter mPresenter;
  RecyclerView rcvOrderList;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_list);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    rcvOrderList = findViewById(R.id.rcvOrderList);
    LinearLayoutManager orderListLayout=  new LinearLayoutManager(this);
    orderListLayout.setOrientation(LinearLayoutManager.VERTICAL);
    rcvOrderList.setLayoutManager(orderListLayout);
    getPresenter().getAllOrdersByShipper();
  }

  @Override
  public void setPresenter(Presenter presenter) {
    mPresenter= (OrderListPresenter) presenter;

  }

  @Override
  public void onShowLoadingProgress(boolean isShow) {
    onShowProgressBar(isShow);
  }

  @Override
  public void onGetOrdersSuccess(List<OrdersList> orderItems) {
    OrderAdapter orderAdapter=new OrderAdapter(getApplicationContext(),orderItems);
    rcvOrderList.setAdapter(orderAdapter);

  }

  private IOrderList.Presenter getPresenter() {
    if (mPresenter == null) {
      mPresenter = new OrderListPresenter(this);
    }
    return mPresenter;
  }

  @Override
  public void onGetOrderFailure(String msg) {
    DialogNotif dialogNotif=new DialogNotif(OrderListActivity.this);
    dialogNotif.showBasicDismissDialog("Errors",msg);

  }
}