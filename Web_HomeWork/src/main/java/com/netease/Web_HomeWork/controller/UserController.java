package com.netease.Web_HomeWork.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netease.Web_HomeWork.bean.User;
import com.netease.Web_HomeWork.dao.UserDao;

@Controller
@RequestMapping(value = "/account")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String userName, String password, HttpSession httpSession, HttpServletResponse response) {
		User user = userDao.GetUserByUserName(userName);
		ModelAndView result = new ModelAndView("redirect:/api/account/user");
		ModelAndView error = new ModelAndView("login");
		if (user != null) {
			if (user.getUserPassword().equals(password)) {
				httpSession.setAttribute("user", user);
				Cookie userCookie = new Cookie("userName", userName);
				userCookie.setMaxAge(30 * 60);
				response.addCookie(userCookie);
				return result;
			} else {
				error.addObject("error", "密码不正确");
				return error;
			}
		} else {
			error.addObject("error", "账号不存在");
			return error;
		}
	}
	
	@RequestMapping(value = "/user")
	public ModelAndView user(@CookieValue(value = "userName", required = false) String userName, HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("user");
		if(user != null) {
			ModelAndView result = new ModelAndView("user");
			result.addObject(user);
			return result;
		}
		else {
			if(userName != null) {
				user = userDao.GetUserByUserName(userName);
				if(user != null) {
					httpSession.setAttribute("user", user);
					ModelAndView result = new ModelAndView("user");
					result.addObject(user);
					return result;
				}
			}
			ModelAndView result = new ModelAndView("error");
			return result;
		}
	}

}
