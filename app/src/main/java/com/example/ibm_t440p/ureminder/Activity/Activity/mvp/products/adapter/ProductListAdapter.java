package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.products.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model.OrderDetail;
import com.example.ibm_t440p.ureminder.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ngoc Khanh on 7/1/2018.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.DataViewHolder> {
  List<OrderDetail> orderItems = new ArrayList<>();
  Context context;

  public ProductListAdapter(Context mContext, List<OrderDetail> orderItems){
    this.context = mContext;
    this.orderItems = orderItems;
  }
  @NonNull
  @Override
  public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView;
    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
    ProductListAdapter.DataViewHolder dataViewHolder = new ProductListAdapter.DataViewHolder(itemView);
    return dataViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
    holder.tvProductName.setText("Tên mặt hàng: "+orderItems.get(position).prodName);
    holder.tvProductQuantity.setText("Số lượng: "+orderItems.get(position).quantiny);
    holder.tvProductPrice.setText("Thành tiền: "+orderItems.get(position).cost+"đ");
  }

  @Override
  public int getItemCount() {
    if(orderItems==null){
      return 0;
    }
    return orderItems.size();
  }

  public static class DataViewHolder extends RecyclerView.ViewHolder {

    public TextView tvProductName;
    public TextView tvProductQuantity;
    public TextView tvProductPrice;

    public DataViewHolder(View itemView) {
      super(itemView);
      tvProductName = itemView.findViewById(R.id.tvOrderName);
      tvProductQuantity = itemView.findViewById(R.id.tvQuantity);
      tvProductPrice = itemView.findViewById(R.id.tvPayment);
    }
  }

}
