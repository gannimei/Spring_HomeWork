package com.netease.Web_HomeWork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.Web_HomeWork.bean.User;
import com.netease.Web_HomeWork.dao.UserDao;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login")
	public String login(String userName, String password, HttpSession httpSession) {
		User user = userDao.GetUserByUserName(userName);
		if (user != null) {
			if (user.getUserPassword().equals(password)) {
				httpSession.setAttribute("user", user);
				return "forward";
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}

}
