package com.avinash.etutors.pojos;

public class CoachingTeachingDetails {
	
	private int caochingTeachDetId;
	private int CoachingId;
	private String coachingClass;
	private String coachingSubject;
	public CoachingTeachingDetails(int caochingTeachDetId, int coachingId, String coachingClass, String coachingSubject) {
		super();
		this.caochingTeachDetId = caochingTeachDetId;
		CoachingId = coachingId;
		this.coachingClass = coachingClass;
		this.coachingSubject = coachingSubject;
	}
	public CoachingTeachingDetails() {
		super();
	}
	public int getCaochingTeachDetId() {
		return caochingTeachDetId;
	}
	public void setCaochingTeachDetId(int caochingTeachDetId) {
		this.caochingTeachDetId = caochingTeachDetId;
	}
	public int getCoachingId() {
		return CoachingId;
	}
	public void setCoachingId(int coachingId) {
		CoachingId = coachingId;
	}
	public String getCoachingClass() {
		return coachingClass;
	}
	public void setCoachingClass(String coachingClass) {
		this.coachingClass = coachingClass;
	}
	public String getcoachingSubject() {
		return coachingSubject;
	}
	public void setcoachingSubject(String coachingSubject) {
		this.coachingSubject = coachingSubject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CoachingId;
		result = prime * result + ((coachingSubject == null) ? 0 : coachingSubject.hashCode());
		result = prime * result + caochingTeachDetId;
		result = prime * result + ((coachingClass == null) ? 0 : coachingClass.hashCode());
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
		CoachingTeachingDetails other = (CoachingTeachingDetails) obj;
		if (CoachingId != other.CoachingId)
			return false;
		if (coachingSubject == null) {
			if (other.coachingSubject != null)
				return false;
		} else if (!coachingSubject.equals(other.coachingSubject))
			return false;
		if (caochingTeachDetId != other.caochingTeachDetId)
			return false;
		if (coachingClass == null) {
			if (other.coachingClass != null)
				return false;
		} else if (!coachingClass.equals(other.coachingClass))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CoachingTeachingDetails [caochingTeachDetId=" + caochingTeachDetId + ", CoachingId=" + CoachingId
				+ ", coachingClass=" + coachingClass + ", Subject=" + coachingSubject + "]";
	}
	
	

}
