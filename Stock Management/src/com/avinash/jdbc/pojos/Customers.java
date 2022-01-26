package com.avinash.jdbc.pojos;
import com.avinash.jdbc.utlities.*;
import java.util.Scanner;

public class Customers {
	protected int custId;
	protected String custName;
	protected String mobile;
	protected String email;
	protected String gender;
	protected double rewards;
	
	public Customers() {
		
	}

	public Customers(int custId, String custName, String mobile, String email, String gender, double rewards) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.rewards = rewards;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getRewards() {
		return rewards;
	}

	public void setRewards(double rewards) {
		this.rewards = rewards;
	}

	@Override
	public String toString() {
		return "Customers [custId=" + custId + ", custName=" + custName + ", mobile=" + mobile + ", email=" + email
				+ ", gender=" + gender + ", rewards=" + rewards + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rewards);
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
		Customers other = (Customers) obj;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (Double.doubleToLongBits(rewards) != Double.doubleToLongBits(other.rewards))
			return false;
		return true;
	}
	
	public void acceptData() {
		
	}
	
}
