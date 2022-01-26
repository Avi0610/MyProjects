package com.avinash.jdbc.pojos;
import java.util.Scanner;

public class SellingList {
	
	protected int storeSalesId;
	protected int pId;
	protected String pName;
	protected int quantity;
	protected Double sp;
	protected Double cgst;
	protected Double sgst;
	protected Double payable;
	
	public SellingList() {
		
	}

	public SellingList(int storeSalesId, int pId, String pName, int quantity, Double sp, Double cgst, Double sgst,
			Double payable) {
		
		this.storeSalesId = storeSalesId;
		this.pId = pId;
		this.pName = pName;
		this.quantity = quantity;
		this.sp = sp;
		this.cgst = cgst;
		this.sgst = sgst;
		this.payable = payable;
	}

	public int getStoreSalesId() {
		return storeSalesId;
	}

	public void setStoreSalesId(int storeSalesId) {
		this.storeSalesId = storeSalesId;
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

	public Double getSp() {
		return sp;
	}

	public void setSp(Double sp) {
		this.sp = sp;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getPayable() {
		return payable;
	}

	public void setPayable(Double payable) {
		this.payable = payable;
	}

	@Override
	public String toString() {
		return "SellingList [storeSalesId=" + storeSalesId + ", pId=" + pId + ", pName=" + pName + ", quantity="
				+ quantity + ", sp=" + sp + ", cgst=" + cgst + ", sgst=" + sgst + ", payable=" + payable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cgst == null) ? 0 : cgst.hashCode());
		result = prime * result + pId;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + ((payable == null) ? 0 : payable.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((sgst == null) ? 0 : sgst.hashCode());
		result = prime * result + ((sp == null) ? 0 : sp.hashCode());
		result = prime * result + storeSalesId;
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
		SellingList other = (SellingList) obj;
		if (cgst == null) {
			if (other.cgst != null)
				return false;
		} else if (!cgst.equals(other.cgst))
			return false;
		if (pId != other.pId)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (payable == null) {
			if (other.payable != null)
				return false;
		} else if (!payable.equals(other.payable))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sgst == null) {
			if (other.sgst != null)
				return false;
		} else if (!sgst.equals(other.sgst))
			return false;
		if (sp == null) {
			if (other.sp != null)
				return false;
		} else if (!sp.equals(other.sp))
			return false;
		if (storeSalesId != other.storeSalesId)
			return false;
		return true;
	}
	
	

}
