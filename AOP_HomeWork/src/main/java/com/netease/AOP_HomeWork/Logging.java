package com.netease.AOP_HomeWork;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logging {

	@AfterReturning("execution(* com.netease.AOP_HomeWork.*Service.*(..))")
	public void serviceReturningDoLog(JoinPoint jp) {
		System.out.println(jp.getSignature().getDeclaringType().getName() + "." + jp.getSignature().getName() + "方法运行成功");
		for(int i = 0; i < jp.getArgs().length; i++) {
			System.out.println("参数" + (i + 1) + ": " + jp.getArgs()[i]);
		}
	}
	
	@AfterThrowing(value = "execution(* com.netease.AOP_HomeWork.*Service.*(..))", throwing = "ex")
	public void serviceThrowingDoLogging(JoinPoint jp, Exception ex) {
		System.out.println(jp.getSignature().getDeclaringType().getName() + "." + jp.getSignature().getName() + "方法运行异常");
		System.out.println(ex.getMessage());
		for(int i = 0; i < jp.getArgs().length; i++) {
			System.out.println("参数" + (i + 1) + ": " + jp.getArgs()[i]);
		}
	}
	
}
