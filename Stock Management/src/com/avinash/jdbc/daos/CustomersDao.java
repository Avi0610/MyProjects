package com.avinash.jdbc.daos;
import java.sql.*;
import com.avinash.jdbc.pojos.Customers;
import java.util.ArrayList;
import java.util.Scanner;

import com.avinash.jdbc.utlities.*;

public class CustomersDao {
	public boolean createCustomer(Customers customer) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.customers(cust_name, mobile, e_mail, gender, rewards) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,customer.getCustName());
			ps.setString(2,customer.getMobile());
			ps.setString(3,customer.getEmail());
			ps.setString(4,customer.getGender());
			ps.setDouble(5, customer.getRewards());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public static Customers find(String mobile) {
		Connection conn = MyDatabaseConnection.getConnection();
		Customers customer = new Customers();
		try {
			String sql = "select * from stock_management.customers where mobile = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer.setMobile(mobile);
				customer.setCustId(rs.getInt("cust_id"));
				customer.setCustName(rs.getString("cust_name"));
				customer.setMobile(rs.getString("mobile"));
				customer.setEmail(rs.getString("e_mail"));
				customer.setGender(rs.getString("gender"));
				customer.setRewards(rs.getDouble("rewards"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return customer;
	}
	
	public ArrayList<Customers> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Customers> listCustomers = new ArrayList<Customers>();
		try {
			String sql = "select * from stock_management.customers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customers customer = new Customers();
				customer.setCustId(rs.getInt("cust_id"));
				customer.setCustName(rs.getString("cust_name"));
				customer.setMobile(rs.getString("mobile"));
				customer.setEmail(rs.getString("e_mail"));
				customer.setGender(rs.getString("gender"));
				customer.setRewards(rs.getDouble("rewards"));
				customer.setGender(rs.getString("gender"));
				listCustomers.add(customer);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listCustomers;
	}
	
	public boolean updatePoint(Double point ,int custId ) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.customers set rewards = ?  where cust_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1 ,point);
			ps.setInt(2,custId);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public boolean updateCustomers(Customers cust, String mob) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.customers set cust_name = ?,"+ " mobile = ?, "+ " e_mail = ?, "+ " gender = ?  where mobile = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

		
			ps.setString(1,cust.getCustName());
			ps.setString(2, cust.getMobile());
			ps.setString(3, cust.getEmail());
			ps.setString(4, cust.getGender());
			ps.setString(5, mob);
			
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public static void main(String args[]) {

		
//		 Customers customer = new Customers();
//		 customer.acceptData();
//		 CustomersDao customerDao = new CustomersDao();
//		 customerDao.createCustomer(customer);
		 
//		 System.out.println("enter mobile no");
//		 String mobileNo = sc.nextLine();
//		 CustomersDao customerdao2  = new CustomersDao();
//	 	 Customers cust2 = CustomersDao.find(mobileNo);
//	 	 System.out.println(cust2);
	 	 
//		CustomersDao customersdao  = new CustomersDao();
//		ArrayList<Customers> al = customersdao.findAll();
//		for (Customers customer : al)
//		System.out.println(customer);
		
//		 Customers customer = new Customers();
//		 customer.acceptData();
//		 CustomersDao customerDao = new CustomersDao();
//		 customerDao.updateCustomers(customer);
		
		
		
	}
	

}
