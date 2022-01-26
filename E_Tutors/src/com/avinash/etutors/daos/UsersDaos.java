package com.avinash.etutors.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.avinash.etutors.pojos.Users;
import com.avinash.etutors.utilities.ConnectionPool;

public class UsersDaos {
	
	public int createUser(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int auto_id = 0;
		try {
			String sql = "insert into e_tutors.users(user_name,email,mobile,city,pincode,gender,dob,password) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getCity());
			ps.setString(5, user.getPinCode());
			ps.setString(6,  user.getGender());
			java.sql.Date dt = new java.sql.Date(user.getDob().getTime());
			ps.setDate(7, dt);
			ps.setString(8, user.getPassword());
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
			String sql = "select user_id from e_tutors.users where upper(email) = upper(?) and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public void edit(Users user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.users set user_name = ?, email = ?, mobile = ?, city = ?, pincode = ?, gender = ?, dob = ? where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getCity());
			ps.setString(5, user.getPinCode());
			ps.setString(6,  user.getGender());
			java.sql.Date dt = new java.sql.Date(user.getDob().getTime());
			ps.setDate(7, dt);
			ps.setInt(8, user.getUserId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void updatePassword(String password, int userId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update e_tutors.users set password = ? where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			
			ps.setInt(2, userId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public Users findByUserId(int userId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from e_tutors.users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(userId);
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setCity(rs.getString("city"));
				user.setPinCode(rs.getString("pincode"));
				user.setGender(rs.getString("gender"));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}
	
	public Users findByUserEmail(String email) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users user = new Users();
		try {
			String sql = "select * from e_tutors.users where  upper(email) = upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setEmail(email);
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setMobile(rs.getString("mobile"));
				user.setCity(rs.getString("city"));
				user.setPinCode(rs.getString("pincode"));
				user.setGender(rs.getString("gender"));
				java.sql.Date dt = rs.getDate("dob");
				user.setDob(new java.util.Date(dt.getTime()));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return user;
	}
	
	public static void main(String args[]) {
		
//		Users users = new Users();
//		users.acceptData();
//		UsersDaos userdaos = new UsersDaos();
//		System.out.println(userdaos.createUser(users));
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter email");
//		String email = sc.nextLine();
//		System.out.println("enter password");
//		String password = sc.nextLine();
		
//		UsersDaos usersDaos = new UsersDaos();
//		System.out.println(usersDaos.verify(email, password));
		
//		Users users = new Users();
//		users.acceptData();
//		UsersDaos userdaos = new UsersDaos();
//		userdaos.edit(users);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter userId");
//		int id = sc.nextInt();
//		sc.nextLine();
//		System.out.println("enter password");
//		String password = sc.nextLine();
//		
//		UsersDaos usersDaos = new UsersDaos();
//		usersDaos.updatePassword(password, id);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter userId");
//		int id = sc.nextInt();
//		UsersDaos usersDaos = new UsersDaos();
//		Users users = usersDaos.findByUserId(id);
//		System.out.println(users);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter email");
//		String email = sc.nextLine();
//		UsersDaos usersDaos = new UsersDaos();
//		Users users = usersDaos.findByUserEmail(email);
//		System.out.println(users);
	}

}
