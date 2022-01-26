package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.etutors.pojos.TutorTeachingDetails;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.ConnectionPool;

public class TutorTeachingDetailsDao {
	
	public int createTeachingDet(TutorTeachingDetails tutorTeachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int auto_id = 0;
		try {
			String sql = "insert into e_tutors.tutor_tecahing_details(tutor_det_id,class,subject) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorTeachingDetails.getTutorId());
			ps.setString(2, tutorTeachingDetails.getTeachingClass());
			ps.setString(3, tutorTeachingDetails.getTeachingSubject());	
			ps.executeUpdate();
		}
					
		 catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} 
		
		finally {
			pool.putConnection(conn);
		}
		return auto_id;
	}
	
	public ArrayList<TutorTeachingDetails> findTeachingDetailsById(int tutorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();	
		ArrayList<TutorTeachingDetails> listTutorsDetails = new ArrayList<TutorTeachingDetails>();
		try {
			String sql = "select * from e_tutors.tutor_tecahing_details where tutor_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorId);	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TutorTeachingDetails tutorTeachingDetails = new TutorTeachingDetails();
				tutorTeachingDetails.setTutorId(tutorId);
				tutorTeachingDetails.setTeachingClass(rs.getString("class"));
				tutorTeachingDetails.setTeachingSubject(rs.getString("subject"));
				tutorTeachingDetails.setTechingdetId(rs.getInt("teaching_det_id"));
				listTutorsDetails.add(tutorTeachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listTutorsDetails;
	}
	
	public void edit(TutorTeachingDetails tutorTeachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update  e_tutors.tutor_tecahing_details set class = ?, subject = ? where teaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,tutorTeachingDetails.getTeachingClass());
			ps.setString(2, tutorTeachingDetails.getTeachingSubject());
			ps.setInt(3, tutorTeachingDetails.getTechingdetId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void remove(int tutorTeachingDetId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from  e_tutors.tutor_tecahing_details where teaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorTeachingDetId);
		
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enetr id");
		int id = sc.nextInt();
		TutorTeachingDetailsDao teachingDetailsDao = new TutorTeachingDetailsDao();
		teachingDetailsDao.remove(id);
	}
	
	
	

}
