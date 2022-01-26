package com.avinash.swing.StoreSale;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.StoreSales;
import com.avinash.jdbc.daos.StoreSalesDao;
import javax.swing.table.AbstractTableModel;

public class DateWiseSaleTableModel extends AbstractTableModel {
	
	ArrayList<StoreSales> sellingList;
	String columns[] = {"store_sales_id", "dos","user_id", "amount", "discount_given","total_payable", "store_id", "cust_id"};
	
	public DateWiseSaleTableModel(java.util.Date date) {
		StoreSalesDao ssd  = new StoreSalesDao();
		sellingList = ssd.findAllSales(date);
		
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
		return sellingList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		StoreSales sell =  sellingList.get(arg0);
		if (arg1 == 0)
			return sell.getStoreSalesId();
		else if (arg1 == 1)
			return sell.getDos();
		else if (arg1 == 2)
			return sell.getUserId();
		else if (arg1 == 3)
			return sell.getAmount();
		else if (arg1 == 4)
			return sell.getDiscount();
		else if (arg1 == 5)
			return sell.getTotalPayable();
		else if (arg1 == 6)
			return sell.getStoreId();
		else if (arg1 == 7)
			return sell.getCustId();
		return null;
	}

}
