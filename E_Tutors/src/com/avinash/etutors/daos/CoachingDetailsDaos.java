package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.etutors.pojos.CoachingDetails;
import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.ConnectionPool;

public class CoachingDetailsDaos {
	
	public int createCoachingDetails(CoachingDetails coachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int auto_id = 0;
		try {
			String sql = "insert into e_tutors.coaching_basic_det(email,mobile,city,name,details,password) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, coachingDetails.getEmail());
			ps.setString(2, coachingDetails.getMobile());
			ps.setString(3, coachingDetails.getCity());
			ps.setString(4, coachingDetails.getInstitutionName());
			ps.setString(5, coachingDetails.getDetails());
			ps.setString(6, coachingDetails.getPassword());	
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
			String sql = "select coaching_det_id from e_tutors.coaching_basic_det where upper(email) = upper(?) and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("coaching_det_id");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public void edit(CoachingDetails coachingDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.coaching_basic_det set email = ?, mobile = ?, city = ?, name = ?, details = ?, password = ? where coaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, coachingDetails.getEmail());
			ps.setString(2, coachingDetails.getMobile());
			ps.setString(3, coachingDetails.getCity());
			ps.setString(4, coachingDetails.getInstitutionName());
			ps.setString(5, coachingDetails.getDetails());
			ps.setString(6, coachingDetails.getPassword());
			ps.setInt(7, coachingDetails.getCoachingDetId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void updatePassword(String password, int coachingId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.coaching_basic_det set password = ? where coaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			
			ps.setInt(2, coachingId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public CoachingDetails findByCoachingId(int coachingId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CoachingDetails coachingDetails = new CoachingDetails();
		try {
			String sql = "select * from e_tutors.coaching_basic_det where coaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, coachingId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				coachingDetails.setCoachingDetId(coachingId);
				coachingDetails.setEmail(rs.getString("email"));
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setDetails(rs.getString("details"));
				coachingDetails.setPassword(rs.getString("password"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return coachingDetails;
	}
	
	public CoachingDetails findByCoachingEmail(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		CoachingDetails coachingDetails = new CoachingDetails();
		try {
			String sql = "select * from e_tutors.coaching_basic_det where upper(email) = upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				coachingDetails.setCoachingDetId(rs.getInt("coaching_det_id"));
				coachingDetails.setEmail(email);
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setDetails(rs.getString("details"));
				coachingDetails.setPassword(rs.getString("password"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return coachingDetails;
	}
	
	public ArrayList<CoachingDetails> findByCoachingCity(String city) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<CoachingDetails> listCoaching = new ArrayList<CoachingDetails>();
		
		try {
			String sql = "select * from e_tutors.coaching_basic_det where upper(city) = upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CoachingDetails coachingDetails = new CoachingDetails();
				coachingDetails.setCoachingDetId(rs.getInt("coaching_det_id"));
				coachingDetails.setEmail(rs.getString("email"));
				coachingDetails.setMobile(rs.getString("mobile"));
				coachingDetails.setCity(rs.getString("city"));
				coachingDetails.setInstitutionName(rs.getString("name"));
				coachingDetails.setDetails(rs.getString("details"));
				coachingDetails.setPassword(rs.getString("password"));
				listCoaching.add(coachingDetails);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCoaching;
	}
	
	public void remove(int coachingDetId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from e_tutors.coaching_basic_det where coaching_det_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, coachingDetId);
		
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
//		CoachingDetails coachingDetails = new CoachingDetails();
//		coachingDetails.acceptData();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		coachingDetailsDaos.createCoachingDetails(coachingDetails);
		
//		System.out.println("email");
//		String email = sc.nextLine();
//		System.out.println("password");
//		String password = sc.nextLine();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		System.out.println(coachingDetailsDaos.verify(email, password));
		
//		CoachingDetails coachingDetails = new CoachingDetails();
//		coachingDetails.acceptData();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		coachingDetailsDaos.edit(coachingDetails);
		
//		System.out.println("id");
//		int coachingId = sc.nextInt();
//		sc.nextLine();
//		System.out.println("password");
//		String password = sc.nextLine();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		coachingDetailsDaos.updatePassword(password, coachingId);
		
//		System.out.println("id");
//		int coachingId = sc.nextInt();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		System.out.println(coachingDetailsDaos.findByCoachingId(coachingId));
		
//		System.out.println("email");
//		String email = sc.nextLine();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		System.out.println(coachingDetailsDaos.findByCoachingEmail(email));
		
//		System.out.println("City");
//		String city = sc.nextLine();
//		CoachingDetailsDaos coachingDetailsDaos = new CoachingDetailsDaos();
//		ArrayList<CoachingDetails> list = new ArrayList<CoachingDetails>();
//		list = coachingDetailsDaos.findByCoachingCity(city);
//		for(CoachingDetails cd : list) {
//			System.out.println(cd);
//		}
			
	}

}
