package com.avinash.swing.wareHousePurchase;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.pojos.WareHouseStockList;
import com.avinash.jdbc.daos.WareHousePurchaseDetailsDao;
import com.avinash.jdbc.daos.WareHouseStocksDao;

import javax.swing.table.AbstractTableModel;

public class WareHouseStocksTableModel extends AbstractTableModel {
	
	ArrayList<WareHouseStockList> stockList;
	String columns[] = {"p_id", "p_name", "total_amount"};
	
	public WareHouseStocksTableModel() {
		WareHouseStocksDao whsd = new WareHouseStocksDao();
		stockList = whsd.findAllInStock();
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
		
		return stockList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		WareHouseStockList whsl =  stockList.get(arg0);
		if (arg1 == 0)
			return whsl.getpId();
		else if (arg1 == 1)
			return whsl.getpName();
		else if (arg1 == 2)
			return whsl.getQuantity();
		return null;
	}

}
