package com.netease.Web_HomeWork.dao;

import com.netease.Web_HomeWork.bean.Blog;
import org.apache.ibatis.annotations.Insert;

public interface BlogDao {

	@Insert("insert into blog(blogTitle,blogContent) values(#blogTitle,#blogContent)")
	public boolean Insert(Blog blog);
	
}
