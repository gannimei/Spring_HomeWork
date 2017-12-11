package com.netease.course;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AccountDao dao =  context.getBean("accountDao", AccountDao.class);
		dao.resetBalance();
		try {
			dao.transferMoney(1, 2, 521);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Account> accountList = dao.getAccountList();
		for(Account account : accountList) {
			System.out.println(account.getUserId() + ": " + account.getBalance());
		}
		((ConfigurableApplicationContext)context).close();
		
	}

}
