package com.netease.Web_HomeWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netease.Web_HomeWork.bean.User;
import com.netease.Web_HomeWork.dao.UserDao;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/userlist")
	public ModelAndView UserList() {
		ModelAndView result = new ModelAndView("userlist");
		List<User> userList = userDao.GetUserList();
		result.addObject("userList", userList);
		return result;
	}
	
}
