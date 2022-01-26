package com.avinash.jdbc.pojos;

public class WareHouseStockList {
	private int pId;
	private String pName;
	private int quantity;
	public WareHouseStockList() {
		
	}
	public WareHouseStockList(int pId, String pName, int quantity) {
	
		this.pId = pId;
		this.pName = pName;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "WareHouseStockList [pId=" + pId + ", pName=" + pName + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + quantity;
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
		WareHouseStockList other = (WareHouseStockList) obj;
		if (pId != other.pId)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	

}
