package com.avinash.etutors.pojos;

public class TutorTeachingDetails {
	int techingdetId;
	int tutorId;
	String teachingClass;
	String teachingSubject;
	public TutorTeachingDetails(int techingdetId, int tutorId, String teachingClass, String teachingSubject) {
		super();
		this.techingdetId = techingdetId;
		this.tutorId = tutorId;
		this.teachingClass = teachingClass;
		this.teachingSubject = teachingSubject;
	}
	public TutorTeachingDetails() {
		super();
	}
	public int getTechingdetId() {
		return techingdetId;
	}
	public void setTechingdetId(int techingdetId) {
		this.techingdetId = techingdetId;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public String getTeachingClass() {
		return teachingClass;
	}
	public void setTeachingClass(String teachingClass) {
		this.teachingClass = teachingClass;
	}
	public String getTeachingSubject() {
		return teachingSubject;
	}
	public void setTeachingSubject(String teachingSubject) {
		this.teachingSubject = teachingSubject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teachingClass == null) ? 0 : teachingClass.hashCode());
		result = prime * result + ((teachingSubject == null) ? 0 : teachingSubject.hashCode());
		result = prime * result + techingdetId;
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
		TutorTeachingDetails other = (TutorTeachingDetails) obj;
		if (teachingClass == null) {
			if (other.teachingClass != null)
				return false;
		} else if (!teachingClass.equals(other.teachingClass))
			return false;
		if (teachingSubject == null) {
			if (other.teachingSubject != null)
				return false;
		} else if (!teachingSubject.equals(other.teachingSubject))
			return false;
		if (techingdetId != other.techingdetId)
			return false;
		if (tutorId != other.tutorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TutorTeachingDetails [techingdetId=" + techingdetId + ", tutorId=" + tutorId + ", teachingClass="
				+ teachingClass + ", teachingSubject=" + teachingSubject + "]";
	}
	

}
