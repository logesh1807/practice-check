package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class Cart {

	private List<MenuItem> menuItemList;
	private double total;

	public Cart() {
		super();
		menuItemList = new ArrayList<>();
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double gettotal() {
		return total;
	}

	public void settotal(double total) {
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setTotal(double total2) {
		// TODO Auto-generated method stub

	}
}
