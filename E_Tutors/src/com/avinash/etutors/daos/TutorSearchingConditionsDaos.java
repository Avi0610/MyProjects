package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;
import com.avinash.etutors.utilities.ConnectionPool;

public class TutorSearchingConditionsDaos {
	
	public ArrayList<TutorBasicDetails> findByTutorBySubjectClassPinCode(String subject, String tutorClass, String pinCode) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "select distinct A.tutor_det_id, A.tutor_name, A.gender, A.email, A.mobile, A.original_city, A.present_city, A.profession, A.password, A.dob, A.additional_det from e_tutors.teaching_area_det B inner join e_tutors.tutor_tecahing_details C on(B.tutor_det_id = C.tutor_det_id) inner join e_tutors.tutor_basic_det A on(A.tutor_det_id = B.tutor_det_id) where B.pincode=? and upper(C.class)=upper(?) and upper(C.subject)=upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pinCode);
			ps.setString(2,tutorClass );
			ps.setString(3, subject);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setEmail(rs.getString("email"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				listTutors.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutors;
	}
	
	public ArrayList<TutorBasicDetails> findByTutorPinCode(String pinCode) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "select distinct A.tutor_det_id, A.tutor_name, A.gender, A.email, A.mobile, A.original_city, A.present_city, A.profession, A.password, A.dob, A.additional_det from e_tutors.tutor_tecahing_details B inner join e_tutors.teaching_area_det C on(B.tutor_det_id = C.tutor_det_id) inner join e_tutors.tutor_basic_det A on(A.tutor_det_id = B.tutor_det_id)where upper(C.pincode)=upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pinCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setEmail(rs.getString("email"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				listTutors.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutors;
	}
	
	public ArrayList<TutorBasicDetails> findByTutorSubjectAndPinCode(String subject, String pinCode) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "select distinct A.tutor_det_id, A.tutor_name, A.gender, A.email, A.mobile, A.original_city, A.present_city, A.profession, A.password, A.dob, A.additional_det from e_tutors.teaching_area_det B inner join e_tutors.tutor_tecahing_details C on(B.tutor_det_id = C.tutor_det_id) inner join e_tutors.tutor_basic_det A on(A.tutor_det_id = B.tutor_det_id) where  upper(C.subject) = upper(?) and B.pincode=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, pinCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setEmail(rs.getString("email"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				listTutors.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutors;
	}
	
	public ArrayList<TutorBasicDetails> findByTutorPinCodeAndClass(String tutorClass, String pinCode) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "select distinct A.tutor_det_id, A.tutor_name, A.gender, A.email, A.mobile, A.original_city, A.present_city, A.profession, A.password, A.dob, A.additional_det from e_tutors.teaching_area_det B inner join e_tutors.tutor_tecahing_details C on(B.tutor_det_id = C.tutor_det_id) inner join e_tutors.tutor_basic_det A on(A.tutor_det_id = B.tutor_det_id) where  upper(C.class) = upper(?) and B.pincode=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tutorClass);
			ps.setString(2, pinCode);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setEmail(rs.getString("email"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				listTutors.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutors;
	}
	
	public ArrayList<TutorBasicDetails> findByClassAndSubject(String tutorClass, String subject) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();	
		ArrayList<TutorBasicDetails> listTutors = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "SELECT distinct  A.tutor_det_id, A.tutor_name, A.gender, A.email, A.mobile, A.original_city, A.present_city, A.profession, A.password, A.dob, A.additional_det from e_tutors.tutor_tecahing_details B inner join e_tutors.tutor_basic_det A on(B.tutor_det_id = A.tutor_det_id) where upper(B.class)=upper(?) and upper(B.subject)=upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tutorClass);
			ps.setString(2, subject);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setEmail(rs.getString("email"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				listTutors.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutors;
	}
	
	
	public ArrayList<TutorTeachingDetails> findTeachingDetailsById(int tutorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();	
		ArrayList<TutorTeachingDetails> listTutorsDetails = new ArrayList<TutorTeachingDetails>();
		try {
			String sql = "select * from e_tutors.tutor_tecahing_details where tutor_det_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorId);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorTeachingDetails tutorTeachingDetails = new TutorTeachingDetails();
				tutorTeachingDetails.setTutorId(tutorId);
				tutorTeachingDetails.setTeachingClass(rs.getString("class"));
				tutorTeachingDetails.setTeachingSubject(rs.getString("subject"));
				
				listTutorsDetails.add(tutorTeachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutorsDetails;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter subject");
		String subject = sc.nextLine();
		System.out.println("enter class");
		String tutorClass = sc.nextLine();
		System.out.println("enter pincode");
		String pinCode = sc.nextLine();
		TutorSearchingConditionsDaos tutorSearchingConditionsDaos = new TutorSearchingConditionsDaos();
		
		ArrayList<TutorBasicDetails> list = tutorSearchingConditionsDaos.findByTutorBySubjectClassPinCode(subject, tutorClass, pinCode);
		for(TutorBasicDetails tbd : list) {
			System.out.println(tbd);
		}
		
//		ArrayList<TutorBasicDetails> list = tutorSearchingConditionsDaos.findByTutorPinCode(pinCode);
//		for(TutorBasicDetails tbd : list) {
//			System.out.println(tbd);
//		}
//		
//		ArrayList<TutorBasicDetails> list = tutorSearchingConditionsDaos.findByTutorSubjectAndPinCode(subject, pinCode);
//		for(TutorBasicDetails tbd : list) {
//			System.out.println(tbd);
//		}
		
//		ArrayList<TutorBasicDetails> list = tutorSearchingConditionsDaos.findByTutorPinCodeAndClass(tutorClass, pinCode);
//		for(TutorBasicDetails tbd : list) {
//			System.out.println(tbd);
//		}
		
//		ArrayList<TutorBasicDetails> list = tutorSearchingConditionsDaos.findByClassAndSubject(tutorClass, subject);
//		for(TutorBasicDetails tbd : list) {
//			System.out.println(tbd);
//		}
		
//		System.out.println("enter Tutor Id");
//		int tutorId = sc.nextInt();
//		ArrayList<TutorTeachingDetails> ttd = new ArrayList<TutorTeachingDetails>();
//		ttd = tutorSearchingConditionsDaos.findTeachingDetailsById(tutorId);
//		for(TutorTeachingDetails ttdl : ttd) {
//			System.out.println(ttdl);
//		}
		
	}
	

}
