package com.yiki.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {

	private HashMap<Books, Integer> goods;
	private Double totalPrice;

	public Cart() {

		setGoods(new HashMap<Books, Integer>());
		setTotalPrice(0.0);

	}

	public boolean addToCart(Books books, int number) {

		if (goods.containsKey(books)) {//键：商品对象，值：数量
			goods.put(books, goods.get(books) + number);
		} else {
			goods.put(books, number);
		}

	
		countPrice();
		return true;
	}

	public boolean removeToCart(Books item) {
		goods.remove(item);
		countPrice();//每次添加进购物车都要重新计算总金额
		return true;

	}

	public Double countPrice() {
		double sum = 0.0;
		Set<Books> keys = goods.keySet();//获得键的集合
		Iterator<Books> iterator = keys.iterator();
		while (iterator.hasNext()) {

			Books i = iterator.next();//每次遍历出来都是一个商品对象
			sum += i.getPrice() * goods.get(i);//单价*值    goods.get(通过键来取出值，键本身就是i)

		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();

	}

	@Override
	public String toString() {
		return "Cart [goods=" + goods + ", totalPrice=" + totalPrice + "]";
	}

	public HashMap<Books, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Books, Integer> goods) {
		this.goods = goods;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
