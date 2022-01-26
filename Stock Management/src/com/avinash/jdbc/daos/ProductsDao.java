package com.avinash.jdbc.daos;
import java.sql.*;
import com.avinash.jdbc.pojos.Products;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.utlities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsDao {
	
	public ProductsDao() {
		
	}
	
	public boolean createProducts(Products product) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.products(p_id, p_cat_id, p_name, cp, sp, profit, unit) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,product.getpId());
			ps.setInt(2,product.getpCatId());
			ps.setString(3,product.getpName());
			ps.setDouble(4,product.getCp());
			ps.setDouble(5,product.getSp());
			Double profit = (product.getSp() - product.getCp());
			ps.setDouble(6,profit);
			ps.setInt(7,product.getUnit());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public boolean updateProducts(Products product) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.products set p_cat_id = ? , " + "p_name = ?,"+ " cp = ?, "+ "sp = ?, "+ " profit = ?, "+"unit = ? where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,product.getpCatId());
			ps.setString(2,product.getpName());
			ps.setDouble(3,product.getCp());
			ps.setDouble(4,product.getSp());
			Double profit = (product.getSp() - product.getCp());
			ps.setDouble(5,profit);
			ps.setInt(6,product.getUnit());
			ps.setInt(7,product.getpId());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;	
	}
	
	public boolean updateProductsCost(Products product,Integer proId) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.products set p_id = ?,"+" p_cat_id = ? , " + "p_name = ?,"+ " cp = ?, "+ "sp = ?, "+ " profit = ?, "+"unit = ? where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getpId());
			ps.setInt(2,product.getpCatId());
			ps.setString(3,product.getpName());
			ps.setDouble(4,product.getCp());
			ps.setDouble(5,product.getSp());
			Double profit = (product.getSp() - product.getCp());
			ps.setDouble(6,profit);
			ps.setInt(7,product.getUnit());
			ps.setInt(8,proId);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;	
	}
	
	
	public ArrayList<Products> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Products> listProducts = new ArrayList<Products>();
		try {
			String sql = "select * from stock_management.products";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Products product = new Products();
				product.setpId(rs.getInt("p_id"));
				product.setpCatId(rs.getInt("p_cat_id"));
				product.setpName(rs.getString("p_name"));
				product.setCp(rs.getDouble("cp"));
				product.setSp(rs.getDouble("sp"));
				product.setProfit(rs.getDouble("profit"));
				
				product.setUnit(rs.getInt("unit"));
				
				listProducts.add(product);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listProducts;
	}
	
	public ArrayList<Products> findAllCatId(int catId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Products> listProducts = new ArrayList<Products>();
		try {
			String sql = "select * from stock_management.products where p_cat_id like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, catId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Products product = new Products();
				product.setpId(rs.getInt("p_id"));
				product.setpCatId(rs.getInt("p_cat_id"));
				product.setpName(rs.getString("p_name"));
				product.setCp(rs.getDouble("cp"));
				product.setSp(rs.getDouble("sp"));
				product.setProfit(rs.getDouble("profit"));
				product.setUnit(rs.getInt("unit"));
				listProducts.add(product);
		} 
		}catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listProducts;
	}
	
	public static Products findByProductId(int productId) {
		Connection conn = MyDatabaseConnection.getConnection();
		Products product = new Products();
		try {
			String sql = "select * from stock_management.products where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				product.setpId(rs.getInt("p_id"));
				product.setpCatId(rs.getInt("p_cat_id"));
				product.setpName(rs.getString("p_name"));
				product.setCp(rs.getDouble("cp"));
				product.setSp(rs.getDouble("sp"));
				product.setProfit(rs.getDouble("profit"));
				product.setUnit(rs.getInt("unit"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return product;
	}
	
	
	public static void main (String args[]) {
		
		
		
//		Products pro = new Products();
//		pro.acceptData();
//		ProductsDao prodao = new ProductsDao();
//		prodao.createProducts(pro);
		
//		Products pro = new Products();
//		pro.acceptData();
//		ProductsDao prodao = new ProductsDao();
//		prodao.updateProducts(pro);
		
//		System.out.println("enter pro id");
//		int id = sc.nextInt();
//		Products pro = new Products();
//		pro.acceptData();
//		ProductsDao prodao = new ProductsDao();
//		prodao.updateProductsCost(pro, id);
		
//		ProductsDao productdao  = new ProductsDao();
//		ArrayList<Products> al = productdao.findAll();
//		for (Products products : al)
//		System.out.println(products);
		
//		System.out.println("enter cat id");
//		int id = sc.nextInt();
//		ProductsDao productdao3  = new ProductsDao();
//		ArrayList<Products> al1 = productdao3.findAllCatId(id);
//		for (Products product : al1)
//		System.out.println(product);
		
//		 System.out.println("enter product id");
//		 int  proId = Integer.parseInt(sc.nextLine());
//		 ProductsDao productdao  = new ProductsDao();
//		 Products product = productdao.findByProductId(proId);
//		 System.out.println(product);
		
	}

}
