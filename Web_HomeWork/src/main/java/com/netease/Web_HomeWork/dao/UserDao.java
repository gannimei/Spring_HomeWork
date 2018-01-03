package com.netease.Web_HomeWork.dao;

import org.apache.ibatis.annotations.Select;

import com.netease.Web_HomeWork.bean.User;

public interface UserDao {

	@Select("select * from user where userName=#{userName}")
	public User GetUserByUserName(String userName);
	
}
