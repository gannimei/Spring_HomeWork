package com.netease.IOC_HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		FileWriterService service = context.getBean("fileWriterService", FileWriterService.class);
		service.write("This is a test programmer.");
		System.out.println("Enter any key to stop: ");   
	    InputStreamReader is = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(is);
	    try {
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		((ConfigurableApplicationContext)context).close();
	}

}
