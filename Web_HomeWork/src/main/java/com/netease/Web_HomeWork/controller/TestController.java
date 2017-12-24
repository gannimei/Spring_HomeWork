package com.netease.Web_HomeWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.netease.Web_HomeWork.bean.User;
import com.netease.Web_HomeWork.dao.UserDao;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/userlist")
	public ModelAndView UserList(@RequestHeader("Accept") String accept) {
		System.out.println(accept);
		if (accept.equals("text/html")) {
			ModelAndView result = new ModelAndView("userlist");
			List<User> userList = userDao.GetUserList();
			result.addObject("userList", userList);
			return result;
		}
		else {
			ModelAndView result = new ModelAndView(new MappingJackson2JsonView());
			List<User> userList = userDao.GetUserList();
			result.addObject("userList", userList);
			return result;
		}
	}

}
