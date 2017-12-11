package com.netease.Spring_Mybatis_HomeWork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountService {

	@Autowired
	private AccountDao dao;
	
	public List<Account> getAccountList(){
		return dao.getAccountList();
	}
	
	public void resetBalance() {
		dao.resetBalance();
	}
	
	@Transactional
	public void transferMoney(long srcUserId, long targetUserId, double count) {
		dao.updateBalance(srcUserId, -count);
		dao.updateBalance(targetUserId, count);
	}
	
}
