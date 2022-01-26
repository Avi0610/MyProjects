package com.avinash.jdbc.daos;
import java.sql.*;

import com.avinash.jdbc.pojos.Customers;
import com.avinash.jdbc.pojos.Stores;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.utlities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoresDao {
	
	public boolean createStore(Stores store) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.stores(doe, location) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.sql.Date dt = new java.sql.Date(store.getDoe().getTime());
			ps.setDate(1,dt);
			ps.setString(2,store.getLocation());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public ArrayList<Stores> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Stores> listStores = new ArrayList<Stores>();
		try {
			String sql = "select * from stock_management.stores";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Stores store = new Stores();
				store.setStoreId(rs.getInt("store_id"));
				java.sql.Date dt1 = rs.getDate("doe");
				store.setDoe(new java.util.Date(dt1.getTime()));
				store.setLocation(rs.getString("location"));
				
				listStores.add(store);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listStores;
	}
	
	public static ArrayList<Stores> findAllByLocation(String location) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Stores> listStores = new ArrayList<Stores>();
		try {
			String sql = "select * from stock_management.stores where location like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Stores store = new Stores();
				store.setStoreId(rs.getInt("store_id"));
				java.sql.Date dt1 = rs.getDate("doe");
				store.setDoe(new java.util.Date(dt1.getTime()));
				store.setLocation(rs.getString("location"));
				
				listStores.add(store);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listStores;
	}
	
	public static Stores findByStoreId(int storeId) {
		Connection conn = MyDatabaseConnection.getConnection();
		Stores store = new Stores();
		try {
			String sql = "select * from stock_management.stores where store_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				store.setStoreId(rs.getInt("store_id"));
				java.sql.Date dt1 = rs.getDate("doe");
				store.setDoe(new java.util.Date(dt1.getTime()));
				store.setLocation(rs.getString("location"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return store;
	}
	
	public static void main(String args[]) {
		
		
		
//		Stores store = new Stores();
//		store.acceptData();
//		StoresDao storeDao = new StoresDao();
//		storeDao.createStore(store);
		
//		StoresDao storedao  = new StoresDao();
//		ArrayList<Stores> al = storedao.findAll();
//		for (Stores stores : al)
//		System.out.println(stores);
		
//		System.out.println("enter location");
//		String location = sc.nextLine();
//		StoresDao storedao  = new StoresDao();
//		ArrayList<Stores> al1 = storedao.findAllByLocation(location);
//		for (Stores stores : al1)
//		System.out.println(stores);
		
//		System.out.println("enter store id");
//		int  storeId = Integer.parseInt(sc.nextLine());
//		StoresDao storedao  = new StoresDao();
//		Stores store = StoresDao.findByStoreId(storeId);
//		System.out.println(store);
		
		
	}
	

}
