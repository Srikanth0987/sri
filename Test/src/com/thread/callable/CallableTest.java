package com.thread.callable;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
	String str=" ";
	for(int i=1;i<=100;i++)
	{
		System.out.println(Thread.currentThread().getName()+"::"+i);
		str= str+i;
				
		Thread.sleep(1000);	
			
	}
		return str;
	}

}
