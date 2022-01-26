package com.avinash.etutors.pojos;

import java.util.Date;
import java.util.Scanner;

import com.avinash.etutors.utilities.DateUtils;

public class TutorBasicDetails {
	
	private int tutorId;
	private String tutorName;
	private String gender;
	private String email;
	private String mobile;
	private String profession;
	private java.util.Date dob;
	private String originalCity;
	private String presentCity;
	private String details;
	private String password;
	public TutorBasicDetails() {
		super();
	}
	public TutorBasicDetails(int tutorId, String tutorName, String gender, String email, String mobile,
			String profession, Date dob, String originalCity, String presentCity, String details, String password) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.profession = profession;
		this.dob = dob;
		this.originalCity = originalCity;
		this.presentCity = presentCity;
		this.details = details;
		this.password = password;
	}
	public TutorBasicDetails(String tutorName, String gender, String email, String mobile, String profession,
			Date dob, String originalCity, String presentCity, String details, String password) {
		super();
		this.tutorName = tutorName;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.profession = profession;
		this.dob = dob;
		this.originalCity = originalCity;
		this.presentCity = presentCity;
		this.details = details;
		this.password = password;
	}
	public TutorBasicDetails(int tutorId, String tutorName, String gender, String email, String mobile,
			String profession, Date dob, String originalCity, String presentCity, String password) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.profession = profession;
		this.dob = dob;
		this.originalCity = originalCity;
		this.presentCity = presentCity;
		this.password = password;
	}
	public TutorBasicDetails(String tutorName, String gender, String email, String mobile, String profession,
			Date dob, String originalCity, String presentCity, String password) {
		super();
		this.tutorName = tutorName;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.profession = profession;
		this.dob = dob;
		this.originalCity = originalCity;
		this.presentCity = presentCity;
		this.password = password;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getOriginalCity() {
		return originalCity;
	}
	public void setOriginalCity(String originalCity) {
		this.originalCity = originalCity;
	}
	public String getPresentCity() {
		return presentCity;
	}
	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
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
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((originalCity == null) ? 0 : originalCity.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((presentCity == null) ? 0 : presentCity.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + tutorId;
		result = prime * result + ((tutorName == null) ? 0 : tutorName.hashCode());
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
		TutorBasicDetails other = (TutorBasicDetails) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
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
		if (originalCity == null) {
			if (other.originalCity != null)
				return false;
		} else if (!originalCity.equals(other.originalCity))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (presentCity == null) {
			if (other.presentCity != null)
				return false;
		} else if (!presentCity.equals(other.presentCity))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		if (tutorId != other.tutorId)
			return false;
		if (tutorName == null) {
			if (other.tutorName != null)
				return false;
		} else if (!tutorName.equals(other.tutorName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tutor_Basic_Details [tutorId=" + tutorId + ", tutorName=" + tutorName + ", gender=" + gender
				+ ", email=" + email + ", mobile=" + mobile + ", profession=" + profession + ", dob=" + dob
				+ ", originalCity=" + originalCity + ", presentCity=" + presentCity + ", details=" + details
				+ ", password=" + password + "]";
	}
	
	public void acceptData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter name");
		tutorName = sc.nextLine();
		System.out.println("enter gender");
		gender = sc.nextLine();
		System.out.println("enter email");
		email = sc.nextLine();
		System.out.println("enter mobile");
		mobile = sc.nextLine();
		System.out.println("enter profession");
		profession = sc.nextLine();
		System.out.println("enter dob");
		String date = sc.nextLine();
		dob = DateUtils.convertDate(date);
		System.out.println("enter original city");
		originalCity = sc.nextLine();
		System.out.println("enter present City");
		presentCity = sc.nextLine();
		System.out.println("enter details");
		details = sc.nextLine();
		sc.nextLine();
//		System.out.println("enter passsword");
//		password = sc.nextLine();
		System.out.println("enter id");
		tutorId = sc.nextInt();
		
		
	}
	

}
