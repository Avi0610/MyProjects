package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.avinash.etutors.pojos.TutorAreaDetails;
import com.avinash.etutors.pojos.TutorTeachingDetails;
import com.avinash.etutors.utilities.ConnectionPool;

public class TutorAreaDetailsDaos {
		
	public void createTeachingDet(TutorAreaDetails tutorAreaDetails) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		try {
			String sql = "insert into e_tutors.teaching_area_det(tutor_det_id,pincode) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tutorAreaDetails.getTutorId());
			ps.setString(2, tutorAreaDetails.getPinCode());
			ps.executeUpdate();
		}
					
		 catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} 
		
		finally {
			pool.putConnection(conn);
		}
	
	}
		
		public void updateArea(TutorAreaDetails tutorAreaDetails) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			try {
				String sql = "update e_tutors.teaching_area_det set pincode = ? where teaching_area_det_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, tutorAreaDetails.getPinCode());
				ps.setInt(2, tutorAreaDetails.getTutorAreaId());
				ps.executeUpdate();
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row." + sq);
			} finally {
				pool.putConnection(conn);
			}
		}
		
		public ArrayList<TutorAreaDetails> findAllByPinCode(String pinCode) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<TutorAreaDetails> listTutorArea = new ArrayList<TutorAreaDetails>();
			try {
				String sql = "select * from e_tutors.teaching_area_det where  upper(pincode) = upper(?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, pinCode);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
					tutorAreaDetails.setPinCode(pinCode);
					tutorAreaDetails.setTutorId(rs.getInt("tutor_det_id"));
					tutorAreaDetails.setTutorAreaId(rs.getInt("teaching_area_det_id"));;
					
					listTutorArea.add(tutorAreaDetails);
				}
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return listTutorArea;
		}
		
		public ArrayList<TutorAreaDetails> findAllByTutorId(int tutorId) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<TutorAreaDetails> listTutorArea = new ArrayList<TutorAreaDetails>();
			try {
				String sql = "select * from e_tutors.teaching_area_det where tutor_det_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, tutorId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
					tutorAreaDetails.setPinCode(rs.getString("pincode"));
					tutorAreaDetails.setTutorId(tutorId);
					tutorAreaDetails.setTutorAreaId(rs.getInt("teaching_area_det_id"));;
					
					listTutorArea.add(tutorAreaDetails);
				}
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row." + sq);
			} finally {
				pool.putConnection(conn);
			}
			return listTutorArea;
		}
		
		public void remove(int tutorAreaDetId) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			try {
				String sql = "delete from e_tutors.teaching_area_det where teaching_area_det_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, tutorAreaDetId);
			
				ps.executeUpdate();
			} catch (SQLException sq) {
				System.out.println("Unable to delete the row." + sq);
			} finally {
				pool.putConnection(conn);
			}
		}
	
		public static void  main(String args[]) {
			Scanner sc = new Scanner(System.in);
			
//			System.out.println("enter the times");
//			int choice = sc.nextInt();
//			ArrayList<TutorAreaDetails> list = new ArrayList<TutorAreaDetails>();
//			for(int i = 0; i < choice; i++) {
//				TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
//				tutorAreaDetails.acceptData();
//				list.add(tutorAreaDetails);
//			}
//			TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
//			tutorAreaDetailsDaos.createTutorArea(list);
			
			
//			TutorAreaDetails tutorAreaDetails = new TutorAreaDetails();
//			tutorAreaDetails.acceptData();
//			TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
//			tutorAreaDetailsDaos.updateArea(tutorAreaDetails);
			
//			System.out.println("enter pincode");
//			String pinCode = sc.nextLine();
//			TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
//			ArrayList<TutorAreaDetails> tutorarea =  tutorAreaDetailsDaos.findAllByPinCode(pinCode);
//			for(TutorAreaDetails tad : tutorarea) {
//				System.out.println(tad);
//			}
			
//			System.out.println("enter id");
//			int tutorAreaDetId = sc.nextInt();
//			TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
//			tutorAreaDetailsDaos.remove(tutorAreaDetId);
			
//			System.out.println("enterid");
//			int id = sc.nextInt();
//			TutorAreaDetailsDaos tutorAreaDetailsDaos = new TutorAreaDetailsDaos();
//			ArrayList<TutorAreaDetails> tutorarea =  tutorAreaDetailsDaos.findAllByTutorId(id);
//			for(TutorAreaDetails tad : tutorarea) {
//				System.out.println(tad);
//			}
		}

}
