package com.yiki.entity;

public class Order {

	private int orderid;// ¶©µ¥ºÅ
	private String bookname;
	private String buyer;
	private String address;
	private String stockout;// ÊÇ·ñ³ö¿â
	private int totalprice;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", bookname=" + bookname + ", buyer=" + buyer + ", address=" + address
				+ ", stockout=" + stockout + ", totalprice=" + totalprice + "]";
	}

	public String getStockout() {
		return stockout;
	}

	public void setStockout(String stockout) {
		this.stockout = stockout;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
