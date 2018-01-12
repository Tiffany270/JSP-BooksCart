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
	public int hashCode() {// 重新定义对hashmap内存储对象判断是否重复的方法

		return this.getId() + this.getBookname().hashCode();// 如4+名字的哈希码32=36
		// 哈希表的存储规则就改变了
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {// 判断是否等于自身
			return true;
		}
		if (obj instanceof Books) {// 判断 Items 是否为obj类型的对象

			Books i = (Books) obj;// 比较Items类中你自定义的数据域，id和name
			if (this.getId() == i.getId() && this.getBookname().equals(i.getBookname())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		// 这样每当new一个item对象，如果是id和名字相同，就默认是同一个对象。
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
