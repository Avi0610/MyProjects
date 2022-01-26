package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.etutors.pojos.TutorBasicDetails;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.ConnectionPool;

public class TutorBasicDetailsDaos {
	
	public int createTutorBasicDetails(TutorBasicDetails tutorBasicDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int auto_id = 0;
		try {
			String sql = "insert into e_tutors.tutor_basic_det(tutor_name,gender,email,mobile,profession,dob,original_city,present_city,additional_det,password) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tutorBasicDetails.getTutorName());
			ps.setString(2, tutorBasicDetails.getGender());
			ps.setString(3, tutorBasicDetails.getEmail());
			ps.setString(4, tutorBasicDetails.getMobile());
			ps.setString(5, tutorBasicDetails.getProfession());
			
			java.sql.Date dt = new java.sql.Date(tutorBasicDetails.getDob().getTime());
			ps.setDate(6, dt);
			ps.setString(7, tutorBasicDetails.getOriginalCity());
			ps.setString(8, tutorBasicDetails.getPresentCity());
			ps.setString(9, tutorBasicDetails.getDetails());
			ps.setString(10, tutorBasicDetails.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
		    rs.next();
		    auto_id = rs.getInt(1);
			//System.out.println(auto_id);
		}
					
		 catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} 
		finally {
			pool.putConnection(conn);
		}
		return auto_id;
	}
	
	public static int verify(String email, String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select tutor_det_id from e_tutors.tutor_basic_det where upper(email) = upper(?) and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("tutor_det_id");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public void edit(TutorBasicDetails tutorBasicDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.tutor_basic_det set tutor_name = ?, gender = ?, email = ?, mobile = ?, profession = ?, dob = ?, original_city = ?, present_city  = ?, additional_det = ?, password = ? where tutor_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tutorBasicDetails.getTutorName());
			ps.setString(2, tutorBasicDetails.getGender());
			ps.setString(3, tutorBasicDetails.getEmail());
			ps.setString(4, tutorBasicDetails.getMobile());
			ps.setString(5, tutorBasicDetails.getProfession());
			
			java.sql.Date dt = new java.sql.Date(tutorBasicDetails.getDob().getTime());
			ps.setDate(6, dt);
			ps.setString(7, tutorBasicDetails.getOriginalCity());
			ps.setString(8, tutorBasicDetails.getPresentCity());
			ps.setString(9, tutorBasicDetails.getDetails());
			ps.setString(10, tutorBasicDetails.getPassword());
			ps.setInt(11, tutorBasicDetails.getTutorId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void updatePassword(String password, int tutorBasicDetId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.tutor_basic_det set password = ? where tutor_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			
			ps.setInt(2, tutorBasicDetId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public TutorBasicDetails findByUserTutorEmail(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
		try {
			String sql = "select * from e_tutors.tutor_basic_det where upper(email) = upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tutorBasicDetails.setEmail(email);
				tutorBasicDetails.setTutorId(rs.getInt("tutor_det_id"));
				tutorBasicDetails.setTutorName(rs.getString("tutor_name"));
				tutorBasicDetails.setGender(rs.getString("gender"));
				tutorBasicDetails.setMobile(rs.getString("mobile"));
				tutorBasicDetails.setProfession(rs.getString("profession"));
				java.sql.Date dt = rs.getDate("dob");
				tutorBasicDetails.setDob(new java.util.Date(dt.getTime()));
				tutorBasicDetails.setOriginalCity(rs.getString("original_city"));
				tutorBasicDetails.setPresentCity(rs.getString("present_city"));
				tutorBasicDetails.setDetails(rs.getString("additional_det"));
				tutorBasicDetails.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return tutorBasicDetails;
	}
	
	public TutorBasicDetails findByTutorById(int tutorId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
		try {
			String sql = "select * from e_tutors.tutor_basic_det where tutor_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tutorBasicDetails.setTutorId(tutorId);
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
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return tutorBasicDetails;
	}
	
	public ArrayList<TutorBasicDetails> findByTutorByPresentCity(String presentCity) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<TutorBasicDetails> tutorBasicDetails2 = new ArrayList<TutorBasicDetails>();
		try {
			String sql = "select * from e_tutors.tutor_basic_det where upper(present_city) like upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, presentCity);
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
				tutorBasicDetails2.add(tutorBasicDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return tutorBasicDetails2;
	}
	
	public void remove(int tutorBasicDetId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from e_tutors.tutor_basic_det where tutor_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorBasicDetId);
		
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public static void main(String args[]) {
		
		
		Scanner sc = new Scanner(System.in);
		
//		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
//		tutorBasicDetails.acceptData();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		System.out.println(tutorBasicDetailsDaos.createTutorBasicDetails(tutorBasicDetails));
		
//		System.out.println("enter email");
//		String email = sc.nextLine();
//		System.out.println("enter password");
//		String password = sc.nextLine();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		System.out.println(tutorBasicDetailsDaos.verify(email, password));
		
//		TutorBasicDetails tutorBasicDetails = new TutorBasicDetails();
//		tutorBasicDetails.acceptData();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		tutorBasicDetailsDaos.edit(tutorBasicDetails);
		
//		System.out.println("enter tutorId");
//		int id = sc.nextInt();
//		sc.nextLine();
//		System.out.println("enter password");
//		String password = sc.nextLine();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		tutorBasicDetailsDaos.updatePassword(password, id);
		
//		System.out.println("enter email");
//		String email = sc.nextLine();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		System.out.println(tutorBasicDetailsDaos.findByUserTutorEmail(email));
		
//		System.out.println("enter id");
//		int id = sc.nextInt();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		System.out.println(tutorBasicDetailsDaos.findByTutorById(id));
		
//		System.out.println("enter City");
//		String city = sc.nextLine();
//		TutorBasicDetailsDaos tutorBasicDetailsDaos = new TutorBasicDetailsDaos();
//		ArrayList<TutorBasicDetails> tutorBasicDetails = tutorBasicDetailsDaos.findByTutorByPresentCity(city);
//		if(tutorBasicDetails.isEmpty()) {
//			System.out.println("List Is Empty");
//		}
//		else {
//			for (TutorBasicDetails td : tutorBasicDetails) {
//				System.out.println(td);
//				
//			}
//			
//		}
		
	}
}