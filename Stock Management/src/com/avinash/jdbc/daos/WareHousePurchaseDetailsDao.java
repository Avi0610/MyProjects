package com.avinash.jdbc.daos;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.avinash.jdbc.utlities.*;
import com.avinash.jdbc.pojos.*;
import java.util.ArrayList;


public class WareHousePurchaseDetailsDao {
	
	public WareHousePurchaseDetailsDao() {
		
	}
	
	public boolean createPurchaseDetails(WareHousePurchaseDetails whpd) {
		
		Connection conn = MyDatabaseConnection.getConnection();
		
try {
			
			String sql = "insert into stock_management.w_h_p_details(w_h_p_id, p_id, quantity_purchased, exp_date) values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			WareHousePurchaseDao whpd1 =  new WareHousePurchaseDao();
			WareHousePurchase l  = whpd1.findLastPurchaseId();
			ps.setInt(1,l.getWareHousePurId());
			ps.setInt(2,whpd.getpId());
			ps.setInt(3,whpd.getQuantityPurchased());
			java.sql.Date date = new java.sql.Date(whpd.getExpDate().getTime());
			ps.setDate(4,date);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;

	}
	

	public ArrayList<WareHousePurchaseList> findAllByPurchaseId(int purId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHousePurchaseList> listPurcase1 = new ArrayList<WareHousePurchaseList>();
		try {
			String sql = "SELECT A.w_h_p_details_id, A.p_id, A.quantity_purchased, B.p_name, C.total_amount from stock_management.w_h_p_details A inner join stock_management.products B on (B.p_id = A.p_id) inner join stock_management.w_h_stocks C on (C.p_id = A.p_id) where A.w_h_p_id like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, purId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHousePurchaseList purlist = new WareHousePurchaseList();
				purlist.setWhpdId(rs.getInt("w_h_p_details_id"));
				purlist.setpId(rs.getInt("p_id"));
				purlist.setQuantityPurchased(rs.getInt("quantity_purchased"));
				purlist.setpName(rs.getString("p_name"));
				purlist.setQuantityInStock(rs.getInt("total_amount"));
			    listPurcase1.add(purlist);
		} 
		}catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listPurcase1;
	}
	
	public ArrayList<WareHousePurchaseDetails> findExpiringProducts() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WareHousePurchaseDetails> listProducts = new ArrayList<WareHousePurchaseDetails>();
		try {
			String sql = "select p_id,max(date(exp_date)) as exp_date from stock_management.w_h_p_details group by p_id order by exp_date asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WareHousePurchaseDetails exp = new WareHousePurchaseDetails();
				exp.setpId(rs.getInt("p_id"));
				java.sql.Date dt1 = rs.getDate("exp_date");
				exp.setExpDate(new java.util.Date(dt1.getTime()));
				
				listProducts.add(exp);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listProducts;
	}
	
	public ArrayList<WhpHistory> findAllByPurchaseByDate(java.util.Date dos) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WhpHistory> listPurcase = new ArrayList<WhpHistory>();
		try {
			String sql = "SELECT A.p_id, A.quantity_purchased,B.p_name,B.cp,B.sp from stock_management.w_h_p_details A Inner join stock_management.products B on(A.p_id = B.p_id) inner join stock_management.w_h_purchase C on(A.w_h_p_id = C.w_h_p_id) where C.dop = date(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			ps.setDate(1, sqlDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WhpHistory whph = new WhpHistory();
				whph.setpId(rs.getInt("p_id"));
				whph.setQuantity(rs.getInt("quantity_purchased"));
				whph.setpName(rs.getString("p_name"));
				whph.setCp(rs.getDouble("cp"));
				whph.setSp(rs.getDouble("sp"));
			    listPurcase.add(whph);
		} 
		}catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listPurcase;
	}
	
	public static void main(String args[]) {
		
		
//		WareHousePurchaseDetails whpd = new WareHousePurchaseDetails();
//		whpd.acceptData();
//		WareHousePurchaseDetailsDao whpdd =  new WareHousePurchaseDetailsDao();
//		whpdd.createPurchaseDetails(whpd);
		
//		System.out.println("ENTER purchase ID");
//		int purId = sc.nextInt();
//    	WareHousePurchaseDetailsDao whpdd =  new WareHousePurchaseDetailsDao();
//		ArrayList<WareHousePurchaseList> o7 = whpdd.findAllByPurchaseId(purId);
//		for(WareHousePurchaseList sw : o7) {
//			System.out.println(sw);
//		} 
		
//		System.out.println("enter dos");
//		String date2 = sc.nextLine();
//		java.util.Date dos = DateUtils.convertDate(date2);
//		WareHousePurchaseDetailsDao whpd  = new WareHousePurchaseDetailsDao();
//		ArrayList<WhpHistory> al1 = whpd.findAllByPurchaseByDate(dos);
//		for (WhpHistory user4 : al1) {
//			System.out.println(user4);
//		}
		
		WareHousePurchaseDetailsDao whpddao  = new WareHousePurchaseDetailsDao();
		ArrayList<WareHousePurchaseDetails> al = whpddao.findExpiringProducts();
		for (WareHousePurchaseDetails pro : al) {
			System.out.print(pro.getpId()+"\t");
			System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(pro.getExpDate()));
		}
		
	
	}

}
