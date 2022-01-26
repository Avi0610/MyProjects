package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.etutors.pojos.CoachingDetails;

import com.avinash.etutors.utilities.ConnectionPool;

public class CoachingSearchingConditionsDaos {
	
	public ArrayList<CoachingDetails> findByTutorByCityAndSubjectAndClass(String city, String sub, String cls) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CoachingDetails> listCoachings = new ArrayList<CoachingDetails>();
		try {
			String sql = "select distinct A.coaching_det_id, A.email, A.mobile, A.name, A.city, A.details from e_tutors.coaching_basic_det A inner join e_tutors.coaching_teaching_details B on(A.coaching_det_id = B.coaching_basic_det_id) where upper(A.city)=upper(?) and upper(B.class)=upper(?) and upper(B.subject)=upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, cls );
			ps.setString(3, sub);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CoachingDetails coachingDetails = new CoachingDetails();
				coachingDetails.setCoachingDetId(rs.getInt("coaching_det_id"));
				coachingDetails.setEmail(rs.getString("email"));
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setDetails(rs.getString("details"));
				listCoachings.add(coachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCoachings;
	}
	
	
	
	public ArrayList<CoachingDetails> findByTutorByCityAndSubject(String city, String sub) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CoachingDetails> listCoachings = new ArrayList<CoachingDetails>();
		try {
			String sql = "select distinct A.coaching_det_id, A.email, A.mobile, A.name, A.city, A.details from e_tutors.coaching_basic_det A inner join e_tutors.coaching_teaching_details B on(A.coaching_det_id = B.coaching_basic_det_id) where upper(A.city)=upper(?) and upper(B.subject)=upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, sub);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CoachingDetails coachingDetails = new CoachingDetails();
				coachingDetails.setCoachingDetId(rs.getInt("coaching_det_id"));
				coachingDetails.setEmail(rs.getString("email"));
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setDetails(rs.getString("details"));
				listCoachings.add(coachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCoachings;
	}
	
	
	public ArrayList<CoachingDetails> findByTutorByCityAndClass(String city, String cls) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CoachingDetails> listCoachings = new ArrayList<CoachingDetails>();
		try {
			String sql = "select distinct A.coaching_det_id, A.email, A.mobile, A.name, A.city, A.details from e_tutors.coaching_basic_det A inner join e_tutors.coaching_teaching_details B on(A.coaching_det_id = B.coaching_basic_det_id) where upper(A.city) = upper(?) and upper(B.class) = upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, cls );
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CoachingDetails coachingDetails = new CoachingDetails();
				coachingDetails.setCoachingDetId(rs.getInt("coaching_det_id"));
				coachingDetails.setEmail(rs.getString("email"));
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setDetails(rs.getString("details"));
				listCoachings.add(coachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCoachings;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter city");
		String city = sc.nextLine();
//		System.out.println("enter sub");
//		String sub = sc.nextLine();
		System.out.println("enter cls");
		String cls = sc.nextLine();
		
//		CoachingSearchingConditionsDaos coachingSearchingConditionsDaos = new CoachingSearchingConditionsDaos();
//		ArrayList<CoachingDetails> list = new ArrayList<CoachingDetails>();
//		list = coachingSearchingConditionsDaos.findByTutorByCityAndSubjectAndClass(city, sub, cls);
//		for(CoachingDetails cd : list) {
//			System.out.println(cd);
//		}
		
		CoachingSearchingConditionsDaos coachingSearchingConditionsDaos = new CoachingSearchingConditionsDaos();
		ArrayList<CoachingDetails> list = new ArrayList<CoachingDetails>();
		list = coachingSearchingConditionsDaos.findByTutorByCityAndClass(city, cls);
		for(CoachingDetails cd : list) {
			System.out.println(cd);
		}
		
	}
	

}
