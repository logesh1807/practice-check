package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import java.text.ParseException;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) {
		try {
			System.out.println("----------Admin List-----------");
			System.out.println("Admin menu item list ");
			testGetMenuItemListAdmin();
			System.out.println("----------Customer List-----------");
			System.out.println("Customer menu item list ");
			testGetMenuItemlistCustomer();
			testModifyMenuItem();
			System.out.println("----------modified List-----------");
			System.out.println("Modify menu item list ");
			testGetMenuItemListAdmin();

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemlistCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem m = new MenuItem(4, "Ice Cream", 120.0f, true, DateUtil.convertToDate("15/03/2017"), "Main Course",
				true);
		MenuItem m1 = new MenuItem(1, "Crispy Chkn", 120.0f, true, DateUtil.convertToDate("05/04/2017"), "Main Course",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(m);
		menuItemDao.modifyMenuItem(m1);
	}

	public static void testAddCartitem() throws ParseException {

	}
}
