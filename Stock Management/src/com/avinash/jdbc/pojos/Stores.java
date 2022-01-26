package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.jdbc.utlities.DateUtils;

public class Stores {
	
	protected int storeId;
	protected java.util.Date doe;
	protected String location;
	public Stores() {
		
	}
	public Stores(int storeId, Date doe, String location) {
		super();
		this.storeId = storeId;
		this.doe = doe;
		this.location = location;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public java.util.Date getDoe() {
		return doe;
	}
	public void setDoe(java.util.Date doe) {
		this.doe = doe;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", doe=" + doe + ", location=" + location + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doe == null) ? 0 : doe.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		Stores other = (Stores) obj;
		if (doe == null) {
			if (other.doe != null)
				return false;
		} else if (!doe.equals(other.doe))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}
	
	public void acceptData() {
		    
		
				
		
	}
	
	

}
