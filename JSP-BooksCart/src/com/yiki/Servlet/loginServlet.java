package com.yiki.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yiki.dao.UserDao;
import com.yiki.entity.User;
import com.yiki.impl.UserImpl;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action;
	UserDao dao = new UserImpl();
	User user = new User();
	ArrayList<User> list = new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		action = request.getParameter("action");

		if (action != null) {
			this.action = request.getParameter("action");

			if (action.equals("insert")) {// 注册
				String name = request.getParameter("username");
				int password = Integer.parseInt(request.getParameter("password"));
				name.getBytes("ISO-8859-1");
				String realname = request.getParameter("realname");
				realname.getBytes("ISO-8859-1");
				String address = request.getParameter("address");
				address.getBytes("ISO-8859-1");
				String sex = request.getParameter("sex");
				sex.getBytes("ISO-8859-1");
				try {

					user.setUsername(name);
					user.setPassword(password);
					user.setRealname(realname);
					user.setSex(sex);
					user.setAddress(address);

					dao.add(user);
					request.getRequestDispatcher("/success.jsp").forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (action.equals("login")) {// 登录

				if (request.getParameter("username") == "" || request.getParameter("password") == "") {
					request.getRequestDispatcher("../error.jsp").forward(request, response);
				}
				String name = request.getParameter("username");
				int password = Integer.parseInt(request.getParameter("password"));

				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				UserDao dao = new UserImpl();
				User user = dao.getSbyID(name);
				request.setAttribute("user", user);
				session.setAttribute("orderuser", user);

				try {
					boolean mark = dao.quer(name, password);
					if (mark == true) {
						Cookie cookie = new Cookie("success", "yes");
						response.addCookie(cookie);
						request.getSession().setAttribute("usersuccess", "yes");
						request.getRequestDispatcher("/JSP/welcom.jsp").forward(request, response);
						return;
					}

					request.getRequestDispatcher("../error.jsp").forward(request, response);
				}

				catch (Exception e) {
					e.printStackTrace();
				}

			} else if (action.equals("out")) {// 退出
				Cookie cookie = new Cookie("success", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				response.sendRedirect("../index.jsp");
				request.getSession().removeAttribute("username");
				request.getSession().removeAttribute("usersuccess");
				request.getSession().removeAttribute("cart");

			}

			else if (action.equals("userinfo")) {// 用户信息
				String name = request.getSession().getAttribute("username").toString();
				System.out.println(name);
				UserDao dao = new UserImpl();
				User user = dao.getSbyID(name);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/JSP/userinfo.jsp").forward(request, response);
			}

			else if (action.equals("insertdata")) {
				String success = request.getParameter("success");
				if (success.equals("yes")) {
					request.getRequestDispatcher("/JSP/insert.jsp").forward(request, response);
					return;
				}
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

			else if (action.equals("back")) {
				String success = request.getParameter("success");
				if (success.equals("yes")) {
					request.getRequestDispatcher("/JSP/welcom.jsp").forward(request, response);
					return;
				}
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

			else if (action.equals("querdata")) {
				String success = request.getParameter("success");
				if (success.equals("yes")) {
					request.getRequestDispatcher("/JSP/querbyform.jsp").forward(request, response);
					return;
				}
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
	}
}
