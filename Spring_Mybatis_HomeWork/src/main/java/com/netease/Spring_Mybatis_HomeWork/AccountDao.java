package com.netease.Spring_Mybatis_HomeWork;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

	@Select("select * from UserBalance")
	public List<Account> getAccountList();
	
	@Update("update UserBalance set balance=1000")
	public void resetBalance();
	
	@Update("update UserBalance set balance=balance+#{balance} where userId=#{userId}")
	public void updateBalance(@Param("userId") long userId, @Param("balance") double balance);
	
}
