package com.demo.hello;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 利用 Servlet 的物件 ServletContext , ServletConfig 獲取 web.xml 資源
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
		
		Map<Integer, String> map = new HashMap<Integer, String>();
        Random r = new Random();
		
		getMyContextInfo();
		getMyServletInfo();
		
		res.getWriter().print("Use ServletConfig & ServletContext to get web.xml parameter");
	}

	/**
	 * 使用 ServletContext 物件, 取得 web.xml 注入的global參數(所有的 servlet都可讀取)
	 * @author oscar51011
	 */
	private void getMyContextInfo() {
		ServletContext servletContext = this.getServletContext();
		System.out.println("get global initial parameter: " + servletContext.getInitParameter("globalParameter"));
	}
	
	/**
	 * 使用 ServletConfig 物件, 取得 web.xml 注入的servelt參數(只有該 servlet才可讀取)
	 * @author oscar51011
	 */
	private void getMyServletInfo() {
		ServletConfig servletConfig = this.getServletConfig();
		// 使用 servlet 的 getInitParameter(String name) 取得 web.xml 初始化的值
		String initialParameter = servletConfig.getInitParameter("initialParameter");
		System.out.println("get servlet initial paramenter: " + initialParameter);
		
		// 使用 servlet 的 getInitParameterNames() 取得 web.xml 所有初始化參數的key
		Enumeration<String> parameters =  servletConfig.getInitParameterNames();
		Iterator<String> iterator = parameters.asIterator();
		while(iterator.hasNext()) System.out.println("parameter:" + iterator.next());
	}

}
