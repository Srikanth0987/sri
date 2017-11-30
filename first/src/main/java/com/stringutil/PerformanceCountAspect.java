package com.stringutil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceCountAspect 
{
			/*private long starttime;
		
		@Before("execution(* com.first.*.*.*(..))")
		public void Before(JoinPoint joinpoint)
		{
		String MethodName=joinpoint.getSignature().getName();
		String className=joinpoint.getTarget().toString();
		starttime=System.currentTimeMillis();
		
		System.out.println("before::"+MethodName+className);
			
				}
		
		@After("execution(* com.first.*.*.*(..))")
		public void After(JoinPoint joinpoint)
		{
		    String MethodName=joinpoint.getSignature().getName();
			String className=joinpoint.getTarget().toString();

			long endtime=System.currentTimeMillis();
			long timetaken=endtime-starttime;
			System.out.println("time taken to execute method::"+MethodName+"::"+className+timetaken);

			
			
		}
		
			*/	
	
	@Around("execution(* com.first.*.*.*(..))")
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable
	{
		String MethodName=joinpoint.getSignature().getName();
		String className=joinpoint.getTarget().toString();

		long starttime;
		
		starttime=System.currentTimeMillis();
		System.out.println("before::"+MethodName+className);
		
		    Object obj=null;
			obj=joinpoint.proceed();
			//target object calling 
			
			long endtime=System.currentTimeMillis();
			long timetaken=endtime-starttime;
			System.out.println("After Method Name::"+MethodName+"ClassName::"+className+"Total time::"+timetaken);
	
		return obj;
		

	

		
		
	}

}
