package com.avinash.wareHouseSupply;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.pojos.WareHouseSupply;
import com.avinash.jdbc.daos.WareHouseSupplyDao;
import javax.swing.table.AbstractTableModel;

public class ForAdminWhSupplyTableModel extends AbstractTableModel {
	ArrayList<WareHouseSupply> whsList;
	String columns[] = {"w_h_supply_id", "p_id", "store_id", "quantity","user_id"};

	public ForAdminWhSupplyTableModel(java.util.Date date) {
		WareHouseSupplyDao whsd  = new WareHouseSupplyDao();
		whsList  = whsd.findBysupplyDate(date);
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
		
		return whsList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		WareHouseSupply whs =  whsList.get(arg0);
		if (arg1 == 0)
			return whs.getWhsId();
		else if (arg1 == 1)
			return whs.getpId();
		else if (arg1 == 2)
			return whs.getStoreId();
		else if (arg1 == 3)
			return whs.getQuantity();
		else if (arg1 == 4)
			return whs.getUserId();
		return null;
	}

}
