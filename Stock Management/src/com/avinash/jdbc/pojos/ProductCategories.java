package com.avinash.jdbc.pojos;

import java.util.Scanner;

public class ProductCategories {
	
	protected int pCatId;
	protected String pCatName;
	protected double cgst;
	protected double sgst;
	protected String details;
	
	public ProductCategories() {
		
	}

	public ProductCategories(int pCatId, String pCatName, double cgst, double sgst, String details) {
		
		this.pCatId = pCatId;
		this.pCatName = pCatName;
		this.cgst = cgst;
		this.sgst = sgst;
		this.details = details;
	}

	public int getpCatId() {
		return pCatId;
	}

	public void setpCatId(int pCatId) {
		this.pCatId = pCatId;
	}

	public String getpCatName() {
		return pCatName;
	}

	public void setpCatName(String pCatName) {
		this.pCatName = pCatName;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ProductCategories [pCatId=" + pCatId + ", pCatName=" + pCatName + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + pCatId;
		result = prime * result + ((pCatName == null) ? 0 : pCatName.hashCode());
		temp = Double.doubleToLongBits(sgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ProductCategories other = (ProductCategories) obj;
		if (Double.doubleToLongBits(cgst) != Double.doubleToLongBits(other.cgst))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (pCatId != other.pCatId)
			return false;
		if (pCatName == null) {
			if (other.pCatName != null)
				return false;
		} else if (!pCatName.equals(other.pCatName))
			return false;
		if (Double.doubleToLongBits(sgst) != Double.doubleToLongBits(other.sgst))
			return false;
		return true;
	}
	
	public void acceptData() {
		
	}

}
