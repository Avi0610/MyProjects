package com.avinash.jdbc.daos;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import com.avinash.jdbc.utlities.*;
import com.avinash.jdbc.daos.StoreSalesDao;
import com.avinash.jdbc.pojos.*;

public class StoreSalesDeatailsDao {
	
	public boolean createStoreSaleDetail(StoreSalesDetails ssd) {
		Connection conn = MyDatabaseConnection.getConnection();
try {
			
			String sql = "insert into stock_management.store_sales_details(store_sales_id, p_id, quantity, cost, payable_amount) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			StoreSalesDao ssd1 = new StoreSalesDao();
			ps.setInt(1,ssd1.findLastSalesId().getStoreSalesId());
			ps.setInt(2,ssd.getpId());
			ps.setInt(3, ssd.getQuantity());
			ProductsDao productdao  = new ProductsDao();
			Products product = productdao.findByProductId(ssd.getpId());
			ps.setDouble(4, product.getSp());
			ProductCategoriesDao procatdao = new ProductCategoriesDao();
			ProductCategories pro7 = procatdao.findByCatId(product.getpCatId());
			Double totaltax = pro7.getCgst() + pro7.getSgst();
			Double total = ssd.getQuantity() * product.getSp();
			Double payable = ((totaltax/100) * total);
			ps.setDouble(5, payable + total);
			ps.executeUpdate();
		}
		catch(SQLException sq) {
			System.out.println("unable a create a new row"+sq);
			return false;
		}
		return true;
	}
	
	public static ArrayList<SellingList> findAllByStoreSalesId(Integer ssId) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<SellingList> listSells = new ArrayList<SellingList>();
		try {
			String sql = "select A.store_sales_details_id, A.p_id, B.p_name, A.quantity, B.sp, C.cgst, C.sgst, A.payable_amount from stock_management.store_sales_details A inner join stock_management.products B on(B.p_id = A.p_id) inner join stock_management.p_categories C on(C.p_cat_id = B.p_cat_id) where store_sales_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ssId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SellingList ssl = new SellingList();
				ssl.setStoreSalesId(rs.getInt("store_sales_details_id"));
				ssl.setpId(rs.getInt("p_id"));
				ssl.setpName(rs.getString("p_name"));
				ssl.setQuantity(rs.getInt("quantity"));
				ssl.setSp(rs.getDouble("sp"));
				ssl.setCgst(rs.getDouble("cgst"));
				ssl.setSgst(rs.getDouble("sgst"));
				ssl.setPayable(rs.getDouble("payable_amount"));
				listSells.add(ssl);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listSells;
	}
	
	public static StoreSalesDetails findByStoreSalesDetailsId(Integer ssdId) {
		Connection conn = MyDatabaseConnection.getConnection();
		StoreSalesDetails ssd = new StoreSalesDetails();
		try {
			String sql = "select * from stock_management.store_sales_details where store_sales_details_id like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ssdId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				ssd.setStoreSalesDetailsId(rs.getInt("store_sales_details_id"));
				ssd.setStoreSalesId(rs.getInt("store_sales_id"));
				ssd.setpId(rs.getInt("p_id"));
				ssd.setQuantity(rs.getInt("quantity"));
				ssd.setCost(rs.getDouble("cost"));
				ssd.setPayableAmount(rs.getDouble("payable_amount"));
				
			
		} 
			
		}catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return ssd;
	}
	
	public boolean removeSaleDetail(int saleDetailId) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from stock_management.store_sales_details where store_sales_details_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, saleDetailId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			return false;
		}
		return true;
	}
	
	public static double totalPayable(int orderId) {
		double value = 0.00;
		Connection conn = MyDatabaseConnection.getConnection();
		StoreSalesDetails ssd = new StoreSalesDetails();
		try {
			String sql = "SELECT SUM(payable_amount) FROM stock_management.store_sales_details WHERE store_sales_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
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
	
	public static ArrayList<StoreProductsList> findAllByPnameAndStoreId(Integer storeId, String name) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<StoreProductsList> listProducts = new ArrayList<StoreProductsList>();
		try {
			String sql = "select A.p_name, A.sp,  B.P_id, B.store_id, B.quantity from stock_management.products A inner join stock_management.store_stock_details B on (A.p_id = B.p_id) where B.store_id = ? and upper(A.p_name) like upper(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreProductsList spl = new StoreProductsList();
				
				spl.setP_name(rs.getString("p_name"));
				spl.setSp(rs.getDouble("sp"));
				spl.setP_id(rs.getInt("P_id"));
				spl.setStoreId(rs.getInt("store_id"));
				spl.setQuantity(rs.getInt("quantity"));
				
				
				listProducts.add(spl);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return listProducts;
	}
	
	public static ArrayList<WhpHistory> findMaxSellingPro(java.util.Date dos) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<WhpHistory> list = new ArrayList<WhpHistory>();
		try {
			String sql = "SELECT p_id,TotalQty,p_name FROM(SELECT A.p_id, SUM(A.quantity) as 'TotalQty',B.p_name FROM stock_management.store_sales_details A inner join stock_management.products B on(A.p_id = B.p_id) inner join stock_management.store_sales C on(C.store_sales_id = A.store_sales_id) where C.dos >= date(?) GROUP BY A.p_id ORDER BY SUM(A.quantity) DESC, A.p_id ASC ) A";
			PreparedStatement ps = conn.prepareStatement(sql);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dos.getTime());
			ps.setDate(1, sqlDate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 WhpHistory whph = new  WhpHistory();
				 whph.setpId(rs.getInt("p_id"));
				 whph.setQuantity(rs.getInt("TotalQty"));
				 whph.setpName(rs.getString("p_name"));
				
				list.add(whph);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to fetch rows." + sq);
		}
		return list;
	}
	
	public static void main(String args[]) {
		
		
		
//		StoreSalesDetails ssd = new StoreSalesDetails();
//		ssd.acceptData();
//		StoreSalesDeatailsDao ssdd = new StoreSalesDeatailsDao();
//		ssdd.createStoreSaleDetail(ssd);
		
//		System.out.println("enter ssId");
//		int id = sc.nextInt();
//		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
//		ArrayList<SellingList> al1 = ssdd.findAllByStoreSalesId(id);
//		for (SellingList sl : al1)
//		System.out.println(sl);
		
//		System.out.println("enter sale Id");
//		int saleId = sc.nextInt();
//		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
//		ssdd.removeSaleDetail(saleId);
		
//		System.out.println("enter ssdId");
//		int ssdId = sc.nextInt();
//		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
//		System.out.println(ssdd.findByStoreSalesDetailsId(ssdId));
		
//		System.out.println("enter ssdId");
//		int ssdId = sc.nextInt();
//		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
//		System.out.println(ssdd.totalPayable(ssdId));
		
//		System.out.println("enter store Id");
//		int sId = sc.nextInt();
//		sc.nextLine();
//		System.out.println("enter p_name");
//		String p = sc.nextLine();
//		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
//		ArrayList<StoreProductsList> al1 = ssdd.findAllByPnameAndStoreId(sId, p);
//		for (StoreProductsList sl : al1)
//		System.out.println(sl);
		
//		System.out.println("enter dos");
//		String date2 = sc.nextLine();
//		java.util.Date dos = DateUtils.convertDate(date2);
//		StoreSalesDeatailsDao storeSaleDao  = new StoreSalesDeatailsDao();
//		ArrayList< WhpHistory> al1 = storeSaleDao.findMaxSellingPro(dos);
//		for ( WhpHistory user4 : al1) {
//			System.out.println(user4);
//		}
		
		
			
	}
	

}
