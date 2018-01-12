package com.yiki.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.yiki.dao.BooksDao;
import com.yiki.dbutil.DButil;
import com.yiki.entity.Books;

public class BooksImpl implements BooksDao {

	public Books getSbyID(int id) {
		String sql = "select * from books where id=?";
		Connection con = DButil.open();

		Books b = new Books();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String bookname = rs.getString(2);
				String writer = rs.getString(3);
				int price = rs.getInt(5);
				String type = rs.getString(6);
				String picture = rs.getString(8);
				String detail = rs.getString(4);
				b.setDetail(detail);
				b.setId(id);
				b.setBookname(bookname);
				b.setWriter(writer);
				b.setPrice(price);
				b.setType(type);
				b.setPicture(picture);
			}
			return b;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public List<Books> query() {
		String sql = "select * from books";
		Connection con = DButil.open();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Books> list = new ArrayList<Books>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				String writer = rs.getString(3);
				int price = rs.getInt(5);
				String type = rs.getString(6);
				String picture = rs.getString(8);
				Books b = new Books();
				b.setId(id);
				b.setBookname(bookname);
				b.setWriter(writer);
				b.setPrice(price);
				b.setType(type);
				b.setPicture(picture);
				b.setCount(rs.getInt(7));

				list.add(b);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public List<Books> getSbyClass(String type) {
		String sql = "select * from books where type like ?";
		Connection con = DButil.open();
		List<Books> list = new ArrayList<Books>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, "%" + type + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Books b = new Books();
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				String writer = rs.getString(3);
				String detail = rs.getString(4);
				int price = rs.getInt(5);
				String picture = rs.getString(8);
				b.setDetail(detail);
				b.setId(id);
				b.setType(type);
				b.setBookname(bookname);
				b.setWriter(writer);
				b.setPrice(price);
				b.setType(type);
				b.setPicture(picture);
				list.add(b);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

		return null;
	}

	public void Update(int id,int count) {
		String sql = "Update books set count=? where id=?";
		Connection con = DButil.open();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, count);
			pstm.setInt(2,id);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}

	}
}
