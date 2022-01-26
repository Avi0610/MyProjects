package com.avinash.jdbc.daos;
import java.sql.*;

import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.pojos.WareHousePurchase;
import com.avinash.jdbc.pojos.WareHouseSupply;
import java.util.ArrayList;
import com.avinash.jdbc.utlities.*;
import java.util.Scanner;

public class WareHouseSupplyDao {
	
	public WareHouseSupplyDao() {
		
	}
	
	public boolean createWareHouseSupply(WareHouseSupply whs) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.w_h_supply(p_id, store_id, quantity, dos, user_id) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,whs.getpId());
			ps.setInt(2,whs.getStoreId());
			ps.setInt(3,whs.getQuantity());
			java.sql.Date dt = new java.sql.Date(whs.getDos().getTime());
			ps.setDate(4,dt);
			ps.setInt(5,whs.getUserId());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public static ArrayList<WareHouseSupply> findByProIdAndStoreId(int proId, int storeId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHouseSupply> listSupply = new ArrayList<WareHouseSupply>();
		
		try {
			String sql = "select * from stock_management.w_h_supply where p_id = ? AND store_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, proId);
			ps.setInt(2,  storeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				WareHouseSupply whs = new WareHouseSupply();
				whs.setpId(rs.getInt("p_id"));
				whs.setStoreId(rs.getInt("store_id"));
				whs.setQuantity(rs.getInt("quantity"));
				java.sql.Date dt1 = rs.getDate("dos");
				whs.setDos(new java.util.Date(dt1.getTime()));
				whs.setUserId(rs.getInt("user_id"));
				listSupply.add(whs);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return listSupply;
	}
	
	public static WareHouseSupply findLastSupplyId() {
		Connection conn = MyDatabaseConnection.getConnection();
		WareHouseSupply whs = new WareHouseSupply();
		try {
			String sql = "select * from stock_management.w_h_supply";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				whs.setWhsId(rs.getInt("w_h_supply_id"));

			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return whs;
	}
	
	public ArrayList< WareHouseSupply> findBysupplyId(int supplyId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHouseSupply> listwhs = new ArrayList<WareHouseSupply>();
		try {
			String sql = "select * from stock_management.w_h_supply where w_h_supply_id > ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, supplyId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHouseSupply whs = new WareHouseSupply();
				whs.setWhsId(rs.getInt("w_h_supply_id"));
				whs.setpId(rs.getInt("p_id"));
				whs.setStoreId(rs.getInt("store_id"));
				whs.setQuantity(rs.getInt("quantity"));
				listwhs.add(whs);
				
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return listwhs;
	}
	
	public ArrayList< WareHouseSupply> findBysupplyDate(java.util.Date dos) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHouseSupply> listwhs = new ArrayList<WareHouseSupply>();
		try {
			String sql = "select * from stock_management.w_h_supply where dos like date(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			ps.setDate(1, sqlDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHouseSupply whs = new WareHouseSupply();
				whs.setWhsId(rs.getInt("w_h_supply_id"));
				whs.setpId(rs.getInt("p_id"));
				whs.setStoreId(rs.getInt("store_id"));
				whs.setQuantity(rs.getInt("quantity"));
				whs.setUserId(rs.getInt("user_id"));
				listwhs.add(whs);
				
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return listwhs;
	}
	
	public static WareHouseSupply findProductBySupplyId(int whsId) {
		Connection conn = MyDatabaseConnection.getConnection();
		WareHouseSupply whs = new WareHouseSupply();
		try {
			String sql = "select * from stock_management.w_h_supply where w_h_supply_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, whsId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				whs.setWhsId(rs.getInt("w_h_supply_id"));
				whs.setpId(rs.getInt("p_id"));
				whs.setStoreId(rs.getInt("store_id"));
				whs.setQuantity(rs.getInt("quantity"));
				java.sql.Date dt1 = rs.getDate("dos");
				whs.setDos(new java.util.Date(dt1.getTime()));
				whs.setUserId(rs.getInt("user_id"));
				
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return whs;
	}
	
	public boolean removeWareHouseSupply(int whsId) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from stock_management.w_h_supply where w_h_supply_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, whsId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			return false;
		}
		return true;
	}
	
	
	
	
	public static void main(String args[]) {
		
		
		
//		WareHouseSupply whs = new WareHouseSupply();
//		whs.acceptData();
//		WareHouseSupplyDao whsd = new WareHouseSupplyDao();
//		whsd.createWareHouseSupply(whs);
		
//		System.out.println("enter p id");
//		int pid = sc.nextInt();
//		System.out.println("enter storeId");
//		int storeId = sc.nextInt();
//		WareHouseSupplyDao whsd  = new WareHouseSupplyDao();
//		ArrayList<WareHouseSupply> al1 = whsd.findByProIdAndStoreId(pid, storeId);
//		for (WareHouseSupply whs : al1)
//		System.out.println(whs);
		
//		WareHouseSupplyDao whsd = new WareHouseSupplyDao();
//		System.out.println(whsd.findLastSupplyId().getWhsId());
		
//		WareHouseSupplyDao whsd  = new WareHouseSupplyDao();
//		ArrayList<WareHouseSupply> al = whsd.findBysupplyId(2);
//		for (WareHouseSupply whs : al)
//		System.out.println(whs);
		
//		System.out.println("enter whs Id");
//		int whs = sc.nextInt();
//		WareHouseSupplyDao whsd = new WareHouseSupplyDao();
//		System.out.println(whsd.findProductBySupplyId(whs));
		
//		System.out.println("enter Date");
//		String str = sc.nextLine();
//		java.util.Date dos = DateUtils.convertDate(str);
//		WareHouseSupplyDao whsd  = new WareHouseSupplyDao();
//		ArrayList<WareHouseSupply> al1 = whsd.findBysupplyDate(dos);
//		for (WareHouseSupply whs : al1)
//		System.out.println(whs);
	
		
	}

}
