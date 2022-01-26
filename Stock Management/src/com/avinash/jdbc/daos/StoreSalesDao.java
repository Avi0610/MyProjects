package com.avinash.jdbc.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.jdbc.pojos.StoreSales;
import com.avinash.jdbc.pojos.StoreSalesDetails;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.pojos.WareHouseSupply;
import com.avinash.jdbc.utlities.*;

public class StoreSalesDao {
	
	public boolean createStoreSale(StoreSales ss) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.store_sales(dos, user_id, amount, discount_given, total_payable, store_id, cust_id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			java.sql.Date dt = new java.sql.Date(ss.getDos().getTime());
			ps.setDate(1,dt);
			ps.setInt(2,ss.getUserId());
			ps.setDouble(3, 00.00);
			ps.setDouble(4, 00.00);
			ps.setDouble(5, 00.00);
			ps.setInt(6, ss.getStoreId());
			ps.setInt(7, ss.getCustId());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public boolean updateAmuontAndDiscount(Double amount, Double discount , Double total, Integer ssId ) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.store_sales set amount = ? , discount_given = ?, total_payable = ? where store_sales_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1 , amount);
			ps.setDouble(2,discount);
			total  = amount - discount;
			ps.setDouble(3,total);
			ps.setInt(4, ssId);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;	
	}
	
	public static StoreSales findLastSalesId() {
		Connection conn = MyDatabaseConnection.getConnection();
		StoreSales ss = new StoreSales();
		try {
			String sql = "select * from stock_management.store_sales";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ss.setStoreSalesId(rs.getInt("store_sales_id"));

			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return ss;
	}
	
	public static StoreSales findFinal(int storeSalesId) {
		Connection conn = MyDatabaseConnection.getConnection();
		StoreSales ss = new StoreSales();
		try {
			String sql = "select amount,discount_given,total_payable from store_sales where store_sales_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeSalesId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ss.setAmount(rs.getDouble("amount"));
				ss.setDiscount(rs.getDouble("discount_given"));
				ss.setTotalPayable(rs.getDouble("total_payable"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return ss;
	}
	
	public static double totalPayable(int storeSalesId) {
		Connection conn = MyDatabaseConnection.getConnection();
		Double value = 00.00;
		StoreSales ss = new StoreSales();
		try {
			String sql = "SELECT total_payable FROM stock_management.store_sales WHERE store_sales_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeSalesId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String sum = rs.getString(1);
			//System.out.println(sum);
			value = Double.parseDouble(sum);

		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return value;
		
	}
	
	public ArrayList<StoreSales> findAllSales(java.util.Date dos) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<StoreSales> listSales = new ArrayList<StoreSales>();
		try {
			String sql = "SELECT * FROM stock_management.store_sales where dos like date(?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			
			ps.setDate(1, sqlDate);
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreSales ss = new StoreSales();
				ss.setStoreSalesId(rs.getInt("store_sales_id"));
				java.sql.Date dt1 = rs.getDate("dos");
				ss.setDos(new java.util.Date(dt1.getTime()));
				ss.setUserId(rs.getInt("user_id"));
				ss.setAmount(rs.getDouble("amount"));
				ss.setDiscount(rs.getDouble("discount_given"));
				ss.setTotalPayable(rs.getDouble("total_payable"));
				ss.setStoreId(rs.getInt("store_id"));
				ss.setCustId(rs.getInt("cust_id"));
				
				listSales.add(ss);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listSales;
	}
	
	public ArrayList<StoreSales> findAllSalesById(java.util.Date dos, Integer storeId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<StoreSales> listSales = new ArrayList<StoreSales>();
		try {
			String sql = "SELECT * FROM stock_management.store_sales where dos like date(?) And store_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			
			ps.setDate(1, sqlDate);
			ps.setInt(2, storeId);
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreSales ss = new StoreSales();
				ss.setStoreSalesId(rs.getInt("store_sales_id"));
				java.sql.Date dt1 = rs.getDate("dos");
				ss.setDos(new java.util.Date(dt1.getTime()));
				ss.setUserId(rs.getInt("user_id"));
				ss.setAmount(rs.getDouble("amount"));
				ss.setDiscount(rs.getDouble("discount_given"));
				ss.setTotalPayable(rs.getDouble("total_payable"));
				ss.setStoreId(rs.getInt("store_id"));
				ss.setCustId(rs.getInt("cust_id"));
				
				listSales.add(ss);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listSales;
	}
	
	public static StoreSales totalCollection(java.util.Date dos) {
		double value = 0.00;
		Connection conn = MyDatabaseConnection.getConnection();
		StoreSales ssd = new StoreSales();
		try {
			String sql = "SELECT sum(amount),sum(discount_given),sum(total_payable) FROM stock_management.store_sales where dos like date(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			
			ps.setDate(1, sqlDate);;
			ResultSet rs = ps.executeQuery();
			rs.next();
			ssd.setAmount( rs.getDouble(1)); 
			ssd.setDiscount(rs.getDouble(2)); 
			ssd.setTotalPayable(rs.getDouble(3));

		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return ssd;
		
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter storeSalesid");
		int ssid = sc.nextInt();
		StoreSales ss  = new StoreSales();
		StoreSalesDao ssd = new StoreSalesDao();
		System.out.println(ssd.findFinal(ssid).getAmount());
		System.out.println(ssd.findFinal(ssid).getDiscount());
		System.out.println(ssd.findFinal(ssid).getTotalPayable());
		
		
//		StoreSales ss = new StoreSales();
//		ss.acceptData();
//		StoreSalesDao ssd = new StoreSalesDao();
//		ssd.createStoreSale(ss);
		
//		System.out.println("amount");
//		Double amount = sc.nextDouble();
//		System.out.println("discount");
//		Double discount = sc.nextDouble();
//		System.out.println("ssId");
//		int ssId = sc.nextInt();
//		StoreSalesDao ssd = new StoreSalesDao();
//		ssd.updateAmuontAndDiscount(amount, discount,amount - discount, ssId);
		
//		StoreSalesDao ssd = new StoreSalesDao();
//		System.out.println(ssd.findLastSalesId().getStoreSalesId());
		
		
//		System.out.println("enter id");
//		int id = sc.nextInt();
//		StoreSalesDao ssd = new StoreSalesDao();
//		System.out.println(ssd.totalPayable(id));
		
//		System.out.println("enter dos");
//		String date2 = sc.nextLine();
//		java.util.Date dos = DateUtils.convertDate(date2);
//		StoreSalesDao storeSaleDao  = new StoreSalesDao();
//		ArrayList<StoreSales> al1 = storeSaleDao.findAllSales(dos);
//		for (StoreSales user4 : al1) {
//			System.out.println(user4);
//		}
		
//		System.out.println("enter dos");
//		String date2 = sc.nextLine();
//		System.out.println("enter storeId");
//		int storeId = sc.nextInt();
//		java.util.Date dos = DateUtils.convertDate(date2);
//		StoreSalesDao storeSaleDao  = new StoreSalesDao();
//		ArrayList<StoreSales> al1 = storeSaleDao.findAllSalesById(dos,storeId);
//		for (StoreSales user4 : al1) {
//			System.out.println(user4);
//		}
		
//		System.out.println("enter dos");
//		String date2 = sc.nextLine();
//		java.util.Date dos = DateUtils.convertDate(date2);
//		StoreSalesDao storeSaleDao  = new StoreSalesDao();
//		StoreSales ss =  storeSaleDao.totalCollection(dos);
//		System.out.println(ss.getAmount());
//		System.out.println(ss.getDiscount());
//		System.out.println(ss.getTotalPayable());
		
		
		
	}
	
	

}
