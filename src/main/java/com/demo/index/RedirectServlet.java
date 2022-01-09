package com.demo.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 實現網頁重新導向 redirect
 * @author oscar51011
 * @date 2022年1月9日
 *
 */
@SuppressWarnings("serial")
public class RedirectServlet extends HttpServlet {

	/**
	 * 將網頁導向 /index/IndexServlet , 讓IndexServlet.java去走後面流程
	 * sendRedirect 方法封裝了 response 的 setHeader & setStatus 方法
	 * 將 HTTP狀態碼 改成 302 ( 重新導向 )
	 * 將 Header 的 Location 設定為 新的網址
	 * 
	 * 則瀏覽器會到新的網址請求資源(因此頁面的URL address會是新的網址)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/index/IndexServlet");
	}
}
