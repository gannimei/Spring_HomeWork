package com.netease.AOP_HomeWork;

public class ProductService {
	public void Insert(int a) throws Exception {
		throw new Exception("自定义Insert方法异常");
	}
	
	public void Delete(int a) throws Exception {
		throw new Exception("自定义Delete方法异常");
	}
	
	public void Update(int a) throws Exception {
		throw new Exception("自定义Update方法异常");
	}
	
	public void Select(int a) throws Exception {
		throw new Exception("自定义Select方法异常");
	}
}
