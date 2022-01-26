package com.avinash.jdbc.daos;
import java.sql.*;
import com.avinash.jdbc.utlities.*;
import com.avinash.jdbc.pojos.Users;
import com.avinash.jdbc.pojos.WareHouseStockList;
import com.avinash.jdbc.pojos.WareHouseStocks;
import java.util.ArrayList;
import java.util.Scanner;

public class WareHouseStocksDao {
	
	public WareHouseStocksDao() {
		
	}
	
	public boolean createWareHouseStocks(WareHouseStocks stock) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.w_h_stocks(p_id, total_amount) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setInt(1,stock.getpId());
			ps.setInt(2,stock.getTotalAmouont());
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public ArrayList<WareHouseStocks> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHouseStocks> listStocks = new ArrayList<WareHouseStocks>();
		try {
			String sql = "select * from stock_management.w_h_stocks";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHouseStocks whs = new WareHouseStocks();
				whs.setWhsId(rs.getInt("w_h_stocks_id"));
				whs.setpId(rs.getInt("p_id"));
				whs.setTotalAmouont(rs.getInt("total_amount"));
				listStocks.add(whs);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listStocks;
	}
	
	public ArrayList<WareHouseStockList> findAllInStock() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHouseStockList> listStocks = new ArrayList<WareHouseStockList>();
		try {
			String sql = "select A.p_id,B.p_name,A.total_amount from stock_management.w_h_stocks A inner join stock_management.products B on(A.p_id = B.p_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHouseStockList whs = new WareHouseStockList();
				whs.setpId(rs.getInt("p_id"));
				whs.setpName(rs.getString("p_name"));
				whs.setQuantity(rs.getInt("total_amount"));
				listStocks.add(whs);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listStocks;
	}
	
	public static WareHouseStocks findBypId(int pId) {
		Connection conn = MyDatabaseConnection.getConnection();
		WareHouseStocks whs = new WareHouseStocks();
		try {
			String sql = "select * from stock_management.w_h_stocks where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				whs.setWhsId(rs.getInt("w_h_stocks_id"));
				whs.setpId(rs.getInt("p_id"));
				whs.setTotalAmouont(rs.getInt("total_amount"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return whs;
	}
	
	public boolean addWareHouseStocks(WareHouseStocks stocks) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.w_h_stocks set total_amount = ?  where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			 WareHouseStocksDao whsd  = new WareHouseStocksDao();
			 WareHouseStocks whs = WareHouseStocksDao.findBypId(stocks.getpId());
			int add = whs.getTotalAmouont() + stocks.getTotalAmouont(); 
			ps.setInt(1,add);
			ps.setInt(2,stocks.getpId());
			
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	public boolean sendWareHouseStocks(WareHouseStocks stocks) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update stock_management.w_h_stocks set total_amount = ?  where p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			 WareHouseStocksDao whsd  = new WareHouseStocksDao();
			 WareHouseStocks whs = WareHouseStocksDao.findBypId(stocks.getpId());
			int add = whs.getTotalAmouont() - stocks.getTotalAmouont(); 
			ps.setInt(1,add);
			ps.setInt(2,stocks.getpId());
			
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a edit the row"+sq);
			return false;
		}
		return true;
			
	}
	
	
	
	public static void main(String args[]) {
		
		
		
//		WareHouseStocks whs = new WareHouseStocks();
//		whs.acceptData();
//		WareHouseStocksDao whsd = new WareHouseStocksDao();
//		whsd.createWareHouseStocks(whs);
			
//		WareHouseStocksDao whsd = new WareHouseStocksDao();
//		ArrayList<WareHouseStocks> al = whsd.findAll();
//		for (WareHouseStocks stocks : al)
//		System.out.println(stocks);
		
//		WareHouseStocksDao whsd = new WareHouseStocksDao();
//		ArrayList<WareHouseStockList> al = whsd.findAllInStock();
//		for (WareHouseStockList stocks : al)
//		System.out.println(stocks);
		
//		 System.out.println("enter p  id");
//		 int pId = Integer.parseInt(sc.nextLine());
//		 WareHouseStocksDao whsd  = new WareHouseStocksDao();
//		 WareHouseStocks whs = WareHouseStocksDao.findBypId(pId);
//		 System.out.println(whs);
		
//		WareHouseStocks whs = new WareHouseStocks();
//		whs.acceptData();
//		WareHouseStocksDao whsd = new WareHouseStocksDao();
//		whsd.addWareHouseStocks(whs);
		
//		WareHouseStocks whs = new WareHouseStocks();
//		whs.acceptData();
//		WareHouseStocksDao whsd = new WareHouseStocksDao();
//		whsd.sendWareHouseStocks(whs);
		
	}

}
