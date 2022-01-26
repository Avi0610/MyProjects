package com.avinash.jdbc.pojos;

import java.util.Scanner;

public class WareHouseStocks {
	
	protected int whsId;
	protected int pId;
	protected int totalAmouont;
	public WareHouseStocks() {
		
	}
	public WareHouseStocks(int whsId, int pId, int totalAmouont) {
		
		this.whsId = whsId;
		this.pId = pId;
		this.totalAmouont = totalAmouont;
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
	public int getTotalAmouont() {
		return totalAmouont;
	}
	public void setTotalAmouont(int totalAmouont) {
		this.totalAmouont = totalAmouont;
	}
	@Override
	public String toString() {
		return "WareHouseStocks [whsId=" + whsId + ", pId=" + pId + ", totalAmouont=" + totalAmouont + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pId;
		result = prime * result + totalAmouont;
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
		WareHouseStocks other = (WareHouseStocks) obj;
		if (pId != other.pId)
			return false;
		if (totalAmouont != other.totalAmouont)
			return false;
		if (whsId != other.whsId)
			return false;
		return true;
	}
	
	public void acceptData() {
		
		
	}
	
	

}
