package com.avinash.swing.customers;
import com.avinash.jdbc.daos.CustomersDao;
import com.avinash.jdbc.pojos.Customers;


import javax.swing.table.AbstractTableModel;


import java.util.ArrayList;

public class CustomerTableModel extends AbstractTableModel {
	ArrayList<Customers> listCustomers;
	String columns[] = { "Customer Id", "Mobile No", "Name", "Email" , "Gender"};
	
	

	public CustomerTableModel() {
		super();
		CustomersDao cDao = new CustomersDao();
		listCustomers = cDao.findAll();
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
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return listCustomers.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Customers c = listCustomers.get(arg0);
		if (arg1 == 0)
			return c.getCustId();
		else if (arg1 == 1)
			return c.getMobile();
		else if (arg1 == 2)
			return c.getCustName();
		else if (arg1 == 3)
			return c.getEmail();
		else if (arg1 == 4)
			return c.getGender();
		return null;
	}

}
