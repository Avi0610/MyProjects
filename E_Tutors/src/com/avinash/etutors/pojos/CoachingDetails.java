package com.avinash.etutors.pojos;

import java.sql.Blob;
import java.util.Scanner;

public class CoachingDetails {
	
	private int coachingDetId;
	private String email;
	private String mobile;
	private String city;
	private String institutionName;
	private String details;
	private String password;
	
	public CoachingDetails(int coachingDetId, String email, String mobile, String city, String institutionName,
			String details, String password) {
		super();
		this.coachingDetId = coachingDetId;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.institutionName = institutionName;
		this.details = details;
		this.password = password;
	}
	public CoachingDetails() {
		super();
	}
	public CoachingDetails(String email, String mobile, String city, String institutionName, String details,
			String password) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.institutionName = institutionName;
		this.details = details;
		this.password = password;
	}
	public int getCoachingDetId() {
		return coachingDetId;
	}
	public void setCoachingDetId(int coachingDetId) {
		this.coachingDetId = coachingDetId;
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
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
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
		result = prime * result + coachingDetId;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((institutionName == null) ? 0 : institutionName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		CoachingDetails other = (CoachingDetails) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (coachingDetId != other.coachingDetId)
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (institutionName == null) {
			if (other.institutionName != null)
				return false;
		} else if (!institutionName.equals(other.institutionName))
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
		return true;
	}
	@Override
	public String toString() {
		return "CoachingDetails [coachingDetId=" + coachingDetId + ", email=" + email + ", mobile=" + mobile + ", city="
				+ city + ", institutionName=" + institutionName + ", details=" + details + ", password=" + password
				+ "]";
	}
	public void acceptData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter email");
		email = sc.nextLine();
		System.out.println("enter mobile");
		mobile = sc.nextLine();
		System.out.println("enter city");
		city = sc.nextLine();
		System.out.println("enter institution name");
		institutionName = sc.nextLine();
		System.out.println("enter details");
		details = sc.nextLine();
		System.out.println("enter id");
		coachingDetId = sc.nextInt();
		
	}
	
	
	

}
