package com.avinash.swing.wareHousePurchase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.avinash.jdbc.pojos.WareHousePurchaseDetails;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.daos.WareHousePurchaseDetailsDao;
import javax.swing.table.AbstractTableModel;


public class ExpiryProductTableModel extends AbstractTableModel {
	ArrayList<WareHousePurchaseDetails> expList;
	String columns[] = {"p_id", "exp_date"};

	public ExpiryProductTableModel() {
		WareHousePurchaseDetailsDao whpddao = new WareHousePurchaseDetailsDao();
		expList = whpddao.findExpiringProducts();
	
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
		
		return expList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		WareHousePurchaseDetails whpd =  expList.get(arg0);
		if (arg1 == 0)
			return whpd.getpId();
		else if (arg1 == 1)
			return new SimpleDateFormat("dd-MM-yyyy").format(whpd.getExpDate());
		return null;
	}

}
