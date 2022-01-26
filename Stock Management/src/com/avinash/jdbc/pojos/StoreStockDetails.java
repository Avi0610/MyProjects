package com.avinash.jdbc.pojos;

import java.util.Scanner;

public class StoreStockDetails {
	
	protected int storeStockDetailsId;
	protected int storeId;
	protected int pId;
	protected int quantity;
	
	public StoreStockDetails() {
		
	}

	public StoreStockDetails(int storeStockDetailsId, int storeId, int pId, int quantity) {
		super();
		this.storeStockDetailsId = storeStockDetailsId;
		this.storeId = storeId;
		this.pId = pId;
		this.quantity = quantity;
	}



	public int getStoreStockDetailsId() {
		return storeStockDetailsId;
	}

	public void setStoreStockDetailsId(int storeStockDetailsId) {
		this.storeStockDetailsId = storeStockDetailsId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	

	@Override
	public String toString() {
		return "StoreStockDetails [storeStockDetailsId=" + storeStockDetailsId + ", storeId=" + storeId + ", pId=" + pId
				+ ", quantity=" + quantity + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pId;
		result = prime * result + quantity;
		result = prime * result + storeId;
		result = prime * result + storeStockDetailsId;
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
		StoreStockDetails other = (StoreStockDetails) obj;
		if (pId != other.pId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeStockDetailsId != other.storeStockDetailsId)
			return false;
		return true;
	}

	public void acceptData() {
		
		
	}
	
}
