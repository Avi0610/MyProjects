package com.avinash.etutors.pojos;

import java.util.Scanner;

public class TutorAreaDetails {
	
	private int tutorAreaId;
	private int tutorId;
	private String pinCode;
	public TutorAreaDetails(int tutorAreaId, int tutorId, String pinCode) {
		super();
		this.tutorAreaId = tutorAreaId;
		this.tutorId = tutorId;
		this.pinCode = pinCode;
	}
	public TutorAreaDetails() {
		super();
	}
	public TutorAreaDetails(int tutorId, String pinCode) {
		super();
		this.tutorId = tutorId;
		this.pinCode = pinCode;
	}
	public int getTutorAreaId() {
		return tutorAreaId;
	}
	public void setTutorAreaId(int tutorAreaId) {
		this.tutorAreaId = tutorAreaId;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + tutorAreaId;
		result = prime * result + tutorId;
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
		TutorAreaDetails other = (TutorAreaDetails) obj;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		if (tutorAreaId != other.tutorAreaId)
			return false;
		if (tutorId != other.tutorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TutorAreaDetails [tutorAreaId=" + tutorAreaId + ", tutorId=" + tutorId + ", pinCode=" + pinCode + "]";
	}
	public void acceptData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter area id");
		tutorAreaId = sc.nextInt();
		sc.nextLine();
		System.out.println("entre pincode");
		pinCode = sc.nextLine();
		
	}
	

}
