package com.udelivery.zions.delivery.Activity.Activity.mvp.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class OrdersList  implements Serializable,Parcelable{
  @SerializedName("SumCost")
  @Expose
  public Integer sumCost;
  @SerializedName("Discount")
  @Expose
  public Integer discount;
  @SerializedName("TotalCost")
  @Expose
  public Integer totalCost;
  @SerializedName("CurrentOrderStatus")
  @Expose
  public Integer currentOrderStatus;
  @SerializedName("DetailCustomer")
  @Expose
  public List<DetailCustomer> detailCustomer = null;
  @SerializedName("DetailStore")
  @Expose
  public List<DetailStore> detailStore = null;
  @SerializedName("DetailShipper")
  @Expose
  public List<DetailShipper> detailShipper = null;
  @SerializedName("OrderDetail")
  @Expose
  public List<OrderDetail> orderDetail = null;
  @SerializedName("OrderStatus")
  @Expose
  public List<Orderstatus> orderStatus = null;
  @SerializedName("_id")
  @Expose
  public String id;
  @SerializedName("IDCustomer")
  @Expose
  public String iDCustomer;
  @SerializedName("IDStore")
  @Expose
  public String iDStore;
  @SerializedName("IDShipper")
  @Expose
  public String iDShipper;
  @SerializedName("PurchaseDate")
  @Expose
  public Long purchaseDate;
  @SerializedName("__v")
  @Expose
  public Integer v;

  protected OrdersList(Parcel in) {
    if (in.readByte() == 0) {
      sumCost = null;
    } else {
      sumCost = in.readInt();
    }
    if (in.readByte() == 0) {
      discount = null;
    } else {
      discount = in.readInt();
    }
    if (in.readByte() == 0) {
      totalCost = null;
    } else {
      totalCost = in.readInt();
    }
    if (in.readByte() == 0) {
      currentOrderStatus = null;
    } else {
      currentOrderStatus = in.readInt();
    }
    id = in.readString();
    iDCustomer = in.readString();
    iDStore = in.readString();
    iDShipper = in.readString();
    if (in.readByte() == 0) {
      purchaseDate = null;
    } else {
      purchaseDate = in.readLong();
    }
    if (in.readByte() == 0) {
      v = null;
    } else {
      v = in.readInt();
    }
  }

  public static final Creator<OrdersList> CREATOR = new Creator<OrdersList>() {
    @Override
    public OrdersList createFromParcel(Parcel in) {
      return new OrdersList(in);
    }

    @Override
    public OrdersList[] newArray(int size) {
      return new OrdersList[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    if (sumCost == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeInt(sumCost);
    }
    if (discount == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeInt(discount);
    }
    if (totalCost == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeInt(totalCost);
    }
    if (currentOrderStatus == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeInt(currentOrderStatus);
    }
    dest.writeString(id);
    dest.writeString(iDCustomer);
    dest.writeString(iDStore);
    dest.writeString(iDShipper);
    if (purchaseDate == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeLong(purchaseDate);
    }
    if (v == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeInt(v);
    }
  }
}
