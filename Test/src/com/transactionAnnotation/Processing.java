package com.transactionAnnotation;

import java.lang.reflect.Method;
import java.nio.charset.MalformedInputException;

import javax.print.attribute.standard.Media;

public class Processing {
	
	public void test(Object o)
	{
	Class  cl=	o.getClass();
	Method method[]=cl.getDeclaredMethods();
	for (Method method2 : method) {
		
		ATrasaction tx=	method2.getAnnotation(ATrasaction.class);
		
		if(tx!=null)
		{
			System.out.println(tx.name());
			
		}
		else
		{
			System.out.println("Not Annotation");
		}
		
			}
				
	}
public static void main(String[] args) {
	
	Bankpojo pojo=new Bankpojo();
	Processing ps=new Processing();
	ps.test(pojo);
	
	
	
	
	
	
	
	
	
}
}
