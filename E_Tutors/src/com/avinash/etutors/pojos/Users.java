package com.avinash.etutors.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.etutors.utilities.DateUtils;

public class Users {
	
	private int userId;
	private String userName;
	private String email;
	private String mobile;
	private String city;
	private String pinCode;
	private String gender;
	private java.util.Date dob;
	private String password;
	public Users(int userId, String userName, String email, String mobile, String city, String pinCode, String gender,
			Date dob, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.pinCode = pinCode;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
	}
	public Users() {
		super();
	}
	public Users(String userName, String email, String mobile, String city, String pinCode, String gender, Date dob,
			String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.pinCode = pinCode;
		this.gender = gender;
		this.dob = dob;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pinCode != other.pinCode)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", email=" + email + ", mobile=" + mobile
				+ ", city=" + city + ", pinCode=" + pinCode + ", gender=" + gender + ", dob=" + dob + ", password="
				+ password + "]";
	}
	
	public void acceptData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		userName = sc.nextLine();
		System.out.println("enter email");
		email = sc.nextLine();
		System.out.println("enter mobile");
		mobile = sc.nextLine();
		System.out.println("enter city");
		city = sc.nextLine();
		System.out.println("enter pincode");
		pinCode = sc.nextLine();
		System.out.println("enter gender");
		gender = sc.nextLine();
		System.out.println("enter dob");
		String date = sc.nextLine();
		dob = DateUtils.convertDate(date);
		System.out.println("enter Password");
		password = sc.nextLine();
//		sc.nextLine();
//		System.out.println("enter userId");
//		userId = sc.nextInt();
	}
	
	

}
