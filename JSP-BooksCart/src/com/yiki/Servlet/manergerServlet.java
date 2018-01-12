package com.yiki.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiki.dao.BooksDao;
import com.yiki.dao.OrderDao;
import com.yiki.dao.UserDao;
import com.yiki.entity.Books;
import com.yiki.entity.Order;
import com.yiki.entity.User;
import com.yiki.impl.BooksImpl;
import com.yiki.impl.OrderImpl;
import com.yiki.impl.UserImpl;

public class manergerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		this.action = request.getParameter("action");

		if (this.action != null) {
			if (action.equals("adminLogin")) {
				String name = request.getParameter("manergername");
				String password = request.getParameter("manergerpassword");

				if (name.equals("admin") && password.equals("admin")) {
					request.getSession().setAttribute("admin", "admin");
					request.getSession().setAttribute("success", "yes");
					request.getRequestDispatcher("/Admin/admin.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}

			} else if (action.equals("alluser")) {

				UserDao dao = new UserImpl();
				List<User> userlist = dao.queryAll();
				request.setAttribute("userall", userlist);
				request.getRequestDispatcher("/Admin/alluser.jsp").forward(request, response);
			}

			else if (action.equals("allorder")) {

				OrderDao dao = new OrderImpl();
				List<Order> orderlist = dao.queryAll();
				request.setAttribute("orderall", orderlist);
				request.getRequestDispatcher("/Admin/allorder.jsp").forward(request, response);

			} else if (action.equals("allbook")) {

				BooksDao dao = new BooksImpl();
				List<Books> booklist = dao.query();
				request.setAttribute("bookall", booklist);
				request.getRequestDispatcher("/Admin/allbooks.jsp").forward(request, response);
			} else if (action.equals("adminOut")) {
				request.getSession().removeAttribute("success");
				response.sendRedirect("../index.jsp");

			} else if (action.equals("deleteuser")) {// 删除用户
				String username = request.getParameter("deletename");
				byte b[] = username.getBytes("ISO-8859-1");
				username = new String(b);
				UserDao dao = new UserImpl();
				dao.delete(username);
				request.getRequestDispatcher("manergerServlet?action=alluser").forward(request, response);

			}
			else if (action.equals("deleteorder")) {// 删除用户
				String buyer = request.getParameter("buyer");
				byte b[] = buyer.getBytes("ISO-8859-1");
				buyer = new String(b);
				int orderid =Integer.parseInt( request.getParameter("orderid"));
				OrderDao dao = new OrderImpl();
				dao.deleteorder(buyer, orderid);
				request.getRequestDispatcher("manergerServlet?action=allorder").forward(request, response);

			}
			else if (action.equals("update")) {// 发货
				String buyer = request.getParameter("buyer");
				byte b[] = buyer.getBytes("ISO-8859-1");
				buyer = new String(b);
				int orderid =Integer.parseInt( request.getParameter("orderid"));
				OrderDao dao = new OrderImpl();
				dao.update(buyer, orderid);
				request.getRequestDispatcher("manergerServlet?action=allorder").forward(request, response);

			}
			else if (action.equals("updatecount")) {// 修改库存
				int orderid =Integer.parseInt( request.getParameter("orderid"));
				int count = Integer.parseInt(request.getParameter("count"));
				BooksDao dao = new BooksImpl();
				dao.Update(orderid, count);
				request.getRequestDispatcher("manergerServlet?action=allbook").forward(request, response);

			}
			else if (action.equals("back")) {
					request.getRequestDispatcher("/Admin/admin.jsp").forward(request, response);
					return;
			}

		}
	}

}
