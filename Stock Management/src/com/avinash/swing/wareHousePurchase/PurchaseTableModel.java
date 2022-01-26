package com.avinash.swing.wareHousePurchase;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.daos.WareHousePurchaseDetailsDao;
import javax.swing.table.AbstractTableModel;

public class PurchaseTableModel extends AbstractTableModel {
	ArrayList<WareHousePurchaseList> purList;
	String columns[] = {"w_h_p_details_id", "p_id", "quantity_purchased", "p_name", "total_amount"};
	
	public PurchaseTableModel(Integer wareHousePurchaseId) {
		WareHousePurchaseDetailsDao whpddao = new WareHousePurchaseDetailsDao();
		purList = whpddao.findAllByPurchaseId(wareHousePurchaseId);
	
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
		
		return purList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		WareHousePurchaseList whpl =  purList.get(arg0);
		if (arg1 == 0)
			return whpl.getWhpdId();
		else if (arg1 == 1)
			return whpl.getpId();
		else if (arg1 == 2)
			return whpl.getQuantityPurchased();
		else if (arg1 == 3)
			return whpl.getpName();
		else if (arg1 == 4)
			return whpl.getQuantityInStock();
		return null;
	}

}
