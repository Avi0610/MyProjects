package com.avinash.swing.StoreSale;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.SellingList;
import com.avinash.jdbc.pojos.StoreStockDetails;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.daos.StoreSalesDeatailsDao;
import com.avinash.jdbc.daos.StoreStockDetailsDao;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;

import com.avinash.jdbc.pojos.SellingList;

public class StoreStockTableModel extends AbstractTableModel {
	
	ArrayList<StoreStockDetails> stockList;
	String columns[] = {"store_id", "p_id","quantity"};
	
	public StoreStockTableModel(Integer storeId) {
		StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
		stockList = ssdd.findByStoreId(storeId);
		
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
		return stockList.size();
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		StoreStockDetails stock =  stockList.get(arg0);
		if (arg1 == 0)
			return stock.getStoreId();
		else if (arg1 == 1)
			return stock.getpId();
		else if (arg1 == 2)
			return stock.getQuantity();
		
		return null;
	}

}
