package com.yiki.entity;

public class Books {

	private String bookname;
	private String writer;
	private String detail;
	private int price;
	private int count;
	private String type;
	private int id;
	private String picture;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Books [bookname=" + bookname + ", writer=" + writer + ", detail=" + detail + ", price=" + price
				+ ", count=" + count + ", type=" + type + ", id=" + id + ", picture=" + picture + "]";
	}

	@Override
	public int hashCode() {// ���¶����hashmap�ڴ洢�����ж��Ƿ��ظ��ķ���

		return this.getId() + this.getBookname().hashCode();// ��4+���ֵĹ�ϣ��32=36
		// ��ϣ��Ĵ洢����͸ı���
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {// �ж��Ƿ��������
			return true;
		}
		if (obj instanceof Books) {// �ж� Items �Ƿ�Ϊobj���͵Ķ���

			Books i = (Books) obj;// �Ƚ�Items�������Զ����������id��name
			if (this.getId() == i.getId() && this.getBookname().equals(i.getBookname())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		// ����ÿ��newһ��item���������id��������ͬ����Ĭ����ͬһ������
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
