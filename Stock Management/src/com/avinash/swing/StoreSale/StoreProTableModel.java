package com.avinash.swing.StoreSale;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.SellingList;
import com.avinash.jdbc.pojos.StoreProductsList;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.daos.StoreSalesDeatailsDao;
import javax.swing.table.AbstractTableModel;

public class StoreProTableModel extends AbstractTableModel {
	
	ArrayList<StoreProductsList> productList;
	String columns[] = {"p_name", "sp","P_id", "store_id", "quantity"};
	
	public StoreProTableModel(Integer sId, String name) {
		
		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
		productList = ssdd.findAllByPnameAndStoreId(sId, name);
		
	}
	
	public String getColumnName(int col) {
		return columns[col];
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
        return columns[c].getClass();
    }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return productList.size();
	}


	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		StoreProductsList pro =  productList.get(arg0);
		if (arg1 == 0)
			return pro.getP_name();
		else if (arg1 == 1)
			return pro.getSp();
		else if (arg1 == 2)
			return pro.getP_id();
		else if (arg1 == 3)
			return pro.getStoreId();
		else if (arg1 == 4)
			return pro.getQuantity();
		
		return null;
	}

}
