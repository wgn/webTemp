package com.zhuani21.jee.base.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdVastServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration e = req.getParameterNames();
		
		System.out.println("----------------------------------------------------------------------");
		while(e.hasMoreElements()){
			String param = (String) e.nextElement();
			String value = req.getParameter(param);
			System.out.print(param + "=" + value + " | ");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
	}
	
}
