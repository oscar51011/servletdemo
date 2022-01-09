package com.demo.index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 將流程跳轉至JSP頁面(Forward)
 * Forward 是在 server端實現, 因此URL address還會停留在 跳轉前 不會改變
 * @author oscar51011
 * @date 2022年1月9日
 *
 */
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String registerForm = "/view/index.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(registerForm);
		dispatcher.forward(req, resp);
	}
	
}
