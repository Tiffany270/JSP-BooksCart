package com.yiki.dao;

import java.util.List;

import com.yiki.entity.Books;

public interface BooksDao {
	public Books getSbyID(int id);//根据id查询书籍
    public List<Books> query();//查询全部图书
    public List<Books> getSbyClass(String type);//图书分类查询
    public void Update(int id,int count) ;//更新库存
	 
	
	
	
	
	
	
	
	

}
