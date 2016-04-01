package com.zhuani21.jee.base.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWPlayerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("----------------------------------------------------------------------");
		String tagLink = "https://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=/28065041/Vuclip_VideoTest&impl=s&gdfp_req=1&env=vp&output=xml_vast3&unviewed_position_start=1&url=[referrer_url]&description_url=[description_url]&correlator=" + System.currentTimeMillis();
		//tagLink = "http://localhost:8080/jwtest1/uc_ad.xml";
		req.setAttribute("tagLink", tagLink);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jwtest1/test.jsp");

		dispatcher .forward(req, resp);
		
		System.out.println("----------------------------------------------------------------------");
	}
	
}
