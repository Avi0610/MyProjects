package com.avinash.jdbc.daos;
import java.sql.*;
import com.avinash.jdbc.pojos.ProductCategories;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.utlities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductCategoriesDao {
	
	public ProductCategoriesDao() {
		
	}
	
	public boolean CreateCategory(ProductCategories procat) {
		Connection conn = MyDatabaseConnection.getConnection();
		
		try {
			String sql = "insert into stock_management.p_categories(p_cat_id,p_cat_name, cgst, sgst, details) values (?,?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, procat.getpCatId());
			ps.setString(2, procat.getpCatName());
			ps.setDouble(3, procat.getCgst());
			ps.setDouble(4, procat.getSgst());
			ps.setString(5, procat.getDetails());
			ps.executeUpdate();
		} 
		catch(SQLException sq) {
			System.out.println("unable to print a new row"+sq);
			return false;
		}
		
		return true;
	}
	
	public ArrayList<ProductCategories> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<ProductCategories> listProducts = new ArrayList<ProductCategories>();
		try {
			String sql = "select * from stock_management.p_categories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductCategories procat = new ProductCategories();
				procat.setpCatId(rs.getInt("p_cat_id"));
				procat.setpCatName(rs.getString("p_cat_name"));
				procat.setCgst(rs.getDouble("cgst"));
				procat.setSgst(rs.getDouble("sgst"));
				procat.setDetails(rs.getString("details"));
				listProducts.add(procat);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listProducts;
	}
	
	public boolean editCategories(ProductCategories procat) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.p_categories set p_cat_name = ? , " + "cgst = ?,"+ " sgst = ?, "+  "details = ? where p_cat_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, procat.getpCatName());
			ps.setDouble(2, procat.getCgst());
			ps.setDouble(3, procat.getSgst());
			ps.setString(4, procat.getDetails());
			ps.setInt(5, procat.getpCatId());
			ps.executeUpdate();
			
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public static ProductCategories findByCatId(int pCatId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ProductCategories procat = new ProductCategories();
		try {
			String sql = "select * from stock_management.p_categories where p_cat_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pCatId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				procat.setpCatId(rs.getInt("p_cat_id"));
				procat.setpCatName(rs.getString("p_cat_name"));
				procat.setCgst(rs.getDouble("cgst"));
				procat.setSgst(rs.getDouble("sgst"));
				procat.setDetails(rs.getString("details"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return procat;
	}
	
	public static ProductCategories findByCatName(String catName) {
		Connection conn = MyDatabaseConnection.getConnection();
		ProductCategories procat = new ProductCategories();
		try {
			String sql = "select * from stock_management.p_categories where p_cat_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, catName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				procat.setpCatId(rs.getInt("p_cat_id"));
				procat.setpCatName(rs.getString("p_cat_name"));
				procat.setCgst(rs.getDouble("cgst"));
				procat.setSgst(rs.getDouble("sgst"));
				procat.setDetails(rs.getString("details"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return procat;
	}
	
	public static void main(String args[]) {
		
		
		
//		ProductCategories procat = new ProductCategories();
//		procat.acceptData();
//		ProductCategoriesDao procatdao = new ProductCategoriesDao();
//		procatdao.CreateCategory(procat);
		
//		ProductCategoriesDao procatdao = new ProductCategoriesDao();
//		ArrayList<ProductCategories> procat = procatdao.findAll();
//		for (ProductCategories pc1 : procat)
//		System.out.println(pc1);
		
//		ProductCategories procat = new ProductCategories();
//		procat.acceptData();
//		ProductCategoriesDao procatdao = new ProductCategoriesDao();
//		procatdao.editCategories(procat);
		
//		System.out.println("enter cat id");
//		int  catId = Integer.parseInt(sc.nextLine());
//		ProductCategoriesDao procatdao = new ProductCategoriesDao();
//		ProductCategories pro7 = procatdao.findByCatId(catId);
//		System.out.println(pro7);
		
//		System.out.println("enter cat name");
//		String  catId = sc.nextLine();
//		ProductCategoriesDao procatdao = new ProductCategoriesDao();
//		ProductCategories pro7 = procatdao.findByCatName(catId);
//		System.out.println(pro7);
		
	}

}
