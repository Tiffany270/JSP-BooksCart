package com.yiki.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class manergFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rqs = (HttpServletRequest) request;
		  HttpSession session = rqs.getSession();
		  if(session.getAttribute("success")==null){
				request.getRequestDispatcher("/error.jsp").forward(request, response);
		  }else{
			  String test = session.getAttribute("success").toString();
			  if(test.equals("yes")){
					chain.doFilter(request, response);
					return;
				}
			  
		  }
		  
		  
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
