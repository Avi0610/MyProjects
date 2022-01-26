package com.avinash.swing.StoreSale;
import java.util.ArrayList;
import com.avinash.jdbc.pojos.SellingList;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.daos.StoreSalesDeatailsDao;
import javax.swing.table.AbstractTableModel;

public class StoreSalesTableModel extends AbstractTableModel {
	
	ArrayList<SellingList> sellingList;
	String columns[] = {"storeSalesdetails_id", "p_id","p_name", "quantity", "sp","cgst", "sgst", "payable"};
	
	public StoreSalesTableModel(Integer storeSaleId) {
		StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
		sellingList = ssdd.findAllByStoreSalesId(storeSaleId);
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
		SellingList sell =  sellingList.get(arg0);
		if (arg1 == 0)
			return sell.getStoreSalesId();
		else if (arg1 == 1)
			return sell.getpId();
		else if (arg1 == 2)
			return sell.getpName();
		else if (arg1 == 3)
			return sell.getQuantity();
		else if (arg1 == 4)
			return sell.getSp();
		else if (arg1 == 5)
			return sell.getCgst();
		else if (arg1 == 6)
			return sell.getSgst();
		else if (arg1 == 7)
			return sell.getPayable();
		return null;
	}

}
