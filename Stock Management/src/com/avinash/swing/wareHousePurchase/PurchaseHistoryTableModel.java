package com.avinash.swing.wareHousePurchase;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.WhpHistory;
import com.avinash.jdbc.daos.WareHousePurchaseDetailsDao;
import javax.swing.table.AbstractTableModel;

public class PurchaseHistoryTableModel extends AbstractTableModel {
	
	ArrayList<WhpHistory> purList;
	String columns[] = {"p_id", "quantity_purchased", "p_name", "cp", "sp"};
	
	public PurchaseHistoryTableModel(java.util.Date date) {
		WareHousePurchaseDetailsDao whpd  = new WareHousePurchaseDetailsDao();
		purList = whpd.findAllByPurchaseByDate(date);
		
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
		return purList.size();
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		WhpHistory his =  purList.get(arg0);
		if (arg1 == 0)
			return his.getpId();
		else if (arg1 == 1)
			return his.getQuantity();
		else if (arg1 == 2)
			return his.getpName();
		else if (arg1 == 3)
			return his.getCp();
		else if (arg1 == 4)
			return his.getSp();
		return null;
	}

}
