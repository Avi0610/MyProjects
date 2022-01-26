package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;
import com.avinash.jdbc.utlities.DateUtils;

public class WareHousePurchaseDetails {
	protected int whpdId;
	protected int whpId;
	protected int pId;
	protected int quantityPurchased;
	protected java.util.Date expDate;
	public WareHousePurchaseDetails() {
		
	}
	public WareHousePurchaseDetails(int whpdId, int whpId, int pId, int quantityPurchased, Date expDate) {
		super();
		this.whpdId = whpdId;
		this.whpId = whpId;
		this.pId = pId;
		this.quantityPurchased = quantityPurchased;
		this.expDate = expDate;
	}
	public int getWhpdId() {
		return whpdId;
	}
	public void setWhpdId(int whpdId) {
		this.whpdId = whpdId;
	}
	public int getWhpId() {
		return whpId;
	}
	public void setWhpId(int whpId) {
		this.whpId = whpId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public java.util.Date getExpDate() {
		return expDate;
	}
	public void setExpDate(java.util.Date expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "WareHousePurchaseDetails [whpdId=" + whpdId + ", whpId=" + whpId + ", pId=" + pId
				+ ", quantityPurchased=" + quantityPurchased + ", expDate=" + expDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
		result = prime * result + pId;
		result = prime * result + quantityPurchased;
		result = prime * result + whpId;
		result = prime * result + whpdId;
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
		WareHousePurchaseDetails other = (WareHousePurchaseDetails) obj;
		if (expDate == null) {
			if (other.expDate != null)
				return false;
		} else if (!expDate.equals(other.expDate))
			return false;
		if (pId != other.pId)
			return false;
		if (quantityPurchased != other.quantityPurchased)
			return false;
		if (whpId != other.whpId)
			return false;
		if (whpdId != other.whpdId)
			return false;
		return true;
	}
	
	public void acceptData() {
		
		
	}
	
	

}
