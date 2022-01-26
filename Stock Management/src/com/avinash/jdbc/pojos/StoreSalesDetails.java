package com.avinash.jdbc.pojos;

import java.util.Scanner;

public class StoreSalesDetails {
	
	protected int storeSalesDetailsId;
	protected int storeSalesId;
	protected int pId;
	protected int quantity;
	protected double cost;
	protected double payableAmount;
	public StoreSalesDetails() {
		
	}
	public StoreSalesDetails(int storeSalesDetailsId, int storeSalesId, int pId, int quantity, double cost,
			double payableAmount) {
		super();
		this.storeSalesDetailsId = storeSalesDetailsId;
		this.storeSalesId = storeSalesId;
		this.pId = pId;
		this.quantity = quantity;
		this.cost = cost;
		this.payableAmount = payableAmount;
	}
	public int getStoreSalesDetailsId() {
		return storeSalesDetailsId;
	}
	public void setStoreSalesDetailsId(int storeSalesDetailsId) {
		this.storeSalesDetailsId = storeSalesDetailsId;
	}
	public int getStoreSalesId() {
		return storeSalesId;
	}
	public void setStoreSalesId(int storeSalesId) {
		this.storeSalesId = storeSalesId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	@Override
	public String toString() {
		return "StoreSalesDetails [storeSalesDetailsId=" + storeSalesDetailsId + ", storeSalesId=" + storeSalesId
				+ ", pId=" + pId + ", quantity=" + quantity + ", cost=" + cost + ", payableAmount=" + payableAmount
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pId;
		temp = Double.doubleToLongBits(payableAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + storeSalesDetailsId;
		result = prime * result + storeSalesId;
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
		StoreSalesDetails other = (StoreSalesDetails) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (pId != other.pId)
			return false;
		if (Double.doubleToLongBits(payableAmount) != Double.doubleToLongBits(other.payableAmount))
			return false;
		if (quantity != other.quantity)
			return false;
		if (storeSalesDetailsId != other.storeSalesDetailsId)
			return false;
		if (storeSalesId != other.storeSalesId)
			return false;
		return true;
	}
	
	public void acceptData() {
		
		
	}
	
	
	
	

}
