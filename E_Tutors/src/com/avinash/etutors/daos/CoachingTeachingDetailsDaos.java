package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.avinash.etutors.pojos.CoachingTeachingDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;
import com.avinash.etutors.utilities.ConnectionPool;

public class CoachingTeachingDetailsDaos {
	
	public void createTeachingDet(CoachingTeachingDetails coachingTeachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		try {
			String sql = "insert into e_tutors.coaching_teaching_details(coaching_basic_det_id,class,subject) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, coachingTeachingDetails.getCoachingId());
			ps.setString(2, coachingTeachingDetails.getCoachingClass());
			ps.setString(3, coachingTeachingDetails.getcoachingSubject());	
			ps.executeUpdate();
		}
					
		 catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} 
		
		finally {
			pool.putConnection(conn);
		}

	}
	
	
	public ArrayList<CoachingTeachingDetails> findTeachingDetailsById(int coachingId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();	
		ArrayList<CoachingTeachingDetails> listCoachingDetails = new ArrayList<CoachingTeachingDetails>();
		try {
			String sql = "select * from e_tutors.coaching_teaching_details where coaching_basic_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, coachingId);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CoachingTeachingDetails coachingTeachingDetails = new CoachingTeachingDetails();
				coachingTeachingDetails.setCoachingId(coachingId);
				coachingTeachingDetails.setCaochingTeachDetId(rs.getInt("coaching_teaching_det_id"));;
				coachingTeachingDetails.setCoachingClass(rs.getString("class"));;
				coachingTeachingDetails.setcoachingSubject(rs.getString("subject"));
				listCoachingDetails.add(coachingTeachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCoachingDetails;
	}
	
	public void edit(CoachingTeachingDetails coachingTeachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update  e_tutors.coaching_teaching_details set class = ?, subject = ? where coaching_teaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,coachingTeachingDetails.getCoachingClass());
			ps.setString(2, coachingTeachingDetails.getcoachingSubject());
			ps.setInt(3, coachingTeachingDetails.getCaochingTeachDetId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void remove(int coachingTeachingDetId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from e_tutors.coaching_teaching_details where coaching_teaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, coachingTeachingDetId);
		
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	

}
