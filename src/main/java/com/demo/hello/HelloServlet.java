package com.demo.hello;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 藉由繼承 HttpServlet 並覆寫其GET, POST ...etc方法來達成目的
 * @author oscar51011
 * @date 2022年1月9日
 *
 */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
	
	/**
	 * 僅Server啟動 or 第一次呼叫該Servlet, 才會去執行該方法
	 * web.xml 的 <load-on-startup> 決定載入方式
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("HelloServlet Initinal");
		super.init();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("start get method");
		doPost(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("start post method");
		String registerForm = "/view/index.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(registerForm);
		dispatcher.forward(req, res);
	}
}
