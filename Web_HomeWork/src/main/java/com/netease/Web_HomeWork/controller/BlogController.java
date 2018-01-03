package com.netease.Web_HomeWork.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.Web_HomeWork.bean.Blog;
import com.netease.Web_HomeWork.dao.BlogDao;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogDao blogDao;
	
	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
	public void SaveBlog(@ModelAttribute Blog blog, HttpServletResponse response) {
		if(blog.getBlogTitle().length() <= 20 && blog.getBlogContent().length()<=100) {
			blogDao.Insert(blog);
			response.setStatus(200);
			try {
				Writer writer = response.getWriter();
				writer.write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendError(400, "error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
