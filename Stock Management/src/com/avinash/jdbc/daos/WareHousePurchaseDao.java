package com.avinash.jdbc.daos;
import java.sql.*;
import com.avinash.jdbc.utlities.*;
import com.avinash.jdbc.pojos.*;

public class WareHousePurchaseDao {
	
	public WareHousePurchaseDao() {
		
		
	}
	
	public boolean CreatePurchase(WareHousePurchase whp) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
					
					String sql = "insert into stock_management.w_h_purchase(dop, user_id) values(?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					java.sql.Date dt = new java.sql.Date(whp.getDop().getTime());
					ps.setDate(1,dt);
					ps.setInt(2, whp.getUserId());
					ps.executeUpdate();
				}
				catch(SQLException sq) {
					System.out.println("unable a create a new row"+sq);
					return false;
				}
				return true;
			}	
	
	public static WareHousePurchase findLastPurchaseId() {
		Connection conn = MyDatabaseConnection.getConnection();
		WareHousePurchase whp = new WareHousePurchase();
		try {
			String sql = "select * from stock_management.w_h_purchase";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				whp.setWareHousePurId(rs.getInt("w_h_p_id"));
				java.sql.Date dt = rs.getDate("dop");
				whp.setDop(new java.util.Date(dt.getTime()));
				whp.setUserId(rs.getInt("user_id"));
			
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch row." + sq);
		}
		return whp;
	}
	
	
	
	public static void main(String args[]) {
		
//		WareHousePurchase whp = new WareHousePurchase();
//		whp.acceptData();
//		WareHousePurchaseDao whpd =  new WareHousePurchaseDao();
//	    whpd.CreatePurchase(whp);
		
//		WareHousePurchaseDao whpd =  new WareHousePurchaseDao();
//		WareHousePurchase l  = whpd.findLastPurchaseId();
//		System.out.println(l.getWareHousePurId());
		

	}
	

}
