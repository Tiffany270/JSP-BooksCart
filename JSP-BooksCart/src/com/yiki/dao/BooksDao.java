package com.yiki.dao;

import java.util.List;

import com.yiki.entity.Books;

public interface BooksDao {
	public Books getSbyID(int id);//����id��ѯ�鼮
    public List<Books> query();//��ѯȫ��ͼ��
    public List<Books> getSbyClass(String type);//ͼ������ѯ
    public void Update(int id,int count) ;//���¿��
	 
	
	
	
	
	
	
	
	

}
