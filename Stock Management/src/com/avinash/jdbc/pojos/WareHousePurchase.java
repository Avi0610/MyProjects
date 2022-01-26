package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.jdbc.utlities.DateUtils;

public class WareHousePurchase {
	
	protected int wareHousePurId;
	protected java.util.Date dop;
	protected int userId;
	public WareHousePurchase() {
		
	}
	public WareHousePurchase(int wareHousePurId, Date dop, int userId) {
		super();
		this.wareHousePurId = wareHousePurId;
		this.dop = dop;
		this.userId = userId;
	}
	public int getWareHousePurId() {
		return wareHousePurId;
	}
	public void setWareHousePurId(int wareHousePurId) {
		this.wareHousePurId = wareHousePurId;
	}
	public java.util.Date getDop() {
		return dop;
	}
	public void setDop(java.util.Date dop) {
		this.dop = dop;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "WareHousePurchase [wareHousePurId=" + wareHousePurId + ", dop=" + dop + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dop == null) ? 0 : dop.hashCode());
		result = prime * result + userId;
		result = prime * result + wareHousePurId;
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
		WareHousePurchase other = (WareHousePurchase) obj;
		if (dop == null) {
			if (other.dop != null)
				return false;
		} else if (!dop.equals(other.dop))
			return false;
		if (userId != other.userId)
			return false;
		if (wareHousePurId != other.wareHousePurId)
			return false;
		return true;
	}
	
	public void acceptData() {
		
		
	}
	
	
	

}
