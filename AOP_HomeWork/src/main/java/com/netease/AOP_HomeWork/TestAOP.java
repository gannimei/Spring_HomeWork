package com.netease.AOP_HomeWork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserService userService = context.getBean("userService", UserService.class);
		userService.Insert(1);
		userService.Delete(2);
		userService.Update(3);
		userService.Select(4);
		ProductService productService = context.getBean("productService", ProductService.class);
		try {
			productService.Insert(5);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			productService.Delete(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			productService.Update(7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			productService.Select(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		((ConfigurableApplicationContext)context).close();
		
	}

}
