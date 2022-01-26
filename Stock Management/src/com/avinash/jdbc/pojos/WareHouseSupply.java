package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.jdbc.utlities.DateUtils;

public class WareHouseSupply {
	
	protected int whsId;
	protected int pId;
	protected int storeId;
	protected int quantity;
	protected java.util.Date dos;
	protected int userId;
	public WareHouseSupply() {
		
	}
	public WareHouseSupply(int whsId, int pId, int storeId, int quantity, Date dos, int userId) {
	
		this.whsId = whsId;
		this.pId = pId;
		this.storeId = storeId;
		this.quantity = quantity;
		this.dos = dos;
		this.userId = userId;
	}
	public int getWhsId() {
		return whsId;
	}
	public void setWhsId(int whsId) {
		this.whsId = whsId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "WareHouseSupply [whsId=" + whsId + ", pId=" + pId + ", storeId=" + storeId + ", quantity=" + quantity
				+ ", dos=" + dos + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dos == null) ? 0 : dos.hashCode());
		result = prime * result + pId;
		result = prime * result + quantity;
		result = prime * result + storeId;
		result = prime * result + userId;
		result = prime * result + whsId;
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
		WareHouseSupply other = (WareHouseSupply) obj;
		if (dos == null) {
			if (other.dos != null)
				return false;
		} else if (!dos.equals(other.dos))
			return false;
		if (pId != other.pId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (storeId != other.storeId)
			return false;
		if (userId != other.userId)
			return false;
		if (whsId != other.whsId)
			return false;
		return true;
	}
	
	public void acceptData() {
		
		
		
	}
	
	

}
