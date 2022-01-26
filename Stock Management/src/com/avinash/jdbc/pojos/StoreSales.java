package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.jdbc.utlities.DateUtils;

public class StoreSales {
	
	protected int storeSalesId;
	protected int custId;
	protected java.util.Date dos;
	protected int userId;
	protected double amount;
	protected double discount;
	protected double totalPayable;
	protected int storeId;
	
	public StoreSales() {
		
			}
	
	public StoreSales(int storeSalesId, int custId, Date dos, int userId, double amount, double discount,
			double totalPayable, int storeId) {
		super();
		this.storeSalesId = storeSalesId;
		this.custId = custId;
		this.dos = dos;
		this.userId = userId;
		this.amount = amount;
		this.discount = discount;
		this.totalPayable = totalPayable;
		this.storeId = storeId;
	}


	
	
	
	public int getStoreSalesId() {
		return storeSalesId;
	}




	public void setStoreSalesId(int storeSalesId) {
		this.storeSalesId = storeSalesId;
	}




	public int getCustId() {
		return custId;
	}




	public void setCustId(int custId) {
		this.custId = custId;
	}




	public java.util.Date getDos() {
		return dos;
	}




	public void setDos(java.util.Date dos) {
		this.dos = dos;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public double getTotalPayable() {
		return totalPayable;
	}




	public void setTotalPayable(double totalPayable) {
		this.totalPayable = totalPayable;
	}




	public int getStoreId() {
		return storeId;
	}




	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	
	@Override
	public String toString() {
		return "StoreSales [storeSalesId=" + storeSalesId + ", custId=" + custId + ", dos=" + dos + ", userId=" + userId
				+ ", amount=" + amount + ", discount=" + discount + ", totalPayable=" + totalPayable + ", storeId="
				+ storeId + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + custId;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dos == null) ? 0 : dos.hashCode());
		result = prime * result + storeId;
		result = prime * result + storeSalesId;
		temp = Double.doubleToLongBits(totalPayable);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreSales other = (StoreSales) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (custId != other.custId)
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (dos == null) {
			if (other.dos != null)
				return false;
		} else if (!dos.equals(other.dos))
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeSalesId != other.storeSalesId)
			return false;
		if (Double.doubleToLongBits(totalPayable) != Double.doubleToLongBits(other.totalPayable))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public  void acceptData() {
		
	
	
		
		}

	

}
