package com.yiki.dao;

import java.util.List;

import com.yiki.entity.Order;

public interface OrderDao {

	public void buildOrder(Order order);

	public List<Order> getSbyName(String name);// 根据名字查询订单

	public List<Order> queryAll();

	public void deleteorder(String buyer, int id);
	
	public void update(String buyer,int id);

}
