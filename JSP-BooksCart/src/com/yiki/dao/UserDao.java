package com.yiki.dao;

import java.util.List;

import com.yiki.entity.User;

public interface UserDao {

	public void add(User u);
	public boolean quer(String name, int password) ;
	public User getSbyID(String name);
	public List<User> queryAll();
	public void delete(String name);

}
