package com.avinash.jdbc.pojos;

import java.util.Date;
import java.util.Scanner;
import com.avinash.jdbc.utlities.DateUtils;


public class Users {
	
	protected int userId;
	protected String userName;
	protected String mobile;
	protected String address;
	protected java.util.Date doj;
	protected java.util.Date dob;
	protected String userType;
	protected String email;
	protected String password;
	protected int storeId;
	protected int totalSale;
	
	public Users() {
		
	}

	public Users(int userId, String userName, String mobile, String address, Date doj, Date dob, String userType,
			String email, String password, int storeId, int totalSale) {
		
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.address = address;
		this.doj = doj;
		this.dob = dob;
		this.userType = userType;
		this.email = email;
		this.password = password;
		this.storeId = storeId;
		this.totalSale = totalSale;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.util.Date getDoj() {
		return doj;
	}

	public void setDoj(java.util.Date doj) {
		this.doj = doj;
	}

	public java.util.Date getDob() {
		return dob;
	}

	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", address=" + address
				+ ", doj=" + doj + ", dob=" + dob + ", userType=" + userType + ", email=" + email + ", password="
				+ password + ", storeId=" + storeId + ", totalSale=" + totalSale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + storeId;
		result = prime * result + totalSale;
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		Users other = (Users) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile != other.mobile)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (storeId != other.storeId)
			return false;
		if (totalSale != other.totalSale)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
	public void acceptData() {
		
				
		
	}
	
	
	
	

}
