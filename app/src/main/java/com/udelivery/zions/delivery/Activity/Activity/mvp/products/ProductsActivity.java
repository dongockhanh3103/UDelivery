package com.udelivery.zions.delivery.Activity.Activity.mvp.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.udelivery.zions.delivery.Activity.Activity.config.Constants;
import com.udelivery.zions.delivery.Activity.Activity.mvp.order.model.OrderDetail;
import com.udelivery.zions.delivery.Activity.Activity.mvp.products.adapter.ProductListAdapter;
import com.udelivery.zions.delivery.R;
import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

  RecyclerView rcDetailOrderList;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_products);
    rcDetailOrderList = findViewById(R.id.rcDetailOrderList);
    LinearLayoutManager orderListLayout=  new LinearLayoutManager(this);
    orderListLayout.setOrientation(LinearLayoutManager.VERTICAL);
    rcDetailOrderList.setLayoutManager(orderListLayout);
    ArrayList<OrderDetail> orderItems = (ArrayList<OrderDetail>) getIntent()
        .getSerializableExtra(Constants.ORDER_DETAIL_KEY);

    ProductListAdapter productListAdapter=new ProductListAdapter(getApplicationContext(),orderItems);

    rcDetailOrderList.setAdapter(productListAdapter);
  }
}
