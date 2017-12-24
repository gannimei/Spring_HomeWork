package com.netease.Web_HomeWork.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.netease.Web_HomeWork.bean.User;

public interface UserDao {

	@Select("select * from user")
	public List<User> GetUserList();
	
}
