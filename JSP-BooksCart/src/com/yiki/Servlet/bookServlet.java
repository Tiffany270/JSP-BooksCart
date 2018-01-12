package com.yiki.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiki.dao.BooksDao;
import com.yiki.entity.Books;
import com.yiki.entity.Cart;
import com.yiki.impl.BooksImpl;

public class bookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String action;
	private BooksDao dao = new BooksImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		action = request.getParameter("action");

		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) {
				try {
					if (addToCart(request, response)) {
						request.getRequestDispatcher("/JSP/success.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/JSP/failure.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (action.equals("bookclass")) {
				String type = request.getParameter("type");
				BooksDao dao = new BooksImpl();
				List<Books> classlist;
				if (type.equals("novel")) {
					type = "小说";
					classlist = dao.getSbyClass(type);
					System.out.println(classlist.toString());
					request.getSession().setAttribute("classlist", classlist);
					request.getRequestDispatcher("/JSP/bookclass.jsp").forward(request, response);
				}if (type.equals("poetry")) {
					type = "诗歌";
					classlist = dao.getSbyClass(type);
					System.out.println(classlist.toString());
					request.getSession().setAttribute("classlist", classlist);
					request.getRequestDispatcher("/JSP/bookclass.jsp").forward(request, response);
				}
				if (type.equals("life")) {
					type = "传记";
					classlist = dao.getSbyClass(type);
					System.out.println(classlist.toString());
					request.getSession().setAttribute("classlist", classlist);
					request.getRequestDispatcher("/JSP/bookclass.jsp").forward(request, response);
				}

			}

			if (action.equals("show")) {
				try {
					showCart(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (action.equals("delete")) {
				if (deleteCart(request, response)) {
					request.getRequestDispatcher("/JSP/cart.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/JSP/cart.jsp").forward(request, response);
				}
			}

			if (action.equals("buynow")) {

				// TODO

			}

		}
	}

	// 删除商品
	private boolean deleteCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Books books = dao.getSbyID(Integer.parseInt(id));
		if (cart.removeToCart(books)) {
			return true;
		} else {

			return false;
		}
	}

	private void showCart(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		request.getRequestDispatcher("/JSP/cart.jsp").forward(request, response);
	}

	// 添加进购物车
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

		String id = request.getParameter("id");
		String number = request.getParameter("number");

		Books item = dao.getSbyID((Integer.parseInt(id)));

		// 是否是第一次给购物车添加商品
		if (request.getSession().getAttribute("cart") == null) {// 创建对象放进session里
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");// 获取现有购物车对象
		if (cart.addToCart(item, Integer.parseInt(number))) {
			return true;
		} else {
			return false;
		}
	}

}
