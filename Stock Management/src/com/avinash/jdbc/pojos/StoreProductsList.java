package com.avinash.jdbc.pojos;
import java.util.*;

public class StoreProductsList {
	
	private int p_id;
	private String p_name;
	private Double sp;
	private int storeId;
	private int quantity;
	public StoreProductsList() {
		super();
	}
	public StoreProductsList(int p_id, String p_name, Double sp, int storeId, int quantity) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.sp = sp;
		this.storeId = storeId;
		this.quantity = quantity;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Double getSp() {
		return sp;
	}
	public void setSp(Double sp) {
		this.sp = sp;
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
	@Override
	public String toString() {
		return "StoreProductsList [p_id=" + p_id + ", p_name=" + p_name + ", sp=" + sp + ", storeId=" + storeId
				+ ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + p_id;
		result = prime * result + ((p_name == null) ? 0 : p_name.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((sp == null) ? 0 : sp.hashCode());
		result = prime * result + storeId;
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
		StoreProductsList other = (StoreProductsList) obj;
		if (p_id != other.p_id)
			return false;
		if (p_name == null) {
			if (other.p_name != null)
				return false;
		} else if (!p_name.equals(other.p_name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sp == null) {
			if (other.sp != null)
				return false;
		} else if (!sp.equals(other.sp))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}
	
	

	
}
