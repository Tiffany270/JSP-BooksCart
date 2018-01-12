package com.yiki.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.yiki.dao.OrderDao;
import com.yiki.dbutil.DButil;
import com.yiki.entity.Order;

public class OrderImpl implements OrderDao {

	public void buildOrder(Order order) {
		String sql = "insert into orders(orderid,bookname,buyer,address,stockout,totalprice)value(?,?,?,?,?,?)";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, order.getOrderid());
			pstm.setString(2, order.getBookname());
			pstm.setString(3, order.getBuyer());
			pstm.setString(4, order.getAddress());
			pstm.setString(5, order.getStockout());
			pstm.setInt(6, order.getTotalprice());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

	}

	public List<Order> getSbyName(String name) {
		String sql = "select * from orders where buyer like ?";
		Connection con = DButil.open();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, "%" + name + "%");
			ResultSet rs = pstm.executeQuery();

			List<Order> orderlist = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt(1));
				order.setBookname(rs.getString(2));
				order.setBuyer(name);
				order.setAddress(rs.getString(4));
				order.setStockout(rs.getString(5));
				order.setTotalprice(rs.getInt(6));
				orderlist.add(order);
			}
			return orderlist;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public List<Order> queryAll() {
		String sql = "select * from orders";
		Connection con = DButil.open();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				Order s = new Order();
				s.setOrderid(rs.getInt(1));
				s.setBookname(rs.getString(2));
				s.setBuyer(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setStockout(rs.getString(5));
				s.setTotalprice(rs.getInt(6));
				list.add(s);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public void deleteorder(String buyer, int id) {
		String sql = "delete from orders where orderid = ? and buyer = ?";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, buyer);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}
		
	}

	public void update(String buyer, int id) {
		String sql = "Update orders set stockout=? where orderid = ? and buyer = ?";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, "ÒÑ·¢»õ");
			pstm.setInt(2, id);
			pstm.setString(3, buyer);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		
		
		
		
	}

}
