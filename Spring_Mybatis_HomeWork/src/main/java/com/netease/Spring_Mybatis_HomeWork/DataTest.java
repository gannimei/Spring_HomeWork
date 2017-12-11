package com.netease.Spring_Mybatis_HomeWork;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AccountService service = context.getBean("accountService", AccountService.class);
		service.resetBalance();
		service.transferMoney(1, 2, 123);
		List<Account> accountList = service.getAccountList();
		for (Account account : accountList) {
			System.out.println(account.getUserId() + ": " + account.getBalance());
		}
		((ConfigurableApplicationContext) context).close();

	}

}
