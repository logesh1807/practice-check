package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws SQLException {

		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<>();
		try {
			String sql = "select * from menu_item";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				MenuItem menu = new MenuItem();
				menu.setId(rs.getInt(1));
				menu.setName(rs.getString(2));
				menu.setPrice(rs.getFloat(3));
				menu.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				menu.setDateOfLaunch(rs.getDate(5));
				menu.setCategory(rs.getString(6));
				menu.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				menuItemList.add(menu);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return menuItemList;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from menu_item WHERE me_active=? AND me_date_of_launch <=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "Yes");
			java.util.Date d = new java.util.Date();
			ps.setDate(2, new java.sql.Date(d.getTime()));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem menu = new MenuItem();
				menu.setId(rs.getInt(1));
				menu.setName(rs.getString(2));
				menu.setPrice(rs.getFloat(3));
				menu.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				menu.setDateOfLaunch(rs.getDate(5));
				menu.setCategory(rs.getString(6));
				menu.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				menuItemList.add(menu);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return menuItemList;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();

		String sql = "UPDATE menu_item SET me_name=? , me_price=?, me_active=?, me_date_of_launch=?,me_category=?,me_free_delivery=? WHERE me_id=?";
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setString(3, menuItem.isActive() ? "Yes" : "No");
			java.util.Date d = new java.util.Date();
			ps.setDate(4, new java.sql.Date(d.getTime()));
			ps.setString(5, menuItem.getCategory());
			ps.setString(6, menuItem.isFreeDelivery() ? "Yes" : "No");
			ps.setLong(7, menuItem.getId());
			int result = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menuItem = new MenuItem();
		try {
			String sql = "select * from menu_item where menu_id =?";
			PreparedStatement ps = con.prepareStatement(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return menuItem;
	}
}
