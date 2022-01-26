package com.avinash.swing.users;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.avinash.jdbc.daos.UsersDao;
import com.avinash.jdbc.pojos.Users;

public class TableModelOfUserType extends AbstractTableModel {
	ArrayList<Users> listUsers;
	String columns[] = {  "User Id","Password", "Name", "Email" , "User-Type", "Mobile", "Dob", "Doj", "Address", "StoreId", "Total Sale"};
	
	
	
	public TableModelOfUserType(String userType) {
	
		UsersDao uDao = new UsersDao();
		listUsers = uDao.findAllByType(userType);
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
		return listUsers.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Users u =  listUsers.get(arg0);
		if (arg1 == 0)
			return u.getUserId();
		else if (arg1 == 1)
			return u.getPassword();
		else if (arg1 == 2)
			return u.getUserName();
		else if (arg1 == 3)
			return u.getEmail();
		else if (arg1 == 4)
			return u.getUserType();
		else if (arg1 == 5)
			return u.getMobile();
		else if (arg1 == 6)
			return u.getDob();
		else if (arg1 == 7)
			return u.getDoj();
		else if (arg1 == 8)
			return u.getAddress();
		else if (arg1 == 9)
			return u.getStoreId();
		else if (arg1 == 10)
			return u.getTotalSale();
		return null;
	}


}
