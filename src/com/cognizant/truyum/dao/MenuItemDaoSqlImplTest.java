package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) throws SQLException {

		try {

			System.out.println("------Admin menu item list------");
			testGetMenuItemListAdmin();

			System.out.println("--------Customer menu item list-------");
			testGetMenuItemListCustomer();

			System.out.println("--------Modify menu item list------");
			testModifyMenuItem();
			testGetMenuItemListAdmin();

		} catch (ParseException e) {

			System.out.println(e);
		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();

		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}

	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem m = new MenuItem(5, "BBQ", 200.0f, true, DateUtil.convertToDate("15/03/2017"), " Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(m);

	}
}
