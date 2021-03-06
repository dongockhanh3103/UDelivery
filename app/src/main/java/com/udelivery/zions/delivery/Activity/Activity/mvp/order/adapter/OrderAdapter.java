package com.udelivery.zions.delivery.Activity.Activity.mvp.order.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.udelivery.zions.delivery.Activity.Activity.config.Constants;
import com.udelivery.zions.delivery.Activity.Activity.mvp.detail_order.DetailOrderActivity;
import com.udelivery.zions.delivery.Activity.Activity.mvp.order.model.OrdersList;
import com.udelivery.zions.delivery.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.DataViewHolder>{
  List<OrdersList> orderItems =new ArrayList<>();
  Context context;
  public OrderAdapter(Context context, List<OrdersList> orderItems){
    this.orderItems = orderItems;
    this.context = context;
  }


  @NonNull
  @Override
  public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView;
    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row, parent, false);
    OrderAdapter.DataViewHolder dataViewHolder = new OrderAdapter.DataViewHolder(itemView);
    return dataViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
    holder.tvCustomerName.setText("KH: "+this.orderItems.get(position).detailCustomer.get(0).fullnameCustomer);
    holder.tvOrderStatus.setText("Trạng thái: "+ Constants.getOrderStatus(this.orderItems.get(position).currentOrderStatus));
    holder.tvCustomerAddress.setText("Địa chỉ: "+ this.orderItems.get(position).detailCustomer.get(0).addressCustomer);
    holder.tvCustomerPhone.setText("SĐT: "+ this.orderItems.get(position).detailCustomer.get(0).phoneCustomer);

    holder.btnOrderDetail.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        DetailOrderActivity.open(context,orderItems.get(position));
      }
    });
  }

  @Override
  public int getItemCount() {
    if(orderItems==null){
      return 0;
    }
    return orderItems.size();
  }

  public static class DataViewHolder extends RecyclerView.ViewHolder{
    public TextView tvCustomerName;
    public TextView tvOrderStatus;
    public TextView tvCustomerAddress;
    public TextView tvCustomerPhone;
    public TextView btnOrderDetail;
    public DataViewHolder(View itemView) {

      super(itemView);
      tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
      tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
      tvCustomerAddress = itemView.findViewById(R.id.tvCustomerAddress);
      tvCustomerPhone = itemView.findViewById(R.id.tvCustomerPhone);
      btnOrderDetail = itemView.findViewById(R.id.btnOrderDetail);
    }
  }




}
