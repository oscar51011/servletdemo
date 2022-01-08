package com.demo.hello;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���� Servlet ���� index.jsp ����
 * @author oscar51011
 * @date 2022�~1��9��
 *
 */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		String registerForm = "/view/index.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(registerForm);
		dispatcher.forward(req, res);
	}
}
