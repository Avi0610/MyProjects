package com.avinash.jdbc.daos;
import java.sql.*;
import java.util.ArrayList;
import com.avinash.jdbc.utlities.*;
import com.avinash.jdbc.pojos.StoreStockDetails;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.pojos.WareHouseSupply;

import java.util.Scanner;


public class StoreStockDetailsDao {
	
	public StoreStockDetailsDao() {
		
	}

	public boolean createStoreStock(StoreStockDetails ssd) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.store_stock_details(store_id, p_id, quantity) values(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,ssd.getStoreId());
			ps.setInt(2,ssd.getpId());
			ps.setInt(3,ssd.getQuantity());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	

	public static StoreStockDetails findByProIdAndStoreId(int proId, int storeId) {
		Connection conn = MyDatabaseConnection.getConnection();
		StoreStockDetails ssd = new StoreStockDetails();
		
		
		try {
			String sql = "select * from stock_management.store_stock_details where p_id = ? AND store_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, proId);
			ps.setInt(2,  storeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				ssd.setStoreId(rs.getInt("store_id"));
				ssd.setpId(rs.getInt("p_id"));
				ssd.setQuantity(rs.getInt("quantity"));
				
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return ssd;
	}
	
	public static ArrayList<StoreStockDetails> findByStoreId(int storeId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<StoreStockDetails> listStoreStocks = new ArrayList<StoreStockDetails>();
		
		try {
			String sql = "select * from stock_management.store_stock_details where store_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreStockDetails ssd = new StoreStockDetails();
				ssd.setStoreId(rs.getInt("store_id"));
				ssd.setpId(rs.getInt("p_id"));
				ssd.setQuantity(rs.getInt("quantity"));
				
				listStoreStocks.add(ssd);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return listStoreStocks;
	}
	
	public static ArrayList<StoreStockDetails> findByProId(int proId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<StoreStockDetails> listStoreStocks = new ArrayList<StoreStockDetails>();
		
		try {
			String sql = "select * from stock_management.store_stock_details where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, proId);
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreStockDetails ssd = new StoreStockDetails();
				ssd.setStoreId(rs.getInt("store_id"));
				ssd.setpId(rs.getInt("p_id"));
				ssd.setQuantity(rs.getInt("quantity"));
				
				listStoreStocks.add(ssd);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return listStoreStocks;
	}
	
	public boolean addStoreStocks(StoreStockDetails ssd) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.store_stock_details set quantity = ?  where p_id = ? AND store_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
			StoreStockDetails al1 = ssdd.findByProIdAndStoreId(ssd.getpId(), ssd.getStoreId());
			int add = al1.getQuantity() + ssd.getQuantity();
			
			ps.setInt(1,add);
			ps.setInt(2,ssd.getpId());
			ps.setInt(3,ssd.getStoreId());
			ps.executeUpdate();
			
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public boolean sellStoreStocks(StoreStockDetails ssd) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.store_stock_details set quantity = ?  where p_id = ? AND store_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
			StoreStockDetails al1 = ssdd.findByProIdAndStoreId(ssd.getpId(), ssd.getStoreId());
			int add = al1.getQuantity() - ssd.getQuantity();
			
			ps.setInt(1,add);
			ps.setInt(2,ssd.getpId());
			ps.setInt(3,ssd.getStoreId());
			ps.executeUpdate();
			
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}


	
	
	public static void main(String args[]) {
	
		
//		StoreStockDetails ssd = new StoreStockDetails();
//		ssd.acceptData();
//		StoreStockDetailsDao ssdd = new StoreStockDetailsDao();
//		ssdd.createStoreStock(ssd);
		
//		System.out.println("enter p id");
//		int pid = sc.nextInt();
//		System.out.println("enter storeId");
//		int storeId = sc.nextInt();
//		StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
//		StoreStockDetails ssd = ssdd.findByProIdAndStoreId(pid, storeId);
//		System.out.println(ssd);
		
//		System.out.println("enter storeId");
//		int storeId = sc.nextInt();
//		StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
//		ArrayList<StoreStockDetails> al1 = ssdd.findByStoreId(storeId);
//		for (StoreStockDetails ssd : al1)
//		System.out.println(ssd);
		
//		System.out.println("enter proId");
//		int proId = sc.nextInt();
//		StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
//		ArrayList<StoreStockDetails> al1 = ssdd.findByProId(proId);
//		for (StoreStockDetails ssd : al1)
//		System.out.println(ssd);
		
//		StoreStockDetails ssd = new StoreStockDetails();
//		ssd.acceptData();
//		StoreStockDetailsDao ssdd = new StoreStockDetailsDao();
//		ssdd.addStoreStocks(ssd);
		
//		StoreStockDetails ssd = new StoreStockDetails();
//		ssd.acceptData();
//		StoreStockDetailsDao ssdd = new StoreStockDetailsDao();
//		ssdd.sellStoreStocks(ssd);
		
		
		
		
	}

}
