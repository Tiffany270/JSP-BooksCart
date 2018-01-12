package com.yiki.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiki.dao.OrderDao;
import com.yiki.entity.Books;
import com.yiki.entity.Cart;
import com.yiki.entity.Order;
import com.yiki.entity.User;
import com.yiki.impl.OrderImpl;

public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Order order = new Order();
	private int id = 1;

	private String action;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");

		this.action = request.getParameter("action");
		if (action != null) {
			if (action.equals("order")) {

				request.getRequestDispatcher("/JSP/order.jsp").forward(request, response);

			}

			if (action.equals("cartorder")) {
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				HashMap<Books, Integer> goods = cart.getGoods();
				Set<Books> items = goods.keySet();
				Iterator<Books> it = items.iterator();

				User orderuser = (User) request.getSession().getAttribute("orderuser");
				System.out.println(orderuser);

				while (it.hasNext()) {
					Books i = it.next();
					String name = i.getBookname();
					order.setBookname(name);
					order.setAddress(orderuser.getAddress());
					order.setBuyer(orderuser.getUsername());
					order.setStockout("·ñ");
					order.setOrderid(id);
					double total = cart.getTotalPrice();
					int totalprice = (int) total;
					order.setTotalprice(totalprice);
					OrderDao dao = new OrderImpl();
					dao.buildOrder(order);
					id++;
				}

				request.getRequestDispatcher("/JSP/order.jsp").forward(request, response);

			}

		}
	}

}
