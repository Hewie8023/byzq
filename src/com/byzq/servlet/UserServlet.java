package com.byzq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzq.entity.User;
import com.byzq.service.UserService;
import com.byzq.util.Md5Util;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// Ó¦´ð·½Ê½
		res.setContentType("text/html;charset=gbk");
		// ±àÂë
		res.setCharacterEncoding("gbk");
		req.setCharacterEncoding("gbk");
		System.out.println(req.getParameter("userregist") + "!!!()!!!");

		/**
		 * ´¦Àí×¢²á
		 */
		if (req.getParameter("userregist")!=null&&!(req.getParameter("userregist").equals(""))&&req.getParameter("userregist").equals("×¢²á")) {
			userRegist(req, res);
		}else if (req.getParameter("login").equals("µÇÂ½")) {
			//´¦ÀíµÇÂ½
			userLogin(req, res);
		}
		

	}

	private void userLogin(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserService us = new UserService();
		User u = us.queryUser(username);
		try {
			if (u.getPassword().equals(Md5Util.MD5(password))) {
				System.out.println(u+"hewie(*)");
				
				req.getSession().setAttribute("currentuser", u);
				
				res.sendRedirect("/byzq/bosombuddy/index.jsp");
			}else{
				res.sendRedirect("/byzq/bosombuddy/login.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				res.sendRedirect("/byzq/bosombuddy/login.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void userRegist(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String checkPassword = req.getParameter("checkpassword");
		String email = req.getParameter("email");

		User u = new User(username, null, Md5Util.MD5(password), null, email,
				null);
		System.out.println(password + "!@##@!" + u);

		try {
			if (password == null && password.equals("")
					|| !password.equals(checkPassword) || email == null
					&& email.equals("")) {
				System.out.println(checkPassword + "@@" + password);
				res.sendRedirect("/byzq/bosombuddy/zhuce.html");
			} else {
				UserService us = new UserService();
				if (us.addUser(u)) {
					res.sendRedirect("/byzq/bosombuddy/login.html");
				} else {
					res.sendRedirect("/byzq/bosombuddy/zhuce.html");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				res.sendRedirect("/byzq/bosombuddy/zhuce.html");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
