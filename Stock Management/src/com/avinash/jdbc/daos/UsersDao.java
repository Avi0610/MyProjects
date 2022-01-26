package com.avinash.jdbc.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.utlities.*;

public class UsersDao {
	
	public UsersDao() {
		
	}
	
	public boolean createUser(Users user) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.users(user_name, mobile, address, doj, dob, user_type, e_mail, password, store_id, total_sale) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getMobile());
			ps.setString(3,user.getAddress());
			java.sql.Date dt = new java.sql.Date(user.getDob().getTime());
			ps.setDate(4,dt);
			java.sql.Date date1 = new java.sql.Date(user.getDoj().getTime());
			ps.setDate(5,date1);
			ps.setString(6,user.getUserType());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPassword());
			ps.setInt(9,user.getStoreId());
			ps.setInt(10,user.getTotalSale());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public ArrayList<Users> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Users> listUsers = new ArrayList<Users>();
		try {
			String sql = "select * from stock_management.users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				java.sql.Date dt1 = rs.getDate("doj");
				user.setDoj(new java.util.Date(dt1.getTime()));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setUserType(rs.getString("user_type"));
				user.setEmail(rs.getString("e_mail"));
				user.setPassword(rs.getString("password"));
				user.setStoreId(rs.getInt("store_id"));
				user.setTotalSale(rs.getInt("total_sale"));
				listUsers.add(user);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listUsers;
	}
	
	public boolean updatePassword(String password, Integer userId, String oldPassword ) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.users set password = ?  where user_id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1 ,password);
			ps.setInt(2,userId);
			ps.setString(3,oldPassword);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public static Users findAllByMobile(String mobile) {
		Connection conn = MyDatabaseConnection.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from stock_management.users where mobile like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				java.sql.Date dt1 = rs.getDate("doj");
				user.setDoj(new java.util.Date(dt1.getTime()));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setUserType(rs.getString("user_type"));
				user.setEmail(rs.getString("e_mail"));
				user.setPassword(rs.getString("password"));
				user.setStoreId(rs.getInt("store_id"));
				user.setTotalSale(rs.getInt("total_sale"));
			
		} 
			
		}catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return user;
	}
	
	public static Users findByUserId(int userId) {
		Connection conn = MyDatabaseConnection.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from stock_management.users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				java.sql.Date dt1 = rs.getDate("doj");
				user.setDoj(new java.util.Date(dt1.getTime()));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setUserType(rs.getString("user_type"));
				user.setEmail(rs.getString("e_mail"));
				user.setPassword(rs.getString("password"));
				user.setStoreId(rs.getInt("store_id"));
				user.setTotalSale(rs.getInt("total_sale"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return user;
	}
	
	public boolean removeUser(int userId) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from stock_management.users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			return false;
		}
		return true;
	}
	
	public static ArrayList<Users> findAllByType(String userType) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Users> listUsers = new ArrayList<Users>();
		try {
			String sql = "select * from stock_management.users where user_type like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userType);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				java.sql.Date dt1 = rs.getDate("doj");
				user.setDoj(new java.util.Date(dt1.getTime()));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setUserType(rs.getString("user_type"));
				user.setEmail(rs.getString("e_mail"));
				user.setPassword(rs.getString("password"));
				user.setStoreId(rs.getInt("store_id"));
				user.setTotalSale(rs.getInt("total_sale"));
				listUsers.add(user);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listUsers;
	}
	
	public boolean editUsers(Users user) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.users set user_name = ? , " + "mobile = ?,"+ " address = ?, "+ " doj = ?, "+ " dob = ?, "+"user_type = ?, "+"e_mail = ?, "+"password = ?, " +"store_id = ?, "+ "total_sale = ? where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getMobile());
			ps.setString(3,user.getAddress());
			java.sql.Date dt = new java.sql.Date(user.getDob().getTime());
			ps.setDate(4,dt);
			java.sql.Date date1 = new java.sql.Date(user.getDoj().getTime());
			ps.setDate(5,date1);
			ps.setString(6,user.getUserType());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPassword());
			ps.setInt(9,user.getStoreId());
			ps.setInt(10,user.getTotalSale());
			ps.executeUpdate();
			
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public static Users findByUserIdAndPassword(int userId, String Password) {
		Connection conn = MyDatabaseConnection.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from stock_management.users where user_id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2,  Password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("user_name"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return user;
	}
	
	public boolean updateSales(int sale ,int userId ) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.users set total_sale = ?  where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1 ,sale);
			ps.setInt(2,userId);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public static void main(String args[]) {
		
		
//		Users user = new Users();
//		user.acceptData();
//		UsersDao userDao = new UsersDao();
//		userDao.createUser(user);
		 
//		UsersDao userdao  = new UsersDao();
//		ArrayList<Users> al = userdao.findAll();
//		for (Users users : al)
//		System.out.println(users);
		
//		System.out.println("enter user id");
//		int type= Integer.parseInt(sc.nextLine());
//		System.out.println("enter ew password");
//		String pass= sc.nextLine();
//		System.out.println("enter old password");
//		String Opass= sc.nextLine();
//		Users user1 = new Users();
//		UsersDao userdao = new UsersDao();
//		userdao.updatePassword(pass, type, Opass);
		
//		System.out.println("enter mobile");
//		String mobile = sc.nextLine();
//		UsersDao userdao3  = new UsersDao();
//		Users user7 = userdao3.findAllByMobile(mobile);
		
//		System.out.println("enter user id");
//		int  userId = Integer.parseInt(sc.nextLine());
//		UsersDao userdao4  = new UsersDao();
//		Users user7 = UsersDao.findByUserId(userId);
//		System.out.println(user7);
		 
//		System.out.println("enter user id");
//		int userId = Integer.parseInt(sc.nextLine());
//		UsersDao userdao1  = new UsersDao();
//		userdao1.removeUser(userId);
		
//		System.out.println("enter user Type");
//		String type= sc.nextLine();
//		UsersDao userdao3  = new UsersDao();
//		ArrayList<Users> al1 = userdao3.findAllByType(type);
//		for (Users user4 : al1)
//		System.out.println(user4);
		
//		Users user1 = new Users();
//		user1.acceptData();
//		UsersDao userdao = new UsersDao();
//		userdao.editUsers(user1);
		
		
		
	}

}
