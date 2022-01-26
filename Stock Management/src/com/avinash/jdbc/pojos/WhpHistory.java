package com.avinash.jdbc.pojos;
import java.util.Scanner;

public class WhpHistory {
	
	private int pId;
	private int quantity;
	private String pName;
	private Double cp;
	private Double sp;
	public WhpHistory() {

	}
	public WhpHistory(int pId, int quantity, String pName, Double cp, Double sp) {
		super();
		this.pId = pId;
		this.quantity = quantity;
		this.pName = pName;
		this.cp = cp;
		this.sp = sp;
	}
	
	public WhpHistory(int pId, int quantity, String pName) {
		super();
		this.pId = pId;
		this.quantity = quantity;
		this.pName = pName;
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
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Double getCp() {
		return cp;
	}
	public void setCp(Double cp) {
		this.cp = cp;
	}
	public Double getSp() {
		return sp;
	}
	public void setSp(Double sp) {
		this.sp = sp;
	}
	@Override
	public String toString() {
		return "WhpHistory [pId=" + pId + ", quantity=" + quantity + ", pName=" + pName + ", cp=" + cp + ", sp=" + sp
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((sp == null) ? 0 : sp.hashCode());
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
		WhpHistory other = (WhpHistory) obj;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (pId != other.pId)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sp == null) {
			if (other.sp != null)
				return false;
		} else if (!sp.equals(other.sp))
			return false;
		return true;
	}
	

}
