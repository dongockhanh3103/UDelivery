package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ibm_t440p.ureminder.Activity.Activity.config.Constants;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.DetailCustomer;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrderDetail;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.products.adapter.ProductListAdapter;
import com.example.ibm_t440p.ureminder.R;
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
