package com.yiki.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.yiki.dao.UserDao;
import com.yiki.dbutil.DButil;
import com.yiki.entity.User;

public class UserImpl implements UserDao {

	public void add(User u) {

		String sql = "insert into user(username,password,realname,sex,address)value(?,?,?,?,?)";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getUsername());
			pstm.setInt(2, u.getPassword());
			pstm.setString(3, u.getRealname());
			pstm.setString(4, u.getSex());
			pstm.setString(5, u.getAddress());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

	}

	public boolean quer(String name, int password) {
		String sql = "select * from user where username=? and password=?";
		boolean mark = false;
		Connection con = DButil.open();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				mark = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}
		return mark;

	}

	public User getSbyID(String name) {
		String sql = "select * from user where username=?";
		Connection con = DButil.open();
		User u = new User();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String realname = rs.getString(3);
				String sex = rs.getString(4);
				String address = rs.getString(5);
				u.setUsername(name);
				u.setRealname(realname);
				u.setAddress(address);
				u.setSex(sex);

			}
			return u;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public List<User> queryAll() {
		String sql = "select * from user";
		Connection con = DButil.open();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User s = new User();
				s.setUsername( rs.getString(1));
				s.setPassword(rs.getInt(2));
				s.setRealname(rs.getString(3));
				s.setSex(rs.getString(4));
				s.setAddress(rs.getString(5));
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

	public void delete(String name) {
		String sql = "delete from user where username = ?";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}
	}
}
