package com.stringutil;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {
	
	@Before("execution(* com.first.controller.*.*(..))")
	public void Beforemethod()
	{
		System.out.println("this is before method....");
			}
	
	@After("execution(* com.first.controller.*.*(..))")
	public void Aftermethod()
	{
		System.out.println("this is after method.....");

		
		
	}


	

}
