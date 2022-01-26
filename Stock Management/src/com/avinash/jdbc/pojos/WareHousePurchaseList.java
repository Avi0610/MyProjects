package com.avinash.jdbc.pojos;
import java.util.Scanner;

public class WareHousePurchaseList {
	protected int whpdId;
	protected int pId;
	protected String pName;
	protected int quantityPurchased;
	protected int quantityInStock;
	public WareHousePurchaseList() {
		
	}
	public WareHousePurchaseList(int whpdId, int pId, String pName, int quantityPurchased, int quantityInStock) {
		super();
		this.whpdId = whpdId;
		this.pId = pId;
		this.pName = pName;
		this.quantityPurchased = quantityPurchased;
		this.quantityInStock = quantityInStock;
	}
	public int getWhpdId() {
		return whpdId;
	}
	public void setWhpdId(int whpdId) {
		this.whpdId = whpdId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	@Override
	public String toString() {
		return "WareHousePurchaseList [whpdId=" + whpdId + ", pId=" + pId + ", pName=" + pName + ", quantityPurchased="
				+ quantityPurchased + ", quantityInStock=" + quantityInStock + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + quantityInStock;
		result = prime * result + quantityPurchased;
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
		WareHousePurchaseList other = (WareHousePurchaseList) obj;
		if (pId != other.pId)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (quantityInStock != other.quantityInStock)
			return false;
		if (quantityPurchased != other.quantityPurchased)
			return false;
		if (whpdId != other.whpdId)
			return false;
		return true;
	}
	
	
	
	
	
	

}
