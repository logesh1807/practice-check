package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "Insert into cart(ct_us_id,ct_pr_id) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> cartList = new ArrayList<>();
		Cart cart = new Cart();

		String sql = "SELECT me_id, me_name, me_price, me_active, me_date_of_launch,me_category,me_free_delivery \r\n"
				+ "FROM menu_item \r\n" + "INNER JOIN cart \r\n" + "ON ct_pr_id = me_id \r\n" + "WHERE ct_us_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
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
				cart.getMenuItemList().add(menu);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cart.getMenuItemList();

	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		String sql = "delete from cart where ct_us_id=? and ct_pr_id=? limit 1";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
