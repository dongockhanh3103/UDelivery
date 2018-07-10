package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.detail_order;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.base.BaseActivity;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.config.Constants;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.detail_order.IDetailOrder.Presenter;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.DetailCustomer;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrderDetail;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrdersList;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.products.ProductsActivity;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils.DialogNotif;
import com.udelivery.ibm_t440p.ureminder.Activity.Activity.utils.DialogVerifyChangeStatusCode;
import com.udelivery.ibm_t440p.ureminder.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DetailOrderActivity extends BaseActivity implements IDetailOrder.View {

  TextView tvOrderName;
  TextView tvCustomerAddress;
  TextView tvCustomerPhone;
  TextView tvOrderId;
  TextView tvPayment;
  TextView tvOrderTime;
  TextView tvOrderStatus;
  TextView tvCustomerName;
  TextView btnDeliveredStatus;
  TextView btnDelayedStatus;
  TextView btnCancelStatus;
  TextView btnMoreDetail;
  static OrdersList ordersListBundle;
  IDetailOrder.Presenter mPresenter;
  DialogVerifyChangeStatusCode dialog;

  public static void open(Context context, OrdersList ordersList) {
    Intent intent = new Intent(context, DetailOrderActivity.class);
    intent.putExtra(Constants.BUNDLE_KEY, (Parcelable) ordersList);
    intent.putExtra(Constants.CUSTOMER_DETAIL_KEY, (Serializable) ordersList.detailCustomer);
    intent.putExtra(Constants.ORDER_STATUS_KEY, (Serializable) ordersList.orderStatus);
    intent.putExtra(Constants.ORDER_DETAIL_KEY, (Serializable) ordersList.orderDetail);
    intent.putExtra(Constants.SHIPPER_DETAIL_KEY, (Serializable) ordersList.detailShipper);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_order);
    init();
    mappingData();
    dialog = new DialogVerifyChangeStatusCode(DetailOrderActivity.this);
    btnDeliveredStatus.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        changeOrderStatusCode(dialog, ordersListBundle.id, 2);
      }
    });

    btnDelayedStatus.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        changeOrderStatusCode(dialog, ordersListBundle.id, 3);
      }
    });

    btnCancelStatus.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        changeOrderStatusCode(dialog, ordersListBundle.id, -1);
      }
    });

    btnMoreDetail.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(DetailOrderActivity.this
            , ProductsActivity.class);
        ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>) getIntent()
            .getSerializableExtra(Constants.ORDER_DETAIL_KEY);
        intent.putExtra(Constants.ORDER_DETAIL_KEY, (Serializable) orderDetails);
        startActivity(intent);
      }
    });


  }

  private String getDate(long timeStamp) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATETIME_PATTERN);
      Date netDate = (new Date(timeStamp));
      return sdf.format(netDate);
    } catch (Exception ex) {
      return "xx";
    }
  }

  void changeOrderStatusCode(final DialogVerifyChangeStatusCode dialog, final String orderId,
      final int statusCode) {
    dialog.setSendMentorCodeButton(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getPresenter().changeOrderStatus(orderId, statusCode, dialog.getNote());
      }
    }).setCancel(new OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.dismiss();
      }
    }).show();


  }

  void init() {
    tvOrderName = findViewById(R.id.tvOrderName);
    tvCustomerAddress = findViewById(R.id.tvAddress);
    tvCustomerPhone = findViewById(R.id.tvCustomerPhone);
    tvOrderId = findViewById(R.id.tvOrderId);
    tvPayment = findViewById(R.id.tvPayment);
    tvOrderTime = findViewById(R.id.tvOrderTime);
    tvCustomerName = findViewById(R.id.tvCustomerName);
    tvOrderStatus = findViewById(R.id.tvOrderStatus);

    btnCancelStatus = findViewById(R.id.btnCancelStatus);
    btnDelayedStatus = findViewById(R.id.btnDelayedStatus);
    btnDeliveredStatus = findViewById(R.id.btnDeliveredStatus);
    btnMoreDetail = findViewById(R.id.btnMoreDetail);
    ordersListBundle = getIntent().getParcelableExtra(Constants.BUNDLE_KEY);
  }

  void mappingData() {
    ArrayList<DetailCustomer> detailCustomers = (ArrayList<DetailCustomer>) getIntent()
        .getSerializableExtra(Constants.CUSTOMER_DETAIL_KEY);
    tvCustomerName.setText("KH: " + detailCustomers.get(0).fullnameCustomer);
    tvCustomerAddress.setText("Địa chỉ: " + detailCustomers.get(0).addressCustomer);
    tvCustomerPhone.setText("Địa chỉ: " + detailCustomers.get(0).phoneCustomer);
    tvOrderId.setText("Mã Đơn Hàng: " + ordersListBundle.id);
    tvPayment.setText("Số tiền thanh toán: " + ordersListBundle.sumCost + "đ");
    tvOrderStatus
        .setText("Trạng thái: " + Constants.getOrderStatus(ordersListBundle.currentOrderStatus));
    tvOrderTime.setText("Thời gian đặt hàng: " + getDate(ordersListBundle.purchaseDate));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    mPresenter = presenter;

  }

  @Override
  public void onShowLoadingProgress(boolean isShow) {
    onShowProgressBar(isShow);
  }

  @Override
  public void changeOrderStatusSuccess(int statusCodeChange) {
    dialog.dismiss();
    tvOrderStatus.setText("Trạng thái:" + Constants.getOrderStatus(statusCodeChange));
  }

  @Override
  public void changeOrderStatusFailure(String msg) {
    DialogNotif dialogNotif = new DialogNotif(DetailOrderActivity.this);
    dialogNotif.showBasicDismissDialog("Không thể chuyển trạng thái", msg);
  }

  private IDetailOrder.Presenter getPresenter() {
    if (mPresenter == null) {
      mPresenter = new DetailOrderPresenter(this);
    }
    return mPresenter;
  }
}
