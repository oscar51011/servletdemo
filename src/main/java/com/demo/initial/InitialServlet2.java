package com.demo.initial;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml 初始化 servlet , 利用 load-on-startup 決定載入順序
 * @author oscar51011
 * @date 2022年1月9日
 *
 */
@SuppressWarnings("serial")
public class InitialServlet2 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("InitialServlet2 Initinal");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("start get method");
		doPost(req, res);
	}
}
