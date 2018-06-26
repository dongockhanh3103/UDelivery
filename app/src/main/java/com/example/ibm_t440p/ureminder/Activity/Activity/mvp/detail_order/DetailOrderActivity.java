package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.detail_order;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import com.example.ibm_t440p.ureminder.Activity.Activity.config.Constants;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.DetailCustomer;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrdersList;
import com.example.ibm_t440p.ureminder.R;
import java.io.Serializable;
import java.util.ArrayList;

public class DetailOrderActivity extends AppCompatActivity {
  TextView tvOrderName;
  TextView tvCustomerAddress;
  TextView tvCustomerPhone;
  TextView tvOrderId;
  TextView tvOrderQuantity;
  TextView tvPayment;
  TextView tvOrderTime;
  OrdersList ordersListBundle;
  public static void open(Context context, OrdersList ordersList){
    Intent intent = new Intent(context, DetailOrderActivity.class);
    intent.putExtra(Constants.BUNDLE_KEY, (Serializable) ordersList);
    intent.putExtra(Constants.CUSTOMER_DETAIL_KEY, (Serializable) ordersList.detailCustomer);

   /* intent.putParcelableArrayListExtra(Constants.SHIPPER_DETAIL_KEY,
        (ArrayList<? extends Parcelable>) ordersList.detailShipper);

    intent.putParcelableArrayListExtra(Constants.ORDER_DETAIL_KEY,
        (ArrayList<? extends Parcelable>) ordersList.orderDetail);

    intent.putParcelableArrayListExtra(Constants.ORDER_STATUS_KEY,
        (ArrayList<? extends Parcelable>) ordersList.orderStatus);*/

    context.startActivity(intent);
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_order);
    tvOrderName = findViewById(R.id.tvOrderName);
    tvCustomerAddress = findViewById(R.id.tvCustomerAddress);
    tvCustomerPhone = findViewById(R.id.tvCustomerPhone);
    tvOrderId = findViewById(R.id.tvOrderId);
    tvOrderQuantity = findViewById(R.id.tvOrderQuantity);
    tvPayment = findViewById(R.id.tvPayment);
    tvOrderTime = findViewById(R.id.tvOrderTime);
    ordersListBundle = getIntent().getParcelableExtra(Constants.BUNDLE_KEY);
   // tvOrderName.setText(ordersListBundle.);
    ArrayList<DetailCustomer> detailCustomers=(ArrayList<DetailCustomer>)getIntent().getSerializableExtra(Constants.CUSTOMER_DETAIL_KEY);
    tvCustomerAddress.setText("Địa chỉ: "+detailCustomers.get(0).fullnameCustomer);
  //  tvCustomerPhone.setText("SĐT: "+ordersListBundle.detailCustomer.get(0).phoneCustomer);
    //tvOrderId.setText("Mã đơn hàng: "+ ordersListBundle.id);


  }

}
