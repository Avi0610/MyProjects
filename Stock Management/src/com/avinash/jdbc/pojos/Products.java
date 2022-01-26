package com.avinash.jdbc.pojos;

import java.util.Scanner;

public class Products {
	 
	protected int pId;
	protected int pCatId;
	protected String pName;
	protected double cp;
	protected double sp;
	protected double profit;
	protected int unit;
	
	public Products() {
		
	}

	public Products(int pId, int pCatId, String pName, double cp, double sp, double profit, int unit) {
		this.pId = pId;
		this.pCatId = pCatId;
		this.pName = pName;
		this.cp = cp;
		this.sp = sp;
		this.profit = profit;
		this.unit = unit;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getpCatId() {
		return pCatId;
	}

	public void setpCatId(int pCatId) {
		this.pCatId = pCatId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getCp() {
		return cp;
	}

	public void setCp(double cp) {
		this.cp = cp;
	}

	public double getSp() {
		return sp;
	}

	public void setSp(double sp) {
		this.sp = sp;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Products [pId=" + pId + ", pCatId=" + pCatId + ", pName=" + pName + ", cp=" + cp + ", sp=" + sp
				+ ", profit=" + profit + ", unit=" + unit + "]";
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pCatId;
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		temp = Double.doubleToLongBits(profit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + unit;
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
		Products other = (Products) obj;
		if (Double.doubleToLongBits(cp) != Double.doubleToLongBits(other.cp))
			return false;
		if (pCatId != other.pCatId)
			return false;
		if (pId != other.pId)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (Double.doubleToLongBits(profit) != Double.doubleToLongBits(other.profit))
			return false;
		if (Double.doubleToLongBits(sp) != Double.doubleToLongBits(other.sp))
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}

	public void acceptData() {
		
		
	}
	
	
	
	
	
	

}
