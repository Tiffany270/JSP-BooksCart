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

		if (goods.containsKey(books)) {//������Ʒ����ֵ������
			goods.put(books, goods.get(books) + number);
		} else {
			goods.put(books, number);
		}

	
		countPrice();
		return true;
	}

	public boolean removeToCart(Books item) {
		goods.remove(item);
		countPrice();//ÿ����ӽ����ﳵ��Ҫ���¼����ܽ��
		return true;

	}

	public Double countPrice() {
		double sum = 0.0;
		Set<Books> keys = goods.keySet();//��ü��ļ���
		Iterator<Books> iterator = keys.iterator();
		while (iterator.hasNext()) {

			Books i = iterator.next();//ÿ�α�����������һ����Ʒ����
			sum += i.getPrice() * goods.get(i);//����*ֵ    goods.get(ͨ������ȡ��ֵ�����������i)

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
